package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class N94_BinaryTreeInorderTraversalTest {

    @Test
    public void inorderTraversalTest() {
        Assertions.assertArrayEquals(new int[]{1, 3, 2},
                N94_BinaryTreeInorderTraversal
                        .inorderTraversalIterative(
                                new TreeNode(3,
                                        new TreeNode(1, null, null),
                                        new TreeNode(2, null, null)))
                        .stream().mapToInt(x->x).toArray());

        Assertions.assertArrayEquals(new int[]{1, 3, 2},
                N94_BinaryTreeInorderTraversal
                        .inorderTraversalIterative(
                                new TreeNode(1,
                                        null, new TreeNode(2,
                                                new TreeNode(3,
                                                        null, null), null)))
                        .stream().mapToInt(x->x).toArray());

    }
}
