import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution {

    public static void main(String[] args) {
        System.out.println(trap(new int[] {0,1,0,2,1,0,1,3,2,1,2,1}));
    }

    public static int trap(int[] height) {
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();

        List<Integer> lMax = new ArrayList<>();
        List<Integer> rMax = new ArrayList<>();

        int result = 0;

        for (int i=0 ; i< height.length; i++) {
            if (stack1.isEmpty()) {
                lMax.add(0);
                stack1.push(height[i]);
            } else {
                if (stack1.peek() > height[i]) {
                    lMax.add(stack1.peek());
                } else {
                    lMax.add(0);
                    stack1.push(height[i]);
                }
            }
        }

        for (int j=height.length-1 ; j>=0; j--) {
            if (stack2.isEmpty()) {
                rMax.add(0,0);
                stack2.push(height[j]);
            } else {
                if (stack2.peek() > height[j]) {
                    rMax.add(0, stack2.peek());
                } else {
                    rMax.add(0, 0);
                    stack2.push(height[j]);
                }
            }
        }

        for (int n = 0; n < height.length; n++) {
            result += Math.max((Math.min(lMax.get(n), rMax.get(n)) - height[n]), 0);
        }

        return result;
    }
}
