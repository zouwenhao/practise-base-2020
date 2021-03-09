package cn.zou.leetcode.type_linkedlist;

/**
 * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
 *
 *  
 *
 * 示例：
 *
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/merge-two-sorted-lists
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class T021MergeTwoLists {

    public static void main(String[] args) {
        T021MergeTwoLists t021MergeTwoLists = new T021MergeTwoLists();
        ListNode l1 = new ListNode(0);
        ListNode l2 = new ListNode(1);
        ListNode a = new ListNode(2);
        ListNode b = new ListNode(5);
        ListNode c = new ListNode(6);
        ListNode d = new ListNode(10);
        ListNode e = new ListNode(11);
        ListNode f = new ListNode(13);
        ListNode g = new ListNode(17);
        l1.next = a;
        a.next = c;
        c.next = d;
        d.next = g;
        l2.next = b;
        b.next = e;
        e.next = f;
        ListNode l3;
        //l3 = t021MergeTwoLists.mergeTwoLists(l1, l2);
        l3 = t021MergeTwoLists.mergeTwoListsRetest(l1, l2);
        while (l3 != null) {
            System.out.println(l3.val);
            l3 = l3.next;
        }
    }

    /**
     * 合并两升序链表成一个新的升序链表
     * 迭代：
     * 1.设置一个哨兵用于返回合并后的结果
     * 2.当两链表指针不同时为空时，拼接节点到新链表上面：
     * 1).对两链表的数字进行判断，以值小的链表连接到新链表上，移动对应小值链表和新链表的指针，直到某一个链表为空
     * 3.将不为空的链表直接连接到新链表上
     * 4.返回哨兵的后继节点
     *
     * 时间复杂度：
     * 最好情况：O(1)，其中一链表为空
     * 平均情况：O(m+n)
     *
     * 空间复杂度：O(1)
     *
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode l3 = new ListNode(0);
        ListNode l3Head = l3;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val){
                l3.next = l1;
                l1 = l1.next;
            } else {
                l3.next = l2;
                l2 = l2.next;
            }
            l3 = l3.next;
        }
        // 当其中一个链表为空时，直接连接另一个链表的剩余部分
        l3.next = l1 == null ? l2 : l1;
        return l3Head.next;
    }

    public ListNode mergeTwoListsRetest(ListNode l1, ListNode l2) {
        ListNode l3 = new ListNode(0), l3Head = l3;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                l3.next = l1;
                l1 = l1.next;
            } else {
                l3.next = l2;
                l2 = l2.next;
            }
            l3 = l3.next;
        }
        l3.next = l1 == null ? l2 : l1;
        return l3Head.next;
    }

    /**
     * 递归（TODO: 还需品）
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoListsByRec(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        } else if (l1.val < l2.val) {
            l1.next = mergeTwoListsByRec(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }
}
