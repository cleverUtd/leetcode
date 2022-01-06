package array;

public class TrappingRainWater {

    public static void main(String[] args) {
        System.out.println(trap(new int[]{0,1,0,2,1,0,1,3,2,1,2,1}));
        System.out.println(trap_memo(new int[]{0,1,0,2,1,0,1,3,2,1,2,1}));
        System.out.println(trap_double_pointer(new int[]{0,1,0,2,1,0,1,3,2,1,2,1}));
    }

    public static int trap(int[] height) {
        int ans = 0;
        for (int i = 1; i < height.length - 1; i++) {
            int lMax = 0;
            int rMax = 0;
            for (int j = i; j < height.length ; j++) {
                if (height[j] > rMax) {
                    rMax = height[j];
                }
            }
            for (int j = i; j >=0 ; j--) {
                if (height[j] > lMax) {
                    lMax = height[j];
                }
            }
            ans += Math.min(lMax, rMax) - height[i];
        }
        return ans;
    }

    public static int trap_memo(int[] height) {
        int[] lMax = new int[height.length];
        int[] rMax = new int[height.length];
        lMax[0] = height[0];
        for (int i = 1; i < height.length; i++) {
            lMax[i] = Math.max(lMax[i - 1], height[i]);
        }
        rMax[height.length - 1] = height[height.length - 1];
        for (int i = height.length - 2; i >= 0; i--) {
            rMax[i] = Math.max(rMax[i + 1], height[i]);
        }

        int ans = 0;
        for (int i = 0; i < height.length; i++) {
            ans += Math.min(lMax[i], rMax[i]) - height[i];
        }
        return ans;
    }

    public static int trap_double_pointer(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int lMax = height[left];
        int rMax = height[right];
        int ans = 0;
        while (left <= right) {
            lMax = Math.max(lMax, height[left]);
            rMax = Math.max(rMax, height[right]);

            if (lMax < rMax) {
                ans += lMax - height[left];
                left++;
            } else {
                ans += rMax - height[right];
                right --;
            }
        }
        return ans;
    }
}
