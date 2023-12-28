package org.example;

import java.util.*;

public class N70_ClimbingStairs {
    /**
     * You are climbing a staircase. It takes n steps to reach the top.
     * <p>
     * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
     * <p>
     * <p>
     * <p>
     * Example 1:
     * <p>
     * Input: n = 2
     * Output: 2<br>
     * Explanation: There are two ways to climb to the top.<br>
     * 1. 1 step + 1 step<br>
     * 2. 2 steps
     * <p>
     * Example 2:
     * <p>
     * Input: n = 3<br>
     * Output: 3<br>
     * Explanation: There are three ways to climb to the top.<br>
     * 1. 1 step + 1 step + 1 step<br>
     * 2. 1 step + 2 steps<br>
     * 3. 2 steps + 1 step
     */


    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";

    public static final String ANSI_BLACK_BACKGROUND = "\u001B[40m";
    public static final String ANSI_RED_BACKGROUND = "\u001B[41m";
    public static final String ANSI_GREEN_BACKGROUND = "\u001B[42m";
    public static final String ANSI_YELLOW_BACKGROUND = "\u001B[43m";
    public static final String ANSI_BLUE_BACKGROUND = "\u001B[44m";
    public static final String ANSI_PURPLE_BACKGROUND = "\u001B[45m";
    public static final String ANSI_CYAN_BACKGROUND = "\u001B[46m";
    public static final String ANSI_WHITE_BACKGROUND = "\u001B[47m";


    public static boolean isValidStepSeq(long[] arr) {
        if (arr[arr.length-1] == 2) {
            return false;
        }
        for (int idx=0; idx<arr.length-1; idx++){
            if (arr[idx] == 2 && arr[idx+1] == 2) {
                return false;
            }
        }
        return true;
    }

    public static long[] initializePathCounter(long[] nodesPerLevel) {
        long[] pathCounter = Arrays.copyOf(nodesPerLevel, nodesPerLevel.length);
        for (int idx=0; idx < pathCounter.length; idx++) {
            pathCounter[idx] -= 1;
        }
        return pathCounter;
    }

    public static int climbStairs(int n) {
        long[] levelStartIdx = new long[n];
        long[] nodesPerLevel = new long[n];
        int totalNumOfNodes = 0;
        for (int idx=0; idx < levelStartIdx.length; idx++) {
            int level = (int) Math.pow(2, idx+1);
            totalNumOfNodes += level;
            nodesPerLevel[idx] = level;
            int next = idx+1;
            if (next < levelStartIdx.length) {
                levelStartIdx[next] = totalNumOfNodes;
            }
        }

        long[] pathCounter = initializePathCounter(nodesPerLevel);
        long resultCounter = 0;
        long[] seq = new long[pathCounter.length];
        while (pathCounter[pathCounter.length-1] >= 0){

            for (int idxLevel=levelStartIdx.length-1; idxLevel >= 0; idxLevel--) {
                long idx = levelStartIdx[idxLevel]+pathCounter[idxLevel];
                if (idx % 2 == 0) {
                    seq[idxLevel] = 1;
                } else {
                    seq[idxLevel] = 2;
                }
            }
            if (isValidStepSeq(seq)) {
                // stepSeqs.add(seq);
                resultCounter++;
            }
            // System.out.printf("Num: %s %s %s%n", pathNumber, Arrays.toString(pathCounter), isValidStepSeq(seq));
            final String BG;
            if (isValidStepSeq(seq)) {
                BG = ANSI_GREEN;
            } else {
                BG = ANSI_RED;
            }
            System.out.printf(BG+" %s %n"+ANSI_RESET, Arrays.toString(pathCounter));
            for (int idxLevel=pathCounter.length-1; idxLevel >= 0; idxLevel--) {
                if (pathCounter[idxLevel] % 2 != 0) {
                    pathCounter[idxLevel] -= 1;
                    break;
                } else {
                    pathCounter[idxLevel] -= 1;
                }
            }
        }
        return (int) resultCounter;
    }
}
