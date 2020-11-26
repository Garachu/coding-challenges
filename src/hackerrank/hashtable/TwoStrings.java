package hackerrank.hashtable;

public class TwoStrings {

    public static void main(String[] args) {

        // Expect "YES"
        System.out.println(twoStrings("hello", "world"));

        // Expect "NO"
        System.out.println(twoStrings("hi", "world"));
    }

    // Complete the twoStrings function below.
    static String twoStrings(String s1, String s2) {
        for (char c : "abcdefghijklmnopqrstuvwxyz".toCharArray()) {
            if (s1.indexOf(c) > -1 && s2.indexOf(c) > -1) {
                return "YES";
            }
        }
        return "NO";
    }
}
