package com.bittech.ArrayList;

public class Test {

    public static void main(String[] args) {

        MyArrayList arrayList = new MyArrayList(10);
        arrayList.pushBack(1);
        arrayList.pushBack(2);
        arrayList.pushBack(3);
        arrayList.pushFront(10);
        arrayList.pushFront(20);
        arrayList.pushFront(30);
        arrayList.add(100, 3);
        arrayList.add(200, 4);
        arrayList.add(300, 5);
        arrayList.popBack();
        arrayList.popBack();
        arrayList.popBack();

    }
}
