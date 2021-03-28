/*
 * 문제 풀이 시작: 2021/03/28 8:51 오후
 * 맞은 시각: 2021/03/28 9:21 오후
 * 소요 시간: 30분
 * @author ventulus95
 */
package codeBaekJoon._2021;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class No1261_알고스팟 {

    static int n, m;
    static int[][] map, visit;
    static int[] dy = {1,-1,0,0};
    static int[] dx = {0,0,-1,1};

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[m][n];
        visit = new int[m][n];
        for (int i = 0; i <m; i++) {
            String temp = br.readLine();
            for (int j = 0; j <n; j++) {
                map[i][j] = temp.charAt(j)-'0';
            }
        }
        PriorityQueue<node> q = new PriorityQueue<>();
        q.add(new node(0, 0 ,0));
        int answer = 0;
        while(!q.isEmpty()){
            node curr = q.poll();
            int cy = curr.y;
            int cx = curr.x;
            if(cy==m-1&&cx==n-1){
                answer = curr.cnt;
                break;
            }
            for (int i = 0; i <4 ; i++) {
                int nx = cx+dx[i];
                int ny = cy+dy[i];
                if(ny<0 || ny>=m || nx<0 || nx>=n) continue;
                if(visit[ny][nx]>visit[cy][cx]+1 || visit[ny][nx]==0){
                    visit[ny][nx] = visit[cy][cx]+1;
                    if(map[ny][nx]==0){
                        q.add(new node(ny, nx, curr.cnt));
                    }
                    else{
                        q.add(new node(ny, nx, curr.cnt+1));
                    }
                }
            }
        }
        System.out.println(answer);
    }

    static class node implements Comparable<node>{
        int y,x,cnt; //벽 몇번만에 부셨는지 확인
        public node(int y, int x, int cnt){
            this.y = y;
            this.x = x;
            this.cnt = cnt;
        }

        @Override
        public int compareTo(node o) {
            return this.cnt-o.cnt;
        }

        @Override
        public String toString() {
            return "node{" +
                    "y=" + y +
                    ", x=" + x +
                    ", cnt=" + cnt +
                    '}';
        }
    }
}
