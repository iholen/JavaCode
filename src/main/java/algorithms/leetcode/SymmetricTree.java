package algorithms.leetcode;

import algorithms.TreeNode;

import java.util.Stack;

public class SymmetricTree {

    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;

        Stack<TreeNode> leftNodes = new Stack<>();
        Stack<TreeNode> rightNodes = new Stack<>();

        TreeNode leftNode = root;
        TreeNode rightNode = root;

        while(leftNode != null && rightNode != null) {
            if (leftNodes.size() != rightNodes.size()) return false;
            if (leftNode.val != rightNode.val) return false;

            if (leftNode.right != null) leftNodes.push(leftNode);
            leftNode = leftNode.left;
            if (rightNode.left != null) rightNodes.push(rightNode);
            rightNode = rightNode.right;

            if (leftNode == null && rightNode != null) return false;
            if (rightNode == null && leftNode != null) return false;
            if (leftNodes.empty()) break;

            if (leftNode == null && rightNode == null) {
                leftNode = leftNodes.pop().right;
                rightNode = rightNodes.pop().left;
            }
        }

        return true;
    }
}
