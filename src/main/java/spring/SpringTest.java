package spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import spring.beans.Dao;

/**
 * @author huliang
 * @date 2019-06-06 19:40
 */
public class SpringTest {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml");
        Dao dao = applicationContext.getBean("dao", Dao.class);
        System.out.println(dao.getHello().getContent());
    }

}
