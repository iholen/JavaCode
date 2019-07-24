package practices.lock.reentrantlock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author huliang
 * @date 2019-06-09 21:47
 */
public class MyService {
    // 定义锁
    private Lock lock = new ReentrantLock();
    // 定义锁的condition
    private Condition condition = lock.newCondition();
    private boolean hasValue = false;

    public void get() {
        try {
            lock.lock();
            while (!hasValue) {
                condition.await();
            }

            System.out.println("我取完值了。。。");
            hasValue = false;
            condition.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void set() {
        try {
            lock.lock();
            while (hasValue) {
                condition.await();
            }

            System.out.println("我设完值了。。。");
            hasValue = true;
            condition.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }

    }
}
