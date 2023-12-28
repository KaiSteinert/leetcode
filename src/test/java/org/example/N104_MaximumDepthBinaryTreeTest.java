package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class N104_MaximumDepthBinaryTreeTest {

    @Test
    public void maxDepthTest3() {
        assertEquals(4,
                N104_MaximumDepthBinaryTree.maxDepth(
                        new TreeNode(
                                0,
                                new TreeNode(
                                        2,
                                        new TreeNode(
                                                1,
                                                new TreeNode(5),
                                                new TreeNode(1)),
                                        null),
                                new TreeNode(
                                        4,
                                        new TreeNode(
                                                3,
                                                null,
                                                new TreeNode(6)),
                                        new TreeNode(
                                                -1,
                                                null,
                                                new TreeNode(8))))));
    }

    @Test
    public void maxDepthTest2() {
        assertEquals(5,
                N104_MaximumDepthBinaryTree.maxDepth(
                        new TreeNode(
                                2,
                                null,
                                new TreeNode(
                                        3,
                                        null,
                                        new TreeNode(
                                                4,
                                                null,
                                                new TreeNode(
                                                        5,
                                                        null,
                                                        new TreeNode(6)))))));
    }

    @Test
    public void maxDepthTest() {

        assertEquals(3,
                N104_MaximumDepthBinaryTree.maxDepth(
                        new TreeNode(
                                1,
                                new TreeNode(
                                        2,
                                        new TreeNode(4),
                                        null),
                                new TreeNode(
                                        3,
                                        null,
                                        new TreeNode(5)))));

        assertEquals(3,
                N104_MaximumDepthBinaryTree.maxDepth(
                        new TreeNode(
                                1,
                                new TreeNode(
                                        2,
                                        new TreeNode(4),
                                        new TreeNode(5)
                                ),
                                new TreeNode(
                                        3))));

        assertEquals(4,
                N104_MaximumDepthBinaryTree.maxDepth(
                new TreeNode(
                        3,
                        new TreeNode(9),
                        new TreeNode(
                                20,
                                new TreeNode(15,
                                        null,
                                        new TreeNode(14)),
                                new TreeNode(7)
                        ))));

        assertEquals(2,
                N104_MaximumDepthBinaryTree.maxDepth(
                        new TreeNode(
                                1,
                                new TreeNode(2),
                                null)));

        assertEquals(2,
                N104_MaximumDepthBinaryTree.maxDepth(
                        new TreeNode(
                                1,
                                null,
                                new TreeNode(2))));

        assertEquals(1,
                N104_MaximumDepthBinaryTree.maxDepth(
                        new TreeNode(0)));

        assertEquals(0, N104_MaximumDepthBinaryTree.maxDepth(null));
    }
}
