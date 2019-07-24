package practices.lombok;

import lombok.*;

import java.util.List;

//@NoArgsConstructor
//@RequiredArgsConstructor(staticName = "of")
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PACKAGE)
public class User {
    private String name;
    private int age;
    private String sex;
    private List<String> hobbies;

    public static void main(String[] args) {
//        User u1 = new User("holen");
//        User u2 = User.of("holen");

        System.out.println("end...");
    }
}