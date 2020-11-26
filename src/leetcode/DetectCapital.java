package leetcode;

public class DetectCapital {

    public static void main(String args[]) {
        System.out.println("USA : " + detectCapitalUse("USA"));
        System.out.println("leetcode : " + detectCapitalUse("leetcode"));
        System.out.println("Meg : " + detectCapitalUse("Meg"));
        System.out.println("flaG : " + detectCapitalUse("flaG"));
    }

    private static boolean detectCapitalUse(String word) {
        if (word.length() < 2) return true;
        if (Character.isUpperCase(word.charAt(0)) && Character.isUpperCase(word.charAt(1))) {
            for (int i = 2; i < word.length(); i++) {
                if (Character.isLowerCase(word.charAt(i))) return false;
            }
        } else {
            for (int i = 1; i < word.length(); i++) {
                if (Character.isUpperCase(word.charAt(i))) return false;
            }
        }
        return true;
    }
}
