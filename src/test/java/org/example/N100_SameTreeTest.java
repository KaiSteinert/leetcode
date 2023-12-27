package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class N100_SameTreeTest {

    @Test
    public void isSameTree() {

        assertFalse(N100_SameTree.isSameTree(
                new TreeNode(
                        1,
                        new TreeNode(2, null, null),
                        new TreeNode(1, null, null)),
                new TreeNode(
                        1,
                        new TreeNode(1, null, null),
                        new TreeNode(2, null, null))
        ));

        assertTrue(N100_SameTree.isSameTree(
                new TreeNode(
                        1,
                        new TreeNode(2, null, null),
                        new TreeNode(3, null, null)),
                new TreeNode(
                        1,
                        new TreeNode(2, null, null),
                        new TreeNode(3, null, null))
        ));

        assertFalse(N100_SameTree.isSameTree(
                new TreeNode(
                        1,
                        new TreeNode(2, null, null),
                        null),
                new TreeNode(1,
                        null,
                        new TreeNode(2, null, null))
        ));

    }
}
