package com.tool.algo.systemdemo;

import org.junit.jupiter.api.Test;

/**
 * 判断运行的系统是windows还是linux
 *
 * @author: zhangyu
 */
public class JudgeSystem {


    /**
     * 判断运行的系统是不是linux
     */
    public static boolean isLinux() {
        return System.getProperty("os.name").toLowerCase().contains("linux");
    }

    public static boolean isWindows() {
        return System.getProperty("os.name").toLowerCase().contains("windows");
    }

    public String judgeSystem() {
        if (isLinux()) {
            return "linux";
        } else if (isWindows()) {
            return "windows";
        } else {
            return "other system";
        }
    }

    @Test
    public void fun() {

        String sys = judgeSystem();
        System.out.println(sys);
    }
}
