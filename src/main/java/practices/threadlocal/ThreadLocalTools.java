package practices.threadlocal;

import java.util.ArrayList;
import java.util.List;

/**
 * @author huliang
 * @date 2019-06-10 17:20
 */
public class ThreadLocalTools {

    private static final SkbThreadLocal threadLocal = new SkbThreadLocal();

    static class SkbThreadLocal<T extends List<E>, E> extends InheritableThreadLocal<T> {

        @Override
        public T initialValue() {
            return (T)new ArrayList<>();
        }

        @Override
        public T childValue(T parentValue) {
            return parentValue;
        }

        public void pushValue(E value) {
            T localValue = get();
            localValue.add(value);
        }
    }

    public static <T extends List<E>, E> T get() {
        return (T)threadLocal.get();
    }

    public static <E> E pushValue(Class<E> clazz, String code) {
        if (ErrorModel.class.equals(clazz)) {
            ErrorModel errorModel = ErrorModel.builder().code(code).build();
            threadLocal.pushValue(errorModel);
            return (E)errorModel;
        }

        return null;
    }
}
