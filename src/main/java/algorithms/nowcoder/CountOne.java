package algorithms.nowcoder;

/**
 * 输入一个long类型的数值, 求该数值的二进制表示中的1的个数 .
 *
 * @author huliang
 * @date 2019-08-07 16:55
 */
public class CountOne {

    public static void main(String[] args) {

    }

    public static int countOne(long num) {
        int count = 0;
        while (num != 0) {
            count++;
            num = num & (num - 1);
        }

        return count;
    }

}
