package random;

public class NoName {

    public static void main(String args[]){
        // expected combinations
        // 0 -> 3
        // 0 -> 4
        // 1 -> 5
        // 3 -> 4
        kk(new int[]{3, 5, 6, 3, 3, 5});
    }

    static void kk(int[] arr){
        int comb = 0;
        for (int i= 0; i < arr.length; i++){
            for (int j = i + 1; j < arr.length; j++){
                if(arr[i] == arr[j]){
                    System.out.println("Comb: " + i + " -> " + j);
                    comb++;
                }
            }
        }
        System.out.println("Combination: " + comb);
    }
}
