package codeBaekJoon._2021;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No11054_가장긴바이토닉부분수열 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        int[] dp = new int[n];
        int[] dpd = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int ans = 0;
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        for (int i = 0; i < n; i++) {
            int curr = 0;
            int desc = 0;
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j])
                    curr = Math.max(curr, dp[j]);
                if(arr[n-i-1]>arr[n-j-1])
                    desc = Math.max(desc, dpd[n-1-j]);
            }
            dp[i] = curr + 1;
            dpd[n-i-1] = desc+1;
        }
//        for (int i = n-1; i >=0; i--) {
//            int curr = 0;
//            for (int j = n-1; j > i; j--) {
//                if (arr[i] > arr[j])
//                    curr = Math.max(curr, dpd[j]);
//            }
//            dpd[i] = curr + 1;
//        }
        for (int i = 0; i <n ; i++) {
            ans = Math.max(dp[i]+dpd[i], ans);
        }
        System.out.println(ans-1);
    }
}
