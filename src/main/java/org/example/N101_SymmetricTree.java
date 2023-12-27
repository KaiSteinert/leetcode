package org.example;

import java.util.Stack;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

public class N101_SymmetricTree {

    /**
     * Given the root of a binary tree, check whether it is a mirror of itself (i.e., symmetric around its center).
     * <p>
     * <p>
     * <p>
     * Example 1:
     * <p>
     * Input: root = [1,2,2,3,4,4,3]<br>
     * Output: true
     * <p>
     * Example 2:
     * <p>
     * Input: root = [1,2,2,null,3,null,3]<br>
     * Output: false
     */
    public static boolean isSymmetric(TreeNode root) {
        if (isNull(root)) {
            return false;
        }
        TreeNode leftCurr = root.left;
        Stack<TreeNode> leftStack = new Stack<>();
        TreeNode rightCurr = root.right;
        Stack<TreeNode> rightStack = new Stack<>();
        if (isNull(leftCurr) && nonNull(rightCurr) ||
                nonNull(leftCurr) && isNull(rightCurr)) {
            return false;
        }
        while (nonNull(leftCurr) || !leftStack.isEmpty() ||
                nonNull(rightCurr) || !rightStack.isEmpty()) {
            while (nonNull(leftCurr) && nonNull(rightCurr)) {
                leftStack.push(leftCurr);
                rightStack.push(rightCurr);
                leftCurr = leftCurr.left;
                rightCurr = rightCurr.right;
            }
            leftCurr = leftStack.pop();
            rightCurr = rightStack.pop();
            if (leftCurr.val != rightCurr.val ||
                    isNull(leftCurr.left) != isNull(rightCurr.right) ||
                    isNull(leftCurr.right) != isNull(rightCurr.left)) {
                return false;
            }
            leftCurr = leftCurr.right;
            rightCurr = rightCurr.left;
        }
        return true;
    }
}
