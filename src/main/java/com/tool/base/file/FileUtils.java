package com.tool.base.file;

import com.tool.base.RandomUtils;
import com.tool.base.date.DateUtils;
import org.apache.commons.io.Charsets;
import org.apache.commons.io.IOUtils;

import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.GZIPInputStream;

/**
 * 文件工具类
 */
public class FileUtils {
    private static final String FOLDER_SEPARATOR = "/";
    private static final char EXTENSION_SEPARATOR = '.';

    /**
     * @param filePath 指定的文件路径
     * @param isNew    true：新建、false：不新建
     * @return 存在返回TRUE，不存在返回FALSE
     * <p>
     * 判断指定路径是否存在，如果不存在，根据参数决定是否新建
     */
    public static boolean isExist(String filePath, boolean isNew) {
        File file = new File(filePath);
        if (!file.exists() && isNew) {
            return file.mkdirs();    //新建文件路径
        }
        return false;
    }

    /**
     * 获取文件名，构建结构为 prefix + yyyyMMddHH24mmss + 10位随机数 + suffix + .type
     *
     * @param type   文件类型
     * @param prefix 前缀
     * @param suffix 后缀
     * @return 返回为字符串
     */
    public static String getFileName(String type, String prefix, String suffix) {
        String date = DateUtils.getCurrentTime("yyyyMMddHH24mmss");   //当前时间
        String random = RandomUtils.generateNumberString(10);   //10位随机数
        //返回文件名
        return prefix + date + random + suffix + "" + type;
    }

    /**
     * 获取文件名，文件名构成:当前时间 + 10位随机数 + .type
     *
     * @param type 文件类型
     * @return 返回字符串
     */
    public static String getFileName(String type) {
        return getFileName(type, "", "");
    }

    /**
     * 获取文件名，文件构成：当前时间 + 10位随机数
     *
     * @return 返回字符串
     */
    public static String getFileName() {
        String date = DateUtils.getCurrentTime("yyyyMMddHH24mmss");   //当前时间
        String random = RandomUtils.generateNumberString(10);   //10位随机数
        //返回文件名
        return date + random;
    }

    /**
     * 获取指定文件的大小
     *
     * @param file file
     * @return 返回长整型数
     * @throws Exception
     */
    public static long getFileSize(File file) throws Exception {
        long size = 0;
        if (file.exists()) {
            FileInputStream fis = null;
            fis = new FileInputStream(file);
            size = fis.available();
        } else {
            file.createNewFile();
        }
        return size;
    }

    /**
     * 删除所有文件，包括文件夹
     *
     * @param dirPath 文件的路径
     * @return 无返回值
     */
    public static void deleteAll(String dirPath) {
        File path = new File(dirPath);
        try {
            if (!path.exists()) {
                return;
            }
            if (path.isFile()) {
                path.delete();
                return;
            }
            File[] files = path.listFiles();// 如果目录中有文件递归删除文件
            for (int i = 0; i < files.length; i++) {
                deleteAll(files[i].getAbsolutePath());
            }
            path.delete();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 复制文件或者文件夹
     *
     * @param inputFile   源文件
     * @param outputFile  目的文件
     * @param isOverWrite 是否覆盖文件
     * @return 无返回值
     * @throws IOException
     */
    public static void copy(File inputFile, File outputFile, boolean isOverWrite)
            throws IOException {
        if (!inputFile.exists()) {
            throw new RuntimeException(inputFile.getPath() + "源目录不存在!");
        }
        copyPri(inputFile, outputFile, isOverWrite);
    }

    /**
     * 复制文件或者文件夹
     *
     * @param inputFile   源文件
     * @param outputFile  目的文件
     * @param isOverWrite 是否覆盖文件
     * @return 无返回值
     * @throws IOException
     */
    private static void copyPri(File inputFile, File outputFile, boolean isOverWrite) throws IOException {
        if (inputFile.isFile()) {        //文件
            copySimpleFile(inputFile, outputFile, isOverWrite);
        } else {
            if (!outputFile.exists()) {        //文件夹
                outputFile.mkdirs();
            }
            // 循环子文件夹
            for (File child : inputFile.listFiles()) {
                copy(child, new File(outputFile.getPath() + "/" + child.getName()), isOverWrite);
            }
        }
    }

    /**
     * 复制单个文件
     *
     * @param inputFile   源文件
     * @param outputFile  目的文件
     * @param isOverWrite 是否覆盖
     * @return 无返回值
     * @throws IOException
     */
    private static void copySimpleFile(File inputFile, File outputFile,
                                       boolean isOverWrite) throws IOException {
        if (outputFile.exists()) {
            if (isOverWrite) {        //可以覆盖
                if (!outputFile.delete()) {
                    throw new RuntimeException(outputFile.getPath() + "无法覆盖！");
                }
            } else {
                // 不允许覆盖
                return;
            }
        }
        InputStream in = new FileInputStream(inputFile);
        OutputStream out = new FileOutputStream(outputFile);
        byte[] buffer = new byte[1024];
        int read = 0;
        while ((read = in.read(buffer)) != -1) {
            out.write(buffer, 0, read);
        }
        in.close();
        out.close();
    }

    /**
     * 获取文件的后缀
     *
     * @param file 文件
     * @return 返回字符串
     */
    public static String getFileSuffix(String file) {
        if (file == null) {
            return null;
        }
        int extIndex = file.lastIndexOf(EXTENSION_SEPARATOR);
        if (extIndex == -1) {
            return null;
        }
        int folderIndex = file.lastIndexOf(FOLDER_SEPARATOR);
        if (folderIndex > extIndex) {
            return null;
        }
        return file.substring(extIndex + 1);
    }

    /**
     * 文件重命名
     *
     * @param oldPath 老文件
     * @param newPath 新文件
     * @return 返回布尔类型值
     */
    public boolean renameDir(String oldPath, String newPath) {
        File oldFile = new File(oldPath);
        File newFile = new File(newPath);
        return oldFile.renameTo(newFile);
    }

    /**
     * 将list里面数据写入到文件
     *
     * @param filePath 文件要保存的路径
     * @param infoList 保存信息的list
     * @return 返回空
     */
    public static void listToFile(String filePath, List<String> infoList) {
        try {
            File filename = new File(filePath);
            org.apache.commons.io.FileUtils.writeLines(filename, infoList, true);
            long sizeOf = org.apache.commons.io.FileUtils.sizeOf(new File(filePath));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 将.gz压缩文件每行读入到list当中
     *
     * @param filePath 文件的路径
     * @return 存储文件每行数据的list
     */
    public static List<String> getGzFileToList(String filePath) {
        InputStream in = null;
        List<String> linesList = null;
        try {
            in = new GZIPInputStream(new FileInputStream(filePath));
            linesList = IOUtils.readLines(in, Charsets.toCharset("UTF-8"));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            IOUtils.closeQuietly(in);
        }
        return linesList;
    }

    /**
     * 将文件每行读入到list当中
     *
     * @param filePath 文件的路径
     * @return 存储文件每行数据的list
     */
    public static List<String> getFileToList(String filePath) {
        List<String> readFileList = null;
        try {
            readFileList = org.apache.commons.io.FileUtils.readLines(new File(filePath), com.google.common.base.Charsets.UTF_8);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return readFileList;
    }

    /**
     * 获取某个目录下所有直接下级文件，不包括目录下的子目录的下的文件
     *
     * @param path 输入路径
     * @return 得到string的list
     */
    public static List<String> getFilesPath(String path) {
        List<String> filesPath = new ArrayList();
        File file = new File(path);
        File[] tempList = file.listFiles();
        for (int i = 0; i < tempList.length; i++) {
            if (tempList[i].isFile()) {
                filesPath.add(tempList[i].toString());
            }
            if (tempList[i].isDirectory()) {
                //这里就不递归了，
            }
        }
        return filesPath;
    }


    /**
     * 从远程下载文件到本地
     *
     * @param remoteUrl 远程url
     * @param localDir  本地存放的地址
     * @return 没有返回值
     */
    public void getFileFromRemote(String remoteUrl, String localDir) {
        try {
            URL url = new URL(remoteUrl);
            byte[] data = IOUtils.toByteArray(url);
            org.apache.commons.io.FileUtils.writeByteArrayToFile(new File(localDir), data);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 根据路径得到文件的字符串
     *
     * @param path 路径
     * @return 返回文件的字符串
     */
    public static String getFile2String(String path) {
        String str = null;
        try {
            str = IOUtils.toString(new InputStreamReader(new FileInputStream(path), "utf-8"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return str;
    }
}
