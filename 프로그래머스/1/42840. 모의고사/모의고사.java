import java.util.*;

class Solution {
    
    public static int findMax(int[] arr) {
        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            if (max < arr[i]) {
                max = arr[i];
            }
        }
        return max;
    }
    
    public static int[] list2array(ArrayList<Integer> list) {
        int[] array = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            array[i] = list.get(i);
        }
        return array;
    }
    
    public int[] solution(int[] answers) {
        int[] one = {1, 2, 3, 4, 5};
        int[] two = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] three = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        
        int[] scores = {0, 0, 0};
        
        for (int i = 0; i < answers.length; i++) {
            if (answers[i] == one[i % 5]) {
                scores[0]++;
            }
            if (answers[i] == two[i % 8]) {
                scores[1]++;
            }
            if (answers[i] == three[i % 10]) {
                scores[2]++;
            }
        }
        
        int max = findMax(scores);
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < scores.length; i++) {
            if (max == scores[i]) {
                list.add(i + 1);
            }
        }
        
        return list2array(list);
    }
}