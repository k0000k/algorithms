import java.io.*;
import java.util.*;

class SumDeque {
    public ArrayDeque<Integer> deque = new ArrayDeque<>();
    private int sum = 0;

    public void add(int val) {
        deque.add(val);
        sum += val;
    }

    public int getSum() {
        return sum;
    }

    public void removeLeft() {
        sum -= deque.pollFirst();
    }

    public int returnRight() {
        int value = deque.pollLast();
        sum -= value;
        return value;
    }

    public boolean isEmpty() {
        return deque.isEmpty();
    }
}

public class Main {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static ArrayDeque<Integer> primes = new ArrayDeque<>();
    public static SumDeque sumDeque = new SumDeque();

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        boolean[] isPrime = new boolean[n + 1];
        Arrays.fill(isPrime, true);
        isPrime[0] = false;
        isPrime[1] = false;
        for (int i = 2; i < isPrime.length; i++) {
            if (!isPrime[i]) {
                continue;
            }
            int j = i + i;
            while (j < isPrime.length) {
                isPrime[j] = false;
                j += i;
            }
            primes.add(i);
        }

        int answer = 0;
        while (!primes.isEmpty()) {
            sumDeque.add(primes.pollFirst());
            int sum = sumDeque.getSum();
            if (sum < n) {
                continue;
            }
            else if (sum == n) {
                answer += 1;
            }
            sumDeque.removeLeft();
            while (!sumDeque.isEmpty() && sumDeque.getSum() >= n) {
                if (sumDeque.getSum() == n) {
                    answer++;
                    sumDeque.removeLeft();
                    break;
                }
                primes.addFirst(sumDeque.returnRight());
            }
        }

        while (!sumDeque.isEmpty()) {
            if (sumDeque.getSum() == n) {
                answer++;
            }
            sumDeque.removeLeft();
        }
        System.out.println(answer);
    }
}
