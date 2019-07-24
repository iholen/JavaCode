package interviews;

import java.util.Arrays;
import java.util.List;

/**
 * @author huliang
 * @date 2019-06-02 14:52
 *
 * 实现两个线程分别打印26个英文字母的元音(a,e,i,o,u)和辅音(其他)，按字母顺序输出
 */
public class MultiThreadPrint {
    private Character[] vowels = {'a', 'e', 'i', 'o', 'u'};
    private List<Character> vowelList = Arrays.asList(vowels);
    private char letter = 'a';

    synchronized void printVowel() {
        while (letter <= 'z') {
            try {
                while (!vowelList.contains(letter)) {
                    wait();
                }

                System.out.println("Current thread name " + Thread.currentThread().getName() + "; print " + letter);
                letter++;
                notify();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.exit(0);
    }

    synchronized void printConsonant() {
        while (letter <= 'z') {
            try {
                while (vowelList.contains(letter)) {
                    wait();
                }

                System.out.println("Current thread name " + Thread.currentThread().getName() + "; print " + letter);
                letter++;
                notify();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.exit(0);
    }

    public static void main(String[] args) {
        MultiThreadPrint print = new MultiThreadPrint();
        new ThreadA(print).start();
        new ThreadB(print).start();
    }

    // 元音打印
    static class ThreadA extends Thread {
        private MultiThreadPrint print;

        ThreadA(MultiThreadPrint print) {
            this.print = print;
        }

        @Override
        public void run() {
            print.printVowel();
        }
    }

    // 辅音打印
    static class ThreadB extends Thread {
        private MultiThreadPrint print;

        ThreadB(MultiThreadPrint print) {
            this.print = print;
        }

        @Override
        public void run() {
            print.printConsonant();
        }

    }
}
