package dfs;

import java.io.*;
import java.util.*;

public class Q11725 {
    static int num;
    static ArrayList<Integer>[] tree;
    static int[] parent;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        num = Integer.parseInt(br.readLine());
        // index는 자식, 값은 부모
        parent = new int[num+1];

        StringTokenizer st;
        // 노드 좌표
        tree = new ArrayList[num+1];
        for (int i=1; i<=num; i++) {
            tree[i] = new ArrayList<>();
        }

        for(int i=0; i<(num-1); i++) {
            st = new StringTokenizer(br.readLine());
            int node1 = Integer.parseInt(st.nextToken());
            int node2 = Integer.parseInt(st.nextToken());
            tree[node1].add(node2);
            tree[node2].add(node1);
        }

        // 2 ~ num 까지 숫자의 부모 노드를 출력
        // 최상위 노드 부터 시작해서 각 노드의 자식 노드를 확인
        dfs(1);        

        StringBuilder sb = new StringBuilder();
        for(int i=2; i<=num; i++) {
            sb.append(parent[i]).append("\n");
        }
        System.out.print(sb.toString());
    }

    static void dfs(int parentNode) {
        for (int node : tree[parentNode]) {
            if (parent[node] == 0) {
                parent[node] = parentNode;
                dfs(node);
            }
        }
    }
}
