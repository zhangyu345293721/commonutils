package com.tool.python;

import com.tool.base.file.FileUtils;
import jep.Interpreter;
import jep.JepException;
import jep.NDArray;
import jep.SharedInterpreter;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Test3 {
    public static void main(String[] args) {
        try (Interpreter interp = new SharedInterpreter()) {
            interp.exec("import sys");
            interp.exec("sys.path.append('.')");
            interp.exec("import sku_sale");
            NDArray<double[]> nd = getNdarray();
            long[] timeArr = getDate();
            interp.set("nd", nd);
            interp.set("timeArr", timeArr);
            interp.exec("x = sku_sale.my_add(timeArr,nd)");
            Object result1 = interp.getValue("x");
            System.out.println(result1.getClass().isPrimitive());
            List objects = null;
            if (result1 instanceof List) {
                objects = (List) result1;
            }
            NDArray<double[]> ndArray = null;
            long[] timesArr = null;
            if (objects.get(0) instanceof long[]) {
                timesArr = (long[]) objects.get(0);
            }
            if (objects.get(1) instanceof NDArray) {
                ndArray = (NDArray<double[]>) objects.get(1);
            }

            for (long time : timesArr) {
                System.out.println(time + " ");
            }
            for (double num : ndArray.getData()) {
                System.out.println(num + " ");
            }
            System.out.println(ndArray.getData().length);
        } catch (JepException je) {
            System.out.println(je.getMessage());
        }
    }

    /**
     * 生成ndarray
     *
     * @return ndarray数组
     */
    public static NDArray<double[]> getNdarray() {
        List<String> list = FileUtils.getFileToList("D:\\data.csv");
        double[] arr = getAllElements(list);
        NDArray<double[]> nd = new NDArray(arr, 31, 10);
        for (int n : nd.getDimensions()) {
            System.out.println(n);
        }
        System.out.println("====================================================");
        return nd;
    }

    /**
     * @return ndarray数组
     */
    public static long[] getDate() {
        List<String> list = FileUtils.getFileToList("D:\\data.csv");
        long[] timeArr = getDate(list);
        return timeArr;
    }

    /**
     * 所有的非日期元素
     *
     * @param list 链表
     * @return 新链表
     */
    private static double[] getAllElements(List<String> list) {
        List<Float> list1 = new ArrayList<>();
        for (String s : list) {
            String[] strs = s.split(",");
            strs[0] = convertTime(strs[0]);
            for (int i = 1; i < strs.length; i++) {
                float d = Float.valueOf(strs[i]);
                list1.add(d);
            }
        }
        return list1.stream().mapToDouble(Double::valueOf).toArray();
    }

    /**
     * @param list 链表
     * @return 时间数组
     */
    private static long[] getDate(List<String> list) {
        List<Long> list1 = new ArrayList<>();
        for (String s : list) {
            String[] strs = s.split(",");
            long time = Long.valueOf(convertTime(strs[0]));
            list1.add(time);
        }
        return list1.stream().mapToLong(Long::valueOf).toArray();
    }

    private static String convertTime(String str) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        try {
            date = sdf.parse(str);
        } catch (Exception e) {
        }
        return String.valueOf(date.getTime());
    }
}
