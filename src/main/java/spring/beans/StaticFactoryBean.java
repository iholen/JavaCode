package spring.beans;

/**
 * @author huliang
 * @date 2019-06-08 15:05
 */
public class StaticFactoryBean {

    public static Dao getDao() {
        return new Dao();
    }

}
