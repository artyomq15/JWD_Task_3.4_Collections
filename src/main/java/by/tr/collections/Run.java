package by.tr.collections;

import by.tr.collections.impl.*;
import by.tr.collections.impl.ArrayList;
import by.tr.collections.impl.LinkedList;

import java.util.*;
import java.util.List;


public class Run {
    public static void main(String[] args) {
        /*List<Integer> list = new ArrayList<>();

        System.out.println(list.size());

        for (int i = 0; i<=20; i++){
            list.add(i, i);
        }

        System.out.println(list.remove(20));
        System.out.println(list.remove(new Integer(66)));
        System.out.println(list.size());*/


        Deque<String> list = new LinkedList<>();
        list.add("kek");
        list.addFirst("lol");
        list.addLast("cheburek");
        System.out.println(list);

        by.tr.collections.List<String> s = new LinkedList<>();

        s.add(0,"b");
        s.add("a");
        s.add("f");
        s.add(3,"v");
        s.add(3,"f");
        System.out.println(s.remove(0));
        System.out.println(s);


        System.out.println("________");

        java.util.List<Integer> d = new java.util.LinkedList<>();
        d.add(0,5);
        d.add(0,6);
        System.out.println(d.remove(1));



    }
}
