package org.example;

import java.util.*;
import java.util.stream.Collectors;

import static org.apache.commons.math3.util.CombinatoricsUtils.binomialCoefficient;

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

    public static List<int[]> allOneTwoCombinationsOld(int n) {
        // All combinations except {1, 2, 1, 2, 1, 2, 1} for n = 7
        // create an array in which all entries are one
        List<int[]> result = new ArrayList<>();
        int[] initArr = new int[n];
        Arrays.fill(initArr, 1);

        result.add(initArr);
        boolean flag=false;
        int resultInit = 0;
        int idxArrInit;
        for (int idx=0; idx<n; idx++){
            int resultSize = result.size();
            idxArrInit = idx;
            for (int idxResult=resultInit; idxResult<resultSize; idxResult++) {
                for(int idxArr=idxArrInit; idxArr<n; idxArr++){
                    int[] arr = result.get(idxResult);
                    int[] copyArr = Arrays.copyOf(arr, arr.length);
                    copyArr[idxArr] = 2;
                    result.add(copyArr);
                    System.out.printf("%s idx: %s, idxResult: %s, idxArr: %s%n",
                            Arrays.toString(copyArr), idx, idxResult, idxArr);
                }
                idxArrInit++;
            }
            int someValue = n-3;
            idxArrInit = someValue;
            int idxResult=result.size()-1;
            while (idxArrInit > 0 && flag) {
                for(int findNameIdx=idxArrInit; findNameIdx<=someValue; findNameIdx++) {
                    for(int idxArr=idxArrInit; idxArr>0; idxArr--) {
                        int[] arr = result.get(idxResult);
                        int[] copyArr = Arrays.copyOf(arr, arr.length);
                        copyArr[idxArr] = 2;
                        result.add(copyArr);
                        System.out.printf("%s idx: %s, idxResult: %s, idxArr: %s, findNameIdx: %s%n",
                                Arrays.toString(copyArr), idx, idxResult, idxArr, findNameIdx);
                        //System.out.printf("%s%n", findNameIdx);
                    }
                    idxResult--;
                }
                idxArrInit = idxArrInit - 1;
            }
            resultInit = resultSize;
            flag = true;
        }
        return result;
    }

    public static int climbStairsOld(int n) {
        List<int[]> result = allOneTwoCombinationsOld(n);

        /*List<int[]> trueResult = new ArrayList<>();
        Iterator<int[]> iter = combinationsIterator(2, 7);
        while (iter.hasNext()) {
            trueResult.add(iter.next());
        }
        System.out.println(trueResult.size());
        printResult(trueResult);*/

        System.out.printf("result size: %s, unique size: %s, binCoef: %s, 2^n: %s%n",
                result.size(),
                result.stream()
                        .map(Arrays::toString)
                        .collect(Collectors.toSet())
                        .size(),
                binomialCoefficient(n, 2),
                Math.pow(2, n));

        return result.stream()
                .filter(N70_ClimbingStairs::isValidStepSeq)
                .toList()
                .size();
    }

    public static void addStepSeqAsc(List<int[]> result, int idxResult, int arrStart, int arrEnd, int cutoff) {
        int[] arr = result.get(idxResult);
        for (int idxArr=arrStart; idxArr<arrEnd; idxArr++) {
            int[] copyArr = Arrays.copyOf(arr, arr.length);
            copyArr[idxArr] = 2;
            boolean cutoffFlag = cutoff < idxArr;
            if (cutoffFlag) {
                result.add(copyArr);
            }
                System.out.printf("%s cF: %s, idxResult: %s, idxArr: %s, arrStart: %s, arrEnd: %s%n",
                        Arrays.toString(copyArr), cutoffFlag, idxResult, idxArr, arrStart, arrEnd);
        }
    }

    public static void resultIntervalAsc(List<int[]> result, int idxStart, int idxEnd, int idx, int n) {
        int arrStart = 0;
        int arrEnd = n;
        for (int idxResult=idxStart; idxResult<idxEnd; idxResult++) {
            System.out.printf("Asc idxResult: %s, idxStart: %s, idxEnd: %s%n",
                    idxResult, idxStart, idxEnd);
            addStepSeqAsc(result, idxResult, arrStart, arrEnd, idxResult-idxStart+idx-1);

            arrStart++;
        }
    }

    public static void addStepSeqDesc(List<int[]> result, int idxResult, int arrStart, int arrEnd, int cutoff) {
        int[] arr = result.get(idxResult);
        for (int idxArr=arrStart; idxArr >= arrEnd; idxArr--) {
            int[] copyArr = Arrays.copyOf(arr, arr.length);
            copyArr[idxArr] = 2;
            boolean cutoffFlag = idxArr < cutoff;
            if (cutoffFlag) {
                result.add(copyArr);
            }
            System.out.printf("%s cF: %s, idxResult: %s, idxArr: %s, arrStart: %s, arrEnd: %s%n",
                    Arrays.toString(copyArr), cutoffFlag, idxResult, idxArr, arrStart, arrEnd);
        }
    }

    public static void resultIntervalDesc(List<int[]> result, int idxStart, int idxEnd, int idx, int n) {
        int arrStart = n-1;
        int arrEnd = 0;
        for (int idxResult=idxStart; idxResult > idxEnd; idxResult--) {
            System.out.printf("Desc idxResult: %s, idxStart: %s, idxEnd: %s%n",
                    idxResult, idxStart, idxEnd);
            int cutoff;
            if (idx == 0) {
                cutoff = idxResult-idxEnd-1;
            } else {
                cutoff = idxResult-idxStart+idxEnd-1;
            }
            addStepSeqDesc(result, idxResult, arrStart, arrEnd, idxResult-idxStart+idxEnd-1);

            arrStart--;
        }
    }

    public static List<int[]> allOneTwoCombinations(int n) {
        List<int[]> result = new ArrayList<>();
        int[] initArr = new int[n];
        Arrays.fill(initArr, 1);
        result.add(initArr);

        int startBufferAsc = 0;
        int endBufferAsc = result.size();
        int startBufferDesc = 0;
        int endBufferDesc = 0;
        for (int idx=0; idx < n; idx++){
            int idxStartAsc = startBufferAsc;
            int idxEndAsc = endBufferAsc;

            System.out.printf("idx: %s%n", idx);

            resultIntervalAsc(result, idxStartAsc, idxEndAsc, idx, n);
            startBufferAsc = idxEndAsc;
            endBufferAsc = result.size();

            int idxStartDesc = result.size() - 2;
            int idxEndDesc = idxEndAsc;

            resultIntervalDesc(result, idxStartDesc, idxEndDesc, idx, n);
            startBufferDesc = result.size() - 1;
            endBufferDesc = idxEndDesc;
        }
        return result;
    }

    public static int climbStairsOld2(int n) {
        List<int[]> result = allOneTwoCombinations(n);

        System.out.printf("result size: %s, unique size: %s, 2^n: %s%n",
                result.size(),
                result.stream()
                        .map(Arrays::toString)
                        .collect(Collectors.toSet())
                        .size(),
                Math.pow(2, n));

        Map<String, int[]> uniqueStepSeq = new HashMap<>();
        for (int[] seq : result) {
            uniqueStepSeq.put(Arrays.toString(seq), seq);
        }

        System.out.printf("uniqueStepSeq.size(): %s%n", uniqueStepSeq.size());

        return uniqueStepSeq.values().stream()
                .filter(N70_ClimbingStairs::isValidStepSeq)
                .toList().size();
    }

    public static boolean isValidStepSeq(int[] arr) {
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

    public static int climbStairsCantHandle35(int n) {
        int[] levelStartIdx = new int[n];
        int[] nodesPerLevel = new int[n];
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

        int[] combTree = new int[totalNumOfNodes];
        // int idxLevel = 0;
        for (int idx=0; idx < combTree.length-1; idx+=2) {
            /*if (idx > levelStartIdx[idxLevel]) {
                idxLevel++;
            }*/
            combTree[idx] = 1;
            combTree[idx + 1] = 2;
            /*if (idx < levelStartIdx[levelStartIdx.length-2]) {
                combTree[idx + 1] = 2;
            }*/
        }

        List<int[]> pathSeqs = new ArrayList<>();
        for (int idxLeaf=0; idxLeaf<nodesPerLevel[nodesPerLevel.length-1]; idxLeaf++) {
            int[] pathCounter = new int[n];
            for (int idxLevel=0; idxLevel<nodesPerLevel.length; idxLevel++) {
                //System.out.printf("idxLevel: %s, idxLeaf: %s, idxLeaf mod nodesPerLevel[idxLevel]: %s, nodesPerLevel[idxLevel] - 1: %s%n", idxLevel, idxLeaf, idxLeaf % nodesPerLevel[idxLevel], nodesPerLevel[idxLevel] - 1);
                if (idxLeaf % nodesPerLevel[idxLevel] < nodesPerLevel[idxLevel] - 1) {
                    pathCounter[idxLevel] = idxLeaf % nodesPerLevel[idxLevel];
                }
            }
            pathSeqs.add(pathCounter);
        }

        List<int[]> stepSeqs = new ArrayList<>();
        int[] pathCounter = new int[n];
        for (int pathNumber=0; pathNumber < Math.pow(2, n); pathNumber++){
            int[] seq = new int[pathCounter.length];
            for (int idxLevel=levelStartIdx.length-1; idxLevel >= 0; idxLevel--) {
                int idx = levelStartIdx[idxLevel]+pathCounter[idxLevel];
                seq[idxLevel] = combTree[idx];
            }
            if (isValidStepSeq(seq)) {
                stepSeqs.add(seq);
            }
            pathCounter[pathCounter.length-1] += 1;
            for (int idxLevel=pathCounter.length-1; idxLevel > 0; idxLevel--) {
                if (pathCounter[idxLevel] % 2 == 0) {
                    pathCounter[idxLevel-1] += 1;
                    break;
                }
            }

        }
        return stepSeqs.size();
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

        //List<long[]> stepSeqs = new ArrayList<>();
        int[] pathCounter = new int[n];
        long resultCounter = 0;
        long[] seq = new long[pathCounter.length];
        for (long pathNumber=0; pathNumber < Math.pow(2, n); pathNumber++){

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
            System.out.printf(BG+"Num: %s %s %n"+ANSI_RESET, pathNumber, Arrays.toString(pathCounter));
            for (int idxLevel=pathCounter.length-1; idxLevel >= 0; idxLevel--) {
                if (pathCounter[idxLevel] % 2 == 0) {
                    pathCounter[idxLevel] += 1;
                    break;
                } else {
                    pathCounter[idxLevel] += 1;
                }
            }

        }
        //return stepSeqs.size();
        return (int) resultCounter;

    }

    public static void printResult(List<int[]> result) {
        for (int[] a : result) {
            System.out.println(Arrays.toString(a));
        }
    }
}
