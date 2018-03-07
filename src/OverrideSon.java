/**
 * Created by Arry on 2017/9/8.
 */
public class OverrideSon extends OverrideTest {

    void test(String a,String b){
        System.out.println(a+b);
    }

    public static void main(String[] args) {
        OverrideSon s = new OverrideSon();
        s.test("a");
        s.test("A","b");
    }
}
