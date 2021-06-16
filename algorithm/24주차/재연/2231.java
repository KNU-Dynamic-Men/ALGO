package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * N과 N의 각 자릿수의 합을 분해합이라고 한다.
 * 어떤 자연수 M의 분해합이 N인 경우, M을 N의 생성자라고 한다.
 * 자연수 N이 주어졌을 때, N의 가장 작은 생성자를 구하는 문제
 * @author Rave
 *
 */
public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		// 1부터 완전 탐색을 통해 정답을 찾는다.
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