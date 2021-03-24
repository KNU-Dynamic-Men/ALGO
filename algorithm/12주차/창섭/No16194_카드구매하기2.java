package codeBaekJoon._2021;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No16194_카드구매하기2 {

    static int[] dp;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        dp = new int[n+1];
        int[] card = new int[n+1];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i=1; i<=n; i++){
            card[i] = Integer.parseInt(st.nextToken());
            dp[i] = card[i];
        }
        for(int i=2; i<=n; i++){
            for(int j=1; j<i; j++){
                dp[i] = Math.min(dp[i], dp[i-j]+card[j]);
            }
        }
        System.out.println(dp[n]);
    }
}
