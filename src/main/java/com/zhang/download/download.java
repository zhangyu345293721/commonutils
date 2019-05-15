package com.zhang.download;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.junit.jupiter.api.Test;
import java.io.File;
import java.net.URL;

/**
 * @program: utilsdemo
 * @description: 下载文件的IO流
 * @author: zhangyu
 * @create: 2019-04-30 17:53
 */
public class download {
    @Test
    public void fun() {
        String path = "http://172.16.79.122/log/tomcat-rms/athena/2019-04/athena-2019-04-30-01-1.log.gz";
        String local = "D:\\ddddddddd.gz";
        getFileFromRemote(path, local);
    }

    /**
    *@Description:从远程下载文件到本地
    *@Param:  remoteUrl: 远程url; localdir: 本地存放的地址
    *@return: 没有返回值
    *@Author: zhangyu
    */

    public void getFileFromRemote(String remoteUrl, String localDir) {
        try {
            URL url = new URL(remoteUrl);
            byte[] data = IOUtils.toByteArray(url);
            FileUtils.writeByteArrayToFile(new File(localDir), data);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
