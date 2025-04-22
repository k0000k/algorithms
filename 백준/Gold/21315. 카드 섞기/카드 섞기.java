import java.io.*;
import java.util.*;

public class Main {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static int[] cards;

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        cards = new int[n];
        for (int i = 0; i < n; i++) {
            cards[i] = Integer.parseInt(st.nextToken());
        }

        int maxK = findMaxK(n);
        int[] init = makeInitArr(n);
        for (int i = 1; i <= maxK; i++) {
            int[] arr = shuffleCards(init.clone(), i);
            for (int j = 1; j <= maxK; j++) {
                int[] result = shuffleCards(arr.clone(), j);
                if (isEqualCardSet(result)) {
                    System.out.println(i + " " + j);
                    return;
                }
            }
        }


//        shuffleCards(init, 2);

    }

    private static int[] makeInitArr(int n) {
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = i + 1;
        }
        return arr;
    }

    private static int findMaxK(int n) {
        int k = 1;
        int multiple = 2;
        while (multiple < n) {
            multiple *= 2;
            k += 1;
        }
        return k - 1;
    }

    private static int[] shuffleCards(int[] arr, int k) {
        int[] newArr = new int[arr.length];
        int powOf2 = (int) Math.pow(2, k);
        // 1번째 단계
        int startIdx = arr.length - powOf2;
        int idx = 0;
        for (int i = startIdx; i < arr.length; i++) {
            newArr[idx++] = arr[i];
        }

        idx = 0;
        for (int i = powOf2; i < arr.length; i++) {
            newArr[i] = arr[idx++];
        }

//        for (Integer num : newArr) {
//            System.out.print(num + " ");
//        }
//        System.out.println();

        // 이후 단계
        for (int i = 0; i < k; i++) {
            int half = powOf2 / 2;
            for (int j = 0; j < half; j++) {
                //j와 j + pow를 스왑
//                System.out.println(j + " " + (j + powOf2));
                int temp = newArr[j];
                newArr[j] = newArr[j + half];
                newArr[j + half] = temp;
            }
            powOf2 /= 2;
//            for (Integer num : newArr) {
//                System.out.print(num + " ");
//            }
//            System.out.println();
        }



        return newArr;
    }

    private static boolean isEqualCardSet(int[] result) {
        for (int i = 0; i < cards.length; i++) {
            if (cards[i] != result[i]) {
                return false;
            }
        }
        return true;
    }
}
