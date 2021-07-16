package com.misc;

class Node{
    int val;
    Node next;
    Node(int val){
        this.val = val;
    }

}

public class LinkedListAdd {
    Node root;
    public void addOne(){
        if(root == null) return;

        Node temp = root;
        int count =0;
        while(temp!=null && temp.val == 9){
            count++;
            temp = temp.next;
        }
        if(temp == null){
            Node newRoot = root;
            while(root!=null){
                root.val = 0;
                root = root.next;
            }
            Node oneNode= new Node(1);
            oneNode.next = newRoot;
            newRoot = oneNode;
            root = newRoot;
            return;
        }

        Node curr = root;
        Node prev = null;
        while(curr!=null ){
            if(curr.val!=9){
                prev = curr;
            }
            curr = curr.next;
        }

        Node tempNode = root;
        if(prev!=null){
            while(tempNode!=null && prev!=null){
                if(tempNode == prev){
                    prev.val+=1;
                    prev = prev.next;
                    while(prev!=null){
                        prev.val = 0;
                        prev = prev.next;
                    }

                }
                tempNode =tempNode.next;
            }
            while(root!=null){
                System.out.print(root.val+" ->");
                root = root.next;
            }
        }
    }

    public void add(int val){
        Node newNode = new Node(val);
        if(root == null){
            root = newNode;
        }else{
            newNode.next = root;
            root = newNode;
        }
    }

    public void show(){
        while(root!=null){
            System.out.print(root.val+" ->");
             root = root.next;
        }
    }

    public static void main(String[] args) {
      //  int[] arr = {9,9,9,9};
        int[] arr = {9,9,8,9,4,3};
        LinkedListAdd listAdd = new LinkedListAdd();
        for(int i:arr){
            listAdd.add(i);
        }
       // listAdd.show();

        listAdd.addOne();

        //listAdd.show();

    }
}
