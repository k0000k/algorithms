import java.io.*;
import java.math.BigInteger;

public class Main {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        String input = br.readLine();
        BigInteger answer = new BigInteger("0");
        BigInteger r = new BigInteger("1");
        for (Character ch : input.toCharArray()) {
            int val = ch - 96;
            answer = answer.add(r.multiply(BigInteger.valueOf(val)));
            r = r.multiply(BigInteger.valueOf(31));
        }
        System.out.println(answer.remainder(BigInteger.valueOf(1234567891)));
    }
}