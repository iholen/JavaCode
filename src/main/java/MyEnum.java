import java.util.Map;

/**
 * @author huliang
 * @date 2019-06-09 23:30
 */
public enum MyEnum {
    mySingletonObject;

    private MyObject myObject;
    private class MyObject {

    }

    MyEnum() {
        myObject = new MyObject();
    }

    public MyObject getInstance() {
        return myObject;
    }
}
