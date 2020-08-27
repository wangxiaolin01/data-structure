package com;

public interface List<E> {

    void clear();

    int size();

    boolean isEmpty();

    E get(int index);

    E set(int index,E element);

    int indexOf(E element);

    boolean contains(E element);


    void add(E element);

    void add(int index,E element);


     E remove(int index);
}
