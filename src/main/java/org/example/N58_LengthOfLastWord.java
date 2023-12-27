package org.example;

public class N58_LengthOfLastWord {
    /**
     * Given a string s consisting of words and spaces, return the length of the last word in the string.
     * <p>
     * A word is a maximal substring consisting of non-space characters only.
     * <p>
     * <p>
     * <p>
     * Example 1:
     * <p>
     * Input: s = "Hello World"<br>
     * Output: 5<br>
     * Explanation: The last word is "World" with length 5.
     * <p>
     * Example 2:
     * <p>
     * Input: s = "   fly me   to   the moon  "<br>
     * Output: 4<br>
     * Explanation: The last word is "moon" with length 4.
     * <p>
     * Example 3:
     * <p>
     * Input: s = "luffy is still joyboy"<br>
     * Output: 6<br>
     * Explanation: The last word is "joyboy" with length 6.
     */
    public static int lengthOfLastWord(String s) {
        String[] sentence = s.split(" ");
        if (sentence.length > 0) {
            return sentence[sentence.length-1].length();
        }
        return 0;
    }
}
