package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int answer = 0;
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int[] arr = new int[n];
		for (int i = 0; i < n; i++)
			arr[i] = Integer.parseInt(st.nextToken());
		HashMap<Integer, Integer> hash = new HashMap<>();
		int start = 0;
		int end = 0;
		boolean isEnd = true;
		while (start <= end && end < n) {
			if (isEnd)
				hash.put(arr[end], hash.getOrDefault(arr[end], 0) + 1);
			if (hash.get(arr[end]) > k) {
				hash.put(arr[start], hash.get(arr[start++]) - 1);
				isEnd = false;
			} else {
				answer = Math.max(answer, ++end - start);
				isEnd = true;
			}
		}
		System.out.println(answer);
	}
}