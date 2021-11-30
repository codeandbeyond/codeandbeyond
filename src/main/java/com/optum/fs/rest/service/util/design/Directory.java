package com.optum.fs.rest.service.util.design;

import java.io.File;
import java.util.LinkedList;
import java.util.Queue;

public class Directory {
    public static void main(String[] args) {
        Queue<File> queue = new LinkedList<File>();
        File root = new File("/Users/apatra9/Documents/ML");     // root directory
        if (!root.exists()) {
            System.out.println(args[0] + " does not exist");
            return;
        }

        queue.add(root);
        while (!queue.isEmpty()) {
            File x = queue.remove();
            if (!x.isDirectory()) {
                System.out.println(x.length() + ":\t" + x);
            }
            else {
                File[] files = x.listFiles();
                if (files != null) {
                    for (int i = 0; i < files.length; i++)
                        queue.add(files[i]);
                }
            }
        }
    }
}
