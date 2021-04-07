/*
 * 문제 풀이 시작: 2021/03/31 10:19 오전
 * 맞은 시각: 2021/03/31 10:58 오전
 * 소요 시간: 39분
 * @author ventulus95
 */
package codeBaekJoon._2021;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No14499_주사위굴리기 {
    static int n,m,y,x,k;
    static int[][] map;
    static int[] dy ={0,0,-1,1};
    static int[] dx ={1,-1,0,0};
    static int[] garo = new int[4];
    static int[] sero = new int[4];

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        for (int i = 0; i <n ; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j <m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i <k; i++) {
            int dir = Integer.parseInt(st.nextToken())-1;
            int ny = y+dy[dir];
            int nx = x+dx[dir];
            if(ny<0 || ny>=n || nx<0 || nx>=m) continue;
            dice(dir);
            if(map[ny][nx]==0){
                if(dir<2){
                    map[ny][nx] = garo[3];
                }
                else{
                    map[ny][nx] = sero[3];
                }
            }
            else{
                if(dir<2){
                    garo[3] = map[ny][nx];
                }
                else{
                    sero[3] = map[ny][nx];
                }
                map[ny][nx] = 0;
            }
            x = nx;
            y = ny;
            sync(dir);
//            System.out.println("가로: "+ Arrays.toString(garo));
//            System.out.println("세로: "+ Arrays.toString(sero));
            System.out.println(garo[1]);
        }


    }

    private static void sync(int dir) {
        if(dir<2){
            sero[1] = garo[1];
            sero[3] = garo[3];
        }
        else{
            garo[1] = sero[1];
            garo[3] = sero[3];
        }
    }

    private static void dice(int dir) {
        if(dir==0){
            int swap = garo[3];
            for (int i =3; i>0 ; i--) {
                garo[i] = garo[i-1];
            }
            garo[0] = swap;
        }
        else if(dir==1){
            int swap = garo[0];
            for (int i = 0; i <3; i++) {
                garo[i] = garo[i+1];
            }
            garo[3] = swap;
        }
        else if(dir==2){
            int swap = sero[3];
            for (int i =3; i>0 ; i--) {
                sero[i] = sero[i-1];
            }
            sero[0] = swap;
        }
        else{
            int swap = sero[0];
            for (int i = 0; i <3; i++) {
                sero[i] = sero[i+1];
            }
            sero[3] = swap;
        }

    }
}
