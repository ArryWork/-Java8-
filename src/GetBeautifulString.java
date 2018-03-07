/**
 * Created by Arry on 2017/10/26.
 *
 * aaaa....
 * aaaaa..bbbb..
 * bbb..aaaa
 * bbbb..aaa..bbbb
 * bbbbb..
 */
public class GetBeautifulString {

    public static void main(String[] args) {
        String s = "bbbabbaaa";
        GetBeautifulString g = new GetBeautifulString();
        int l = g.getMaxLengthOfBeautifulString(s);
        System.out.println(l);
    }

    private int getMaxLengthOfBeautifulString(String s) {
        int countA = 0;
        int endA = 0;
        int endB = 0;
        for (int i = 0; i < s.length(); i++){
            if (s.charAt(i)=='a'){
                countA++;
                endA = Math.max(endA,endB)+1;
            }else {
                endB = Math.max(countA,endB)+1;
            }

        }
        return Math.max(endA,endB);
    }
}
