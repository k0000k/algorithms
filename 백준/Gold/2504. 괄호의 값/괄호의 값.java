import java.io.*;
import java.util.*;

public class Main {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static ArrayDeque<String> queue;
    public static ArrayDeque<String> stack = new ArrayDeque<>();
    public static HashMap<String, String> pairs = new HashMap<>();

    public static void main(String[] args) throws IOException {
        queue = new ArrayDeque<>(Arrays.asList(br.readLine().split("")));
        pairs.put("(", ")");
        pairs.put(")", "(");
        pairs.put("[", "]");
        pairs.put("]", "[");
        int answer = 0;
        try {
            while (!queue.isEmpty()) {
                findPair();
            }
//        System.out.println(stack + "    " +queue + "   final");
            for (String str : stack) {
                answer += Integer.parseInt(str);
            }
            System.out.println(answer);
        } catch (Exception e) {
            System.out.println(0);
        }
    }

    private static void findPair() {
        String queueFirst = queue.pollFirst();
        if (isLeft(queueFirst)) { // 왼쪽 괄호일 때
            stack.add(queueFirst);
//            System.out.println(stack + "     " + queue);
            findPair();
//            System.out.println("recursion: " + queueFirst);
//            System.out.println(stack + "     " + queue + "  calc start");
            while (!queue.isEmpty() && !isLeft(queue.peekFirst())) {
                calc();
            }
        }
        else { // 오른쪽 괄호일 때
            if (stack.peekLast().equals("(") && queueFirst.equals(")")) {
                stack.pollLast();
                stack.add("2");
            }
            else if (stack.peekLast().equals("[") && queueFirst.equals("]")) {
                stack.pollLast();
                stack.add("3");
            }
//            System.out.println(stack + "     " + queue + "  findpair end");
        }
    }

    private static boolean isLeft(String str) {
        return (str.equals("(")) || (str.equals("["));
    }

    private static void calc() {
        String queueFirst = queue.pollFirst();
        String stackFirst = stack.peekLast();
        String pairOfQueue = pairs.get(queueFirst);
        int val = 0;
        while (!stackFirst.equals(pairOfQueue)) {
            val += Integer.parseInt(stack.pollLast());
            stackFirst = stack.peekLast();
        }
        stackFirst = stack.pollLast();
//        System.out.println(stack + "    " + queue);
        if (stackFirst.equals("(")) {
            stack.add(String.valueOf(2 * val));
        }
        else if (stackFirst.equals("[")) {
            stack.add(String.valueOf(3 * val));
        }
//        System.out.println(stack + "    " + queue + "   calc end");
    }
}