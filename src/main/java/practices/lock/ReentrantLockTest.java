package practices.lock;

import practices.lock.reentrantlock.MyService;
import practices.lock.reentrantlock.ThreadA;
import practices.lock.reentrantlock.ThreadB;

/**
 * @author huliang
 * @date 2019-06-09 21:44
 */
public class ReentrantLockTest {
    public static void main(String[] args) {
        MyService service = new MyService();
        new ThreadA(service).start();
        new ThreadB(service).start();
    }
}
