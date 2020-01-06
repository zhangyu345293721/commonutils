package com.tool.streamdemo;

import com.tool.bean.Person;
import com.tool.bean.TestObject;
import com.tool.bean.User;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 测试ListDemo
 *
 * @author: zhangyu
 */
public class ListStreamDemo {

    // 统计并计算分组
    @Test
    public void groupAndComputeAverage() {
        List<Integer> list = new ArrayList();
        list.add(1);
        list.add(2);
        list.add(2);
        list.add(3);
        list.add(3);
        Map<Integer, Long> map = list.stream().collect(Collectors.groupingBy(Integer::intValue, Collectors.counting()));
        System.out.println(map);
    }

    // 过滤掉为空，并对名字进行分组，计算年龄平均值
    @Test
    public void groupAndComputeAgeAverage() {
        List<Person> list = new ArrayList();
        list.add(new Person("zhangsan", "11", 12));
        list.add(new Person("zhangsan", "11", 14));
        list.add(new Person(null, "11", 12));
        list.add(new Person("zhangsan", "11", 12));
        list.add(new Person("zhangsan", "11", 13));

        Map<String, Double> map = list.stream().filter(e -> e.getUserName() != null).collect(Collectors.groupingBy(Person::getUserName, Collectors.averagingInt(Person::getAge)));
        for (String name : map.keySet()) {
            System.out.println(name + ":" + map.get(name));
        }
    }

    // 抽取出来年纪，并当作可以，对象当作value
    @Test
    public void personTestDemo3() {
        List<Person> list = new ArrayList();
        list.add(new Person("zhangsan", "11", 12));
        list.add(new Person("zhangsan", "11", 13));
        list.add(new Person("zhangsan", "11", 14));
        list.add(new Person("zhangsan", "11", 15));
        list.add(new Person("zhangsan", "11", 16));

        Map<Integer, Person> map = list.stream().collect(Collectors.toMap(Person::getAge, e -> e));
        for (Integer id : map.keySet()) {
            System.out.println(id + ":" + map.get(id).toString());
        }
    }

    // 将小写字母变成大写字母
    @Test
    public void Small2BigStringDemo() {
        List<String> list = Arrays.asList("a", "b", "c", "d"); //使用asLit之后，不能再加入新的元素
        List<String> collect = list.stream().map(String::toUpperCase).collect(Collectors.toList());
        collect.add("f");
        System.out.println(collect);
    }

    // 对list中的每个元素进行平方
    @Test
    public void Each2PowDemo() {
        List<Integer> num = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> collect1 = num.stream().map(n -> (int) Math.pow(n, 2)).collect(Collectors.toList());
        System.out.println(collect1);
    }

    // 把set集合转成list
    @Test
    public void set2ListDemo() {
        Set<Integer> num = new HashSet<>();
        num.addAll(Arrays.asList(1, 2, 3, 41, 2, 3, 5));
        List list = num.stream().collect(Collectors.toList());
        System.out.println(list);
    }

    // 过滤掉字符串中为空
    @Test
    public void filterStringIsNull() {
        List<String> strings = Arrays.asList("abc", "", "bc", "efd", "abcd", "", "jkl");
        List<String> filtered = strings.stream().filter(t -> !t.isEmpty()).collect(Collectors.toList());
        System.out.println(filtered);
    }

    // 测试sorted进行排序后再打印
    @Test
    public void listSortedDemo() {
        Random random = new Random(1);
        random.ints().limit(10).sorted().forEach(System.out::println);
    }

    // 统计不为空的个数
    @Test
    public void CountIsNotNullDemo() {
        List<String> strings = Arrays.asList("abc", "", "bc", "efd", "abcd", "", "jkl");
        long count = strings.stream().filter(t -> t.isEmpty()).count();
        System.out.println(count);
    }

    // 统计出现次数
    @Test
    public void statisticAppearTime() {
        List<String> strings = Arrays.asList("abc", "", "bc", "efd", "abcd", "", "jkl");
        List<String> filtered = strings.stream().filter(e -> !e.isEmpty()).collect(Collectors.toList());
        // 过滤掉为空的字符串
        System.out.println(filtered);
    }

    @Test
    public void mergeStringList() {
        List<String> strings = Arrays.asList("abc", "", "bc", "efd", "abcd", "", "jkl");
        // 对字符串进行拼接
        String mergeString = strings.stream().filter(e -> !e.isEmpty()).collect(Collectors.joining(" "));
        System.out.println(mergeString);
    }

    // stream的统计流计算
    @Test
    public void statisticDemo() {
        List<Integer> numbers = Arrays.asList(3, 2, 3, 7, 3, 5);
        IntSummaryStatistics statistics = numbers.stream().mapToInt((x) -> x).summaryStatistics();
        System.out.println(statistics.getMax());
        System.out.println(statistics.getAverage());
        System.out.println(statistics.getCount());
        System.out.println(statistics.getMin());
        System.out.println(statistics.getSum());

        // 获取最大值
        int max = numbers.stream().mapToInt((x) -> x).summaryStatistics().getMax();
        System.out.println(max);
    }

    /**
     * 统计一个字符出现的个数，利用jdk8的新特性
     */
    @Test
    public void groupAndCount() {
        List<String> items = Arrays.asList("apple", "apple", "banana", "apple", "orange", "banana", "papaya");
        Map<String, Long> result = items.stream().collect(Collectors.groupingBy(e -> e, Collectors.counting()));
        System.out.println(result);
    }

    @Test
    public void StreamFun() {
        //1.数组
        String[] arr = new String[]{"ab", "cd", "df"};
        String str = Arrays.stream(arr).findFirst().get();
        System.out.println(str);
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

    // jdk8之后的排序
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

    // 打印部分元素
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

    // 跳过某个元素
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

    // 打印两个元素
    @Test
    public void StreamConditionFun() {
        List<User> list = Arrays.asList(new User("zhangsan", 23),
                new User("lisi", 24),
                new User("lisi", 24),
                new User("wangwu", 28),
                new User("tangtuo", 26)
        );
        list.stream().filter(user -> user.getAge() > 24).sorted(Comparator.comparing(User::getAge)).limit(2).forEach(user -> System.out.println(user));
    }

    //
    @Test
    public void StreamMapFun() {
        List<User> list = Arrays.asList(new User("zhangsan", 23),
                new User("lisi", 24),
                new User("lisi", 24),
                new User("wangwu", 18),
                new User("tangtuo", 26)
        );
        List<String> words = Arrays.asList("aa", "bb", "cc");
        List<String> users = list.stream().map(user -> user.getUserName().toUpperCase()).collect(Collectors.toList());
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
        List<User> users = list.stream().filter(e -> (e.getUserName() != "null")).collect(Collectors.toList());
        //System.out.println(user);
        users.stream().forEach(e -> System.out.println(e.getUserName()));
    }

    // 移除某个元素
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
                if (users.get(i).getAge() == users.get(j).getAge() && users.get(i).getUserName().equals(users.get(j).getUserName())) {
                    users.remove(i);
                }
            }
        }
        users.stream().forEach(user -> System.out.println(user));
    }

    // 统计元素出现的个数
    @Test
    public void StreamListFun() {
        List<Integer> numList = Arrays.asList(1, 2, 3, 3, 4, 5, 10, 7, 8, 9, 6);
        Map<Integer, Long> map = numList.stream().collect(Collectors.groupingBy(e -> e, Collectors.counting()));
        System.out.println(map);
    }

    // 将list转成map,且遇到重复的选后那一个
    @Test
    public void StreamListFun2() {
        List<User> users = new ArrayList<>(Arrays.asList(new User("zhangsan", 23),
                new User("lisi", 24),
                new User("lisi", 25),
                new User("wangwu", 18),
                new User("tangtuo", 26)
        ));
        Map<String, Integer> map = users.stream().collect(Collectors.toMap(e -> e.getUserName(), e -> e.getAge(), (o1, o2) -> o2));
        for (String key : map.keySet()) {
            System.out.println(key + ":" + map.get(key));
        }
    }

    // 过滤并进行打印
    @Test
    public void filterPrint() {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);

        list.stream().filter(e -> e > 2).forEach(r -> System.out.println(r));
    }

    // 将字符串list变成字符串没重复的list
    @Test
    public void StringDistinctTestDemo() {
        String[] strs = {"java8", "is", "easy", "to", "use"};
        List<String> distinctStrs = Arrays.stream(strs)
                .map(str -> str.split(""))  // 映射成为Stream<String[]>
                .flatMap(Arrays::stream)  // 扁平化为Stream<String>
                .distinct()
                .collect(Collectors.toList());
        System.out.println(distinctStrs);
    }

    List<TestObject> list = Arrays.asList(
            new TestObject("Ron", "M", 10, "ron.zheng@tfschange.com", false),
            new TestObject("KDS", "W", 10, "kds@qq.com", false),
            new TestObject("BoDuo", "W", 30, "boduo@163.com", false),
            new TestObject("CangJin", "W", 10, "cangjin@gmail.com", false),
            new TestObject("XiaoZe", "W", 30, "xiaoze@hotmail.com", true),
            new TestObject("James", "M", 10, "leblonjames@hotmail.com", true),
            new TestObject("Allen", "M", 50, "allen.lei@tfschange.com", true),
            new TestObject("Smith", "M", 9, "jr.smith@cel.com", true),
            new TestObject("Wade", "M", 20, "dw.wade@cel.com", true),
            new TestObject("Wade", "M", 20, "dw.wade@cel.com", false)
    );

    // 测试filter
    @Test
    public void filterTestDemo() {
        List<TestObject> arrList = list.stream().filter(TestObject::getFlag).collect(Collectors.toList());
        arrList.stream().forEach((e -> System.out.println(e.getName())));
    }

    // 测试distinct,得到偶数
    @Test
    public void distinctTestDemo() {
        List<Integer> numbers = Arrays.asList(1, 2, 1, 3, 3, 2, 4);
        numbers.stream().filter(i -> i % 2 == 0).distinct().forEach(System.out::println);
    }

    // 测试limit，不考虑大小写
    @Test
    public void limitTestDemo() {
        list.stream().filter(u -> u.getSex().equalsIgnoreCase("w")).limit(5).forEach(u -> System.out.println(u.getName()));
    }

    // 测试toList
    @Test
    public void testToList() {
        list.stream().map(TestObject::getName).collect(Collectors.toList()).forEach(System.out::println);
    }

    // 打印出每个字符串的长度
    @Test
    public void printEachStringLength() {
        list.stream()
                .map(TestObject::getName)
                .map(String::length)
                .collect(Collectors.toList())
                .forEach(System.out::println);
    }

    // 测试anyMatch
    @Test
    public void anyMatchTestDemo() {
        if (list.stream().anyMatch(u -> u.getName().equals("Ron"))) {
            System.out.println("Ron已经到了");
        }
    }

    // 测试allMatch
    @Test
    public void allMatchTestDemo() {
        if (list.stream().allMatch(u -> u.getAge() >= 10)) {
            System.out.println("很棒，都大于10岁");
        } else {
            System.out.println("原来都还没发育");
        }
    }

    // 测试findAny
    @Test
    public void findAnyTestDemo() {
        list.stream().filter(u -> u.getName().
                equals("Ron")).findAny().
                ifPresent(u -> System.out.println(u.getAge()));
    }

    // 测试findFirst
    @Test
    public void findFirstTestDemo() {
        list.stream().
                filter(u -> u.getFlag()).
                findFirst().ifPresent(u -> System.out.println(u.getName()));
    }

    private static List<Person> personList = new ArrayList<>();


    {
        Person p1 = new Person();
        p1.setUserName("zhangyu");
        p1.setAge(21);
        p1.setPassword("12345");
        Person p2 = new Person();
        p1.setUserName("zhangyu");
        p1.setAge(21);
        p1.setPassword("12345");

        Person p3 = new Person("lisi", "1234", 25);
        personList.addAll(Arrays.asList(p1, p2, p3));
    }

    // 按照age从大到小排序
    @Test
    public void sortTestDemo1() {
        personList.sort(Comparator.comparing(Person::getAge).reversed());
        System.out.println(personList);
    }

    // age求和
    @Test
    public void ageSumTestDemo() {
        int sum = personList.stream().mapToInt(e -> e.age).sum();
        System.out.println(sum);
    }

    // 求年纪最大那个人的名字
    @Test
    public void getMaxAgeName() {
        int maxAge = personList.stream().mapToInt(e1 -> e1.getAge()).max().orElse(0);
        Person person = personList.stream().filter(e -> e.getAge() == maxAge).findFirst().get();
        System.out.println(person.userName);
    }
}
