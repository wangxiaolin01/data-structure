package tree;

import java.util.Comparator;

public class BinarySerachTreeTest {
    public static void main(String[] args) {
        Integer[] integers = new Integer[]{
                7,4,9,2,5,8,11,1,3,10,12
        };

        BinarySearchTree<Integer> binarySearchTree = new  BinarySearchTree<Integer>();


        for (int i=0;i<integers.length;i++){
            binarySearchTree.add(integers[i]);
        }

//        System.out.println(binarySearchTree);
        binarySearchTree.levelOrderTraversal();

//        binarySearchTree.preorderTraversal();
//        binarySearchTree.inorderTraversal();

//        binarySearchTree.postorderTraversal();
//        binarySearchTree.levelOrderTraversal(new BinarySearchTree.Visitor<Integer>() {

//            @Override
//            boolean visitor(Integer element) {
//                System.out.print(element+"_");
//              return  element == 2 ? true : false;
//            }
//    });

//        binarySearchTree.levelOrderTraversal(new BinarySearchTree.Vistor<>());
//        binarySearchTree.levelOrderTraversal();

//        System.out.println(binarySearchTree);
//        System.out.println(binarySearchTree);
//
//        int height = binarySearchTree.height();
//        System.out.println(height);

        int sum = binarySearchTree.height1();
        System.out.println();
        System.out.println(sum);

//        System.out.println(binarySearchTree.height1());
    }
}
