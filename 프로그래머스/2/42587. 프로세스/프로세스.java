import java.util.*;

class Solution {
    
    public static ArrayDeque<Integer> queue;
    public static PriorityQueue<Integer> priorityQueue;
    
    public static void init(int[] priorities) {
        queue = new ArrayDeque<>();
        priorityQueue = new PriorityQueue<>(Collections.reverseOrder());
        for (int a: priorities) {
            queue.addLast(a);
            priorityQueue.add(a);
        }
    }
    
    public static boolean isMostPriority(int num) {
        if (priorityQueue.peek() == num) {
            return true;
        }
        return false;
    }
    
    public static int checkRange(int num) {
        while (num < 0) {
            num += queue.size();
        }
        return num;
    }
    
    public int solution(int[] priorities, int location) {
        int answer = 0;
        init(priorities);
        
        while (queue.size() > 0) {
            int front = queue.pollFirst();
            
            if (isMostPriority(front)) {
                answer++;
                if (location == 0) {
                    break;
                }
                priorityQueue.poll();
            }
            else {
                queue.addLast(front);
            }
            location = checkRange(location - 1);
            
        }
        
        return answer;
    }
}