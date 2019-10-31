package com.tool.function.javalinux;

/**
 * 测试scp连接
 *
 * @author: zhangyu
 */
public class scpTestDemo {
    public static void main(String[] args) {
        Scpclient scpclient = Scpclient.getInstance("78.133.219.43", 40001, "readonly", "readonly");
        scpclient.getFile("/var/log/geekplus/tomcat-rms/athena/2019-10/athena-2019-10-15-15-1.log.gz", "C:\\Users\\octopus\\Desktop\\新建文件夹 (3)\\");
    }
}
