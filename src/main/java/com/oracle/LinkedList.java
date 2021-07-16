package com.oracle;

public class LinkedList {
    Node head;
    class Node{
        int key;
        Node next;

       public  Node(int key){
            this.key = key;
        }
        public Node(){

        }
    }

    public LinkedList(){


    }
    //2-1
    public void add(int key){
        Node newNode = new Node(key);
        if(head == null){
            head = newNode;
            return;
        }

        head.next = newNode;
        head = newNode;
        return;

    }


}
