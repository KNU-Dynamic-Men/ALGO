/*
 * 문제 풀이 시작: 2021/04/09 9:00 오후
 * 맞은 시각: 2021/04/09 9:42
 * 소요 시간:
 * @author ventulus95
 */
package codeBaekJoon._2021;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;


public class No15685_드래곤커브 {

    static int[] dx ={1,0,-1,0};
    static int[] dy ={0,-1,0,1};
    static int[][] map;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        map = new int[101][101];
        for (int i = 0; i<n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int g = Integer.parseInt(st.nextToken());
            ArrayList<int[]> dragon = new ArrayList<>();
            dragon.add(new int[]{d});
            int idx =0;
            while(g-->0){
                int[] prev = dragon.get(idx);
                int[] curr = new int[prev.length*2];
                for(int a=prev.length-1; a>=0; a--){
                    curr[a] = prev[a];
                    curr[curr.length-1-a] = prev[a]+1>3?0:prev[a]+1;
                }
                dragon.add(curr);
                idx++;
            }
            curve(x,y,dragon.get(idx));
        }
        int cnt =0;
        for (int i = 0; i <100; i++) {
            for (int j = 0; j <100; j++) {
                if(map[i][j]==1&&map[i+1][j]==1&&map[i][j+1]==1&&map[i+1][j+1]==1)
                    cnt++;
            }
        }
        System.out.println(cnt);



    }

    private static void curve(int x, int y, int[] ints) {
        for (int dir: ints) {
            int nx = x+dx[dir];
            int ny = y+dy[dir];
            map[y][x] = 1;
            map[ny][nx] = 1;
            x = nx; y=ny;
        }
    }

}
