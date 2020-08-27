package leetcode;


/**
 * 快慢指针思想
 * ，快指针和慢指针是否有重合
 */
public class _141_环形链表 {
    public boolean hasCycle(ListNode head){
        if (head == null || head.next == null) return true;
        ListNode slow = head;
        ListNode fast = head.next;

        while (fast !=null && fast.next!=null){
            if (slow == fast) return true;
            slow = slow.next;
            fast = fast.next.next;
        }
        return false;
    }
}
