package org.example;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class N14_LongestCommonPrefix {
    /**
     * Write a function to find the longest common prefix string amongst an array of strings.
     * <p>
     * If there is no common prefix, return an empty string "".
     * <p>
     * Example 1:
     * <p>
     * Input: strs = ["flower","flow","flight"]<br>
     * Output: "fl"<br>
     * <p>
     * Example 2:
     * <p>
     * Input: strs = ["dog","racecar","car"]<br>
     * Output: ""<br>
     * Explanation: There is no common prefix among the input strings.<br>
     */
    public static String longestCommonPrefix(String[] strs) {
        int shortestStr = Stream.of(strs)
                .map(String::length)
                .mapToInt(i->i)
                .min()
                .orElseThrow();

        Set<String> prefix;
        Set<String> result = null;

        for (int prefixLength = 0; prefixLength < shortestStr; prefixLength++) {
            int finalPrefixLength = prefixLength;
            prefix = Stream.of(strs)
                    .map(str -> str.substring(0, finalPrefixLength+1))
                    .collect(Collectors.toSet());
            if (prefix.size() == 1) {
                result = prefix;
            } else {
                break;
            }
        }

        return Optional.ofNullable(result)
                .orElse(new HashSet<>())
                .stream()
                .findFirst()
                .orElse("");
    }
}
