package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class N101_SymmetricTreeTest {

    @Test
    public void isSymmetric() {

        assertFalse(N101_SymmetricTree.isSymmetric(new TreeNode(
                1,
                new TreeNode(
                        2,
                        null,
                        new TreeNode(3, null, null)),
                new TreeNode(
                        2,
                        null,
                        new TreeNode(3, null, null)))));

        assertTrue(N101_SymmetricTree.isSymmetric(new TreeNode(
                1,
                new TreeNode(
                        2,
                        new TreeNode(3, null, null),
                        new TreeNode(4, null, null)),
                new TreeNode(
                        2,
                        new TreeNode(4, null, null),
                        new TreeNode(3, null, null)))));

    }
}
