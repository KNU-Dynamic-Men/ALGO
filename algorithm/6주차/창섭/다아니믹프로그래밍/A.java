package dp;

import java.util.Arrays;

public class A {

	public static void main(String[] args) {
		int N = 2; int number=11;
		System.out.println(solution(N, number));

	}

	public static int solution(int N, int number) {
        int dp[] = new int[number+1];
        Arrays.fill(dp, 9999999);
        dp[1] = 2;
        StringBuilder sb = new StringBuilder();
        for(int i=1; i<5; i++){
        		sb.append(1);
        		int num = Integer.parseInt(sb.toString());
        		if(num*N<=number){
        			dp[num*N] = i;
        		}
        }
        for(int i=2; i<=number; i++){
        		for(int j=1; j<i/2; j++){
        			dp[i] = Math.min(dp[i], dp[i-j]+dp[j]);
        		}
        }
        return dp[number]<=8?dp[number]:-1;
    }
}
