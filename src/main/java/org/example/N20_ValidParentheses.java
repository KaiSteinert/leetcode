package org.example;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class N20_ValidParentheses {
    /**
     * Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.<br>
     * <p>
     * An input string is valid if:<br>
     * <p>
     * Open brackets must be closed by the same type of brackets.<br>
     * Open brackets must be closed in the correct order.<br>
     * Every close bracket has a corresponding open bracket of the same type.
     * <p>
     * Example 1:<br>
     * <p>
     * Input: s = "()"<br>
     * Output: true
     * <p>
     * Example 2:<br>
     * <p>
     * Input: s = "()[]{}"<br>
     * Output: true
     * <p>
     * Example 3:<br>
     * <p>
     * Input: s = "(]"<br>
     * Output: false
     */
    public static boolean isValid(String s) {
        Map<Character, Character> parenthesesMap = new HashMap<>();
        parenthesesMap.put('(', ')');
        parenthesesMap.put('[', ']');
        parenthesesMap.put('{', '}');
        Stack<Character> stack = new Stack<>();
        for (int index=0; index<s.length(); index++){
            char c = s.charAt(index);
            if (parenthesesMap.containsKey(c)){
                stack.push(c);
            }
            if (parenthesesMap.containsValue(c)) {
                if(stack.isEmpty() ||
                        !parenthesesMap.get(stack.pop()).equals(c)) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
