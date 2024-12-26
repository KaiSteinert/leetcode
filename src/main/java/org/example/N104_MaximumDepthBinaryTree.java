package org.example;

import java.util.Stack;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

public class N104_MaximumDepthBinaryTree {

    /**
     * Given the root of a binary tree, return its maximum depth.
     * <p>
     * A binary tree's maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
     * <p>
     * <p>
     * <p>
     * Example 1:
     * <p>
     * Input: root = [3,9,20,null,null,15,7]<br>
     * Output: 3
     * <p>
     * Example 2:
     * <p>
     * Input: root = [1,null,2]<br>
     * Output: 2
     */
    public static int maxDepth(TreeNode root) {
        TreeNode current = root;
        Stack<TreeNode> stack = new Stack<>();
        int depth = 0;
        int counter = 0;
        while (nonNull(current) || !stack.isEmpty()) {

            while (nonNull(current)) {
                stack.push(current);
                if(nonNull(current.right)) {
                    stack.push(current.right);
                }
                current = current.left;
                counter++;
            }
            current = stack.pop();
            if (nonNull(current.left) && nonNull(current.right)) {
                counter--;
            }
            if (root.equals(current)) {
                counter = 1;
            }
            if (counter > depth) {
                depth = counter;
            }
        }
        return depth;
    }

    public static int maxDepth_Bck(TreeNode root) {
        TreeNode current = root;
        Stack<TreeNode> stack = new Stack<>();
        int depth = 0;
        int counter = 0;
        while (nonNull(current) || !stack.isEmpty()) {

            while (nonNull(current)) {
                stack.push(current);
                current = current.left;
                counter++;
            }
            current = stack.pop();
            if (nonNull(current.left) && nonNull(current.right)) {
                counter--;
            }
            if (root.equals(current)) {
                counter = 1;
            }
            current = current.right;
            if (counter > depth) {
                depth = counter;
            }
        }
        return depth;
    }

}
