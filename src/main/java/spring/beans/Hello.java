package spring.beans;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author huliang
 * @date 2019-06-06 19:45
 */
@Data
public class Hello {

    private String content = "content";
    @Autowired
    private Dao dao;

}
