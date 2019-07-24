package basis.proxy.service.impl;

import basis.proxy.service.MyService;

/**
 * @author huliang
 * @date 2019-07-24 16:53
 */
public class MyServiceImpl implements MyService {

    @Override
    public void print() {
        System.out.println("MyService printed");
    }

}
