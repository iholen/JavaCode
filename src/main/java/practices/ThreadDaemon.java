package practices;

import java.util.concurrent.TimeUnit;

public class ThreadDaemon {

    public static void main(String[] args) {
        /**
         * 由于 Runnable 接口 是 SAM 接口
         * 使用Lambda表达式来表示 Runnable 接口的一个实现
         */
        Runnable runnable = () -> {
            while(true) {
                System.out.println("child thread running...");
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        Thread thread = new Thread(runnable);

        thread.setDaemon(true);
        thread.start();

        try {
            TimeUnit.SECONDS.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

//        while(true) {
//            System.out.println("Main thread running...");
//            try {
//                TimeUnit.SECONDS.sleep(10);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }
    }
}
