import java.io.*;
import java.util.*;

class Party {
    int count;
    int[] peoples;
    boolean available = true;

    public Party(int count, int[] peoples) {
        this.count = count;
        this.peoples = peoples;
    }
    
}

public class Main {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer st;
    public static HashMap<Integer, Boolean> truePeoples = new HashMap<>();
    public static LinkedList<Party> parties = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int trueCnt = Integer.parseInt(st.nextToken());
        while (st.hasMoreTokens()) {
            truePeoples.put(Integer.parseInt(st.nextToken()), Boolean.TRUE);
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int peopleCnt = Integer.parseInt(st.nextToken());
            int[] arr = new int[peopleCnt];
            int idx = 0;
            while (st.hasMoreTokens()) {
                arr[idx++] = Integer.parseInt(st.nextToken());
            }
            parties.add(new Party(peopleCnt, arr));
        }

        boolean isEnd;
        do {
            isEnd = false;
            for (Party party : parties) {
                if (party.available && isInTruePeople(party)) {
                    enrollTrue(party);
                    party.available = false;
                    isEnd = true;
                }
            }
        } while (isEnd);

        HashMap<Integer, Integer> numberCnt = new HashMap<>();
        for (Party party : parties) {
            if (party.available) {
                for (Integer num : party.peoples) {
                    int val = numberCnt.getOrDefault(num, 0);
                    numberCnt.put(num, val + 1);
                }
            }
        }

        int answer = 0;
        for (Party party : parties) {
            if (party.available) {
                answer++;
            }
        }
        System.out.println(answer);

    }

    private static boolean isInTruePeople(Party party) {
        for (int people : party.peoples) {
            if (truePeoples.containsKey(people)) {
                return true;
            }
        }
        return false;
    }

    private static void enrollTrue(Party party) {
        for (int people : party.peoples) {
            truePeoples.put(people, Boolean.TRUE);
        }
    }

}