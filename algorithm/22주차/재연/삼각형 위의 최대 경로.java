package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 삼각형으로 배치된 자연수들이 있다.
 * 맨 위의 숫자에서 시작하여 맨 아래줄 까지 한 칸씩 내려가려고 한다.
 * 이 때, 모든 경로의 숫자의 합이 가장 큰 경로를 구하는 문제
 * @author Rave
 *
 */
public class Main {

	/**
	 * 삼각형은 다음과 같이 구성되어 있다.
	 * 6
	 * 1 2
	 * 3 7 4
	 * 9 4 1 7
	 * 2 7 5 9 4
	 * dp를 이용하여 현재 위치에서 바로 위의 값과 왼쪽 위의 값 중 더 큰 값을 가져와 더한다.
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		int testCase = Integer.parseInt(br.readLine());
		while (testCase-- > 0) {
			int n = Integer.parseInt(br.readLine());
			int[][] arr = new int[n][n];
			int[][] dp = new int[n][n];
			for (int i = 0; i < n; i++) {
				arr[i] = new int[i + 1];
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < i + 1; j++)
					arr[i][j] = Integer.parseInt(st.nextToken());
			}
			dp[0][0] = arr[0][0];
			for (int i = 1; i < n; i++)
				for (int j = 0; j < i + 1; j++) {
					dp[i][j] += arr[i][j];
					try {
						// 위의 값과 왼쪽 위의 값 중 큰 값을 가져와 더한다.
						dp[i][j] += Math.max(dp[i - 1][j], dp[i - 1][j - 1]);
					} catch (Exception e) {
						// j가 0이어서 범위를 초과하는 경우 바로 위의 값을 더해준다.
						dp[i][j] += dp[i - 1][j];
					}
				}
			int max = 0;
			// 가장 큰 값을 dp[n-1]에서 찾는다.
			for (int i = 0; i < n; i++)
				max = Math.max(max, dp[n - 1][i]);
			sb.append(max + "\n");
		}
		System.out.println(sb);
	}
}