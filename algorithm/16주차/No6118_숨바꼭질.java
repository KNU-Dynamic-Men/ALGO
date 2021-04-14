/*
 * 문제 풀이 시작: 2021/04/14 4:01 오후
 * 맞은 시각: 2021/04/14 4:10 오후
 * 소요 시간: 9분
 * @author ventulus95
 */
package codeBaekJoon._2021;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class No6118_숨바꼭질 {

    static ArrayList<Integer>[] graph;
    static int[] visited;
    static int max=Integer.MIN_VALUE;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
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
        visited = new int[n+1];
        bfs(1);
        int cnt =0;
        for(int i=1; i<=n; i++){
            if(visited[i]==max){
                if(cnt==0)
                    System.out.print(i+" ");
                cnt++;
            }
        }
        System.out.println(max+" "+cnt);
    }

    private static void bfs(int i) {
        Queue<Integer> q = new LinkedList<>();
        q.add(i);
        while (!q.isEmpty()){
            int curr = q.poll();
            max = Math.max(max, visited[curr]);
            for(int nxt: graph[curr]){
                if(visited[nxt]==0&&nxt!=i){
                    q.add(nxt);
                    visited[nxt] = visited[curr]+1;
                }
            }
        }
    }
}
