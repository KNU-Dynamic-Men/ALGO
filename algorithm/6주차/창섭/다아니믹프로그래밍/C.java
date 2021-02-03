package dp;

public class C {

	public static void main(String[] args) {
		int m =4; int n=3;
		int[][] puddles = {{1,3},{3,1}};
		System.out.println(solution(m, n, puddles));

	}
	
	public static int solution(int m, int n, int[][] puddles) {
        int dp[][] = new int[m+1][n+1];//m 열, n 행.
        for(int[] arr: puddles){ //열,행. 
        		int y = arr[0];
        		int x = arr[1];
    			dp[y][x] = -1;
        }	
        dp[0][1] = 1;
        for(int i=1; i<m; i++){
        		for(int j=1; j<n; j++){
        			if(dp[i][j]==-1){
        				dp[i][j]=0;
        			}
        			else{
        				dp[i][j] = (dp[i][j-1] + dp[i-1][j])%1000000007;
        			}
        		}
        }
        return dp[m][n];
    }

}
