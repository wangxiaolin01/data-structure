package 链表;

import com.AbstractList;
import com.List;

import java.util.Arrays;

public class 链表02<E>  extends AbstractList<E> implements List<E> {
    private Node first;
    private int size;

    @Override
    public E get(int index) {
        return node(index).element;
    }

    @Override
    public void add(E element) {
        add(size,element);
    }

    public Node<E> node(int index){
        Node<E> node = first;
        for (int x=0;x<index;x++){
            node = node.next;
        }
        return node;
    }

    @Override
    public E set(int index, E element) {
        Node<E> node = node(index);
        E old = node.element;
        node.element = element;
        return old;
    }

    @Override
    public int indexOf(E element) {
        if (element == null){
             Node<E> node = first;
            for (int i=0;i<size;i++){
                if (node.element == null){
                    node = node.next;
                }
            }
        }else{
            Node<E> node = first;
            for (int i=0;i<size;i++){
                if (element.equals(node.element))
                    node = node.next;
            }
        }
        return -1;
    }

    @Override
    public void add(int index, E element) {
        if (index == 0){
            first = new Node(element,first);
        }else{
           Node<E> pre = node(index-1);
           pre.next = new Node<>(element,pre.next);
        }
        size++;

    }

    @Override
    public boolean contains(E element) {
        return indexOf(element) == -1;
    }

    @Override
    public E remove(int index) {
        Node<E> node = first;
        if (index == 0){
            first = first.next;
        }
        node = node(index-1);
        node.next = node.next.next;
        size --;

        return node.element;
    }

    private static class Node<E>{
         E element;
         Node<E> next;

        public Node(E element, Node<E> next) {
            this.element = element;
            this.next = next;
        }
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        Node<E> node = first;
        for (int i =0;i<size;i++){
            builder.append(node.element+"-");
            node = node.next;
        }
        return builder.toString();
    }
}
