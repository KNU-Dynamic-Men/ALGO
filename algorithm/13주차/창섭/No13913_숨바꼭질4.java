/*
 * 문제 풀이 시작: 2021/03/26 11:37 오전
 * 맞은 시각: 2021/03/26 12:17 오후
 * 소요 시간: 40분
 * @author ventulus95
 */
package codeBaekJoon._2021;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class No13913_숨바꼭질4 {

    static Stack<Integer> stack = new Stack<>();
    static StringBuilder sb = new StringBuilder();
    static boolean[] visit;
    static int[] dist;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        visit = new boolean[100001];
        dist = new int[100001];
        Queue<Integer> q = new LinkedList<>();
        q.add(n);
        visit[n] = true;
        while(!q.isEmpty()){
            int curr = q.poll();
            for(int nxt: new int[]{curr - 1, curr + 1, curr * 2}){
                if(nxt<0 || nxt>100000) continue;
                if(!visit[nxt]) { //방문 하지 않았으면,
                    visit[nxt] = true; // 방문처리
                    dist[nxt] = dist[curr] + 1; //N부터 몇번만에 방문했는지 처리
                    q.add(nxt); // 큐에다 넣음.
                }
                else if(dist[nxt]==dist[curr]+1){ //방문처리는 되있는데, 이게 더 최단거리인 경우
                    dist[nxt] = dist[curr] + 1; //N부터 몇번만에 방문했는지 처리
                }
            }
        }
        System.out.println(dist[k]);
        dfs(n, k,dist[k]);
        System.out.println(sb.toString());
    }

    private static void dfs(int n, int k, int deep) {
        stack.push(k);
        if(n==k){
            if(sb.length()==0){
                while(!stack.isEmpty()){
                    sb.append(stack.pop()+" ");
                }
            }
            return;
        }
        if(k-1>=0 &&dist[k-1]==deep-1){
            dfs(n, k-1, deep-1);
        }
        if(k+1<=100000&&dist[k+1]==deep-1){
            dfs(n, k+1, deep-1);
        }
        if(dist[k/2]==deep-1){
            dfs(n, k/2, deep-1);
        }


    }
}
