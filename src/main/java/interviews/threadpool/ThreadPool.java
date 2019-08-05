package interviews.threadpool;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author huliang
 * @date 2019-08-05 19:54
 */
public class ThreadPool {

    public static void main(String[] args) {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(
                1,
                1,
                1,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(1),
                (r) -> new Thread(r, "测试线程"),
                new ThreadPoolExecutor.CallerRunsPolicy()
        );

        executor.execute(() -> {
            try {
                Thread.sleep(2000);
                System.out.println("线程1");
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        executor.execute(() -> {
            try {
                Thread.sleep(2000);
                System.out.println("线程2");
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        executor.submit(() -> System.out.println("123木头人"),"木头人进程执行完了");

        try {
            executor.awaitTermination(5, TimeUnit.SECONDS);
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("123....");
    }

}
