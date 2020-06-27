package com.ieugene.algorithmdemo;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class BinaryTreeTraversal {

    public void demo() {
        LinkedList<Integer> inputList = new LinkedList<>(Arrays.asList(3, 2, 9, 1, 5, 10, 6, 7, 8, 11, 4));
        TreeNode node = createBinaryTree(inputList, "root");
        System.out.println("前序遍历：");
        preOrderTraversal(node);
        System.out.println();
        System.out.println("中序遍历：");
        inOrderTraversal(node);
        System.out.println();
        System.out.println("后序遍历：");
        postOrderTraversal(node);
        System.out.println();
        System.out.println("层序遍历：");
        levelOrderTraversal(node);
    }

    /**
     * 构建二叉树
     *
     * @param inputList 数据列表
     * @param name      节点名称 root, left, right
     * @return 根节点
     */
    public TreeNode createBinaryTree(LinkedList<Integer> inputList, String name) {
        TreeNode treeNode = null;
        if (inputList != null && !inputList.isEmpty()) {
            Integer data = inputList.removeFirst();
            if (data != null) {
                treeNode = new TreeNode(data);
                System.out.print(name + data + " ");
                treeNode.leftChild = createBinaryTree(inputList, "left");
                treeNode.rightChild = createBinaryTree(inputList, "right");
            }
        }
        return treeNode;
    }

    /**
     * 前序遍历
     *
     * @param node 根节点
     */
    public void preOrderTraversal(TreeNode node) {
        if (node == null) return;
        System.out.print(node.data + " ");
        preOrderTraversal(node.leftChild);
        preOrderTraversal(node.rightChild);
    }

    /**
     * 中序遍历
     *
     * @param node 根节点
     */
    public void inOrderTraversal(TreeNode node) {
        if (node == null) return;
        inOrderTraversal(node.leftChild);
        System.out.print(node.data + " ");
        inOrderTraversal(node.rightChild);
    }

    /**
     * 后序遍历
     *
     * @param node 根节点
     */
    public void postOrderTraversal(TreeNode node) {
        if (node == null) return;
        postOrderTraversal(node.leftChild);
        postOrderTraversal(node.rightChild);
        System.out.print(node.data + " ");
    }

    /**
     * 层序遍历
     *
     * @param node 根节点
     */
    public void levelOrderTraversal(TreeNode node) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(node);
        while (!queue.isEmpty()) {
            TreeNode treeNode = queue.poll();
            System.out.print(treeNode.data + " ");
            if (treeNode.leftChild != null) {
                queue.offer(treeNode.leftChild);
            }
            if (treeNode.rightChild != null) {
                queue.offer(treeNode.rightChild);
            }
        }
    }

    private static class TreeNode {
        int data;
        TreeNode leftChild;
        TreeNode rightChild;

        TreeNode(int data) {
            this.data = data;
        }
    }

    public static void main(String[] args) {
        BinaryTreeTraversal traversal = new BinaryTreeTraversal();
        traversal.demo();
    }
}
