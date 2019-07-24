package spring.beans;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author huliang
 * @date 2019-06-08 14:59
 */
@Data
public class Dao {
    @Autowired
    private Hello hello;
}
