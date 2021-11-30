package com.optum.fs.rest.service.util.amazon.company.preparation.hard;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;


public class CustomFileSystem {
    Node root;

    class Node {
        String name;
        StringBuilder content;
        Map<String, Node> children;
        boolean isFile;

        Node(String name) {
            this.children = new TreeMap<>();
            isFile = false;
            content = new StringBuilder();
        }
    }

    CustomFileSystem() {
        root = new Node("/");
    }

    public void mkdir(String path) {
        traverse(path);
    }

    public List<String> ls(String path) {
        List<String> files = new ArrayList<>();
        Node curr = traverse(path);
        if (curr.isFile) {
            files.add(curr.name);
        } else {
            for (String name : curr.children.keySet()) {
                files.add(name);
            }
        }
        return files;
    }

    public String readContentFromFile(String filePath) {
        Node curr = traverse(filePath);
        if (curr.isFile) {
            return curr.content.toString();
        }
        return "";
    }

    public void addContentToFile(String filePath, String content) {
        Node curr = traverse(filePath);
        curr.isFile = true;
        curr.content.append(content);
    }

    private Node traverse(String path) {
        Node curr = root;
        String[] dirs = path.split("/");
        for (String dir : dirs) {
            if (!curr.children.containsKey(dir)) {
                Node node = new Node(dir);
                curr.children.put(dir, node);
            }
            curr = curr.children.get(dir);
        }
        return curr;
    }

    public static void main(String[] args) {
        CustomFileSystem customFileSystem = new CustomFileSystem();
        customFileSystem.mkdir("/a/b/c");
        for(String name:customFileSystem.ls("/a")){
            System.out.println(name);
        }
    }
}
