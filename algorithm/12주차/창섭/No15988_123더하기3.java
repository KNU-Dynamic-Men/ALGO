package codeBaekJoon._2021;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class No15988_123더하기3 {

    static final long MOD = 1000000009;
    static int n;
    static long[] dp;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        dp = new long[1000001];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;
        for(int i=4; i<=1000000; i++){
            dp[i] = (dp[i-1]+dp[i-2]+dp[i-3])%MOD;
        }
        while(n-->0){
            int k = Integer.parseInt(br.readLine());
            System.out.println(dp[k]%MOD);
        }
    }
}
