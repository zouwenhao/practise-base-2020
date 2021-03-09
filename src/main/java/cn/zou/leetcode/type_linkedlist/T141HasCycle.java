package cn.zou.leetcode.type_linkedlist;

/**
 * 给定一个链表，判断链表中是否有环。
 *
 * 如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。注意：pos 不作为参数进行传递，仅仅是为了标识链表的实际情况。
 *
 * 如果链表中存在环，则返回 true 。 否则，返回 false 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/linked-list-cycle
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class T141HasCycle {

    public static void main(String[] args) {
        T141HasCycle t141HasCycle = new T141HasCycle();
        System.out.println(t141HasCycle.judgeCycle(null));
        System.out.println(t141HasCycle.judgeCycle(new ListNode(0)));
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        node1.next = node2;
        node2.next = node3;
        node3.next = node1;
        System.out.println(t141HasCycle.judgeCycle(node1));
    }

    public boolean judgeCycle(ListNode head) {
        return hasCycleRetest(head);
    }

    /**
     * 链表是否有环
     * 双指针
     * 思路：
     * 1.为链表头节点设置两个快慢指针A、B
     * 2.当双指针都不为空时，进行判断
     *  1).向后移动指针A一次，指针B两次
     *  2).当两指针相等时：若不为空，说明链表存在环，返回true，否则返回false
     * 3.不存在环，返回false
     * 只要在移动指针后，指针为空，必不可能是环
     * @param head
     * @return
     */
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) return false;
        ListNode high = head, low = head;
        while (high != null && low != null) {
            high = high.next;
            if (high != null) high = high.next;
            else return false;
            low = low.next;
            if (high == low) {
                if (high != null) return true;
                else return false;
            }
        }
        return false;
    }

    public boolean hasCycleRetest(ListNode head) {
        if (head == null || head.next == null) return false;
        ListNode slow = head, high = head.next;
        while (high != null && slow != null) {
            if (slow == high) return true;
            slow = slow.next;
            high = high.next;
            if (high == null) return false;
            else high = high.next;
        }
        return false;
    }

}
