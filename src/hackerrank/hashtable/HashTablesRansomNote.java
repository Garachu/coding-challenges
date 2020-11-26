package hackerrank.hashtable;


import java.util.Hashtable;

/**
 * Harold is a kidnapper who wrote a ransom note, but now he is worried it will be traced back to him through his handwriting.
 * He found a magazine and wants to know if he can cut out whole words from it and use them to create an untraceable replica of his ransom note.
 * The words in his note are case-sensitive and he must use only whole words available in the magazine.
 * He cannot use substrings or concatenation to create the words he needs.
 * <p>
 * Given the words in the magazine and the words in the ransom note,
 * print Yes if he can replicate his ransom note exactly using whole words from the magazine; otherwise, print No.
 */
public class HashTablesRansomNote {

    public static void main(String[] args) {

        // Expect "Yes"
        String m1 = "give me one grand today night";
        String[] magazine1 = m1.split(" ");
        String n1 = "give me one grand today night";
        String[] note1 = n1.split(" ");
        checkMagazine(magazine1, note1);

        // Expect "No"
        String m2 = "two times three is not four";
        String[] magazine2 = m2.split(" ");
        String n2 = "two times two is four";
        String[] note2 = n2.split(" ");
        checkMagazine(magazine2, note2);

        // Expect "No"
        String m3 = "give me one grand today night";
        String[] magazine3 = m3.split(" ");
        String n3 = "give one grand today";
        String[] note3 = n3.split(" ");
        checkMagazine(magazine3, note3);
    }

    // Complete the checkMagazine function below.
    static void checkMagazine(String[] magazine, String[] note) {
        if (note.length > magazine.length) {
            System.out.println("No");
            return;
        }

        Hashtable<String, Integer> ht = new Hashtable<>();
        for (String s : magazine) {
            ht.put(s, ht.getOrDefault(s, 0) + 1);
        }

        ht.entrySet().forEach(v -> System.out.println(v.getKey() + "\t" + v.getValue()));

        for (String n : note) {
            if (ht.containsKey(n)) {
                Integer i = ht.get(n);
                if (i == 1) {
                    ht.remove(n);
                } else {
                    ht.replace(n, (i - 1));
                }
            } else {
                System.out.println("No");
                return;
            }
        }

        System.out.println("Yes");
    }
}
