package com.tool.database.jdbc;


import org.junit.jupiter.api.Test;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;


/**
 * @program: utilsdemo
 * @description: 计算货架更新的频次
 * @author: zhangyu
 * @create: 2019-08-14 11:54
 */

public class StatisticShelfToStationDemo {
    //数据库地址
    private static String dbUrl1 = "jdbc:mysql://172.18.1.23:3306/athena";
    //用户名
    private static String dbUserName = "readonly";
    //密码
    private static String dbPassword = "readonly";
    //驱动名称
    private static String jdbcName = "com.mysql.jdbc.Driver";

    // 测试类
    @Test
    public void fun() {
        String startTime = "2019-05-13 09:40:41";
        String endTime = "2019-05-16 09:40:41";
        long start = converseDateTo(startTime);
        long end = converseDateTo(endTime);
        double numberHour = (double) (end - start) / (1000 * 60 * 60);
        List<String> shelfCodes = getShelfCode(start, end);
        Map<String, Long> shelfCodeMap = shelfCodes.stream().collect(Collectors.groupingBy(String::valueOf, Collectors.counting()));
        Map<String, Double> newShelfCodeMap = new HashMap<>();
        for (String key : shelfCodeMap.keySet()) {
            // System.out.println(key + ":" + String.format("%.2f", shelfCodeMap.get(key) / numberHour));
            newShelfCodeMap.put(key, Double.valueOf(String.format("%.2f", (shelfCodeMap.get(key) / numberHour))));
        }
        System.out.println("总共有货架" + newShelfCodeMap.size() + "个");
        List<String> sortedShelves = newShelfCodeMap.entrySet().stream().sorted(Comparator.comparingDouble(Map.Entry::getValue)).map(e -> e.getKey()).collect(Collectors.toList());
        for (String shelfCode : sortedShelves) {
            System.out.println("每小时货架 " + shelfCode + " 搬动的频率为：" + newShelfCodeMap.get(shelfCode));
        }
    }

    /**
     * @Description: 获取货架的链表
     * @Param: 输入传入的开始时间和结束时间
     * @return: 货架的链表
     * @Author: zhangyu
     */
    public List<String> getShelfCode(long start, long end) {
        List<String> shelfCodes = new ArrayList<>();
        try {
            Class.forName(jdbcName);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("加载驱动失败！");
        }
        Connection con = null;
        String shelfCode = null;
        try {
            String querysql = "SELECT * FROM t_robot_task WHERE task_type='DELIVER_SHELF_TO_STATION' AND create_time BETWEEN " + start + " AND " + end;
            //获取数据库连接
            con = DriverManager.getConnection(dbUrl1, dbUserName, dbPassword);
            Statement stmt = con.createStatement();
            ResultSet resultSet = stmt.executeQuery(querysql);
            while (resultSet.next()) {
                shelfCode = resultSet.getString("shelf_code");
                shelfCodes.add(shelfCode);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("获取数据库连接失败！");
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return shelfCodes;
    }

    /**
     * @Description:将String的字符串换成long类型
     * @Param: 传入String的date类型数
     * @return: 时间的毫秒值
     * @Author: zhangyu
     */
    private long converseDateTo(String date) {
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//24小时制  
            long time2 = simpleDateFormat.parse(date).getTime();
            return time2;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }
}