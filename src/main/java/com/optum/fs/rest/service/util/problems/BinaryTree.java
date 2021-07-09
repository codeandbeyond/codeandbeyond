package com.optum.fs.rest.service.util.problems;


import java.util.*;

class Node {
    Node left;
    Node right;
    int data;

    Node(int item) {
        this.data = item;
        left = right = null;
    }
}

class Height {
    int height = 0;
}

class Result {
    int val = 0;
}

public class BinaryTree {
    private static final String spliter = ",";
    private static final String NN = "X";
    private static Node root;
    private static int preIndex = 0;
    private static List<Integer> path = new ArrayList<>();

    public BinaryTree(int rootData) {
        root = new Node(rootData);
        root.left = null;
        root.right = null;
    }

    public BinaryTree() {
        root = null;
    }

    public static void printInorder() {
        Node tempRoot = root;
        inorder(tempRoot);
    }

    private static void inorder(Node tempRoot) {
        if (tempRoot == null)
            return;
        inorder(tempRoot.left);
        System.out.print(tempRoot.data + " ->");
        inorder(tempRoot.right);

    }

    public boolean isHeightBalanced(Node root, Height height) {
        if (root == null) {
            height.height = 0;
            return true;
        }
        Height lHeight = new Height();
        Height rHeight = new Height();

        boolean l = isHeightBalanced(root.left, lHeight);
        boolean r = isHeightBalanced(root.right, rHeight);

        height.height = (lHeight.height > rHeight.height ? lHeight.height : rHeight.height) + 1;

        if (Math.abs(lHeight.height - rHeight.height) >= 2) {
            return false;
        } else {
            return l && r;
        }
    }

    public boolean isSumTree(Node root) {
        if (root == null || (isLeaf(root)))
            return true;
        int ls = 0;
        int rs = 0;
        ls = sumNode(root.left);
        rs = sumNode(root.right);
        if (ls + rs == root.data && isSumTree(root.left) && isSumTree(root.right)) {
            return true;
        }
        return false;


    }

    public boolean isSumTreeTricky(Node root) {
        int ls = 0;

        if (root == null || isLeaf(root))
            return true;
        if (isSumTree(root.left) && isSumTree(root.right)) {
            if (root.left == null) {
                ls = 0;
            } else if (isLeaf(root.left)) {
                ls = root.left.data;
            } else {
                ls = 2 * root.left.data;
            }
            int rs = 0;
            if (root.right == null) {
                rs = 0;
            } else if (isLeaf(root.right)) {
                rs = root.left.data;
            } else {
                rs = 2 * root.right.data;
            }
            if (root.data == ls + rs) {
                return true;
            } else {
                return false;
            }
        }
        return false;


    }

    private boolean isLeaf(Node root) {
        if (root == null)
            return false;
        return root.left == null && root.right == null;
    }

    private int sumNode(Node node) {
        if (node == null)
            return 0;
        return sumNode(node.left) + node.data + sumNode(node.right);
    }

    public static int size() {
        Node tempNode = root;
        return size(tempNode);
    }

    static int levelOfFirstNode = 0;

    public static void printLeftView(Node root, int level) {
        if (root == null)
            return;
        if (levelOfFirstNode < level) {
            System.out.println(" " + root.data);
            levelOfFirstNode = level;
        }
        printLeftView(root.left, level + 1);
        printLeftView(root.right, level + 1);
    }

    private static int size(Node tempNode) {
        if (tempNode == null)
            return 0;
        return (size(tempNode.left) + size(tempNode.right) + 1);
    }

    public int findLCA(int n1, int n2) {
        Node node = findLCA(root, n1, n2);
        if (node != null) {
            return node.data;
        } else return -1;
    }

    private Node findLCA(Node root, int n1, int n2) {
        if (root == null)
            return null;
        if (root.data == n1 || root.data == n2) {
            return root;
        }
        Node left_lca = findLCA(root.left, n1, n2);
        Node right_lca = findLCA(root.right, n1, n2);

        if (left_lca != null && right_lca != null) {
            return root;
        }
        return left_lca != null ? left_lca : right_lca;

    }

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.root = new Node(10);
        tree.root.left = new Node(8);
        tree.root.left.left = new Node(7);
        tree.root.left.right = new Node(4);
        tree.root.left.left.left = new Node(-6);
        tree.root.left.left.right = new Node(5);

        tree.root.right = new Node(3);
        tree.root.right.left = new Node(1);
        tree.root.right.right = new Node(2);
        tree.root.right.right.right = new Node(11);


        List<Integer> result = tree.distanceK(root, new Node(8), 2);
        for (Integer data : result) {
            System.out.println(data);
        }
        int[] preOrder = {890, 325, 290, 530, 965};
        tree.printLeavesInPreOrderTraversal(preOrder);

//         tree.kDistanceUtilFromroot(2);
//        String searlized = tree.serialize(root);
//        System.out.println(" Searlized " + searlized);
//        root = tree.deserialize(searlized);
//        inorder(root);
//        System.out.println("Maximum Sum "+tree.maxPathSumBetweenTwoLeaves());

//        System.out.println(" Left View of Tree");
//        printLeftView(root, 1);
//        System.out.println(" "+tree.isSumTreeTricky(root));

//        int[] pre = {1, 2, 4, 5, 3, 6, 7};
//        int[] in = {4, 2, 5, 1, 6, 3, 7};
//        root = buildTree(in, pre, 0, in.length - 1);
//        System.out.println(" is the tree Height Balanced " + tree.isHeightBalanced(root, new Height()));
//        System.out.println(" LCA " + tree.findLCA(2, 7));
//        System.out.println("LCA " + tree.findLCA(4, 5));
//        // printInorder();
//        // toSumTree(root);
//        printInorder();
//        System.out.println("Diameter of the tree " + diaMeterOfTree(root, new Height()));
//        int k = 15;
//        printKapthSum(k);
//        System.out.println(" ");
//        System.out.println("Size of Tree " + BinaryTree.size());
    }

    private static void printKapthSum(int k) {

        printKapthSum(root, k);
        pathSum(root, k);
    }

    Map<Node, Integer> nodeDistancemap = new HashMap<>();

    public List<Integer> distanceK(Node root, Node target, int K) {
        List<Integer> res = new LinkedList<>();
        find(root, target);
        dfs(root, target, K, nodeDistancemap.get(root), res);
        return res;
    }

    // find target node first and store the distance in that path that we could use it later directly
    private int find(Node root, Node target) {
        if (root == null) return -1;
        if (root.data == target.data) {
            nodeDistancemap.put(root, 0);
            return 0;
        }
        int left = find(root.left, target);
        if (left >= 0) {
            nodeDistancemap.put(root, left + 1);
            return left + 1;
        }
        int right = find(root.right, target);
        if (right >= 0) {
            nodeDistancemap.put(root, right + 1);
            return right + 1;
        }
        return -1;
    }

    private void dfs(Node root, Node target, int K, int length, List<Integer> res) {
        if (root == null) return;
        if (nodeDistancemap.containsKey(root)) length = nodeDistancemap.get(root);
        if (length == K) res.add(root.data);
        dfs(root.left, target, K, length + 1, res);
        dfs(root.right, target, K, length + 1, res);
    }

    private static void printKapthSum(Node root, int k) {
        if (root == null)
            return;
        path.add(root.data);
        printKapthSum(root.left, k);
        printKapthSum(root.right, k);
        int sum = 0;
        for (int j = path.size() - 1; j >= 0; j--) {
            sum += path.get(j);
            if (sum == k) {
                printKapths(path, j);
            }
        }
        path.remove(path.size() - 1);

    }

    static HashMap<Integer, Integer> map = new HashMap<>();

    public static int pathSum(Node root, int sum) {
        if (root == null) {
            return 0;
        }
        map.put(0, 1);
        return pathSumHelper(root, 0, sum);
    }

    private static int pathSumHelper(Node node, int currSum, int target) {
        if (node == null) {
            return 0;
        }
        currSum += node.data;
        int numOfPaths = map.getOrDefault(currSum - target, 0);
        map.put(currSum, map.getOrDefault(currSum, 0) + 1);
        numOfPaths += pathSumHelper(node.left, currSum, target) + pathSumHelper(node.right, currSum, target);
        map.put(currSum, map.get(currSum) - 1);
        return numOfPaths;
    }

    private static void printKapths(List<Integer> path, int j) {
        for (int i = j; i < path.size(); i++) {
            System.out.print(path.get(i) + " ");
        }
        System.out.println("");
    }

    private static int diaMeterOfTree(Node root, Height height) {
        Height lh = new Height();
        Height rh = new Height();
        if (root == null) {
            height.height = 0;
            return 0;
        }
        int lDiameter = diaMeterOfTree(root.left, lh);
        int rDiameter = diaMeterOfTree(root.right, rh);
        height.height = Math.max(lh.height, rh.height) + 1;
        return Math.max(lh.height + rh.height + 1, Math.max(lDiameter, rDiameter));

    }

    private static int toSumTree(Node root) {
        if (root == null)
            return 0;
        int oldVal = root.data;
        root.data = toSumTree(root.left) + toSumTree(root.right);
        return oldVal + root.data;
    }

    private static Node buildTree(int[] in, int[] pre, int inStart, int inEnd) {
        if (inStart > inEnd)
            return null;
        Node tempNode = new Node(pre[preIndex++]);
        if (inStart == inEnd)
            return tempNode;
        int inIndex = search(in, tempNode.data);
        if (inIndex == -1)
            throw new RuntimeException("Nodes are not consistent");
        tempNode.left = buildTree(in, pre, inStart, inIndex - 1);
        tempNode.right = buildTree(in, pre, inIndex + 1, inEnd);
        return tempNode;

    }

    private static int search(int[] in, int data) {
        int index = -1;
        for (int i = 0; i < in.length; i++) {
            if (in[i] == data) {
                index = i;
            }
        }
        return index;
    }

    public void createTree(int[] parent) {
        Node[] created = new Node[parent.length];

        for (int i = 0; i < created.length; i++) {
            created[i] = null;
        }
        for (int i = 0; i < parent.length; i++) {
            createTree(parent, created, i);
        }
    }

    private void createTree(int[] parent, Node[] created, int i) {
        if (created[i] != null) {
            return;
        }
        Node node = new Node(i);
        created[i] = node;
        if (parent[i] == -1) {
            root = node;
            return;
        }
        if (created[parent[i]] == null) {
            createTree(parent, created, parent[i]);
        }
        Node parentNode = created[parent[i]];
        if (parentNode.left == null) {
            parentNode.left = created[i];
        } else {
            parentNode.right = created[i];
        }
    }

    public void kDistanceUtilFromroot(int k) {
        List<Integer> pathContent = new ArrayList<>();
        int pathLength = 0;
        List<Boolean> visited = new ArrayList<>();
        printKdistance(root, k, pathContent, visited, pathLength);
    }

    private void printKdistance(Node root, int k, List<Integer> pathContent, List<Boolean> visited, int pathLength) {
        if (root == null) {
            return;
        }
        pathContent.add(pathLength, root.data);
        visited.add(pathLength, false);
        pathLength++;

        if (isLeaf(root) && pathLength - k - 1 >= 0 && Boolean.FALSE.equals(visited.get(pathLength - k - 1))) {
            System.out.print(pathContent.get(pathLength - k - 1) + " ");
            visited.set(pathLength - k - 1, Boolean.TRUE);
        }
        printKdistance(root.left, k, pathContent, visited, pathLength);
        printKdistance(root.right, k, pathContent, visited, pathLength);
    }

    public int maxPathSumBetweenTwoLeaves() {
        Result result = new Result();
        maxPathSumBetweenTwoLeavesUtil(root, result);
        return result.val;
    }

    private int maxPathSumBetweenTwoLeavesUtil(Node root, Result result) {
        if (root == null) return 0;
        if (isLeaf(root)) return root.data;
        int ls = maxPathSumBetweenTwoLeavesUtil(root.left, result);
        int rs = maxPathSumBetweenTwoLeavesUtil(root.right, result);
        if (hasBothChildren(root)) {
            result.val = Math.max(result.val, ls + rs + root.data);
            return Math.max(ls, rs) + root.data;
        }
        return root.left == null ? rs + root.data : ls + root.data;

    }

    private boolean hasBothChildren(Node root) {
        return root.left != null && root.right != null;
    }


    public void printLeavesInPreOrderTraversal(int[] pre) {
        int[] in = Arrays.copyOf(pre, pre.length);
        Arrays.sort(in);
        printLeavesRecursion(in, pre, preIndex, 0, pre.length - 1);
    }

    private void printLeavesRecursion(int[] in, int[] pre, int preIndex, int l, int r) {
        if (l == r) {
            System.out.println(in[l]);
            return;
        }
        if (l < 0 || l > r || r < 0 || r > pre.length - 1) {
            return;
        }
        int loc = Arrays.binarySearch(in, pre[preIndex]);
        preIndex++;
        printLeavesRecursion(in, pre, preIndex, l, loc - 1);
        printLeavesRecursion(in, pre, preIndex, loc + 1, r);
    }

    public String serialize(Node root) {
        StringBuilder sb = new StringBuilder();
        buildString(root, sb);
        return sb.toString();
    }

    private void buildString(Node node, StringBuilder sb) {
        if (node == null) {
            sb.append(NN).append(spliter);
        } else {
            sb.append(node.data).append(spliter);
            buildString(node.left, sb);
            buildString(node.right, sb);
        }
    }

    // Decodes your encoded data to tree.
    public Node deserialize(String data) {
        Deque<String> nodes = new LinkedList<>();
        nodes.addAll(Arrays.asList(data.split(spliter)));
        return buildTree(nodes);
    }

    private Node buildTree(Deque<String> nodes) {
        String val = nodes.remove();
        if (val.equals(NN)) return null;
        else {
            Node node = new Node(Integer.valueOf(val));
            node.left = buildTree(nodes);
            node.right = buildTree(nodes);
            return node;
        }
    }
}
