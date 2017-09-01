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
}
