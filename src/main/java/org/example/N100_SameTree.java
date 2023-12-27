package org.example;

import java.util.Stack;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

public class N100_SameTree {

    public static boolean isSameTree(TreeNode p, TreeNode q) {
        if (isNull(p) && isNull(q)) {
            return true;
        }
        if (isNull(p) || isNull(q)) {
            return false;
        }
        TreeNode currentLeft = p;
        Stack<TreeNode> leftStack = new Stack<>();
        TreeNode currentRight = q;
        Stack<TreeNode> rightStack = new Stack<>();
        while (nonNull(currentLeft) || !leftStack.isEmpty() &&
                nonNull(currentRight) || !rightStack.isEmpty()) {
            while (nonNull(currentLeft) && nonNull(currentRight)) {
                leftStack.push(currentLeft);
                rightStack.push(currentRight);
                currentLeft = currentLeft.left;
                currentRight = currentRight.left;
            }
            currentLeft = leftStack.pop();
            currentRight = rightStack.pop();
            if (currentLeft.val != currentRight.val ||
                    isNull(currentLeft.left) != isNull(currentRight.left) ||
                    isNull(currentLeft.right) != isNull(currentRight.right)) {
                return false;
            }
            currentLeft = currentLeft.right;
            currentRight = currentRight.right;
        }
        return true;
    }
}
