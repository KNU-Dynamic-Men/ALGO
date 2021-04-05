/*
 * 문제 풀이 시작: 2021/04/05 1:41 오후
 * 맞은 시각: 2021/04/05 2:14 오후
 * 소요 시간: 33분
 * @author ventulus95
 */
package codeBaekJoon._2021;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No14503_로봇청소기 {

    static int n, m, cnt;
    static int[][] map;
    static int[] dx ={0,1,0,-1};
    static int[] dy ={-1,0,1,0};
    static boolean done = false;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine(), " ");
        int ry = Integer.parseInt(st.nextToken());
        int rx = Integer.parseInt(st.nextToken());
        int dir = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        for (int i = 0; i <n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j<m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        cleaner(ry, rx, dir);
        System.out.println(cnt);
    }

    private static void cleaner(int ry, int rx, int dir) {
        if(done)
            return;
        //현재 위치를 청소한다.
        map[ry][rx] = 2;
        cnt++;
        search(ry,rx,dir);
    }

    private static void search(int ry, int rx, int dir) {
        if(done)
            return;
        //현재 위치에서 현재 방향을 기준으로 왼쪽방향부터 차례대로 탐색을 진행한다.
        int ny=0, nx=0;
        for(int i=0; i<4; i++){
            //왼쪽 방향에 청소할 공간이 없다면, 그 방향으로 회전하고 2번으로 돌아간다.
            dir = dir-1<0?3:dir-1;
            ny = ry +dy[dir];
            nx = rx +dx[dir];
            if(ny>=n || ny<0 || nx>=m || nx<0) continue;
            //왼쪽 방향에 아직 청소하지 않은 공간이 존재한다면, 그 방향으로 회전한 다음 한 칸을 전진하고 1번부터 진행한다.
            if(map[ny][nx]==0){
                cleaner(ny, nx, dir);
            }
        }
        //네 방향 모두 청소가 이미 되어있거나 벽인 경우에는, 바라보는 방향을 유지한 채로 한 칸 후진을 하고 2번으로 돌아간다.
        int back = (dir+2)%4;
        int by = ry+dy[back];
        int bx = rx+dx[back];
        //네 방향 모두 청소가 이미 되어있거나 벽이면서, 뒤쪽 방향이 벽이라 후진도 할 수 없는 경우에는 작동을 멈춘다.
        if(map[by][bx]==1){
            done = true;
            return;
        }
        search(by, bx, dir);

    }

}
