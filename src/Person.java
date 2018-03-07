import java.util.ArrayList;
import java.util.List;

/**
 * Created by Arry on 2017/8/30.
 */
public class Person {
    private String name;
    private String email;
    private int sex;

    public Person() {
    }

    public Person(String name, String email, int sex) {
        this.name = name;
        this.email = email;
        this.sex = sex;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public static void main(String[] args) {
        Integer t1 = 128;
        Integer t2 = 128;
        System.out.println(t1==t2);

        Integer t3 = 127;
        Integer t4 = 127;
        System.out.println(t3==t4);

        Integer t5 = new Integer(127);
        Integer t6 = new Integer(127);
        System.out.println(t5==t6);
        System.out.println(t3==t5);
    }
}
