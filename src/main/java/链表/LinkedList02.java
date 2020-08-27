package 链表;

import com.AbstractList;
import com.List;

/**
 * 增加虚拟头节点
 * @param <E>
 */
public class LinkedList02<E> extends AbstractList<E> implements List<E> {

    public LinkedList02(){
        first = new Node(null,null);
    }

    private int size;
    private Node first;



    @Override
    public E get(int index) {
        return node(index).element;
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
    public boolean contains(E element) {
        return indexOf(element) != -1;
    }

    @Override
    public void add(E element) {
        add(size,element);

    }

    @Override
    public void add(int index, E element) {
//        rangeCheckForAdd(index);

            Node<E> pre = index == 0 ? first : node(index - 1);
            pre.next = new Node<>(element,pre.next);

        size ++;
    }

    @Override
    public E remove(int index) {
        Node<E> prev = index ==0 ? first : node(index-1);
        Node<E> node = prev.next;
        prev.next = node.next;

        size--;
        return node.element;
    }

    /**
     * 获取index维值对应的节点对象
     * @param index
     * @return
     */
    private Node<E> node(int index){
//        rangeCheck(index);
        Node<E> node = first.next;
        for (int i = 0;i<index;i++){
            node = node.next;
        }
        return node;
    }

    private static class Node<E>{
        E element;
        Node<E> next;

        public Node(E element,Node<E> next){
            this.element = element;
            this.next = next;
        }
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        Node<E> node = first.next;
        for (int i=0;i<size;i++){
           builder.append(node.element+"-");
           node=node.next;
        }
        return builder.toString();
    }
}
