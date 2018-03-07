import java.util.HashSet;
import java.util.Set;

/**
 * Given a string, find the length of the longest substring without repeating characters.
 * <p>
 * Examples:
 * <p>
 * Given "abcabcbb", the answer is "abc", which the length is 3.
 * <p>
 * Given "bbbbb", the answer is "b", with the length of 1.
 * <p>
 * Given "pwwkew", the answer is "wke", with the length of 3. Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
 * Created by Arry on 2017/10/27.
 */
public class LongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        int answer = 0, i = 0, j = 0;
        int n = s.length();
        Set<Character> set = new HashSet<>(16);
        while (i<n&&j<n){
            if (!set.contains(s.charAt(j))){
                set.add(s.charAt(j++));
                answer = Math.max(answer,j-i);
            }else {
                set.remove(s.charAt(i++));
            }
        }
            return answer;
    }


    public static void main(String[] args) {
        LongestSubstring s = new LongestSubstring();
        System.out.println(s.lengthOfLongestSubstring("pwwkew"));
    }
}
