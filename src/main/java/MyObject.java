/**
 * @author huliang
 * @date 2019-06-09 23:35
 */
class MyObject {
    private MyObject() {}

    private enum MyEnum {
        mySingletonObject;

        private MyObject myObject;
        MyEnum() {
            myObject = new MyObject();
        }
    }

    public static MyObject getInstance() {
        return MyEnum.mySingletonObject.myObject;
    }

}
