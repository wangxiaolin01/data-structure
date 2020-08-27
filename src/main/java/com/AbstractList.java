package com;

import java.util.Arrays;

public abstract  class AbstractList<E> implements List<E>{

    protected int size;
    protected E[] elements;

    public void clear(){
        for (int i = 0;i<elements.length;i++){
            elements[i] = null;
        }
    }
    public int size(){
        return size;
    }

    public boolean contains(E element){
        return  indexOf(element) > 0;
    }


    public void add(E element){
        elements[size] = element;
        size++;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    protected void outOfBounds(int index){
        throw  new IndexOutOfBoundsException("Index:"+index+",size:"+size);
    }

    protected void rangeCheck(int index){
        if (index < 0 || index > size){
            outOfBounds(index);
        }
    }

    protected void  rangeCheckForAdd(int index){
        if (index < 0 || index > size){
            outOfBounds(index);
        }
    }


//    @Override
//    public String toString() {
//        String result = null;
//        if (size > 0){
//            result =  "ArrayList{" +
//                    "size=" + size +
//                    ", elements=" + Arrays.toString(elements) +
//                    '}';
//        }
//        else{
//            throw new IndexOutOfBoundsException("列表为空");
//        }
//
//        return result;
//    }
}
