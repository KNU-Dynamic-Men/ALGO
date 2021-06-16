package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * N�� N�� �� �ڸ����� ���� �������̶�� �Ѵ�.
 * � �ڿ��� M�� �������� N�� ���, M�� N�� �����ڶ�� �Ѵ�.
 * �ڿ��� N�� �־����� ��, N�� ���� ���� �����ڸ� ���ϴ� ����
 * @author Rave
 *
 */
public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		// 1���� ���� Ž���� ���� ������ ã�´�.
		for (int i = 1; i <= n; i++) {
			String str = Integer.toString(i);
			int sum = i;
			for (int j = 0; j < str.length(); j++)
				sum += str.charAt(j) - '0';
			if (sum == n) {
				System.out.println(i);
				return;
			}
		}
		System.out.println(0);
	}
}