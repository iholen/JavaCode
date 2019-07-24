package practices.lock.reentrantlock;

/**
 * @author huliang
 * @date 2019-06-09 21:55
 */
public class ThreadB extends Thread {

    private MyService myService;

    public ThreadB(MyService myService) {
        this.myService = myService;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            myService.set();
        }
    }

}
