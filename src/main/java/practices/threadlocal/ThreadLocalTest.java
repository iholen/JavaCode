package practices.threadlocal;

import java.util.List;

/**
 * @author huliang
 * @date 2019-06-10 17:20
 */
public class ThreadLocalTest {

    public static void main(String[] args) {
        new Thread(() -> {
            ThreadLocalTools.pushValue(ErrorModel.class, "200");
            ThreadLocalTools.pushValue(ErrorModel.class, "201");
            ThreadLocalTools.pushValue(ErrorModel.class, "202");
            List<ErrorModel> data = ThreadLocalTools.get();
            System.out.println("sub thread" + data);
        }).start();


        System.out.println("main thread" + ThreadLocalTools.get());
    }

}
