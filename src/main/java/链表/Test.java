package 链表;

import com.List;

import java.util.LinkedList;

public class Test {
    public static void main(String[] args) {
//        List<Integer> list = new LinkedList02<>();
//        list.add(10);
//        list.add(0,20);
////        System.out.println(list.contains(20));
//        list.set(1,33);
//        list.add(30);
//        list.add(1,50);
//        list.add(40);
//        list.remove(0);
//        System.out.println(list.contains(20));
//
//        System.out.println(list);

//        List<Integer> list = new LinkedList_Shuangxiang();
//        list.add(1);
//        list.add(2);

//
////        System.out.println(list);
//        LinkedList<Integer> linkedList = new LinkedList<>();
//        linkedList.add(linkedList.size(),20);
        CircleSingleLinkedList<Integer> circleSingleLinkedList = new CircleSingleLinkedList<>();
        circleSingleLinkedList.add(11);
        circleSingleLinkedList.add(22);
        circleSingleLinkedList.add(0,55);
        System.out.println(circleSingleLinkedList.size());
        circleSingleLinkedList.add(circleSingleLinkedList.size(),77);
        System.out.println(circleSingleLinkedList);
        Integer a = circleSingleLinkedList.remove(0);
        circleSingleLinkedList.add(1,90);
        System.out.println(a);


        System.out.println(circleSingleLinkedList);
    }
}
