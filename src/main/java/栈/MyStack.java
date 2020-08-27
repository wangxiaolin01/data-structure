package 栈;

import arrayList.ArrayList;

public class MyStack<E> {
    private ArrayList<E> list = new ArrayList<E>();

    public void push(E element){
        list.add(list.size()-1,element);
    }

    public E pop(){
        return list.remove(list.size()-1);
    }
}
