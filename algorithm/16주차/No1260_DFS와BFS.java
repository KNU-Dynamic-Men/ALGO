/*
 * 문제 풀이 시작: 2021/04/14 3:21 오후
 * 맞은 시각: 2021/04/14 3:38 오후
 * 소요 시간: 17분
 * @author ventulus95
 */
package codeBaekJoon._2021;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class No1260_DFS와BFS {

    static ArrayList<Integer>[] graph;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        graph = new ArrayList[n+1];
        for (int i = 1; i <=n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i <m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int v = Integer.parseInt(st.nextToken());
            int u = Integer.parseInt(st.nextToken());
            graph[v].add(u);
            graph[u].add(v);
        }
        for (int i = 1; i <=n; i++) {
            graph[i].sort(Integer::compareTo); //((a,b)->a.compareTo(b));
        }
        visited = new boolean[n+1];
        dfs(s);
        sb.append("\n");
        visited = new boolean[n+1];
        bfs(s);
        System.out.println(sb.toString());
    }

    private static void dfs(int s) {
        visited[s] = true;
        sb.append(s+" ");
        for (int nxt: graph[s]){
            if(!visited[nxt])
                dfs(nxt);
        }
    }

    private static void bfs(int s) {
        Queue<Integer> q = new LinkedList<>();
        q.add(s);
        visited[s] = true;
        while (!q.isEmpty()){
            int node = q.poll();
            sb.append(node+" ");
            for (int nxt: graph[node]){
                if(!visited[nxt]){
                    q.add(nxt);
                    visited[nxt] = true;
                }
            }
        }
    }
}
