class Solution {
    
    public static int findMax(int[] array) {
        int max = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }
        return max;
    }
    
    public int solution(int[][] triangle) {
        int answer = 0;
        int[][] dp = new int[triangle.length][triangle.length];
        
        dp[0][0] = triangle[0][0];
        for (int i = 0; i < triangle.length - 1; i++) {
            for (int j = 0; j < triangle[i].length; j++) {
                int left = dp[i][j] + triangle[i + 1][j];
                int right = dp[i][j] + triangle[i + 1][j + 1];
                if (left > dp[i + 1][j]) {
                    dp[i + 1][j] = left;
                }
                if (right > dp[i + 1][j + 1]) {
                    dp[i + 1][j + 1] = right;
                }
            }
        }
        
        answer = findMax(dp[dp.length - 1]);
        
        return answer;
    }
}