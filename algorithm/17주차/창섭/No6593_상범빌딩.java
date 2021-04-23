/*
 * 문제 풀이 시작: 2021/04/17 5:23 오후
 * 맞은 시각: 2021/04/17
 * 소요 시간:
 * @author ventulus95
 */
package codeBaekJoon._2021;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class No6593_상범빌딩 {

    static int L,R,C;
    static char[][][] map; //층,행,열
    static int[][][] visit;
    static int[] dx = {0, 0,0,0,1,-1};
    static int[] dy = {0, 0,1,-1,0,0};
    static int[] dz = {1,-1,0,0, 0, 0};
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        while(L!=0&&R!=0&&C!=0){
            map = new char[L][R][C];
            visit = new int[L][R][C];
            int sx=0, sy=0, sl=0, ex=0, ey=0, el=0;
            for (int i = 0; i <L; i++) {
                for (int j = 0; j <R; j++) {
                    String row = br.readLine();
                    for (int k = 0; k <C; k++) {
                        map[i][j][k] = row.charAt(k);
                        if(map[i][j][k]=='S'){
                            sl = i;
                            sy = j;
                            sx = k;
                        }
                        if(map[i][j][k]=='E'){
                            el = i;
                            ey = j;
                            ex = k;
                        }
                    }
                }
                br.readLine();
            }
            bfs(sl, sy, sx);
            System.out.println(visit[el][ey][ex]==0?"Trapped!":"Escaped in "+visit[el][ey][ex]+" minute(s).");
            st = new StringTokenizer(br.readLine(), " ");
            L = Integer.parseInt(st.nextToken());
            R = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());
        }
    }

    private static void bfs(int sl, int sy, int sx) {
        Queue<node> q = new LinkedList<>();
        q.add(new node(sl, sy, sx));
        while (!q.isEmpty()){
            node curr = q.poll();
            int cz = curr.z;
            int cy = curr.y;
            int cx = curr.x;
            for (int i = 0; i <6; i++) {
                int nz= cz+dz[i];
                int ny= cy+dy[i];
                int nx= cx+dx[i];
                if(nz<0 || nz>=L || ny<0 || ny>=R || nx<0 || nx>=C) continue;
                if(nz==sl&&ny==sy&&nx==sx) continue;
                if((map[nz][ny][nx]=='.'||map[nz][ny][nx]=='E')&&visit[nz][ny][nx]==0){
                    q.add(new node(nz,ny,nx));
                    visit[nz][ny][nx] = visit[cz][cy][cx]+1;
                }
            }
        }
    }

    static class node{
        int z, y, x;
        public node(int z, int y, int x){
            this.z = z;
            this.y = y;
            this.x = x;
        }

        @Override
        public String toString() {
            return "node{" +
                    "z=" + z +
                    ", y=" + y +
                    ", x=" + x +
                    '}';
        }
    }
}
