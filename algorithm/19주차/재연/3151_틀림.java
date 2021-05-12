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
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] arr = new int[n];
		for (int i = 0; i < n; i++)
			arr[i] = Integer.parseInt(st.nextToken());
		Arrays.sort(arr);
		long answer = 0;
		for (int i = 0; i < n; i++) {
			int first = arr[i];
			if (first > 0)
				break;
			int left = i + 1;
			int right = n - 1;
			while (left < right) {
				int sum = first + arr[left] + arr[right];
				if (sum > 0)
					right--;
				else if (sum < 0)
					left++;
				else {
					if (arr[left] == arr[right]) {
						answer += (right - left + 1) * (long) (right - left) / 2;
						break;
					} else {
						int leftCnt = 1;
						int prev = arr[left];
						while (prev == arr[++left])
							leftCnt++;
						int rightCnt = 1;
						prev = arr[right];
						while (prev == arr[--right])
							rightCnt++;
						answer += leftCnt * (long) rightCnt;
					}
				}
			}
		}
		System.out.println(answer);
	}
}