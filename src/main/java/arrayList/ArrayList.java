package arrayList;

import com.AbstractList;
import com.List;

import java.util.Arrays;

public class ArrayList<E> extends AbstractList<E> implements List<E> {

    private int size;
    private E[] elements;

    private static final int DEFAULT_CAPATICY = 10;


    public ArrayList(int capacity){
        capacity = (capacity < 0) ? DEFAULT_CAPATICY : capacity;
        elements = (E[])new Object[capacity];
    }


    public ArrayList(){
        this(DEFAULT_CAPATICY);
    }

//    public void clear(){
//        for (int i = 0;i<elements.length;i++){
//            elements[i] = null;
//        }
//    }
//    public int size(){
//        return size;
//    }
//
//    public boolean isEmpty(){
//        return size == 0;
//    }

    public  E get(int index){
        if(index < 0 || index >= size){
            throw new IndexOutOfBoundsException("数组越界");
        }
        return elements[index];
    }

    public  E set(int index,E element){
        if(index < 0 || index >= size){
            throw new IndexOutOfBoundsException("数组越界");
        }
        E old = elements[index];
        elements[index] = element;
        return old;

    }

    public int indexOf(E element){
//        int i = -1 ;
        if (element == null){
            for (int x = 0; x < size; x++) {
                if (elements[x] == null) {
                    return x;
                }
            }
        }else {
            for (int x = 0; x < size; x++) {
                if (element.equals(elements[x])) {
                   return x;
                }
            }
        }
        return  -1;
    }

//    public boolean contains(E element){
//        return  indexOf(element) > 0;
//    }
//
//
//    public void add(E element){
//        elements[size] = element;
//        size++;
//    }

    public  void add(int index,E element){
        //
        if (element == null) return;  //不存空

        ensureCapacity(elements.length);
        for (int i = size;i > index ;i--){
            elements[i] = elements[i-1];
        }
        elements[index] = element;
        size ++;
    }

    private void ensureCapacity(int capacity) {
        int oldCapacity = elements.length;
        if (oldCapacity >= capacity) return;

        int newCapacity = oldCapacity + (oldCapacity >> 1);
        E[] newElements = (E[])new Object[newCapacity];
        for (int i =0;i<size;i++){
            newElements[i] = elements[i];
        }
        elements = newElements;
    }

    public  E remove(int index){
        E element = elements[index];
        for (int x = index+1;x <= size;x++){
            elements[x-1] = elements[x];
        }
        size --;
       elements[size] = null;
        return element;
    }

    public  E remove(int index,Boolean ensureTrim){
        E element = elements[index];
        for (int x = index+1;x <= size;x++){
            elements[x-1] = elements[x];
        }
        size --;
        elements[size] = null;
        if (ensureTrim) trim();
        return element;
    }

    /**
     * 数组缩容
     * 如果扩容倍数，缩容时机设计不当，有可能导致复杂度震荡
     */
    public  void trim(){
        int capacity = elements.length;
        if (size > (capacity >> 1) || capacity <= DEFAULT_CAPATICY ) return;
        int newCapaticy = capacity >> 1;
        E[] newElements = (E[])new Object[newCapaticy];
        for (int i = 0;i<size;i++){
            newElements[i] = elements[i];
        }
        elements = newElements;
    }

    @Override
    public String toString() {
        String result = null;
        if (size > 0){
            result =  "ArrayList{" +
                    "size=" + size +
                    ", elements=" + Arrays.toString(elements) +
                    '}';
        }
        else{
            throw new IndexOutOfBoundsException("列表为空");
        }

        return result;
    }
}
