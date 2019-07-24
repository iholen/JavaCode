package practices.threadlocal;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author huliang
 * @date 2019-06-10 17:22
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ErrorModel {

    private String code;

}
