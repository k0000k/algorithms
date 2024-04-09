import java.util.*;

class Solution {
    
    public static PriorityQueue<Integer> pq;
    
    public static void init(int[] scoville) {
        pq = new PriorityQueue<>();
        
        for (int a: scoville) {
            pq.add(a);
        }
    }
    
    public int solution(int[] scoville, int K) {
        int answer = 0;
        init(scoville);
        
        while (pq.size() >= 2 && pq.peek() < K) {
            int first = pq.poll();
            int second = pq.poll();
            pq.add(2 * second + first);
            answer++;
        }
        
        if (pq.peek() < K) {
            answer = -1;
        }
        
        return answer;
    }
}