package tree;

import java.util.Comparator;

public class M_BinarySearchTree<E> {
    private int size;
    private Node<E> root;
    private Comparator<E> comparator;

    public M_BinarySearchTree(){
        this(null);
    }

    public M_BinarySearchTree(Comparator<E> comparator){
        this.comparator = comparator;
    }

    public void add(E element){
        if (root == null) {
             root = new Node<>(element,null);
            size ++ ;
            return ;
        }
        Node<E> parent = null;
        Node<E> node = root;
        int cmp = 0 ;
        //寻找要插入元素得父节点
        while (node != null){
            cmp = compare(element, node.element);
            parent = node;
            if (cmp>0){
                node = node.left;
            }else if(cmp < 0){
                node = node.right;
            } else {
                node.element = element;
                return;
            }
        }
        //插入元素
        Node<E> newNode = new Node<>(element,parent);
        if (cmp > 0){
            parent.left = newNode;
        }else{
            parent.right = newNode;
        }

        size ++ ;
    }


    public int height(){
        return height(root);
    }

    public int height(Node<E> node){
        if (node == null) return 0;
        return 1+Math.max(height(node.left),height(node.right));
    }

   private int compare(E element1,E element2){
        if (comparator == null){
            return ((Comparable<E>)element1).compareTo(element2);
        }
       return comparator.compare(element1,element2);
   }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        toString(root,sb);
        return sb.toString();

    }

    public  void toString(Node<E> node,StringBuilder sb){
        if (node == null) return;
        sb.append(node.element).append("--");
        toString(node.left,sb);
        toString(node.right,sb);

    }

    private static class Node<E>{
          E element;
          Node<E> left;
          Node<E> right;
          Node<E> parent;

         public Node(E element,Node<E> parent){
             this.element = element;
             this.parent = parent;
         }
    }
}
