package cn.zou.leetcode.type_linkedlist;

/**
 * 编写一个程序，找到两个单链表相交的起始节点。
 *
 * 如下面的两个链表：
 *
 *
 *
 * 在节点 c1 开始相交。
 *
 *  
 *
 * 示例 1：
 *
 *
 *
 * 输入：intersectVal = 8, listA = [4,1,8,4,5], listB = [5,0,1,8,4,5], skipA = 2, skipB = 3
 * 输出：Reference of the node with value = 8
 * 输入解释：相交节点的值为 8 （注意，如果两个链表相交则不能为 0）。从各自的表头开始算起，链表 A 为 [4,1,8,4,5]，链表 B 为 [5,0,1,8,4,5]。在 A 中，相交节点前有 2 个节点；在 B 中，相交节点前有 3 个节点。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/intersection-of-two-linked-lists
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class T160GetIntersectionNode {

    public static void main(String[] args) {
        T160GetIntersectionNode t160GetIntersectionNode = new T160GetIntersectionNode();
        ListNode a1 = new ListNode(1);
        ListNode a2 = new ListNode(2);
        ListNode a3 = new ListNode(3);
        ListNode a4 = new ListNode(4);
        ListNode c1 = new ListNode(7);
        ListNode c2 = new ListNode(8);
        ListNode b1 = new ListNode(5);
        ListNode b2 = new ListNode(6);
        ListNode d1 = new ListNode(10);
        a1.next = a2;
        a2.next = a3;
        a3.next = a4;
        a4.next = c1;
        b1.next = b2;
        b2.next = c1;
        c1.next = c2;
        System.out.println(t160GetIntersectionNode.getIntersectionNode(a1, b1) != null ?
                t160GetIntersectionNode.getIntersectionNode(a1, b1).val : "null");
        System.out.println(t160GetIntersectionNode.getIntersectionNode(a2, b1) != null ?
                t160GetIntersectionNode.getIntersectionNode(a2, b1).val : "null");
        System.out.println(t160GetIntersectionNode.getIntersectionNode(c2, b1) != null ?
                t160GetIntersectionNode.getIntersectionNode(c2, b1).val : "null");
        System.out.println(t160GetIntersectionNode.getIntersectionNode(d1, b1) != null ?
                t160GetIntersectionNode.getIntersectionNode(d1, b1).val : "null");
    }

    /**
     * 论证：
     * 对于链表A和B，存在A+B=B+A
     * 若两链表存在相交节点，则从相交节点开始两链表最后一段长度相同，记为C
     * A+B=B+A =》 A1+C+B1+C=B1+C+A1+C =》 (A1+C+B1)+C=(B1+C+A1)+C
     * 所以同时从A起点开始一直走向B的结尾和从B起点开始一直走向A的结尾时，一定会【同时】开始相交于一个节点
     *
     * 思路：
     * 分别对链表A和链表B的头节点添加一个指针，
     * 同时向后移动指针。当两指针不同时为空时，继续移动。当两指针同时为空时，说明已经走完相同路径，结束移动，返回null
     * 当其中一指针为空时，移动指针到另一个链表的头指针上继续移动
     * 当两指针相同时，返回该节点
     *
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode nodeA = headA, nodeB = headB;
        while (nodeA != null || nodeB != null) {
            if (nodeA == nodeB) return nodeA;
            nodeA = nodeA != null ? nodeA.next : headB;
            nodeB = nodeB != null ? nodeB.next : headA;
        }
        return null;
    }

    public ListNode getIntersectionNode_v1(ListNode headA, ListNode headB) {
        ListNode a = headA, b = headB;
        //ListNode endA = null, endB = null;
        int endA = 0, endB = 0;
        while (!(endA == 2 && endB == 2)) {
            if (a == b) return a;
            if (a.next != null) {
                a = a.next;
            }
            else {
                a = headB;
                endA ++;
            }
            if (b.next != null) {
                b = b.next;
            }
            else {
                b = headA;
                endB++;
            }
            System.out.println(a.val + " " + b.val);
        }
        return null;
    }
}
