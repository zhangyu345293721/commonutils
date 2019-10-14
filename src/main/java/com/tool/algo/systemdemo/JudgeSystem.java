package com.tool.algo.systemdemo;

import org.junit.jupiter.api.Test;

/**
 * @program: utilsdemo
 * @description: 判断运行的系统是windows还是linux
 * @author: zhangyu
 * @create: 2019-08-12 10:07
 */
public class JudgeSystem {


    /**
     * @description: 判断运行的系统是不是linux
     * @author: zhangyu
     * @create: 2019-08-12
     */
    public static boolean isLinux() {
        return System.getProperty("os.name").toLowerCase().contains("linux");
    }

    public static boolean isWindows() {
        return System.getProperty("os.name").toLowerCase().contains("windows");
    }

    public String JudgeSystem() {
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
        boolean flag1 = isLinux();
        // System.out.println(flag1);

        boolean flag2 = isWindows();
        // System.out.println(flag2);

        // System.out.println(System.getProperty("os.name"));

        String sys = JudgeSystem();
        System.out.println(sys);
    }
}
