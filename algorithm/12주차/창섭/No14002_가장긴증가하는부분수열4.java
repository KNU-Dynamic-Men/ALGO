package codeBaekJoon._2021;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class No14002_가장긴증가하는부분수열4 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        int[] dp = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int ans = 0;
        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
            int curr = 0;
            for(int j=0; j<i; j++){
                if(arr[i]>arr[j])
                    curr = Math.max(curr, dp[j]);
            }
            dp[i] = curr+1;
            ans = Math.max(ans, dp[i]);
        }
        System.out.println(ans);
        Stack<Integer> stack = new Stack<>();
        for(int i=n-1; i>=0; i--){
            if(ans==dp[i]){
                stack.push(arr[i]);
                ans--;
            }
        }
        while(!stack.isEmpty()){
            System.out.print(stack.pop()+" ");
        }
    }
}
