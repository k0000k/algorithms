import java.util.*;

class Node {
    public int x;
    public int y;
    public int length;
    
    public Node(int x, int y, int length) {
        this.x = x;
        this.y = y;
        this.length = length;
    }
}

class Solution {
    
    public static int[][] board;
    public static ArrayList<Integer> lengths;
    public static int[][] directions = new int[][] {{-1, 0}, {0, 1}, {0, -1}, {1, 0}};
    
    public static void printArrays(boolean[][] array) {
        // for (int i = 0; i < board.length; i++) {
        //     for (int j = 0; j < board[0].length; j++) {
        //         System.out.print(board[i][j] + " ");
        //     }
        //     System.out.println();
        // }
        // System.out.println("-----------");
        
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("-----------");
    }
    
    public static void init(int[][] maps, boolean[][] visited) {
        board = maps;
        lengths = new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 0) {
                    visited[i][j] = true;
                }
            }
        }
    }
    
    public static int findPaths(int x, int y, boolean[][] visited) {
        ArrayDeque<Node> queue = new ArrayDeque<>();
        visited[x][y] = true;
        queue.addLast(new Node(x, y, 1));
        
        while (queue.size() != 0) {
            Node thisNode = queue.pollFirst();
            if (thisNode.x == board.length - 1 && thisNode.y == board[0].length - 1) {
                return thisNode.length;
            }
            for (int i = 0; i < 4; i++) {
                int afterX = thisNode.x + directions[i][0];
                int afterY = thisNode.y + directions[i][1];
                if (checkValidate(afterX, afterY) && !visited[afterX][afterY]) {
                    visited[afterX][afterY] = true;
                    queue.addLast(new Node(afterX, afterY, thisNode.length + 1));
                }
            }
        }
        return -1;
    }
    
    public static boolean checkValidate(int x, int y) {
        boolean isX = x >= 0 && x <= board.length - 1;
        boolean isY = y >= 0 && y <= board[0].length - 1;
        return isX && isY;
    }
    
    public int solution(int[][] maps) {
        
        boolean[][] visited = new boolean[maps.length][maps[0].length];
        init(maps, visited);
        
        int answer = findPaths(0, 0, visited);
        
        // System.out.println(lengths);
        
        return answer;
    }
}