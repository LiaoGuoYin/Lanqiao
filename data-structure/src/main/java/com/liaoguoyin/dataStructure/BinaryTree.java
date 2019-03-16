package com.liaoguoyin.dataStructure;

/**
 * 二叉树BinaryTree
 * 二叉树里面的遍历，并没有学数据结构的时候书上写的那么复杂：迭代就完事了
 */
public class BinaryTree {
    private TreeNode root;

    public BinaryTree(TreeNode root) {
        this.root = root;
    }

    // test
    public static void main(String[] args) {
        TreeNode rootNode = new TreeNode(1, "A");
        TreeNode aNode = new TreeNode(1, "B");
        TreeNode bNode = new TreeNode(1, "C");
        TreeNode cNode = new TreeNode(1, "D");
        TreeNode dNode = new TreeNode(1, "E");
        TreeNode eNode = new TreeNode(1, "F");
        TreeNode gNode = new TreeNode(1, "G");
        BinaryTree binaryTree = new BinaryTree(rootNode);
        rootNode.leftNode = aNode;
        rootNode.rightNode = bNode;
        aNode.leftNode = cNode;
        aNode.rightNode = dNode;
        bNode.leftNode = eNode;
        bNode.rightNode = gNode;

        System.out.println(binaryTree.getHeight());

        binaryTree.beforeOrder(rootNode);
        System.out.println();
        binaryTree.midOrder(rootNode);
        System.out.println();
        binaryTree.afterOrder(rootNode);

    }

    public int getHeight() {
        return getHeight(root);
    }

    public int getHeight(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int leftHeight = getHeight(node.leftNode);
        int rightHeight = getHeight(node.rightNode);
        return leftHeight > rightHeight ? leftHeight + 1 : rightHeight + 1;
    }

    public int getSize() {
        return getSize(root);
    }

    private int getSize(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int leftSize = getSize(node.leftNode);
        int rightSize = getSize(node.rightNode);
        return (leftSize + rightSize + 1);
    }

    private void beforeOrder(TreeNode node) {
        if (node == null) {
            return;
        }
        System.out.print(node.data + " ");
        beforeOrder(node.leftNode);
        beforeOrder(node.rightNode);
    }

    private void midOrder(TreeNode node) {
        if (node == null) {
            return;
        }
        midOrder(node.leftNode);
        System.out.print(node.data + " ");
        midOrder(node.rightNode);
    }

    private void afterOrder(TreeNode node) {
        if (node == null) {
            return;
        }
        afterOrder(node.leftNode);
        afterOrder(node.rightNode);
        System.out.print(node.data + " ");
    }


}

class TreeNode {
    int index;
    String data;
    TreeNode leftNode;
    TreeNode rightNode;

    public TreeNode(int index, String data) {
        this.index = index;
        this.data = data;
        this.leftNode = null;
        this.rightNode = null;
    }
}