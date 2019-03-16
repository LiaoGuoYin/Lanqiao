package com.liaoguoyin.dataStructure;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class test {
    public static void main(String[] args) {
        List<String> list = ImmutableList.of("test0", "test11", "test222");

        List<String> list1 = Arrays.asList("21", "222", "333", "4424", "333", null, "432");

//        list1.stream()
//                .filter(s -> s != null)
//                .distinct()
//                .forEach(System.out::println);

        List<String> name = new ArrayList<>();
        name.add("TomCat");
        name.add("JerryMouse");


        List<String> lowercaseNames = name
                .stream()
                .map(String::toUpperCase)
                .collect(Collectors.toList());

        List<Integer> test = Lists.newArrayList(1, null, 3243, null, 324);

        test.stream()
                .filter(n -> n != null)
                .count();

        System.out.println(test);
        Stream<Integer> stringStream = Stream.of(123, 321, 312, 3);
        List<Integer> nums = Lists.newArrayList(1, 1, null, 2, 3, 4, null, 5, 6, 7, 8, 9, 10);

        //Stream.iterate(1, item -> item + 1).limit(10).forEach(System.out::println);

        System.out.println("sum is :" + nums.stream()
                .distinct()
                .filter(Objects::nonNull)
                .mapToInt(n -> n * 2)
                .peek(System.out::println)
                .skip(2)
                .limit(2)
                .sum());
        List<Integer> nums2 = Lists.newArrayList(1, 1, null, 2, 3, 4, null, 5, 6, 7, 8, 9, 10);

        nums2.stream().filter(n -> n != null)
                .collect(Collectors.toList());

        System.out.println("sum is :" + nums2.stream()
                .filter(Objects::nonNull)
                .distinct()
                .max(((o1, o2) -> o1.compareTo(o2)))
                .toString());
    }
}