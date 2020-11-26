package leetcode;

public class LongestPalindromeThatCanBeBuilt {

    public static void main(String args[]){
        String s = "abccccdd";
        System.out.println("Longest palindrome Length: " + longestPalindrome(s));
        String AZ="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String az="abcdefghijklmnopqrstuvwxyz";
        for(char c : AZ.toCharArray()){
            System.out.print((int) c   + "\t");
        }

        System.out.println();
        for(char c : az.toCharArray()){
            System.out.print((int) c   + "\t");
        }
    }

    private static int longestPalindrome(String s) {
        int[] char_counts = new int[128];
        for(char c : s.toCharArray()){
            char_counts[c]++;
        }

        int result = 0;
        for(int char_count: char_counts){
            result += (char_count / 2) * 2;
            if(result % 2 == 0 && char_count % 2 == 1){
                result++;
            }
        }
        return result;
    }
}
