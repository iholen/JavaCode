package spring.beans;

/**
 * @author huliang
 * @date 2019-06-08 15:17
 */
public class ServiceFactory {

    public static ServiceFactory createInstance() {
        return new ServiceFactory();
    }

    public UserService createUserService() {
        return new UserService();
    }

}
