package cn.zou.leetcode.type_linkedlist;

public class T206ReverseList {

    public static void main(String[] args) {
        ListNode a1 = new ListNode(1);
        ListNode a2 = new ListNode(2);
        ListNode a3 = new ListNode(3);
        ListNode a4 = new ListNode(4);
        a1.next = a2;
        a2.next = a3;
        a3.next = a4;
        T206ReverseList t206ReverseList = new T206ReverseList();
        ListNode reverseHead = t206ReverseList.reverseList(a1);
        while (reverseHead != null) {
            System.out.println(reverseHead.val);
            reverseHead = reverseHead.next;
        }
    }

    /**
     * 头插法（迭代）
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
        ListNode reverseHead = null;
        ListNode node = head;
        while (node != null) {
            // 错误写法
//            node = node.next;
//            head.next = reverseHead;  //一直没变
//            reverseHead = head;

            ListNode nodeTemp = node.next;
            node.next = reverseHead;
            reverseHead = node;
            node = nodeTemp;
        }
        return reverseHead;
    }
}
