package class2;

import java.io.*;
import java.util.*;

public class Q4153 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<String> output = new ArrayList<>();

        while(true) {
            long[] data = new long[3];

            data[0] = scan.nextInt();
            data[1] = scan.nextInt();
            data[2] = scan.nextInt();

            for (int i=1; i < 3; i++) {
                if (data[i] < data[i-1]) {
                    long temp = data[i];
                    data[i] = data[i-1];
                    data[i-1] = temp;
                }
            }

            if (data[2] == 0) {
                break;
            }
            output.add((Math.pow(data[2], 2) == Math.pow(data[1], 2) + Math.pow(data[0], 2)) ? "right" : "wrong");
        }

        output.stream().forEach(out -> System.out.println(out));
    }

    public static void other() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while(true) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            int[] data = {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
            Arrays.sort(data);

            if (data[2] == 0) {
                break;
            }

            bw.write((data[2]*data[2] == data[1]*data[1] + data[0]*data[0]) ? "right" : "wrong");
            bw.newLine();
        }
        bw.flush();
        br.close();
        bw.close();
    }
}
