package org.example;

public class N28_FindTheIndexOfTheFirstOccurrenceInAString {
    /**
     * Given two strings needle and haystack, return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
     * <p>
     * <p>
     * <p>
     * Example 1:
     * <p>
     * Input: haystack = "sadbutsad", needle = "sad"<br>
     * Output: 0<br>
     * Explanation: "sad" occurs at index 0 and 6.<br>
     * The first occurrence is at index 0, so we return 0.
     * <p>
     * Example 2:
     * <p>
     * Input: haystack = "leetcode", needle = "leeto"<br>
     * Output: -1<br>
     * Explanation: "leeto" did not occur in "leetcode", so we return -1.
     */

    public static int strStr(String haystack, String needle) {
        int idxMatch;
        int idxNeedle = 0;
        int haystackLength = haystack.length();
        int needleLength = needle.length();
        for (int idx=0; idx < haystackLength; idx++) {
            idxMatch = idx;
            while (idxMatch < haystackLength &&
                    idxNeedle < needleLength &&
                    haystack.charAt(idxMatch) == needle.charAt(idxNeedle)) {
                idxMatch++;
                idxNeedle++;
                if (idxNeedle == needleLength) {
                    return idx;
                }
            }
            idxNeedle = 0;
        }
        return -1;
    }
}
