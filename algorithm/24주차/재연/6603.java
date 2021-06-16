package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 1부터 49까지의 숫자 중에서 6개의 수를 고르는 방법을 모두 구하는 문제
 * @author Rave
 */
public class Main {

	static StringBuffer sb = new StringBuffer();
	static int[] arr;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = "";
		while ((line = br.readLine()) != null) {
			StringTokenizer st = new StringTokenizer(line);
			int n = Integer.parseInt(st.nextToken());
			arr = new int[n];
			for (int i = 0; i < n; i++)
				arr[i] = Integer.parseInt(st.nextToken());
			Arrays.sort(arr);
			BackTracking(0, 0, "");
			sb.append("\n");
		}
		System.out.println(sb);
	}
	
	/**
	 * 백트래킹을 통해 6개의 숫자를 선택한다.
	 * 숫자들은 정렬이 되어 있기 때문에 다음 인덱스에서 한 개씩 고르기만 하면 된다.
	 * @param depth 고른 숫자의 수
	 * @param next 탐색을 시작할 다음 인덱스
	 * @param result 고른 숫자들을 저장할 변수
	 */
	public static void BackTracking(int depth, int next, String result) {
		if (depth == 6) {
			sb.append(result + "\n");
			return;
		}
		for (int i = next; i < arr.length; i++)
			BackTracking(depth + 1, i + 1, result + arr[i] + " ");
	}
}