package com.optum.fs.rest.service.util.amazon.company.preparation.medium;

import java.util.HashMap;
import java.util.Map;

public class DesignFileSystem {
    Map<String, Integer> paths = new HashMap();

    public boolean createPath(String path, int value) {
        if (path.isEmpty() || (path.length() == 1 && path.equals("/")) || paths.containsKey(path)) {
            return false;
        }
        int lastIndex = path.lastIndexOf("/");
        String parent = path.substring(0, lastIndex);

        if (parent.length() > 1 && !paths.containsKey(parent)) {
            return false;
        }

        paths.put(path, value);
        return true;
    }

    public int get(String path) {
        return paths.getOrDefault(path, -1);
    }

    public static void main(String[] args) {
        DesignFileSystem designFileSystem = new DesignFileSystem();
        System.out.println(designFileSystem.createPath("/a",5));
        System.out.println(designFileSystem.get("/a"));
    }
}
