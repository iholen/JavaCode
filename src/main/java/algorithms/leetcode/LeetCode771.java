package algorithms.leetcode;

import java.util.HashMap;
import java.util.Map;

// Jewels and Stones
public class LeetCode771 {

    public static void main(String[] args) {
        System.out.println(numJewelsInStones("aA", "AaaZZZZA"));
    }

    static int numJewelsInStones(String J, String S) {
        Map<Character, Integer> map = new HashMap<>();
        int sum = 0;
        for(char c : J.toCharArray()) map.put(c, 0);
        for(char c : S.toCharArray()) if (null != map.get(c)) sum++;

        return sum;

//        int sum = 0;
//        int[] mark = new int['z' - 'A' + 1];
//        for(char c : J.toCharArray()) mark[c - 'A'] = 1;
//        for(char c : S.toCharArray()) if (mark[c - 'A'] == 1) sum++;
//
//        return sum;
    }

}
