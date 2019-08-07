package algorithms.nowcoder;

import algorithms.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 平衡二叉搜索树
 *
 * @author huliang
 * @date 2019-08-07 11:16
 */
public class BalancedBinaryTree {

    TreeNode root;

    public void addNode(TreeNode node) {
        if (node == null) return;

        if (root == null) root = node;
        else {
            addChildNode(root, node);
        }

        rotate(null, root);
    }

    private void addChildNode(TreeNode parent, TreeNode child) {
        int result = parent.compareTo(child);
        if (result < 0) {
            // 父节点小于新节点，进行right判断

            TreeNode right = parent.right;
            if (right == null) parent.right = child;
            else addChildNode(right, child);
        } else {
            // 父节点大于等于新节点，进行left判断

            TreeNode left = parent.left;
            if (parent.left == null) parent.left = child;
            else addChildNode(left, child);
        }
    }

    public int depth(TreeNode node) {
        if (node == null) return 0;
        else return Math.max(depth(node.left) + 1, depth(node.right) + 1);
    }

    private void rotate(TreeNode beforeNode, TreeNode parent) {
        int left = depth(parent.left);
        int right = depth(parent.right);
        while (Math.abs(left - right) >= 2) {
            if (left > right) {
                rightRotate(beforeNode, parent, parent.left, false);
            } else {
                leftRotate(beforeNode, parent, parent.right, false);
            }

            left = depth(parent.left);
            right = depth(parent.right);
        }
    }

    private void leftRotate(TreeNode beforeNode, TreeNode parent, TreeNode current, boolean fromRight) {
        int left = depth(current.left);
        int right = depth(current.right);
        if (Math.abs(left - right) < 2) {
            if (left > right) {
                // 出现RL(右-左)情况, 先进行右旋
                rightRotate(parent, current, current.left, true);

                current = parent.right;
            }

            // 右子变新爹
            if (beforeNode == null) {
                root = current;
            } else {
                if (fromRight) beforeNode.left = current;
                else beforeNode.right = current;
            }
            // 新爹左子变老爹右子
            parent.right = current.left;
            // 老爹变新爹左子
            current.left = parent;
        } else {
            rotate(parent, current);
        }
    }

    private void rightRotate(TreeNode beforeNode, TreeNode parent, TreeNode current, boolean fromLeft) {
        int left = depth(current.left);
        int right = depth(current.right);
        if (Math.abs(left - right) < 2) {
            if (left < right) {
                // 出现LR(左-右)情况, 先进行左旋
                leftRotate(parent, current, current.right, true);

                current = parent.left;
            }

            // 左子变新爹
            if (beforeNode == null) {
                root = current;
            } else {
                if (fromLeft) beforeNode.right = current;
                else beforeNode.left = current;
            }
            // 新爹左子变老爹右子
            parent.left = current.right;
            // 老爹变新爹左子
            current.right = parent;
        } else {
            rotate(parent, current);
        }
    }

    public static void main(String[] args) {
        BalancedBinaryTree tree = new BalancedBinaryTree();
        tree.addNode(new TreeNode(1013));
        tree.addNode(new TreeNode(1022));
        tree.addNode(new TreeNode(1026));
        tree.addNode(new TreeNode(1007));
    }

}
