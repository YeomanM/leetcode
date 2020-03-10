package com.leetcode;

/**
 * @author 冯宇明
 * @version 1.0
 * @date 2020/1/22
 * @desc
 */
public class Connect {

    public Node connect(Node root) {

        if (root != null) {
            connectTo2(root);
        }
        return root;
    }

    public void connectTo2(Node root) {
        if (root.left != null && root.right != null) {
            root.left.next = root.right;
            if (root.next != null) {
                if (root.next.left != null) {
                    root.right.next = root.next.left;
                } else if (root.next.right != null) {
                    root.right.next = root.next.right;
                }
            }
        } else if (root.right != null) {
            if (root.next.left != null) {
                root.right.next = root.next.left;
            } else if (root.next.right != null) {
                root.right.next = root.next.right;
            }
        } else if (root.left != null) {
            if (root.next != null) {
                if (root.next.left != null) {
                    root.left.next = root.next.left;
                } else if (root.next.right != null) {
                    root.left.next = root.next.right;
                }
            }
        }
    }

    public void connectTo(Node root) {
        root.left.next = root.right;
        if (root.next != null) {
            root.right.next = root.next.left;
        }

        if (root.left.left == null) {
            return;
        }

        connectTo(root.left);
        connectTo(root.right);

    }

}
