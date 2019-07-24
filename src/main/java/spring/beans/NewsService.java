package spring.beans;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * @author huliang
 * @date 2019-06-08 15:40
 */
public class NewsService {

    @Setter
    @Getter
    private News news;

}
