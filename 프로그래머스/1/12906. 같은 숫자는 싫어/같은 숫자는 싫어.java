import java.util.*;

public class Solution {
    public int[] solution(int[] arr) {
        
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        for (int num : arr) {
            if (stack.size() == 0) {
                stack.addLast(num);
                continue;
            }
            if (stack.getLast() != num) {
                stack.addLast(num);
            }
        }
        
        int idx = 0;
        int[] answer = new int[stack.size()];
        for (int a: stack) {
            answer[idx++] = a;
        }

        return answer;
    }
}