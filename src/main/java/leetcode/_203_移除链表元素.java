package leetcode;

import com.List;

public class _203_移除链表元素 {
        public ListNode removeElements(ListNode head, int val) {
            ListNode node = head;
            while (node.val == val){
                node = node.next;
            }
           return  node;
    }

    public static void main(String[] args) {
//        ListNode node = new ListNode();
    }
}
