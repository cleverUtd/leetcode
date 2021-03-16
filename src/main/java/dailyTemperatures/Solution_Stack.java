package dailyTemperatures;

import java.util.Stack;

public class Solution_Stack {

    public static int[] dailyTemperatures(int[] T) {
        int[] result = new int[T.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < T.length; i++) {
            while (!stack.empty() && T[i] > T[stack.peek()]) {
                int index = stack.pop();
                result[index] = i - index;
            }
            stack.push(i);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] result = dailyTemperatures(new int[]{73, 74, 75, 71, 69, 72, 76, 73});
        for (int j : result) {
            System.out.println(j);
        }
    }
}
