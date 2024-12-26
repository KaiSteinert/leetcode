package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class N108_ConvertSortedArrayToBinarySearchTreeTest {

    @Test
    public void testSortedArrayToBST(){
        int[] testInput = {-10,-3,0,5,9};

        assertTrue(N100_SameTree.isSameTree(
                new TreeNode(0,
                        new TreeNode(-3,
                                new TreeNode(-10),
                                null),
                        new TreeNode(9,
                                new TreeNode(5),
                                null)
                ),
                N108_ConvertSortedArrayToBinarySearchTree.sortedArrayToBST(testInput)));
    }

    @Test
    public void testSortedArrayToBST_2(){
        int[] testInput = {0, 1, 2, 3, 4, 5};

        assertTrue(N100_SameTree.isSameTree(
                new TreeNode(3,
                        new TreeNode(1,
                                new TreeNode(0),
                                new TreeNode(2)),
                        new TreeNode(5,
                                new TreeNode(4),
                                null)
                ),
                N108_ConvertSortedArrayToBinarySearchTree.sortedArrayToBST(testInput)));
    }
}
