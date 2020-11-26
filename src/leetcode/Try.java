package leetcode;

public class Try {

    static TrieNode root;

    public static void main(String args[]) {
        // Input keys (use only 'a' through 'z' and lower case)
        String keys[] = {"the", "a", "there", "answer", "any",
                "by", "bye", "their"};

        String output[] = {"Not present in trie", "Present in trie"};

        root = new TrieNode();

        // Construct trie
        int i;
        for (i = 0; i < keys.length; i++)
            insert(keys[i]);

        // Search for different keys
        if (search("the") == true)
            System.out.println("the --- " + output[1]);
        else System.out.println("the --- " + output[0]);

        if (search("these") == true)
            System.out.println("these --- " + output[1]);
        else System.out.println("these --- " + output[0]);

        if (search("their") == true)
            System.out.println("their --- " + output[1]);
        else System.out.println("their --- " + output[0]);

        if (search("thaw") == true)
            System.out.println("thaw --- " + output[1]);
        else System.out.println("thaw --- " + output[0]);
    }

    static void insert(String key) {
        TrieNode pCrawl = root;
        int len = key.length();
        for (int i = 0; i < len; i++) {
            int index = key.charAt(i) - 'a';
            if (pCrawl.children[index] == null) {
                pCrawl.children[index] = new TrieNode();
                pCrawl = pCrawl.children[index];
            } else {
                pCrawl = pCrawl.children[index];
            }
        }
        pCrawl.we += 1;
    }

    static boolean search(String key) {
        TrieNode pCrawl = root;
        int len = key.length();
        for (int i = 0; i < len; i++) {
            int index = key.charAt(i) - 'a';
            if (pCrawl.children[index] == null) {
                return false;
            } else {
                pCrawl = pCrawl.children[index];
            }
        }
        if (pCrawl.we > 0) return true;
        else return false;
    }

    static class TrieNode {

        private int size = 26;
        TrieNode[] children = new TrieNode[size];
        int we = 0;

        public TrieNode() {
            for (int i = 0; i < size; i++) {
                children[0] = null;
            }
        }

    }

}

