package com.optum.fs.rest.service.util.design;

import java.util.LinkedList;
import java.util.Queue;

public class QuadTree {
    public static void main(String[] args) {
        QuadTree quadTree = new QuadTree();
        int[][] grid = {
                {1, 1, 1, 1, 0, 0, 0, 0},
                {1, 1, 1, 1, 0, 0, 0, 0},
                {1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 0, 0, 0, 0},
                {1, 1, 1, 1, 0, 0, 0, 0},
                {1, 1, 1, 1, 0, 0, 0, 0},
                {1, 1, 1, 1, 0, 0, 0, 0}
        };
        QuadNode node = quadTree.buildQuadTree(grid);
        printQuadTree(node);
    }

    private static void printQuadTree(QuadNode node) {
        if (node == null) return;
        Queue<QuadNode> q = new LinkedList<>();
        q.add(node);
        while (!q.isEmpty()) {
            int size = q.size();
            while (size-- > 0) {
                QuadNode temp = q.poll();

                if (temp!=null && temp.isLeaf) {
                    System.out.print(" "+temp.value);
                }
                if (temp != null) {
                    q.offer(temp.topLeft);
                    q.offer(temp.topRight);
                    q.offer(temp.bottomLeft);
                    q.offer(temp.bottomRight);
                }
            }
            System.out.println();
        }
    }

    public QuadNode buildQuadTree(int[][] grid) {
        return buildQuadTree(grid, 0, 0, grid.length);
    }

    private QuadNode buildQuadTree(int[][] grid, int x, int y, int length) {
        if (length == 1) {
            return new QuadNode(grid[x][y] != 0, true);
        }
        QuadNode node = new QuadNode();
        QuadNode topLeft = buildQuadTree(grid, x, y, length / 2);
        QuadNode topRight = buildQuadTree(grid, x, y + length / 2, length / 2);
        QuadNode bottomLeft = buildQuadTree(grid, x + length / 2, y, length / 2);
        QuadNode bottomRight = buildQuadTree(grid, x + length / 2, y + length / 2, length / 2);

        if (topLeft.isLeaf && topRight.isLeaf && bottomLeft.isLeaf && bottomRight.isLeaf && topLeft.value == topRight.value && topRight.value == bottomLeft.value && bottomLeft.value == bottomRight.value) {
            node.isLeaf = true;
            node.value = topLeft.value;
        } else {
            node.topLeft = topLeft;
            node.topRight = topRight;
            node.bottomLeft = bottomLeft;
            node.bottomRight = bottomRight;
        }
        return node;
    }
}

class QuadNode {
    QuadNode topLeft;
    QuadNode topRight;
    QuadNode bottomLeft;
    QuadNode bottomRight;
    boolean value;
    boolean isLeaf;

    public QuadNode(QuadNode topLeft, QuadNode topRight, QuadNode bottomLeft, QuadNode bottomRight, boolean value, boolean isLeaf) {
        this.topLeft = topLeft;
        this.topRight = topRight;
        this.bottomLeft = bottomLeft;
        this.bottomRight = bottomRight;
        this.value = value;
        this.isLeaf = isLeaf;
    }

    public QuadNode() {

    }

    public QuadNode(boolean value, boolean isLeaf) {
        this.value = value;
        this.isLeaf = isLeaf;
    }
}
