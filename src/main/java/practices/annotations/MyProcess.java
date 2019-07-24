package practices.annotations;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedAnnotationTypes;
import javax.lang.model.element.TypeElement;
import java.util.Set;

/**
 * @author huliang
 * @date 2019-06-06 11:17
 */
@SupportedAnnotationTypes({"practices.annotations.MyAnnotation"})
public class MyProcess extends AbstractProcessor {
    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
        System.out.println("123");
        return false;
    }
}
