package basis.proxy.handler;

import basis.proxy.service.MyService;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author huliang
 * @date 2019-07-24 16:50
 */
public class MyHandler implements InvocationHandler {

    private MyService myService;

    public MyHandler(MyService myService) {
        this.myService = myService;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        method.invoke(myService, args);

        return null;
    }

}
