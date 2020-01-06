package com.database.jdbc;

/**
 * @program: utilsdemo
 * @description: 连接数据库
 * @author: zhangyu
 * @create: 2019-05-24 11:54
 */

import com.tool.bean.StationData;
import org.dom4j.Document;
import org.dom4j.Element;
import org.junit.jupiter.api.Test;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class ConnectDatabase2 {
    //数据库地址
    private static String dbUrl1 = "jdbc:mysql://172.16.79.203:3306/wms";
    //用户名
    private static String dbUserName = "readonly";
    //密码
    private static String dbPassword = "readonly";
    //驱动名称
    private static String jdbcName = "com.mysql.jdbc.Driver";

    // 测试类
    @Test
    public void fun() {
        String robotMapString = getRobotMapFromDatabase();
        //List<StationData> stationDataList = getStationDataList(robotMapString);
        //System.out.println(stationDataList.size());

    }


    public String getRobotMapFromDatabase() {
        try {
            Class.forName(jdbcName);
            System.out.println("加载驱动成功！");
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            System.out.println("加载驱动失败！");
        }
        Connection con = null;
        String robotMap = null;
        try {
            String querysql = "SELECT * FROM t_pick_order;";
            //获取数据库连接
            con = DriverManager.getConnection(dbUrl1, dbUserName, dbPassword);
            Statement stmt = con.createStatement();
            ResultSet resultSet = stmt.executeQuery(querysql);
            while (resultSet.next()) {
                //System.out.println(resultSet);
                robotMap = resultSet.getString("pick_order_id");
                System.out.println(robotMap);
            }

            System.out.println("获取数据库连接成功！");
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            System.out.println("获取数据库连接失败！");
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        return robotMap;
    }

    public static List<StationData> getStationDataList(String mapPath) {
        List<StationData> stationDataList = new ArrayList();
        // SAXReader reader = new SAXReader();
        try {
            Document document = org.dom4j.DocumentHelper.parseText(mapPath);
            Element mapRoot = document.getRootElement();
            Element stationsElement = mapRoot.element("stations");
            List<Element> stationElementList = stationsElement.elements("station");
            for (Element stationElement : stationElementList) {
                StationData stationData = new StationData();
                String stationId = stationElement.element("id").getText();
                String locationX = stationElement.element("locationx").getText();
                String locationY = stationElement.element("locationy").getText();

                stationData.setStationId(Integer.valueOf(stationId));
                stationData.setX(Integer.valueOf(locationX));
                stationData.setY(Integer.valueOf(locationY));
                stationDataList.add(stationData);
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return stationDataList;
    }
}