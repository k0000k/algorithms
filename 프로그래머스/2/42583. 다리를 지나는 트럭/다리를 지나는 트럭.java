import java.util.*;

class Solution {
    
    public static ArrayDeque<Integer> bridgeQueue;
    public static ArrayDeque<Integer> truckQueue;
    public static ArrayDeque<Integer> timeQueue;
    
    public static void init(int[] truck_weights) {
        bridgeQueue = new ArrayDeque<>();
        truckQueue = new ArrayDeque<>();
        timeQueue = new ArrayDeque<>();
        
        for (int num: truck_weights) {
            truckQueue.addLast(num);
        }
    }
    
    public static void printQueue() {
        System.out.println("bridge: " + bridgeQueue);
        System.out.println("truck: " + truckQueue);
        System.out.println("time: " + timeQueue);
        System.out.println("------------");
    }
    
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        init(truck_weights);
        
        int currentWiegth = 0;
        while (truckQueue.size() > 0 || bridgeQueue.size() > 0) {
            answer++;
            if (bridgeQueue.size() > 0 && timeQueue.peekFirst() + bridge_length == answer) {
                int truck = bridgeQueue.peekFirst();
                currentWiegth -= truck;
                bridgeQueue.removeFirst();
                timeQueue.removeFirst();
            }
            if (truckQueue.size() > 0) {
                int head = truckQueue.peekFirst();
                if (bridgeQueue.size() < bridge_length && currentWiegth + head <= weight) {
                    bridgeQueue.addLast(truckQueue.pollFirst());
                    timeQueue.addLast(answer);
                    currentWiegth += head;
                }
            }
            // printQueue();
        }
        return answer;
    }
}