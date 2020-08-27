package 链表;

import com.AbstractList;
import com.List;

public class CircleSingleLinkedList<E> extends AbstractList<E> implements List<E> {

    public int size;
    public Node first;



    @Override
    public E get(int index) {
        return node(index).element;
    }

    @Override
    public int size() {
        return size;
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
        if (index == 0){
            Node<E> newfirst = new Node(element,first);
            Node<E> lastNode = (size == 0) ? newfirst : node(size-1); //获取最后一个节点
            lastNode.next = newfirst;
            first = newfirst;
        }else {
            Node<E> pre = node(index - 1);
            pre.next = new Node<>(element,pre.next);
        }
        size ++;
    }

    @Override
    public E remove(int index) {
        Node<E> node = first;
        if (index == 0){
            if (size == 1){
                first = null;
            }else{
                Node<E> last = node(size-1);  //必须再改变first之前拿到last
                first = first.next;
                last.next = first;
            }
        }else{
            Node<E> prev = node(index-1);
            node = prev.next;
            prev.next = node.next;
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
        Node<E> node = first;
        for (int i = 0;i<index;i++){
            node = node.next;
        }
        return node;
    }

    private static class Node<E>{
        E element;
        Node<E> next;
//        Node<E> pre;

        public Node(E element,Node<E> next){
            this.element = element;
            this.next = next;
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
