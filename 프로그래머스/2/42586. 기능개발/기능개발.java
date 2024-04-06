import java.util.*;

class Solution {
    
    public int[] solution(int[] progresses, int[] speeds) {
        ArrayList<Integer> answer = new ArrayList<>();
        
        ArrayDeque<Integer> progressQueue = new ArrayDeque<>();
        for (int i = 0; i < progresses.length; i++) {
            progressQueue.addLast(i);
        }

        int currentHeadIdx = 0;
        while (progressQueue.size() > 0) {
            for (int i = currentHeadIdx; i < progresses.length; i++) {
                progresses[i] += speeds[i];
            }
            int count = 0;
            while (progressQueue.size() > 0 && progresses[progressQueue.getFirst()] >= 100) {
                progressQueue.removeFirst();
                count++;
                currentHeadIdx++;
            }
            if (count != 0) {
                answer.add(count);
            }
        }
        
        System.out.println(answer);
        
        int[] answerArray = new int[answer.size()];
        int j = 0;
        for (int num: answer) {
            answerArray[j++] = num;
        }
        
        return answerArray;
    }
}