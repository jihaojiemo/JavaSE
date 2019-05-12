package com.bittech;

import java.util.Arrays;

public class MySequenceImpl implements ISequence {

    //存放顺序表的数组
    private Object[] elem;
    //有效数据个数
    private int usedSize;
    //能存放数据的最大长度
    private static final int DEFAULT_SIZE = 10;

    public MySequenceImpl() {
        this.elem = new Object[DEFAULT_SIZE];
        this.usedSize = 0;
    }

    private boolean isFull() {
        return this.usedSize == this.elem.length;
    }

    private boolean isEmpty() {
        return this.usedSize == 0;
    }

    @Override
    public boolean add(int pos, Object data) {
        //判断pos的合法性
        if(pos < 0 || pos > this.usedSize) {
            return false;
        }
        //判断是否为满
        if(isFull()) {
            //2倍扩容
            this.elem = Arrays.copyOf(this.elem, 2*this.elem.length);

        }
        //插入
        for(int i = usedSize-1; i >= pos; i--) {
            this.elem[i+1] = this.elem[i];
        }
        this.elem[pos] = data;
        this.usedSize++;
        return true;
    }


    @Override
    public int search(Object key) {
        if(isEmpty()) {
            return -1;
        }
        for(int i = 0; i < this.usedSize; i++) {
            if(this.elem[i].equals(key)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public boolean contains(Object key) {
        if(isEmpty()) {
            return false;
        }
        for(int i = 0; i < this.usedSize; i++) {
            if(this.elem[i].equals(key)) {
                return true;
            }
        }
        return false;
    }

    @Override
    //得到pos位置的值
    public Object getPos(int pos) {
        //判断是否为空
        if(isEmpty()) {
            return false;
        }
        //判断pos的合法性
        if(pos < 0 || pos >= usedSize) {
            return null;
        }
        return this.elem[pos];
    }

    @Override
    //删除第一次出现的关键字key，不是删除key位置上的元素
    public Object remove(Object key) {
        //获取值为key的索引
        int index = search(key);
        if(index == -1) {
            return null;
        }

        for(int i = index+1; i <= this.usedSize-1; i++) {
            this.elem[i-1] = this.elem[i];
        }
        this.elem[usedSize-1] = null;
        this.usedSize--;
        return true;
    }

    @Override
    public int size() {
        return this.usedSize;
    }

    @Override
    public void display() {
        for(int i = 0; i < this.usedSize; i++) {
            System.out.print(this.elem[i]+" ");
        }
    }

    @Override
    public void clear() {
        for (int i = 0; i < this.usedSize; i++) {
            this.elem[i] = null;
        }
    }
}
