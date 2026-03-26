package dataStructure;

import java.io.*;
import java.util.*;

public class Q10866 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());

        Deque<Integer> deque = new ArrayDeque<>();

        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        for(int i=0; i<num; i++) {
            st = new StringTokenizer(br.readLine());
            String word = st.nextToken();

            switch(word) {
                case "push_front": {
                    int value = Integer.parseInt(st.nextToken());
                    deque.addFirst(value);
                }
                break;
                case "push_back": {
                    int value = Integer.parseInt(st.nextToken());
                    deque.addLast(value);
                }
                break;
                case "pop_front": sb.append(deque.isEmpty() ? -1 : deque.pollFirst()).append("\n");
                break;
                case "pop_back": sb.append(deque.isEmpty() ? -1 : deque.pollLast()).append("\n");
                break;
                case "size": sb.append(deque.size()).append("\n");
                break;
                case "empty": sb.append(deque.isEmpty() ? 1 : 0).append("\n");
                break;
                case "front": sb.append(deque.isEmpty() ? -1 : deque.peekFirst()).append("\n");
                break;
                case "back": sb.append(deque.isEmpty() ? -1 : deque.peekLast()).append("\n");
                break;
            }
        }
        System.out.print(sb.toString());
    }    
}
