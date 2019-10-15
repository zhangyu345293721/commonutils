package com.tool.function.collector.testsort.collector.collectordemo;

import com.tool.bean.User;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 *  测试stream
 * @author: zhangyu
 */
public class StreamTest {
    @Test
    public void StreamFun() {
        //1.数组
        String[] arr = new String[]{"ab", "cd", "df"};
        Stream<String> arrStream = Arrays.stream(arr);
        System.out.println(arrStream.findFirst().get());
        //2.集合
        List<String> list = Arrays.asList("ab", "cd", "df");
        Stream<String> colStream = list.stream();
        colStream.forEach(System.out::println);

        // 3.值
        Stream<String> stream = Stream.of("ab", "cd", "fd");
        stream.forEach(System.out::print);
    }

    @Test
    public void StreamFun2() {
        List<User> list = Arrays.asList(new User("zhangsan", 23),
                new User("lisi", 24),
                new User("wangwu", 18),
                new User("tangtuo", 26)
        );
        // 利用stream的lambda
        list.stream().forEach(user -> System.out.println(user));
        // lambda表达式
        //list.forEach(user->System.out.println(user));
    }

    @Test
    public void StreamFun3() {
        List<User> list = Arrays.asList(new User("zhangsan", 23),
                new User("lisi", 24),
                new User("wangwu", 18),
                new User("tangtuo", 26)
        );
        // jdk8之前
        Collections.sort(list, new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                return o2.getAge() - o1.getAge();
            }
        });
        // 输出
        list.stream().forEach(user -> System.out.println(user));
    }

    @Test
    public void StreamSortedFun() {
        List<User> list = Arrays.asList(new User("zhangsan", 23),
                new User("lisi", 24),
                new User("wangwu", 18),
                new User("tangtuo", 26)
        );
        // jdk8 stream方法引用
        list.stream().sorted(Comparator.comparing(User::getAge).reversed()).forEach(user -> System.out.println(user));
    }

    @Test
    public void StreamFilterFun() {
        List<User> list = Arrays.asList(new User("zhangsan", 23),
                new User("lisi", 24),
                new User("wangwu", 18),
                new User("tangtuo", 26)
        );
        // java 8 Stream
        list.stream().filter(e -> e.getAge() > 20).forEach(user -> System.out.println(user));
    }

    @Test
    public void StreamLimitFun() {
        List<User> list = Arrays.asList(new User("zhangsan", 23),
                new User("lisi", 24),
                new User("wangwu", 18),
                new User("tangtuo", 26)
        );
        // java 8 Stream
        list.stream().limit(3).forEach(user -> System.out.println(user));
    }

    @Test
    public void StreamSkipFun() {
        List<User> list = Arrays.asList(new User("zhangsan", 23),
                new User("lisi", 24),
                new User("wangwu", 18),
                new User("tangtuo", 26)
        );
        // java 8 stream 与limit互斥
        list.stream().skip(3).forEach(user -> System.out.println(user));
    }

    @Test
    public void StreamDistinctFun() {
        List<User> list = Arrays.asList(new User("zhangsan", 23),
                new User("lisi", 24),
                new User("lisi", 24),
                new User("wangwu", 18),
                new User("tangtuo", 26)
        );
        List<User> users = new ArrayList<>(list);
        // java 8 stream 与limit互斥
        // list.stream().skip(3).forEach(user->System.out.println(user));
        System.out.println(list);
        // System.out.println(users.stream().distinct().collect(Collectors.toList()));
        users.stream().distinct().forEach(user -> System.out.print(user));
    }

    @Test
    public void StreamNumFun() {
        List<User> list = Arrays.asList(new User("zhangsan", 23),
                new User("lisi", 24),
                new User("lisi", 24),
                new User("wangwu", 18),
                new User("tangtuo", 26)
        );
        IntSummaryStatistics num = list.stream().mapToInt(u -> u.getAge()).summaryStatistics();
        System.out.println("总共人数:" + num.getCount());
        System.out.println("最大年纪:" + num.getMax());
        System.out.println("最小年纪:" + num.getMin());
        System.out.println("年龄之和:" + num.getSum());
        System.out.println("平均年纪:" + num.getAverage());

    }

    @Test
    public void StreamConditionFun() {
        List<User> list = Arrays.asList(new User("zhangsan", 23),
                new User("lisi", 24),
                new User("lisi", 24),
                new User("wangwu", 18),
                new User("tangtuo", 26)
        );
        list.stream().filter(user -> user.getAge() > 24).sorted(Comparator.comparing(User::getAge)).limit(2).forEach(user -> System.out.println(user));
    }

    @Test
    public void StreamMapFun() {
        List<User> list = Arrays.asList(new User("zhangsan", 23),
                new User("lisi", 24),
                new User("lisi", 24),
                new User("wangwu", 18),
                new User("tangtuo", 26)
        );
        List<String> words = Arrays.asList("aa", "bb", "cc");
        List<String> users = list.stream().map(user -> user.getName().toUpperCase()).collect(Collectors.toList());
        List<String> collect = words.stream().map(s -> s.toUpperCase()).collect(Collectors.toList());
        System.out.println(collect);
        System.out.println(users);
    }

    @Test
    public void StreamFirstFun() {
        List<User> list = Arrays.asList(new User("zhangsan", 23),
                new User("lisi", 24),
                new User("lisi", 24),
                new User("wangwu", 18),
                new User("tangtuo", 26),
                new User("null", 26)
        );
        List<User> users = list.stream().filter(e -> (e.getName() != "null")).collect(Collectors.toList());
        //System.out.println(user);
        users.stream().forEach(e -> System.out.println(e.getName()));
    }

    @Test
    public void StreamDeleteFun() {
        List<User> users = new ArrayList<>(Arrays.asList(new User("zhangsan", 23),
                new User("lisi", 24),
                new User("lisi", 24),
                new User("wangwu", 18),
                new User("tangtuo", 26)
        ));

        for (int i = 0; i < users.size(); i++) {
            for (int j = i + 1; j < users.size(); j++) {
                if (users.get(i).getAge() == users.get(j).getAge() && users.get(i).getName().equals(users.get(j).getName())) {
                    users.remove(i);
                }
            }
        }
        users.stream().forEach(user -> System.out.println(user));
    }

    @Test
    public void StreamListFun() {
        List<Integer> numList = Arrays.asList(1, 2, 3, 3, 4, 5, 10, 7, 8, 9, 6);
        // numList.stream().sorted().collect(Collectors.toList());
        Map<Integer, Long> map = numList.stream().collect(Collectors.groupingBy(e -> e, Collectors.counting()));
        System.out.println(map);
    }

    @Test
    public void StreamListFun2() {
        List<User> users = new ArrayList<>(Arrays.asList(new User("zhangsan", 23),
                new User("lisi", 24),
                // new User("lisi", 24),
                new User("wangwu", 18),
                new User("tangtuo", 26)
        ));
        // numList.stream().sorted().collect(Collectors.toList());
        Map<String, Integer> map = users.stream().collect(Collectors.toMap(e -> e.getName(), e -> e.getAge()));
        for (String key : map.keySet()) {
            System.out.println(key + ":" + map.get(key));
        }
    }
}
