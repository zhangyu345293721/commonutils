package com.tool;

import org.junit.jupiter.api.Test;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 测试运算符
 *
 * @author: zhangyu
 */
public class TestDemo {
    @Test
    public void fun1() {
        String[] strs = {"java8", "is", "easy", "to", "use"};
        List<String> distinctStrs = Arrays.stream(strs)
                .map(str -> str.split(""))  // 映射成为Stream<String[]>
                .flatMap(Arrays::stream)  // 扁平化为Stream<String>
                .distinct()
                .collect(Collectors.toList());
        System.out.println(distinctStrs);
    }

    // 对时间进行格式化处理
    @Test
    public void fun2() throws Exception {
        String date = "2019-05-14 09:40:41";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//24小时制  
        // SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh-mm-ss");//12小时制
        long time2 = simpleDateFormat.parse(date).getTime();
        System.out.println(time2);
    }
}
