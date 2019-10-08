package com.atguigu.datastructure.huffmantree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ComparableTest {

    public static void main(String[] args) {
        List<Integer> nodes = new ArrayList<>();
        nodes.add(1);
        nodes.add(9);
        nodes.add(2);
        nodes.add(7);
        nodes.add(2);
        nodes.add(8);
        nodes.add(5);
        Collections.sort(nodes);
        System.out.println(nodes);
    }
}


