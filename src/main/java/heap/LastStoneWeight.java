package heap;

import java.util.Comparator;
import java.util.PriorityQueue;

public class LastStoneWeight {
    public static int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(stones.length, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });

        for (int stone : stones) {
            maxHeap.add(stone);
        }

        int w;
        while (maxHeap.size() > 1) {
            w = maxHeap.poll() - maxHeap.poll();
            if (w > 0) {
                maxHeap.add(w);
            }
        }
        return maxHeap.isEmpty() ? 0 : maxHeap.poll();
    }


    public static void main(String[] args) {
        System.out.println(lastStoneWeight(new int[]{2,7,4,1,8,1}));
        System.out.println(lastStoneWeight(new int[]{1,1,1,1}));
    }
}
