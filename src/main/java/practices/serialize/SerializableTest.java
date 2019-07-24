package practices.serialize;

import java.io.*;

public class SerializableTest {

    public static void main(String[] args) {
        Student student = new Student("Holen", 26);
        System.out.println(student);

        try {
            FileOutputStream out = new FileOutputStream("student.out");
            ObjectOutputStream outObj = new ObjectOutputStream(out);
            outObj.writeObject(student);
            outObj.flush();
            outObj.close();
            out.close();

            FileInputStream in = new FileInputStream("student.out");
            ObjectInputStream inObj = new ObjectInputStream(in);
            Student stu = (Student)inObj.readObject();
            inObj.close();
            in.close();
            System.out.println(stu);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

}
