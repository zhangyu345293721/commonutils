package com.tool.base;


/**
 * 判断运行的系统是windows还是linux
 *
 * @author zhangyu (zhangyuyu417@gmail.com)
 */
public class JudgeSystem {


    /**
     * 判断运行的系统是不是linux
     */
    public static boolean isLinux() {
        return System.getProperty("os.name").toLowerCase().contains("linux");
    }

    /**
     * 判断运行的系统是不是windows
     */

    public static boolean isWindows() {
        return System.getProperty("os.name").toLowerCase().contains("windows");
    }

    /**
     * 判断系统是windows还是linux
     *
     */
    public String judgeSystem() {
        if (isLinux()) {
            return "linux";
        } else if (isWindows()) {
            return "windows";
        } else {
            return "other system";
        }
    }
}
