package com.optum.fs.rest.service.util.problems;

public class LinkedListService {
    public static Node head;
    public static Node last;

    public static class Node {
        public Node(Integer data2) {
            this.data = data2;
        }

        public Node() {
            // TODO Auto-generated constructor stub
        }

        Node next;
        Integer data;

    }

    public static Node getNext(Node node) {
        return node.next;
    }

    public boolean createNodeIntheBegining(Integer data) {
        if (head == null) {
            Node temp = new Node(data);
            temp.next = null;
            head = temp;
            return true;
        } else {
            Node temp = new Node(data);
            temp.next = head;
            head = temp;
            return true;
        }

    }

    public static void show() {
        Node p = head;

        while (p != null) {
            System.out.print(p.data + "->");
            p = p.next;
        }
        System.out.print("null");
		 
		/*for (int i = 0; i < 6; i++) {
			System.out.println(p.data + " ");
			p = p.next;
		}*/
    }

    public boolean insertAfter(int value, int after) {
        Node tmp;
        Node p = head;
        while (p != null && p.data != after) {
            tmp = p;
            p = p.next;
        }
        if (p != null) {
            tmp = new Node(value);
            tmp.next = p.next;
            p.next = tmp;
            return true;
        } else
            return false;
    }

    public int findLength() {
        Node root = head;
        return findLength(root);

    }

    private int findLength(Node head2) {
        if (head2 == null)
            return 0;
        else {
            return 1 + findLength(head2.next);
        }
    }

    public boolean searchElement(int element) {
        Node root = head;
        return serachElement(root, element);

    }

    private boolean serachElement(Node root, int element) {
        if (root == null)
            return false;
        if (root.data == element)
            return true;
        else
            return serachElement(root.next, element);
    }

    public int getNthNode(int position) {
        Node root = head;
        return getNode(root, position);
    }

    private int getNode(Node root, int position) {
        for (int i = 0; i < position - 1 && root != null; i++) {
            root = root.next;
        }
        if (root != null)
            return root.data;
        else
            return 0;
    }

    public void delete() {
        head = deleteLinkedList(head);
        if (head == null) {
            System.out.println("Deleted");
        }
    }

    private Node deleteLinkedList(Node head) {
        while (head != null) {
            Node temp = head;
            temp = null;
            head = head.next;

        }
        return head;
    }

    public void deleteLastNode() {
        last = head;

        while (last.next != null)
            last = last.next;

        System.out.println(" Node deleted " + deleteExactLastNode(last));
    }

    private int deleteExactLastNode(Node last) {
        int data = last.data;
        Node dummy = new Node();
        dummy.next = null;
        last.next = dummy.next;
        last = dummy = null;
        show();
        return data;


    }

    public static boolean isPalindrome() {
        Node root = head;
        return isListPalindrmoe(root);

    }

    private static boolean isListPalindrmoe(Node root) {
        Node fast_ptr, slow_ptr, second_half, mid_node;
        fast_ptr = root;
        slow_ptr = root;
        second_half = null;
        mid_node = null;
        Node prev_slow = null;
        while (fast_ptr != null && fast_ptr.next != null && slow_ptr != null) {
            fast_ptr = fast_ptr.next.next;
            prev_slow = slow_ptr;
            slow_ptr = slow_ptr.next;
        }
        if (fast_ptr != null) {//for odd number of nodes 1->2->3->4->3->2->1
            mid_node = slow_ptr;

            prev_slow.next = null;
        }
        second_half = slow_ptr.next;
        Node reversed = reverseList(second_half);
        boolean result = compareList(root, reversed);
        second_half = reverseList(reversed);
        if (mid_node != null) {
            mid_node.next = second_half;
            prev_slow.next = mid_node;
        } else {
            prev_slow.next = second_half;
        }
        return result;
    }

    public static int getMiddleNode() {
        Node root = head;
        return getMiddleNode(root).data;

    }

    private static Node getMiddleNode(Node root) {
        Node fast_ptr, slow_ptr;
        slow_ptr = root;
        fast_ptr = root;

        while (fast_ptr != null && fast_ptr.next != null && slow_ptr != null) {
            fast_ptr = fast_ptr.next.next;

            slow_ptr = slow_ptr.next;
        }
        return slow_ptr;
    }

    public static boolean compareList(Node n1, Node n2) {
        if (n1 == null && n2 == null)
            return true;

        else if (n1 == null || n2 == null)
            return false;
        else {
            while (n1 != null && n2 != null) {

                if (n1.data == n2.data) {
                    n1 = n1.next;
                    n2 = n2.next;
                } else {
                    return false;
                }
            }
        }
        return true;

    }

    public static Node reverseList(Node root) {
        Node next, current, prev;
        prev = null;
        current = root;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;

    }

    public static void sort() {
        Node root = head;
        sortingZerosOnesTwos(root);

    }

    private static void sortingZerosOnesTwos(Node root) {
        int count[] = {0, 0, 0};
        Node ptr = root;
        while (ptr != null) {
            count[ptr.data] += 1;
            ptr = ptr.next;
        }
        ptr = root;
        int i = 0;
        while (ptr != null) {
            if (count[i] == 0)
                i++;
            else {
                ptr.data = i;
                --count[i];
                ptr = ptr.next;
            }
        }
        head = root;

    }

    public static void seggreGateOddEven() {
        Node current = head;
        Node end = head;
        Node newEnd = null;
        Node prev = null;
        while (end.next != null) {
            end = end.next;
        }
        newEnd = end;
        //Considering all the odd nodes before first even node
        while (current.data % 2 != 0 && current != end) {
            newEnd.next = current;
            current = current.next;
            newEnd.next.next = null;
            newEnd = newEnd.next;
        }
        if (current.data % 2 == 0) {
            head = current;
            while (current != end) {
                if (current.data % 2 == 0) {
                    prev = current;
                    current = current.next;
                } else {
                    prev.next = current.next;
                    current.next = null;
                    newEnd.next = current;
                    newEnd = current;
                    current = prev.next;

                }
            }
        } else prev = current;
        if (newEnd != end && end.data % 2 != 0) {
            prev.next = end.next;
            end.next = null;
            newEnd.next = end;
        }
    }

    public static void deleteLesserNode() {
        head = reverseList(head);
        deleteLesserNode(head);
        head = reverseList(head);
    }

    private static void deleteLesserNode(Node head) {
        Node current = head;
        Node maxNode = head;
        while (current != null && current.next != null) {
            if (maxNode.data > current.next.data) {
                Node temp = current.next;
                current.next = temp.next;
                temp = null;
            } else {
                maxNode = current;
                current = current.next;
            }
        }
    }

    public static Node sortedIntersect(Node list1, Node list2) {
        Node dummy = new Node();
        Node last;
        last = dummy;

        while (list1 != null && list2 != null) {
            if (list1.data == list2.data) {
                push(last, list1.data);
                list1 = list1.next;
                list2 = list2.next;
            } else if (list1.data < list2.data) {
                list1 = list1.next;
            } else {
                list2 = list2.next;
            }
        }
        return dummy.next;
    }

    private static void push(Node tail, int data) {
        Node node = new Node(data);
        tail.next = node;
        tail = node;
    }

    public static void sortOnActualValues() {
        Node current = head;
        while (current != null && current.next != null) {
            if (current.data > current.next.data) {
                Node temp = current.next;
                current.next = current.next.next;
                temp.next = head;
                head = temp;
            } else {
                current = current.next;
            }
        }
        System.out.println(" after Sorting");
        show();
    }

    public static void deleteNodeGreaterThanK(int k) {
        while (head != null && head.data > k) {
            Node temp = head.next;
            head.next = null;
            head = temp;
        }
        if (head == null)
            return;
        Node current = head;
        while (current.next != null) {
            if (current.next.data > k) {
                Node temp = current.next;
                current.next = current.next.next;
                temp.next = null;
            } else {
                current = current.next;
            }
        }
    }

    public static void deleteNodeLesserThanK(int k) {
        while (head != null && head.data < k) {
            Node temp = head.next;
            head.next = null;
            head = temp;
        }
        if (head == null)
            return;
        Node current = head;
        while (current.next != null) {
            if (current.next.data < k) {
                Node temp = current.next;
                current.next = current.next.next;
                temp.next = null;
            } else {
                current = current.next;
            }
        }
    }


}
