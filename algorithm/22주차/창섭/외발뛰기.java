/*
 * 문제 풀이 시작: 2021/05/28 4:05 오후
 * 맞은 시각: 2021/05/28
 * 소요 시간:
 * @author ventulus95
 */
package codeBaekJoon._2021;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 외발뛰기 {

    static int n;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        while(T-->0){
            n = Integer.parseInt(br.readLine());
            int[][] map = new int[n][n];
            int[][] cache = new int[n][n];
            for (int i = 0; i <n; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j <n; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                    cache[i][j] = -1;
                }
            }
            cache[0][0] = 0;
            jump(0,0, map,cache);
//            System.out.println("###################");
//            for (int[] arr: cache){
//                for(int a: arr){
//                    System.out.print(a+" ");
//                }
//                System.out.println();
//            }
            System.out.println(cache[n-1][n-1]==-1?"NO":"YES");

        }


    }

    private static void jump(int y, int x, int[][] map,int[][] cache) {
        if(y==n-1 && x==n-1) return;
        int cnt = map[y][x];
        if(y+cnt<n && cache[y + cnt][x] ==-1) {
            cache[y + cnt][x] = cache[y][x] + 1;
            jump(y + cnt, x, map, cache);
        }
        if(x+cnt<n && cache[y][x + cnt] ==-1 ) {
            cache[y][x + cnt] = cache[y][x] + 1;
            jump(y, x + cnt, map, cache);
        }
    }
}
