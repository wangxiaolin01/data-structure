package 链表;

import com.AbstractList;
import com.List;

public class LinkedList_Shuangxiang<E> extends AbstractList<E> implements List<E> {

    private int size;
    private Node first;
    private Node last;



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

    /**
     * gc root对象
     * 1> 被栈指针指向得对象
     * 2>
     */
    @Override
    public void clear() {
        size = 0;
        first = null;
        last = null;
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
        if (index == size){  //往最后添加元素
           Node<E> oldLast = node(index);
           Node<E> last = new Node<>(element,oldLast,null);
           if (oldLast == null){ //添加第一个元素
               first = last;
           }else{
               last.prev = oldLast;
           }
        }
        Node<E> next = node(index);
        Node<E> prev = next.prev;
        Node<E> node = new Node<>(element,prev,next);

        next.prev = node;
        if (prev == null){
            first = node;
        }else{
            prev.next = node;
        }

        size ++;
    }

    @Override
    public E remove(int index) {
        Node<E> node = node(index);
        Node<E> prev = node.prev;
        Node<E> next = node.next;

        if (prev == null){  //index == 0
            first = next;
        }else{
            prev.next = next;
        }

        if (next == null){  //index == size-1
            last = prev;
        }else{
            next.prev = prev;
        }

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
//         Node<E> node ;
        if (index <= (size>>1)) {
            Node<E> node = first;
            for (int i = 0; i < index; i++) {
                node = node.next;
            }
            return node;
        }else{
            Node<E> node = last;
            for (int i = size-1; i > index; i--) {
                node = node.prev;
            }
            return node;
        }
    }

    private static class Node<E>{
        E element;
        Node<E> prev;
        Node<E> next;

        public Node(E element, Node<E> next) {
            this.element = element;
            this.next = next;
        }

        public Node(E element, Node<E> prev, Node<E> next) {
            this.element = element;
            this.next = next;
            this.prev = prev;
        }
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        Node<E> node = first;
        for (int i=0;i<size;i++){
           builder.append(node.element+"-");
           node=node.next;
        }
        return builder.toString();
    }
}
