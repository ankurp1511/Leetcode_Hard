import java.util.*;

public class Solution {

    static class CustomIntegerOrdering implements Comparator<Integer> {

        @Override
        public int compare(Integer o1, Integer o2) {

            if (o1 < o2) {
                return 1;
            } else if (o1 > o2) {
                return -1;
            }
            return 0;
        }
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(maxSlidingWindow(new int[]{1,3,1,2,0,5}, 3)));
    }

    public static int[] maxSlidingWindow(int[] nums, int k) {

        int i =0, j=0;
        int[] result = new int[nums.length - k + 1];
        Queue<Integer> queue = new LinkedList<>();

        while (j < nums.length) {

            if (queue.isEmpty()) {
                queue.add(nums[j]);
            } else {
                while (!queue.isEmpty() && queue.peek() < nums[j]) {
                    queue.poll();
                }
                queue.add(nums[j]);
            }

            if (j - i + 1 == k) {
                result[i] = queue.peek();
                if (queue.peek() == nums[i]) {
                    queue.poll();
                    while (!queue.isEmpty() && queue.peek() < nums[j]) {
                        queue.poll();
                    }
                }
                i++;
            }
            j++;
        }
        return result;
    }
}
