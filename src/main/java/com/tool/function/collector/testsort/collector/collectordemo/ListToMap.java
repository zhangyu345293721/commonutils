package com.tool.function.collector.testsort.collector.collectordemo;

import com.tool.bean.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @program: utilsdemo
 * @description:
 * @author: zhangyu
 * @create: 2019-08-19 10:14
 */
public class ListToMap {
    public static void main(String[] args) {
        List<User> userList = new ArrayList<>();
        User user1 = new User();
        user1.setId(1L);
        user1.setAge(12);

        User user2 = new User();
        user2.setId(2L);
        user2.setAge(13);

        userList.add(user1);
        userList.add(user2);

       /*
       Map<Long, User> maps = new HashMap<>();
        for (User user : userList) {
            maps.put(user.getId(), user);
        }
        System.out.println(maps);
       */

        // Map<Long, User> maps = userList.stream().collect(Collectors.toMap(User::getId, Function.identity()));
        // Map<Long, User> maps = userList.stream().collect(Collectors.toMap(User::getId, e -> e));

        Map<Long, Integer> maps = userList.stream().collect(Collectors.toMap(User::getId, User::getAge));
        System.out.println(maps);
    }
}
