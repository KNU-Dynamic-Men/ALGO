/*
 * 문제 풀이 시작: 2021/04/17 5:13 오후
 * 맞은 시각: 2021/04/17
 * 소요 시간:
 * @author ventulus95
 */
package codeBaekJoon._2021;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class No1600_말이되고픈원숭이 {

    static int n, m,k;
    static int[][] map;
    static int[][][] visit;
    static int[] dx = {1,2,2,1,-1,-2,-2,-1,0,0,-1,1};
    static int[] dy = {2,1,-1,-2,-2,-1,1,2,1,-1,0,0};


    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        k = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[m][n];
        visit = new int[m][n][k+1];
        for (int i = 0; i <m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j <n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(i==0&&j==0) continue;
                Arrays.fill(visit[i][j], -1);
            }
        }
        Queue<node> q = new LinkedList<>();
        q.add(new node(0, 0 ,k));
        boolean flag = true;
        while(!q.isEmpty()){
            if(!flag)
                break;
            node curr = q.poll();
            int cy = curr.y;
            int cx = curr.x;
            int ccnt = curr.cnt;
            for (int i = 0; i <12; i++) {
                int nx = cx+dx[i];
                int ny = cy+dy[i];
                if(ny<0 || ny>=m || nx<0 || nx>=n) continue;
                if(map[ny][nx]==0){
                    if(i>=8) { //인접행 가는 경우
                        if(visit[ny][nx][ccnt]==-1) {
                            if(nx==m-1&&ny==n-1)
                                flag = false;
                            visit[ny][nx][ccnt] = visit[cy][cx][ccnt]+1;
                            q.add(new node(ny, nx, curr.cnt));
                        }
                    }
                    else{ //말을 이용하는 경우
                        if(ccnt>0)
                            if(visit[ny][nx][ccnt-1]==-1) {
                                if(nx==m-1&&ny==n-1)
                                    flag = false;
                                visit[ny][nx][ccnt-1] = visit[cy][cx][ccnt]+1;
                                q.add(new node(ny, nx, curr.cnt-1));
                            }
                    }
                }
            }
        }
        int min = Integer.MAX_VALUE;
        for (int check:visit[m-1][n-1]) {
            if (check>=0)
                min = Math.min(check, min);
        }
        System.out.println(min<Integer.MAX_VALUE?min:-1);
    }

    static class node{
        int y,x,cnt; //말로 움직일수 있는 번수.
        public node(int y, int x, int cnt){
            this.y = y;
            this.x = x;
            this.cnt = cnt;
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
