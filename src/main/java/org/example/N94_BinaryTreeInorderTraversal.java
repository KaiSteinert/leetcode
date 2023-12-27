package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

public class N94_BinaryTreeInorderTraversal {
    /**
     * Given the root of a binary tree, return the inorder traversal of its nodes' values.
     * <p>
     * <p>
     * <p>
     * Example 1:
     * <p>
     * Input: root = [1,null,2,3]<br>
     * Output: [1,3,2]
     * <p>
     * Example 2:
     * <p>
     * Input: root = []<br>
     * Output: []
     * <p>
     * Example 3:
     * <p>
     * Input: root = [1]<br>
     * Output: [1]
     */

    public static Integer recursiveTraversal(List<Integer> result, TreeNode node) {
        if (nonNull(node.left) && nonNull(node.right)) {
            result.add(recursiveTraversal(result, node.left));
            result.add(node.val);
            return recursiveTraversal(result, node.right);
        }
        if (nonNull(node.left)) {
            result.add(recursiveTraversal(result, node.left));
            return node.val;
        }
        if (nonNull(node.right)) {
            result.add(node.val);
            return recursiveTraversal(result, node.right);
        }
        return node.val;
    }

    public static List<Integer> inorderTraversalRecursive(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (isNull(root)) {
            return result;
        }
        result.add(recursiveTraversal(result, root));
        return result;
    }

    /**
     * Complexity Analysis
     * <p>
     * Time complexity: O(n)
     * <p>
     * Space complexity: O(n)
     */
    public static List<Integer> inorderTraversalIterative(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;
        while (nonNull(current) || !stack.isEmpty()) {
            while (nonNull(current)) {
                TreeNode tmp = new TreeNode(current.val, null, current.right);
                stack.add(tmp);
                current = current.left;
            }
            current = stack.pop();
            result.add(current.val);
            current = current.right;
        }
        return result;
    }

    /**
     * The first method to solve this problem is using recursion. This is the classical method and is straightforward. We can define a helper function to implement recursion.
     * <p>
     * Complexity Analysis
     * <p>
     * Time complexity: O(n)
     * <p>
     * The time complexity is O(n) because the recursive function is T(n)=2⋅T(n/2)+1.
     * <p>
     * Space complexity: O(n)
     * <p>
     * The worst case space required is O(n), and in the average case it's O(log n) where n is number of nodes.
     */
    public List<Integer> inorderTraversalSolution(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        helper(root, res);
        return res;
    }

    public void helper(TreeNode root, List<Integer> res) {
        if (root != null) {
            helper(root.left, res);
            res.add(root.val);
            helper(root.right, res);
        }
    }
}
