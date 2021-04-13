/*
 * 문제 풀이 시작: 2021/04/08 8:21 오후
 * 맞은 시각: 2021/04/08 8:35 오후
 * 소요 시간: 14분
 * @author ventulus95
 */
package codeBaekJoon._2021;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No16931_겉넓이구하기 {

    static int map[][];
    static int cnt =0;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        cnt+=n*m*2;
        map = new int[n][m];
        for (int i = 0; i <n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j <m; j++) {
                map[i][j]=Integer.parseInt(st.nextToken());
            }
        }
        for (int i = 0; i <n; i++) {
            int idx = 0;
            for (int j = 0; j <m; j++) {
                if (idx==0){
                    cnt+=map[i][j];
                }
                else{
                    if(map[i][j]>idx)
                        cnt+=map[i][j]-idx;
                }
                idx=map[i][j];
            }
            idx = 0;
            for (int j = m-1; j>=0; j--) {
                if (idx==0){
                    cnt+=map[i][j];
                }
                else{
                    if(map[i][j]>idx)
                        cnt+=map[i][j]-idx;
                }
                idx=map[i][j];
            }
        }
        for (int j = 0; j <m; j++) {
            int idx = 0;
            for (int i = 0; i <n; i++) {
                if (idx==0){
                    cnt+=map[i][j];
                }
                else{
                    if(map[i][j]>idx)
                        cnt+=map[i][j]-idx;
                }
                idx=map[i][j];
            }
            idx = 0;
            for (int i = n-1; i>=0; i--) {
                if (idx==0){
                    cnt+=map[i][j];
                }
                else{
                    if(map[i][j]>idx)
                        cnt+=map[i][j]-idx;
                }
                idx=map[i][j];
            }
        }
        System.out.println(cnt);
    }
}
