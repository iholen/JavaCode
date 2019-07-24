package practices.serialize;

import java.io.Serializable;

public class Student implements Serializable {

    private static final long serialVersionUID = -5358588397688318053L;
    private String name;
    private transient int age;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student[name="+ name +", age="+ age + "]";
    }
}
