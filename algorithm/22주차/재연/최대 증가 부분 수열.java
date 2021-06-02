package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * N개의 수로 이루어진 수열이 주어진다.
 * 이 수열의 부분 수열 중 이전 수보다 큰 수로 이루어진 증가하는 부분 수열의 최대 길이를 출력하는 문제
 * @author Rave
 *
 */
public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		int testCase = Integer.parseInt(br.readLine());
		while (testCase-- > 0) {
			int n = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			int[] arr = new int[n];
			for (int i = 0; i < n; i++)
				arr[i] = Integer.parseInt(st.nextToken());
			int[] dp = new int[n];
			int answer = 0;
			for (int i = 0; i < n; i++) {
				dp[i] = 1;
				for (int j = 0; j < i; j++)
					if (arr[i] > arr[j]) {
						dp[i] = Math.max(dp[i], dp[j] + 1);
						answer = Math.max(answer, dp[i]);
					}
			}
			sb.append(answer + "\n");
		}
		System.out.println(sb);
	}
}