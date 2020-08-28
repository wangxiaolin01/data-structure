package tree;

import javax.sound.midi.Soundbank;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;

public class BinarySearchTree<E> {

    private int size;
    private Node<E> root;  //根节点
    private Comparator<E> comparator;

    public BinarySearchTree(){
        this(null);
    }
    public BinarySearchTree(Comparator<E> comparator){
        this.comparator = comparator;
    }

    public int size(){
        return  0;
    }

    public boolean isEmpty(){
        return false;
    }

    public  void clear(){
        size = 0;
    }

    /**
     * 添加元素
     * @param element
     */
    public void add(E element){
        //添加第一个节点
        if (root == null){
            root = new Node<E>(element,null);
            size++;
            return;
        }

        //不是第一个节点
        //找到parent节点
        Node<E> parent = null;
        Node<E> node = root;
        int cmp = 0;
        while (node != null){  //最后一个节点
            cmp = compare(element, node.element);
            parent = node;
            if (cmp > 0){
                node = node.right;
            }
            else if(cmp < 0){
                node = node.left;
            }else{//相等
                node.element = element;   //覆盖内容
                return;
            }
        }

        //看看插入到父节点的那个位置
        Node<E> newNode = new Node<E>(element,parent);
        if (cmp > 0){
            parent.right=newNode;
        }else{
            parent.left=newNode;
        }
        size++;
    }

    public  void remove(E element){

    }

    public  boolean contains(E element){
        return false;
    }

    public  void elementNotNullCheck(E element){
        if (element == null){
            throw  new IllegalArgumentException("element must not be null");
        }
    }

    /**
     * 递归遍历获取高度
     * @return
     */
    public int height(){
        return height(root);
    }
    private int height(Node<E> node){
        if (node == null) return 0;
        return 1+ Math.max(height(node.left),height(node.right));
    }


    public int height1(){
        int height = 0;    //数的高度
        int levelSize = 1; //存储每一层的元素的数量
        if (root == null) return 0;
        Queue<Node<E>> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()){
            Node<E> node = queue.poll();
            levelSize --;
            if (node.left != null){
                queue.offer(node.left);
            }
            if (node.right != null){
                queue.offer(node.left);
            }

            if (levelSize == 0){  //意味着即将要访问下一层
                levelSize = queue.size();
                height++;
            }
        }

        return height;
    }

    
    public boolean isComplete(){
        if (root == null) return false;
        Queue<Node<E>> queue = new LinkedList<>();
        queue.offer(root);

        boolean leaf = false;
        while (!queue.isEmpty()){
            Node<E> node = queue.poll();
            if (node.left != null && node.left != null){
                queue.offer(node.left);
                queue.offer(node.right);
            }else if(node.left ==null && node.right != null){
                return false;
            }else { //后面遍历的节点都必须是叶子节点

            }
        }
        return false;
    }
//    public int compareTo(E o) {
//        return 0;
//    }
//
    public  int compare(E e1,E e2){
        if (comparator != null){
            return comparator.compare(e1,e2);
        }
        return ((Comparable<E>)e1).compareTo(e2);
    }



    public void preorderTraversal(Visitor visitor){
        preorderTraversal(root,visitor);

    }

    /**
     * 前序遍历
     * @param node
     */
    private void preorderTraversal(Node<E> node,Visitor visitor){
        if (node == null ) return;
//        System.out.println(node.element);
        if (visitor.stop) return;
        visitor.stop = visitor.visitor(node.element);
        preorderTraversal(node.left,visitor);
        preorderTraversal(node.right,visitor);

    }

    /**
     * 中序遍历
     */
    public void inorderTraversal(Visitor<E> visitor){
        if (visitor == null) return;
        inorderTraversal(root,visitor);
    }

    public void inorderTraversal(Node<E> node){
        if (node == null) return ;
        inorderTraversal(node.left);
        System.out.println(node.element);
        inorderTraversal(node.right);
    }

    public void inorderTraversal(Node<E> node,Visitor<E> visitor){
        if (node == null || visitor.stop) return ;
        inorderTraversal(node.left,visitor);
//        System.out.println(node.element);
        if (visitor.stop) return;
        visitor.stop = visitor.visitor(node.element);
        inorderTraversal(node.right,visitor);
    }

    /**
     * 后序遍历
     */
    public  void postorderTraversal(Visitor<E> visitor){
        if (visitor == null) return;
        postorderTraversal(root,visitor);
    }

    public  void postorderTraversal(Node<E> node){
        if (node == null ) return;
        postorderTraversal(node.left);
        postorderTraversal(node.right);
//        System.out.println(node.element);
    }

    public  void postorderTraversal(Node<E> node,Visitor<E> visitor){
        if (node == null || visitor.stop) return;   //递归调用终止
        postorderTraversal(node.left,visitor);
        postorderTraversal(node.right,visitor);

        if (visitor.stop) return;  //打印停止
        visitor.stop = visitor.visitor(node.element);
    }

    public void levelOrderTraversal(){
        if (root == null) return;
        Queue<Node<E>> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()){
            Node<E> node = queue.poll();
            System.out.print(node.element+"--");
            if (node.left != null){
                queue.offer(node.left);
            }
            if (node.right!=null){
                queue.offer(node.right);
            }
        }
    }

    public void levelOrderTraversal(Visitor<E> visitor){
       if (root == null || visitor == null) return;
        Queue<Node<E>> queue = new LinkedList<Node<E>>();
        queue.offer(root);

        while (!queue.isEmpty()){
            Node<E> node =  queue.poll();

            if (visitor.visitor(node.element)) return ;

//            visitor.visitor(node.element);

            if (node.left!=null){
                queue.offer(node.left);
            }
            if (node.right !=null){
                queue.offer(node.right);
            }
        }
    }


    private static class Node<E > {
        E element;
        Node<E> left;
        Node<E> right;
        Node<E> parent;

        public Node(E element,Node<E> parent){
            this.element = element;
            this.parent = parent;

        }

        /**
         * 判断是不是叶子节点
         * @return
         */
        public boolean  isLeaf(){
            return  left == null && right == null;
        }

        /**
         * 判断是不是有两个节点
         * @return
         */
        public boolean hasTwoChild(){
            return left != null && right != null;
        }

    }

    public static abstract class Visitor<E>{
        boolean stop;

        /**
         * 如果为true，就代表停止遍历
         * @param element
         * @return
         */
        abstract boolean visitor(E element) ;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        toString(root,sb,"");
        return  sb.toString();
    }

    private void toString(Node<E> node,StringBuilder sb,String prefix){
        if (node == null) return;
        sb.append(prefix).append(node.element).append("\n");
        toString(node.left, sb,prefix+"L---");
        toString(node.right,sb,prefix+"R---");
    }
}
