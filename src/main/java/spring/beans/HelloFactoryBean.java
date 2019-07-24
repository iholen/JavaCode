package spring.beans;

import org.springframework.beans.factory.FactoryBean;

/**
 * FactoryBean 是一种可以产生 bean 的 bean
 *
 * @author huliang
 * @date 2019-06-06 19:45
 */
public class HelloFactoryBean implements FactoryBean<Hello> {

    @Override
    public Hello getObject() throws Exception {
        Hello hello = new Hello();
        hello.setContent("hello");
        return hello;
    }

    @Override
    public Class<?> getObjectType() {
        return Hello.class;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }
}
