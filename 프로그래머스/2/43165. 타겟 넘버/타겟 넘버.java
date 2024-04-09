import java.util.*;

class Solution {
    
    public static int[] givenNumbers;
    public static int answer = 0;
    public static int targetNumber;
    
    public static void findComb(int value, int idx) {
        if (idx == givenNumbers.length) {
            if (targetNumber == value) {
                answer++;
            }
            return;
        }
        findComb(value + givenNumbers[idx], idx + 1);
        findComb(value - givenNumbers[idx], idx + 1);
    }
    
    public int solution(int[] numbers, int target) {
        givenNumbers = numbers;
        targetNumber = target;
        
        findComb(0, 0);
        int result = answer;
        
        return result;
    }
}