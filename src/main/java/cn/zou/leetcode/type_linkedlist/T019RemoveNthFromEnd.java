package cn.zou.leetcode.type_linkedlist;

import java.util.Objects;

/**
 * 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
 *
 * 进阶：你能尝试使用一趟扫描实现吗？
 */
public class T019RemoveNthFromEnd {
    int x;

    public static void main(String[] args) {
        T019RemoveNthFromEnd t019RemoveNthFromEnd = new T019RemoveNthFromEnd();
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        ListNode node = t019RemoveNthFromEnd.removeNthFromEnd(node4, 2);
        while (node!=null) {
            System.out.println(node.val);
            node = node.next;
        }
    }

    /**
     * 双指针
     * 快指针先向后移动n次，再迭代同时移动两指针。
     * 当快指针的next为空时，表示慢指针的下一节点就是要被删除的节点，移动慢指针的next
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) return head;
        ListNode newHead = head;
        ListNode node = head, fast = head;
        // 构造快慢指针的步数差
        for (int i = 0; i < n; i++) {
            if (fast != null) {
                fast = fast.next;
            } else {
                return head; // 链表长度小于n，返回原链表
            }
        }
        if (fast == null) return head.next; // n等于链表的长度，删除头节点
        while (fast.next != null) {
            fast = fast.next;
            node = node.next;
        }
        node.next = node.next.next;
        return newHead;
    }
}
