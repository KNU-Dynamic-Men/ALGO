package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		int[] increaseLcs = new int[n];
		int[] reverseIncreaseLcs = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++)
			arr[i] = Integer.parseInt(st.nextToken());
		for (int i = 0; i < n; i++) {
			increaseLcs[i] = 1;
			for (int j = 0; j < i; j++)
				if (arr[i] > arr[j] && increaseLcs[j] + 1 > increaseLcs[i])
					increaseLcs[i] = increaseLcs[j] + 1;
		}
		for (int i = n - 1; i >= 0; i--) {
			reverseIncreaseLcs[i] = 1;
			for (int j = n - 1; j > i; j--)
				if (arr[i] > arr[j] && reverseIncreaseLcs[j] + 1 > reverseIncreaseLcs[i])
					reverseIncreaseLcs[i] = reverseIncreaseLcs[j] + 1;
		}
		int answer = 0;
		for (int i = 0; i < n; i++)
			answer = Math.max(answer, increaseLcs[i] + reverseIncreaseLcs[i] - 1);
		System.out.println(answer);
	}
}