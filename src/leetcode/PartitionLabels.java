package leetcode;

import java.util.ArrayList;
import java.util.List;

public class PartitionLabels {

    public static void main(String args[]) {
        String s = "ababcbacadefegdehijhklij";
        convertNumericValuesToAscii();
        List<Integer> integers = partitionLabels(s);
        System.out.println(integers);
    }

    static List<Integer> partitionLabels(String S) {
        List<Integer> partitionLens = new ArrayList<>();
        int partitionIndices[] = new int[26];
        for (int i = 0; i < S.length(); i++) {
            partitionIndices[S.charAt(i) - 'a'] = i;
        }
        int start = 0;
        int end = 0;
        for (int i = 0; i < S.length(); i++) {
            int charLastIndex = partitionIndices[S.charAt(i) - 'a'];
            end = Math.max(end, charLastIndex);
            if (end == i) {
                partitionLens.add((end - start) + 1);
                start = end + 1;
            }
        }
        return partitionLens;
    }

    static void convertNumericValuesToAscii() {
        for (int i = 0; i < 129; i++) {
            char c = (char) i;
            System.out.println(i + "\t" + c);
        }
    }
}
