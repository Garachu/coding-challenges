package leetcode;

public class FirstMissingPositive {

    public static void main(String args[]){
//        System.out.println(firstMissingPositive(new int[]{1,2,0}));
//        System.out.println(firstMissingPositive(new int[]{3,4,-1,1}));
//        System.out.println(firstMissingPositive(new int[]{7,8,9,11,12}));
        System.out.println(firstMissingPositive(new int[]{1}));
    }

    static int firstMissingPositive(int[] nums) {
        int len = nums.length;
        for(int i = 0; i < len; i++){
            int element = i + 1;
            System.out.println("looking for: " + element);
            for(int j = 0; j < len; j++){
                System.out.println(nums[j] + "\t" + j + "\t" + (len - 1));
                int num = nums[j];
                if(num == element) break;
                if(j == len - 1) return element;
            }
        }
        return len + 1;
    }

}
