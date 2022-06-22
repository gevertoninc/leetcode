import java.util.PriorityQueue;

class Solution {
  public int furthestBuilding(int[] heights, int bricks, int ladders) {
    PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();

    for (int i = 0; i < heights.length - 1; i++) {
      int next = heights[i + 1];
      int current = heights[i];
      int distance = next - current;

      if (distance > 0) {
        priorityQueue.add(distance);
      }

      if (priorityQueue.size() > ladders) {
        bricks -= priorityQueue.poll();
      }

      if (bricks < 0) {
        return i;
      }
    }

    return heights.length - 1;
  }
}
