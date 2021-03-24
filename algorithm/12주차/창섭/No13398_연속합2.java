package codeBaekJoon._2021;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.StringTokenizer;

public class No13398_연속합2 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        int[][] dp = new int [n][2];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int idx =0;
        while(st.hasMoreTokens()){
            arr[idx++] = Integer.parseInt(st.nextToken());
        }
        dp[0][0] = arr[0];
        dp[0][1] = arr[0];
        int ans = arr[0];
        for(int i =1; i<n; i++){
            dp[i][0] = Math.max(dp[i-1][0]+arr[i], arr[i]);
            dp[i][1] = Math.max(dp[i-1][1]+arr[i], dp[i-1][0]);
            ans = Math.max(ans, Math.max(dp[i][0], dp[i][1]));
        }
        System.out.println(ans);
    }
}
