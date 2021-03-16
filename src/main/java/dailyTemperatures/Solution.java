package dailyTemperatures;

public class Solution {

    public static int[] dailyTemperatures(int[] T) {
        int[] result = new int[T.length];
        for (int i = 0; i < T.length; i++) {
            for (int j = i + 1; j < T.length; j++) {
                if (T[j] > T[i]) {
                    result[i] = j - i;
                    break;
                }
            }
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
