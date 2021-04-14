/*
 * 문제 풀이 시작: 2021/04/14 6:27 오후
 * 맞은 시각: 2021/04/14
 * 소요 시간:
 * @author ventulus95
 */
package codeBaekJoon._2021;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class No1043_거짓말 {

    static int ans=0;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] lier = new int[n+1];
        st = new StringTokenizer(br.readLine(), " ");
        int trueN = Integer.parseInt(st.nextToken());
        while(trueN-->0){
            lier[Integer.parseInt(st.nextToken())] = 1;
        }
        int[][] starr = new int[m][];
        for (int i = 0; i <m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int party = Integer.parseInt(st.nextToken());
            starr[i] = new int[party];
            for (int j = 0; j <party; j++) {
                starr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int a = 0; a <m; a++) {
            int party = starr[a].length;
            boolean checker = true;
            boolean first = false;
            for (int j = 0; j <party; j++) {
                if(lier[starr[a][j]]==1) {
                    checker = false;
                }
                if(lier[starr[a][j]]==0)
                    first = true;
            }
            if(!checker&&first) {
                for (int j = 0; j < party; j++) {
                    lier[starr[a][j]] = 1;
                }
                a = -1;
            }
        }
        for (int i = 0; i <m; i++) {
            int party = starr[i].length;
            boolean checker = true;
            for (int j = 0; j <party; j++) {
                if(lier[starr[i][j]]==1){
                    checker = false;
                    break;
                }
            }
            if(checker)
                ans++;
        }
        System.out.println(Arrays.toString(lier));
        System.out.println(ans);
    }
}
