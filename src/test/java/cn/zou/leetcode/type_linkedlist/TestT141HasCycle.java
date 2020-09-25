package cn.zou.leetcode.type_linkedlist;

import org.junit.Assert;
import org.junit.Test;

public class TestT141HasCycle {

    @Test
    public void testHasCycle() {
        T141HasCycle t141HasCycle = new T141HasCycle();
        ListNode head = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        head.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = head;
        Assert.assertTrue(t141HasCycle.hasCycle(head));
    }

    @Test
    public void testHasCycle2() {
        T141HasCycle t141HasCycle = new T141HasCycle();
        Assert.assertFalse(t141HasCycle.hasCycle(null));
    }

    @Test
    public void testHasCycle3() {
        T141HasCycle t141HasCycle = new T141HasCycle();
        ListNode head = new ListNode(1);
        Assert.assertFalse(t141HasCycle.hasCycle(head));
    }

    @Test
    public void testHasCycle4() {
        T141HasCycle t141HasCycle = new T141HasCycle();
        ListNode head = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        head.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node2;
        Assert.assertTrue(t141HasCycle.hasCycle(head));
    }

    @Test
    public void testHasCycle5() {
        T141HasCycle t141HasCycle = new T141HasCycle();
        ListNode head = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        head.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node3;
        Assert.assertTrue(t141HasCycle.hasCycle(head));
    }
}
