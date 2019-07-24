package algorithms.leetcode;

public class smallestRepunitDivByK {

    public static void main(String[] args) {
        int k = 3;
        long max = Long.MAX_VALUE;
        int length = String.valueOf(max).length();
        String n = "";

        for (int i = 1; i <= length; i++) {
            n += "1";
            long num = Long.parseLong(n);
            if (num % k == 0) {
                System.out.println(i + "");
                break;
            }
        }
    }

}
