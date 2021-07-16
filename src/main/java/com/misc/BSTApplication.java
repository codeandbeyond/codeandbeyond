package com.misc;

public class BSTApplication {
    public static void main(String[] args) {
        BST bst = new BST();
        bst.put(10, "Neon");
        bst.put(1, "Hydrogen");
        bst.put(8, "Oxygen");
        bst.put(7, "Nitrogen");
        bst.put(3, "Lithium");
        bst.put(4, "Beryllium");
        bst.put(2, "Helium");
        bst.put(5, "Boron");

//        System.out.println(" Value at key 5 is "+bst.get(5));
       System.out.println(" Minimum key in com.misc.BST is "+bst.min());System.out.println(" Maximum key in com.misc.BST is "+bst.max());
//        System.out.println(" Floor of key 6 in com.misc.BST is "+bst.floor(6));
//        System.out.println(" Ceiling of key 6 in com.misc.BST is "+bst.ceiling(6));
       System.out.println(" Selecting a key of rank 6 in com.misc.BST is "+bst.select(6));
//        System.out.println(" Rank of key 8 in com.misc.BST is "+bst.rank(8));
        bst.preorder();
//        bst.delete(10);
//        bst.preorder();
//        bst.keys();
        /*bst.delete(3);*/
        /*bst.deleteMin();
        bst.deleteMax();*/
       /* bst.inorder();*/
       // System.out.println("Height Of Tree is "+bst.height());
        //System.out.println("Is this com.misc.BST "+bst.isBST());
        int arr[]={12,14,15,17,18,20};
        int low=0;
        int high=arr.length;
        System.out.println(" Index is "+BinarySearch.search(arr,low,high,29));

    }
}
