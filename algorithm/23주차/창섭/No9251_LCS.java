/*
 * 문제 풀이 시작: 2021/06/05 2:29 오후
 * 맞은 시각: 2021/06/05
 * 소요 시간:
 * @author ventulus95
 */
package codeBaekJoon._2021;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class No9251_LCS {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String A = br.readLine();
        String B = br.readLine();
        int[][] dp = new int[B.length()+1][A.length()+1];
        for (int i = 0; i <B.length(); i++) {
            for (int j = 0; j <A.length(); j++) {
                if(B.charAt(i)==A.charAt(j))
                    dp[i+1][j+1] = dp[i][j]+1;
                else
                    if(dp[i][j+1]>dp[i+1][j])
                        dp[i+1][j+1] = dp[i][j+1];
                    else
                        dp[i+1][j+1] = dp[i+1][j];
            }
        }
        for (int i = 0; i <B.length()+1; i++) {
            for (int j = 0; j <A.length()+1; j++) {
                System.out.print(dp[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println(dp[B.length()][A.length()]);
    }
}
