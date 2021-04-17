/*
 * 문제 풀이 시작: 2021/04/14 3:47 오후
 * 맞은 시각: 2021/04/14 3:57 오후
 * 소요 시간: 10분
 * @author ventulus95
 */
package codeBaekJoon._2021;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class No5567_결혼식 {

    static ArrayList<Integer>[] graph;
    static int[] friend;

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
        friend = new int[n+1];
        bfs(1);
        int cnt =0;
        for (int i = 2; i <=n; i++) {
            if(friend[i]>=1&&friend[i]<3){
                cnt++;
            }
        }
        System.out.println(cnt);
    }

    private static void bfs(int i) {
        Queue<Integer> q = new LinkedList<>();
        q.add(i);
        while(!q.isEmpty()){
            int curr = q.poll();
            for (int nxt: graph[curr]){
                if(friend[nxt]==0){
                    q.add(nxt);
                    friend[nxt] = friend[curr]+1;
                }

            }
        }
    }
}
