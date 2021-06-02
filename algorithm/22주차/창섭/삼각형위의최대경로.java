/*
 * 문제 풀이 시작: 2021/05/28 5:36 오후
 * 맞은 시각: 2021/05/28
 * 소요 시간:
 * @author ventulus95
 */
package codeBaekJoon._2021;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 삼각형위의최대경로 {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());
        while(t-->0){
            int n  =Integer.parseInt(br.readLine());
            int[][] map = new int[n][];
            int[][] cache = new int[n][];
            for (int i = 0; i <n; i++) {
                st = new StringTokenizer(br.readLine());
                map[i] = new int[i+1];
                cache[i] = new int[i+1];
                for (int j = 0; j <i+1; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                    cache[i][j] =-1;
                }
            }
            cache[0][0] = map[0][0];
            cache[1][0] = cache[0][0]+map[1][0];
            cache[1][1] = cache[0][0]+map[1][1];
            for (int i = 1; i <n-1; i++) {
                for (int j = 0; j <i+1; j++) {
                    if(cache[i+1][j]<cache[i][j]+map[i+1][j]){
                        cache[i+1][j]= cache[i][j]+map[i+1][j];
                    }
                    if(cache[i+1][j+1]<cache[i][j]+map[i+1][j+1]) {
                        cache[i + 1][j + 1] = cache[i][j]+map[i+1][j+1];
                    }
                }
            }
            int max = 0;
            for (int i = 0; i <n; i++) {
                max = Math.max(max, cache[n-1][i]);
            }
            System.out.println(max);
        }
    }
}
