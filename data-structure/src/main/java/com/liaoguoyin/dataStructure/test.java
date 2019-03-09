package com.liaoguoyin.dataStructure;

import com.google.common.collect.ImmutableList;

import java.util.Arrays;
import java.util.List;

public class test {
    public static void main(String[] args) {
        List<String> list = ImmutableList.of("test0", "test11", "test222");

        List<String> list1 = Arrays.asList("21", "222", "333", "4424", "333", null, "432");

        list1.stream()
                .filter(s -> s != null)
                .distinct()
                .forEach(System.out::println);

    }
}
