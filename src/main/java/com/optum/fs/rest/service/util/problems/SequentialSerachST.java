package com.optum.fs.rest.service.util.problems;

public class SequentialSerachST<Key,Value> {
    private Node first;
    private class Node{
        Key key;
        Value val;
        Node next;
        public Node(Key key,Value val,Node next){
            this.key=key;
            this.val=val;
            this.next=next;
        }

    }
    public Value get(Key key){
        for(Node x=first;x!=null;x=x.next){
            if(x.key.equals(key)){
                return x.val;
            }
        }
        return null;
    }
    public boolean contains(Key key){
        return get(key)!=null;
    }
    public void put(Key key,Value val){
        for(Node x=first;x!=null;x=x.next){
            if(x.key.equals(key)){
                x.val=val;
            }
        }
        first=new Node(key,val,first);
    }
    public void delete(Key key) {
        first = delete(first, key);
    }

    // delete key in linked list beginning at Node x
    // warning: function call stack too large if table is large
    private Node delete(Node x, Key key) {
        if (x == null) return null;
        if (key.equals(x.key)) {
            return x.next;
        }
        x.next = delete(x.next, key);
        return x;
    }

    public static void main(String[] args) {
        Integer key=5;
        String value="Java";
        SequentialSerachST st=new SequentialSerachST();
        st.put(key,value);
        System.out.println(" "+st.get(key));
    }
}
