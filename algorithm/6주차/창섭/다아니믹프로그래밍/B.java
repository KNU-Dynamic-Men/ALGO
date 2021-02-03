/** 2021. 2. 1. 오전 11:27:14
 * @author ventulus95
 */
package dp;

public class B {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static int solution(int[][] triangle) {
        int answer = 0;
        int dp[][] = new int[triangle.length][];
        for(int i=0; i<triangle.length-1; i++){
        		int leng = triangle[i].length;
        		dp[i] = new int[leng];
        }
        dp[0][0] = triangle[0][0];
        dp[1][0] = dp[0][0] + triangle[1][0];
        dp[1][1] = dp[0][0] + triangle[1][1];
        for(int i=2; i<triangle.length-1; i++){
        		dp[i][0] = dp[i-1][0]+triangle[i][0];
        		dp[i][i] = dp[i-1][i-1] + triangle[i][i];
        		for(int j=1; j<i; j++){
        			dp[i][j] = Math.max(dp[i-1][j-1], dp[i-1][j])+triangle[i][j];
        		}
        }
        for(int temp: dp[triangle.length]){
        		answer = Math.max(answer, temp);
        }
        return answer;
    }

}
