package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 1���� 49������ ���� �߿��� 6���� ���� ���� ����� ��� ���ϴ� ����
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
	 * ��Ʈ��ŷ�� ���� 6���� ���ڸ� �����Ѵ�.
	 * ���ڵ��� ������ �Ǿ� �ֱ� ������ ���� �ε������� �� ���� ���⸸ �ϸ� �ȴ�.
	 * @param depth �� ������ ��
	 * @param next Ž���� ������ ���� �ε���
	 * @param result �� ���ڵ��� ������ ����
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