package com.tool.remote;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.junit.Test;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

/**
 * 测试从python获取数据
 *
 * @author: zhangyu
 */
public class GetMessageFromPython {
    @Test
    public void pythonTestDemo1() {
        Process proc;
        try {
            proc = Runtime.getRuntime().exec("python D:\\demo.py");// 执行py文件
            // 用输入输出流来截取结果
            BufferedReader in = new BufferedReader(new InputStreamReader(proc.getInputStream()));
            String line = null;
            while ((line = in.readLine()) != null) {
                System.out.println(line);
            }
            in.close();
            proc.waitFor();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void pythonTestDemo2() {
        int a = 18;
        int b = 23;
        try {
            String[] args = new String[]{"python", "D:\\demo.py", String.valueOf(a), String.valueOf(b)};
            Process proc = Runtime.getRuntime().exec(args);// 执行py文件

            BufferedReader in = new BufferedReader(new InputStreamReader(proc.getInputStream()));
            String line = null;
            while ((line = in.readLine()) != null) {
                System.out.println(line);
            }
            in.close();
            proc.waitFor();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void pythonTestDemo3() throws Exception {
        String msgType = "data1";
        int port = 12346;
        InetAddress addr = InetAddress.getLocalHost();
        String ip = addr.getHostName();
        String responseMessage = getMessageFromRemotePort(msgType, ip, port);
        System.out.println(responseMessage);
        // System.out.println(responseMessage.substring(responseMessage.length() - 3));
        JSONObject object = JSONObject.parseObject(responseMessage);
        JSONArray arr = object.getJSONArray(msgType);
        // List<Integer> list = arr.stream().map(e -> (int) e).collect(Collectors.toList());
        System.out.println(arr.get(0));
        System.out.println(arr.size());
    }

    /**
     * @param message 输入输出数据
     * @param host    主机名
     * @param port    端口
     * @return 返回数据
     */
    public String getMessageFromRemotePort(String message, String host, int port) {
        Socket socket = null;
        StringBuilder sb = new StringBuilder();
        try {
            // 初始化套接字，设置访问服务的主机和进程端口号，HOST是访问python进程的主机名称，可以是IP地址或者域名，PORT是python进程绑定的端口号
            socket = new Socket(host, port);
            OutputStream os = socket.getOutputStream();
            PrintStream out = new PrintStream(os);
            out.print(message);
            out.print("over");
            InputStream is = socket.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(is, "utf-8"));
            String tmp = new String();
            while ((tmp = br.readLine()) != null) {
                sb.append(tmp).append('\n');
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (socket != null) {
                    socket.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return sb.toString();
    }
}
