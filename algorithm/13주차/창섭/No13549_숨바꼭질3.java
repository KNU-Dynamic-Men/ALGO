/*
 * 문제 풀이 시작: 2021/03/26 11:19 오전
 * 맞은 시각: 2021/03/26 11:36 오전
 * 소요 시간: 19분 -> 숨바꼭질 2의 파생이라서 살짝 변형해서 풀어서 빠르게 맞춤.
 * @author ventulus95
 */
package codeBaekJoon._2021;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class No13549_숨바꼭질3 {

    static int n,k;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        boolean[] visit = new boolean[100001];
        int[] dist = new int[100001];
        Queue<Integer> q = new LinkedList<>();
        q.add(n);
        visit[n] = true;
        while(!q.isEmpty()){
            int curr = q.poll();
            for(int nxt: new int[]{curr - 1, curr + 1, curr * 2}){
                if(nxt<0 || nxt>100000) continue;
                if(nxt!=curr*2) {
                    if (!visit[nxt]) { //방문 하지 않았으면,
                        visit[nxt] = true; // 방문처리
                        dist[nxt] = dist[curr] + 1; //N부터 몇번만에 방문했는지 처리
                        q.add(nxt); // 큐에다 넣음.
                    } else if (dist[nxt] >= dist[curr] + 1) { //방문처리는 되있는데, 이게 더 최단거리인 경우\
                        dist[nxt] = dist[curr] + 1;
                    }
                }
                else{
                    if (!visit[nxt]) { //방문 하지 않았으면,
                        visit[nxt] = true; // 방문처리
                        dist[nxt] = dist[curr]; //N부터 몇번만에 방문했는지 처리
                        q.add(nxt); // 큐에다 넣음.
                    } else if (dist[nxt] > dist[curr]) { //방문처리는 되있는데, 이게 더 최단거리인 경우\
                        dist[nxt] = dist[curr];
                    }
                }
            }
        }
        System.out.println(dist[k]);

    }
}
