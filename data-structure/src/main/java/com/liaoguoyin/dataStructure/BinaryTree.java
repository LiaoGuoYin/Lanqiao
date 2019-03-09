package com.liaoguoyin.dataStructure;

/**
 * 二叉树BinaryTree
 */
public class BinaryTree {
    private TreeNode root;

    public BinaryTree(TreeNode root) {
        this.root = root;
    }

    // test
    public static void main(String[] args) {
        TreeNode rootNode = new TreeNode(1, "testo");
        TreeNode aNode = new TreeNode(1, "test1");
        TreeNode bNode = new TreeNode(1, "test2");
        TreeNode cNode = new TreeNode(1, "test3");
        TreeNode dNode = new TreeNode(1, "test4");
        TreeNode eNode = new TreeNode(1, "testtt");
        BinaryTree binaryTree = new BinaryTree(rootNode);
        rootNode.leftNode = aNode;
        rootNode.rightNode = bNode;
        aNode.leftNode = cNode;
        bNode.rightNode = dNode;
        dNode.leftNode = eNode;

        System.out.println(binaryTree.getHeight());


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

    public int getSize(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int leftSize = getSize(node.leftNode);
        int rightSize = getSize(node.rightNode);
        return (leftSize + rightSize + 1);
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