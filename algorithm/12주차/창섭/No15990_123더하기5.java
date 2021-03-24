package codeBaekJoon._2021;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class No15990_123더하기5 {
    static final long MOD = 1000000009;
    static int n;
    static long[][] dp;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        dp = new long[100001][4];
        dp[1][1] = 1;
        dp[2][2] = 1;
        Arrays.fill(dp[3], 1);
        for(int i=4; i<=100000; i++){
            dp[i][1] = dp[i-1][2]%MOD + dp[i-1][3]%MOD;
            dp[i][2] = dp[i-2][1]%MOD + dp[i-2][3]%MOD;
            dp[i][3] = dp[i-3][1]%MOD + dp[i-3][2]%MOD;
        }
        while(n-->0){
            int k = Integer.parseInt(br.readLine());
            System.out.println((dp[k][1]+dp[k][2]+dp[k][3])%MOD);
        }

    }
}
