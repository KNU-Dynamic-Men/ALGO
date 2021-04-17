/*
 * 문제 풀이 시작: 2021/04/14 3:39 오후
 * 맞은 시각: 2021/04/14 3:45 오후
 * 소요 시간: 6분
 * @author ventulus95
 */
package codeBaekJoon._2021;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class No2606_바이러스 {

    static int cnt;
    static ArrayList<Integer>[] graph;
    static boolean[] visited;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        StringTokenizer st;
        graph = new ArrayList[n + 1];
        for (int i = 1; i <=n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i <m; i++) {
            st= new StringTokenizer(br.readLine(), " ");
            int v = Integer.parseInt(st.nextToken());
            int u = Integer.parseInt(st.nextToken());
            graph[v].add(u);
            graph[u].add(v);
        }
        visited = new boolean[n+1];
        dfs(1);
        System.out.println(cnt-1);
    }

    private static void dfs(int i) {
        visited[i] = true;
        cnt++;
        for (int nxt: graph[i]){
            if(!visited[nxt])
                dfs(nxt);
        }
    }
}
