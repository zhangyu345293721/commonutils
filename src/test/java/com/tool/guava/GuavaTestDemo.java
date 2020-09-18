package com.tool.guava;

import com.google.common.base.*;
import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.google.common.collect.*;
import com.tool.bean.Person;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

/**
 * 测试guava包
 *
 * @author: zhangyu
 */
public class GuavaTestDemo {

    /**
     * 不可变list,set,map
     */
    @Test
    public void ImmutableTestDemo() {
        ImmutableList<String> list = ImmutableList.of("a", "b", "c");
        for (String s : list) {
            System.out.print(s + " ");
        }
        System.out.println();
        ImmutableSet<String> iSet = ImmutableSet.of("e1", "e2");
        System.out.println(iSet);

        ImmutableMap<String, String> imap = ImmutableMap.of("k1", "v1", "k2", "v2");
        System.out.println(imap);
    }

    @Test
    public void listMapTestDemo() {
        // 有key重复的map
        Multimap<String, Integer> map = ArrayListMultimap.create();
        map.put("a", 1);
        map.put("a", 2);
        System.out.println(map.get("a"));

        // set中可以看见元素的出现次数
        Multiset<String> set = HashMultiset.create();
        set.add("a");
        set.add("a");
        set.add("a");
        set.add("c");
        System.out.println(new HashSet<>(set));
        System.out.println(set.count("d"));
        System.out.println(set.elementSet());
    }

    // 测试使用不重复map
    @Test
    public void biMapTestDemo() {
        BiMap<String, String> biMap = HashBiMap.create();
        biMap.put("a", "123");
        biMap.put("a", "1234");
        Map<String, String> map1 = new HashMap<>();
        biMap.forEach((k, v) -> map1.put(k, v));
        System.out.println(biMap.get("a"));
        System.out.println(map1);
    }

    // 测试使用table
    @Test
    public void tableTestDemo() {
        Table<String, String, Integer> tables = HashBasedTable.create();
        tables.put("1", "1", 1);
        tables.put("1", "2", 2);
        System.out.println(tables.toString());
    }

    // 测试连接字符串
    @Test
    public void joinListDemo() {
        List<String> list = new ArrayList(Arrays.asList("a", "b", "c", "d"));
        String result = Joiner.on("-").join(list);
        System.out.println(result);
    }

    // 将String转成特定的集合
    @Test
    public void string2ListTestDemo() {
        /*String str = "1-2-3-4-5-6";
        List<String> list = Splitter.on("-").splitToList(str);
        System.out.println(list);*/
        String str = "1-2-3-4-  5-  6   ";
        List<String> list = Splitter.on("-").omitEmptyStrings().trimResults().splitToList(str);
        System.out.println(list);
    }

    // 将字符串变成map  BiMap强制其value的唯一性
    @Test
    public void string2LinkedMapTestDemo() {
        String str = "xiaoming=11,xiaohong=23,xiaohong=24";
        Map<String, Integer> map = new LinkedHashMap<>();

        Splitter.on(",").split(str).forEach(e -> {
            String strs[] = e.split("=");
            map.put(strs[0], Integer.valueOf(strs[1]));
        });

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }
    }

    // 将字符串变成map  BiMap强制其value的唯一性
    @Test
    public void string2MapTestDemo() {
        String str = "xiaoming=11,xiaohong=23 ";
        Map<String, Integer> map = new LinkedHashMap<>();

        Splitter.on(",").trimResults().split(str).forEach(e -> {
            String strs[] = e.split("=");
            map.put(strs[0], Integer.valueOf(strs[1]));
        });

        for (String s : map.keySet()) {
            System.out.println(s + ":" + map.get(s));
        }
    }

    // 测试guava支持正则分隔
    @Test
    public void spiltOnRegexTestDemo() {
        String input = "aa.dd,,ff,,.";
        List<String> result = Splitter.onPattern("[.|,]").omitEmptyStrings().splitToList(input);
        System.out.println(result);
    }

    //按照条件过滤
    @Test
    public void collectFilterTestDemo() {
        ImmutableList<String> names = ImmutableList.of("begin", "code", "guava", "Java");
        Iterable<String> filter = Iterables.filter(names, Predicates.or(Predicates.equalTo("guava"), Predicates.equalTo("Java")));
        System.out.println(filter); // [Guava, Java]
    }

    //测试map的交集
    @Test
    public void mapSetTestDemo() {
        HashMap<String, Integer> mapA = Maps.newHashMap();
        mapA.put("a", 1);
        mapA.put("b", 2);
        mapA.put("c", 3);

        HashMap<String, Integer> mapB = Maps.newHashMap();
        mapB.put("b", 20);
        mapB.put("c", 3);
        mapB.put("d", 4);

        MapDifference difference = Maps.difference(mapA, mapB);
        System.out.println(difference.areEqual());// 判断两个map是不是一样

        Map entriesDiff = difference.entriesDiffering();
        Map entriesDiffLeft = difference.entriesOnlyOnLeft();
        Map entriesDeffRight = difference.entriesOnlyOnRight();
        Map entriesDeffCommon = difference.entriesInCommon();

        // 不同的部分
        System.out.println(entriesDiff);
        // 只有左边部分
        System.out.println(entriesDiffLeft);
        // 只有右边部分
        System.out.println(entriesDeffRight);
        // 全部相同
        System.out.println(entriesDeffCommon);

    }

    @Test
    public void checkDataTestDemo() {
        String s = "";
        System.out.println(Strings.isNullOrEmpty(s));
    }

    // 将对象变成字符串
    @Test
    public void moreObjectTestDemo() {
        Person p = new Person();
        p.setUserName("zhangyu");
        p.setPassword("123");
        p.setAge(23);

        String str = MoreObjects.toStringHelper("hahhah").add("age", p.getAge()).toString();
        System.out.println(str);
    }

    // 测试guava的排序
    @Test
    public void orderTestDemo() {
        Person p1 = new Person("zhangyu", "123", 12);
        Person p2 = new Person("zhangsan", "1234", 10);

        Ordering<Person> byOrdering = Ordering.natural().nullsFirst().onResultOf(new Function<Person, Integer>() {
            public Integer apply(Person person) {
                return person.age;
            }
        });
        byOrdering.compare(p1, p2);
        System.out.println(byOrdering.compare(p1, p2));
    }

    // 计算程序运行时间
    @Test
    public void computeTimesTestDemo() {
        Stopwatch stopwatch = Stopwatch.createStarted();
        for (int i = 0; i < 100000000; i++) {
            // do some thing
        }
        long nanos = stopwatch.elapsed(TimeUnit.MILLISECONDS);
        System.out.println(nanos);

    }

    @Test
    public void cacheTetDemo() throws Exception {
        Cache<String, String> cache = CacheBuilder.newBuilder().maximumSize(1000).build();
        String resultVal = cache.get("code", new Callable<String>() {
            public String call() {
                String strProValue = "begin " + "code" + "!";
                return strProValue;
            }
        });
        System.out.println("value : " + resultVal);
    }
}
