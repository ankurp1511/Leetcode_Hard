public class Solution {

    public static void main(String[] args) {

        System.out.println(firstPositive(new int[]{7,8,9,11,12}));

    }

    private static int firstPositive(int[] nums) {

        for (int i=0 ; i < nums.length; i++) {
           int x = nums[i];
           nums[i] = 0;

           if (x > 0 && x <= nums.length && x != nums[x-1]) {
               int y = 0;
               while (true) {
                   if (x < 1 || x > nums.length || x == nums[x-1]) {
                       break;
                   }
                   y = nums[x-1];
                   nums[x-1] = x;
                   x=y;
               }
           }
        }

        for (int j = 0; j < nums.length; j++) {
            if (nums[j] == 0 || nums[j] != j+1) {
                return j + 1;
            }

        }
        return nums.length  + 1;
    }



}
