package algorithms.leetcode;

import com.sun.deploy.util.StringUtils;

import java.util.Stack;

/**
 * Longest Palindromic Substring
 */
public class LeetCode5 {

    public static void main(String[] args) {
        System.out.println(longestPalindrome("asaasa"));
    }

    static String longestPalindrome(String s) {
        String[] palindrome = {"", ""};
        Stack<Character> stack = new Stack<>();
        boolean[] findPalindrome = { false };
        s.chars().forEach(_c -> {
            char c = (char)_c;
            if (stack.isEmpty()) { // 如果是空栈
                if (findPalindrome[0] && palindrome[0].length() > 0 && palindrome[0].charAt(0) == c) palindrome[0] += c;
                else stack.push(c);
            } else {
                char topV = stack.peek();
                if (topV == c) { // 找到回文了
                    findPalindrome[0] = true;
                    palindrome[0] = c + palindrome[0] + c;
                    stack.pop();
                } else {
                    stack.pop();
                    if (stack.isEmpty()) {
                        stack.push(topV);
                        findPalindrome[0] = false;
                        palindrome[0] = "";
                    } else {
                        char secondV = stack.peek();
                        if (secondV == c) {
                            findPalindrome[0] = true;
                            palindrome[0] = c + "" + topV + c;
                            stack.pop();
                        } else {
                            stack.push(secondV);
                            stack.push(topV);
                            findPalindrome[0] = false;
                        }
                    }
                    if (palindrome[0].length() > palindrome[1].length()) {
                        palindrome[1] = palindrome[0];
                        palindrome[0] = "";
                    }
                }

                if (!findPalindrome[0]) stack.push(c);
            }
        });

        return palindrome[0].length() > palindrome[1].length() ? palindrome[0] : palindrome[1];
    }

}
