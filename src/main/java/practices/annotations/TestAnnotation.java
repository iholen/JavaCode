package practices.annotations;

/**
 * @author huliang
 * @date 2019-06-06 11:19
 */
public class TestAnnotation {

    @MyAnnotation("holen")
    private String name;

    public String getName() {
        return name;
    }

    public static void main(String[] args) {
        TestAnnotation testAnnotation = new TestAnnotation();
        System.out.println(testAnnotation.getName());
    }

}
