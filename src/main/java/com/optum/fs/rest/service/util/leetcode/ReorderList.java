package com.optum.fs.rest.service.util.leetcode;

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

public class ReorderList {
    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node4.next = node5;
        node3.next = node4;
        node2.next = node3;
        node.next = node2;
        ReorderList list = new ReorderList();
        list.reorderList(node);
        while(node!=null){
            System.out.print(node.val+" -->");
            node = node.next;
        }
        list.removeNthFromEnd(node,1);
    }

    public void reorderList(ListNode head) {
        if (head == null || head.next == null)
            return;

        ListNode slow = head;
        ListNode fast = head;
        ListNode l1 = head;
        ListNode prev = null;

        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        prev.next = null;
        ListNode l2 = reverse(slow);

        mergeAlternate(l1, l2);
    }

    public ListNode reverse(ListNode node) {
        ListNode current = node;
        ListNode prev = null;
        while (current != null) {
            ListNode next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }

    public void mergeAlternate(ListNode l1, ListNode l2) {
        while (l1 != null) {
            ListNode l1Next = l1.next;
            ListNode l2Next = l2.next;

            l1.next = l2;
            if (l1Next == null) {
                break;
            }
            l2.next = l1Next;

            l1 = l1Next;
            l2 = l2Next;

        }
    }
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null){
            return null;
        }
        ListNode temp = new ListNode(0);
        temp.next = head;

        ListNode fast = temp;
        ListNode slow = temp;
        for(int i = 1 ; i<=n+1;i++){
            fast = fast.next;
        }
        while(fast != null){
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return temp.next;
    }
}