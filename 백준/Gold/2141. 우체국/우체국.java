import java.io.*;
import java.util.*;

class Town implements Comparable<Town> {
    int location;
    int people;

    public Town(int location, int people) {
        this.location = location;
        this.people = people;
    }

    @Override
    public int compareTo(Town o) {
        return this.location - o.location;
    }
}

public class Main {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static Town[] towns;

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        towns = new Town[n];
        StringTokenizer st;
        long slideSum = 0;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int location = Integer.parseInt(st.nextToken());
            int people = Integer.parseInt(st.nextToken());
            towns[i] = new Town(location, people);
            slideSum -= people;
        }

        Arrays.sort(towns);

        int pointIdx = 0;
        for (int i = 0; i < towns.length; i++) {
            Town town = towns[i];
            slideSum += town.people * 2L;
//            System.out.println(slideSum);
            if (slideSum >= 0) {
                pointIdx = i;
                break;
            }
        }

        System.out.println(towns[pointIdx].location);

    }

    private static void printArr(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
