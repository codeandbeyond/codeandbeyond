package com.optum.fs.rest.service.util.com.amazon.interview.experience.experience15;

import com.optum.fs.rest.service.util.problems.BinarySearchTrees;

public class InOrderSuccesorInBst {
    public static void main(String[] args) {
        BinarySearchTrees binarySearchTrees = new BinarySearchTrees();
        binarySearchTrees.put(64,"Sixty Four");
        binarySearchTrees.put(32,"Thirty two");
        binarySearchTrees.put(48,"Forty Eight");
        binarySearchTrees.put(96,"Ninety Six");
        binarySearchTrees.put(8,"Eight");
        System.out.print(" "+ binarySearchTrees.inOrderSuccesor(8));
        System.out.print(" "+ binarySearchTrees.inOrderSuccesor(32));
        System.out.print(" "+ binarySearchTrees.inOrderSuccesor(48));
        System.out.print(" "+ binarySearchTrees.inOrderSuccesor(64));
        System.out.println(binarySearchTrees.isBST());

    }


}
