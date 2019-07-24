package basis.proxy;

import basis.proxy.handler.MyHandler;
import basis.proxy.service.MyService;
import basis.proxy.service.impl.MyServiceImpl;

import java.lang.reflect.Proxy;

/**
 * @author huliang
 * @date 2019-07-24 16:48
 */
public class DynamicProxy {

    public static void main(String[] args) {
        // 委托类
        MyService myService = new MyServiceImpl();
        // InvocationHandler
        MyHandler myHandler = new MyHandler(myService);
        // 获取代理类及其对象
        MyService myServiceProxy = (MyService)Proxy.newProxyInstance(myService.getClass().getClassLoader(), myService.getClass().getInterfaces(), myHandler);
        // 使用代理类对象执行方法
        myServiceProxy.print();
    }

}
