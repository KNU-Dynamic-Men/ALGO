package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * �ﰢ������ ��ġ�� �ڿ������� �ִ�.
 * �� ���� ���ڿ��� �����Ͽ� �� �Ʒ��� ���� �� ĭ�� ���������� �Ѵ�.
 * �� ��, ��� ����� ������ ���� ���� ū ��θ� ���ϴ� ����
 * @author Rave
 *
 */
public class Main {

	/**
	 * �ﰢ���� ������ ���� �����Ǿ� �ִ�.
	 * 6
	 * 1 2
	 * 3 7 4
	 * 9 4 1 7
	 * 2 7 5 9 4
	 * dp�� �̿��Ͽ� ���� ��ġ���� �ٷ� ���� ���� ���� ���� �� �� �� ū ���� ������ ���Ѵ�.
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
						// ���� ���� ���� ���� �� �� ū ���� ������ ���Ѵ�.
						dp[i][j] += Math.max(dp[i - 1][j], dp[i - 1][j - 1]);
					} catch (Exception e) {
						// j�� 0�̾ ������ �ʰ��ϴ� ��� �ٷ� ���� ���� �����ش�.
						dp[i][j] += dp[i - 1][j];
					}
				}
			int max = 0;
			// ���� ū ���� dp[n-1]���� ã�´�.
			for (int i = 0; i < n; i++)
				max = Math.max(max, dp[n - 1][i]);
			sb.append(max + "\n");
		}
		System.out.println(sb);
	}
}