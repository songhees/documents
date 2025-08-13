package class2.sliver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q11866 {
    public static int read() throws IOException {
        int num = System.in.read() & 15;
        int input;
        while ((input = System.in.read()) > 32) {
            num = ((num << 3) + (num << 1)) + (input & 15);
        }
        return num;
    }

    public static void main(String[] args) throws IOException {
        StringBuffer sb = new StringBuffer();

        int num = read();
        int target = read();

        Queue<Integer> que = new LinkedList<>();
        for(int i=0; i<num; i++) {
            que.add(i+1);
        }

        int count = 1;
        sb.append("<");
        while (que.size() > 0) {
            if (count%target != 0) {
                que.add(que.remove());
            } else {
                sb.append(que.remove()+", ");
            }
            count++;
        }
        sb.delete(sb.length() -2, sb.length());
        sb.append(">");

        System.out.println(sb);
    }

    /**
      * @param args
     * @throws IOException
     */
    public static void answer1(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        StringBuffer sb = new StringBuffer();

        int num = Integer.parseInt(st.nextToken());
        int target = Integer.parseInt(st.nextToken());

        Queue<Integer> que = new LinkedList<>();
        for(int i=0; i<num; i++) {
            que.add(i+1);
        }

        int count = 1;
        sb.append("<");
        while (que.size() > 0) {
            Queue<Integer> temp = new LinkedList<>();

            int length = que.size();
            for(int i=0; i<length; i++) {
                if (count%target != 0) {
                    temp.add(que.remove());
                } else {
                    sb.append(que.remove()+", ");
                }
                count++;
            }
            que = temp;
        }
        sb.delete(sb.length() -2, sb.length());
        sb.append(">");

        System.out.println(sb);
        br.close();
    }
}
