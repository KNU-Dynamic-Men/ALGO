/*
 * 문제 풀이 시작: 2021/04/14 3:04 오후
 * 맞은 시각: 2021/04/14 3:21 오후
 * 소요 시간: 17분
 * @author ventulus95
 */
package codeBaekJoon._2021;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class No11724_연결요소의개수 {

    static ArrayList<Integer>[] graph;
    static int count=0;
    static int[] visited;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        graph = new ArrayList[n+1];
        visited = new int[n+1];
        for (int i = 1; i <=n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i <m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            graph[u].add(v);
            graph[v].add(u);
        }
        for(int i=1; i<=n; i++){
            if(visited[i]==0){
                count++;
                dfs(i, count);
            }
        }
        System.out.println(count);
    }

    private static void dfs(int curr, int cnt) {
        visited[curr] = cnt;
        for (int next :graph[curr]){
            if(visited[next]==0)
                dfs(next, cnt);
        }
    }
}
