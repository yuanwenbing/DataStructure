package com.yuan.inter.tree.binary_serach_tree;


import javax.sound.midi.Soundbank;
import java.util.*;

/**
 * 0.动态数据结构
 * 1.是一颗二叉树
 * 2.二分搜索树的每个节点的值:
 * 每个节点的值都大于其左子树的所有节点的值
 * 每个节点的值都小于其右子树的所有节点的值
 * 3.每一颗子树也是二分搜索树
 * 4.存储的元素必须有可比较性, Java中的话就要求二分搜索树保存的数据类型要实现Comparable接口, 或者使用额外的比较器实现
 * 5.一般二分搜索树不包含重复元素, 当然也可以定义包含重复元素的二分搜索树
 * 如果想要包含重复元素的话, 只需要定义二分搜索树的左节点的值小于等于当前节点的值或右节点的值大于等于当前节点即可
 * 6.二分搜索树天然的具有递归特性
 */

public class BinarySearchTree<E extends Comparable<E>> {

    private class Node {
        public E e;
        public Node left, right;

        public Node(E e) {
            this.e = e;
            left = null;
            right = null;
        }
    }

    private Node root;
    private int size;

    public BinarySearchTree() {
        root = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void add(E e) {
//        if (root == null) {
//            root = new Node(e);
//        } else {
//            add(root, e);
//        }

        root = add(root, e);
    }

//    private void add(Node node, E e) {
//        if (e == node.e) {
//            return;
//        } else if (e.compareTo(node.e) < 0 && node.left == null) {
//            node.left = new Node(e);
//            size++;
//            return;
//        } else if (e.compareTo(node.e) > 0 && node.right == null) {
//            node.right = new Node(e);
//            size++;
//            return;
//        }
//
//        if (e.compareTo(node.e) < 0) {
//            add(node.left, e);
//        } else { // e.compareTo(node.e) > 0
//            add(node.right, e);
//        }
//    }

    private Node add(Node node, E e) {
        if (node == null) {
            size++;
            return new Node(e);
        }

        if (e.compareTo(node.e) < 0) {
            node.left = add(node.left, e);
        } else if (e.compareTo(node.e) > 0) {
            node.right = add(node.right, e);
        }

        return node;
    }

    public boolean contains(E e) {
        return contains(root, e);
    }

    private boolean contains(Node node, E e) {
        if (node == null) {
            return false;
        }
        if (e.compareTo(node.e) == 0) {
            return true;
        } else if (e.compareTo(node.e) < 0) {
            return contains(node.left, e);
        } else {
            return contains(node.right, e);
        }

    }

    public void preOrder() {
        preOrder(root);
    }

    // 非递归前序遍历
    public void preOrderNR() {
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node cur = stack.pop();
            System.out.println(cur.e);
            if (cur.right != null)
                stack.push(cur.right);
            if (cur.left != null)
                stack.push(cur.left);
        }
    }

    private void preOrder(Node node) {
        if (node == null) {
            return;
        }

        System.out.println(node.e);
        preOrder(node.left);
        preOrder(node.right);
    }

    public void inOrder() {
        inOrder(root);
    }

    private void inOrder(Node node) {
        if (node == null) {
            return;
        }

        inOrder(node.left);
        System.out.println(node.e);
        inOrder(node.right);
    }

    public void postOrder() {
        postOrder(root);
    }

    private void postOrder(Node node) {
        if (node == null) {
            return;
        }

        postOrder(node.left);
        postOrder(node.right);
        System.out.println(node.e);
    }

    // 层序遍历
    public void levelOrder(){
        levelOrder(root);
    }

    private void levelOrder(Node node) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);
        if(!queue.isEmpty()){
            Node cur = queue.remove();
            System.out.println(cur.e);
            if (cur.left != null) {
                queue.add(cur.left);
            }
            if (cur.right != null) {
                queue.add(cur.right);
            }
        }
    }

    public E minNum() {
        if (size == 0) {
            throw new IllegalArgumentException("bst is empty!");
        }

        return miniNum(root).e;
    }

    private Node miniNum(Node node) {
        if (node == null) {
            return node;
        }

        return miniNum(node.left);
    }

    public E maxNum() {
        if (size == 0) {
            throw new IllegalArgumentException("bst is empty!");
        }

        return maxNum(root).e;
    }

    private Node maxNum(Node node) {
        if (node == null) {
            return node;
        }

        return maxNum(node.right);
    }

    public E removeMin() {
        E ret = minNum();
        root = removeMin(root);
        return ret;
    }

    private Node removeMin(Node node) {
        if (node.left == null) {
            Node rightNode = node.right;
            node.right = null;
            size --;
            return rightNode;
        }

        node.left = removeMin(node.left);
        return node;
    }

    public E removeMax() {
        E ret = maxNum();
        root = removeMax(root);
        return ret;
    }

    private Node removeMax(Node node) {
        if (node.right == null) {
            Node leftNode = node.left;
            node.left = null;
            size --;
            return leftNode;
        }

        node.right = removeMax(node.right);
        return node;
    }

    public void remove(E e) {
        remove(root, e);
    }

    private Node remove(Node node, E e) {
        if (node == null) {
            return null;
        }

        if (e.compareTo(node.e) < 0) {
            node.left = remove(node.left, e);
            return node;
        }else if (e.compareTo(node.e) > 0){
            node.right = remove(node.right, e);
            return node;
        }else  {

            // 删除节点左子树情况
            if (node.left == null) {
                Node rightNode = node.right;
                node.right = null;
                size --;
                return rightNode;
            }
            // 删除节点右子树情况
            if (node.right == null) {
                Node leftNode = node.left;
                node.left = null;
                size --;
                return leftNode;
            }

            // 待删除节点左右子树均不为空的情况
            // 找到比待删除节点大的最小节点，即待删除节点有区别子树的最小节点
            // 用这个节点顶替待删除节点的位置
            Node successor = miniNum(node.right);
            successor.right = removeMin(node.right);
            successor.left = node.left;

            node.left = node.right = null;
            return successor;

        }
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        generateBSTString(root, 0, res);
        return res.toString();
    }

    private void generateBSTString(Node node, int depth, StringBuilder res) {
        if (node == null) {
            res.append("null\n");
        }
    }
}
