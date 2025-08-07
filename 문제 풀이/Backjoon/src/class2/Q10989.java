package class2;

import java.io.*;
import java.util.Arrays;

public class Q10989 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int num = Integer.parseInt(br.readLine());

        int[] datas = new int[num];

        for(int i=0; i<num; i++) {
            datas[i] = Integer.parseInt(br.readLine());
        }
        br.close();
        Arrays.sort(datas);

        Arrays.stream(datas).forEach(data -> {
            try {
                bw.write(String.valueOf(data));
                bw.newLine();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
        bw.flush();
        bw.close();

    }
}
