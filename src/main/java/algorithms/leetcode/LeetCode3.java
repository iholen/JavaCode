package algorithms.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

// Longest Substring Without Repeating Characters
public class LeetCode3 {

    public static void main(String[] args) {
//        System.out.println(lengthOfLongestSubstring1("dedf"));
        System.out.println(lengthOfLongestSubstring2("dedf"));
    }

    // 解法1
    static int lengthOfLongestSubstring1(String s) {
        int[] index = {0, 0, 0}; // 窗口和子串长度
        Set<Character> subString = new HashSet<>();

        s.chars().forEach(sc -> {
            char c = (char)sc;

            // 移动窗口右边位置
            index[1] += 1;
            // 添加失败时。先计算当前子串的长度。
            if (!subString.add(c)) {
                index[2] = Math.max(index[2], index[1] - index[0] - 1);
                do {
                    char charWithIndex = s.charAt(index[0]);
                    subString.remove(charWithIndex);
                    index[0] += 1; // 移动窗口左边位置
                } while(!subString.add(c));
            }
        });

        return Math.max(index[2], index[1] - index[0]);
    }

    // 解法2
    static int lengthOfLongestSubstring2(String s) {
        int len = 0, n = s.length();
        Map<Character, Integer> map = new HashMap<>();
        for(int i = 0, j = 0; j < n; j++) {
            char c = s.charAt(j);
            if (map.containsKey(c)) i = Math.max(i, map.get(c));
            len = Math.max(len, j - i + 1);
            map.put(c, j + 1);
        }

        return len;
    }

}
