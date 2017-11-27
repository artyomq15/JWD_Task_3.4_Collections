package by.tr.collections;

import by.tr.collections.impl.*;
import by.tr.collections.impl.ArrayList;
import by.tr.collections.impl.LinkedList;




public class Run {
    public static void main(String[] args) {
        /*List<Integer> list = new ArrayList<>();


        for (int i = 0; i<=5; i++){
            list.add(i, i);
        }

        Iterator<Integer> it = list.getIterator();
        while (it.hasNext()){
            System.out.println(it.next());
        }
        while (it.hasPrevious()){
            System.out.println(it.previous());
        }*/


        Deque<String> list = new LinkedList<>();
        list.add("kek");
        list.addFirst("lol");
        list.addLast("cheburek");
        System.out.println(list);

        Iterator<String> iterator = list.getIterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
        while (iterator.hasPrevious()){
            System.out.println(iterator.previous());
        }


        List<String> s = new LinkedList<>();

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
