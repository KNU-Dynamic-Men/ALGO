package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int[][] stat;
	static boolean[] check;
	static int answer = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		stat = new int[n][n];
		check = new boolean[n];
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++)
				stat[i][j] = Integer.parseInt(st.nextToken());
		}
		Search(0, 0);
		System.out.println(answer);
	}

	public static void Search(int selected, int selectedPeopleCnt) {
		if (selectedPeopleCnt > stat.length / 2 + 1)
			return;
		if (selected >= stat.length)
			return;
		if (selectedPeopleCnt > 0)
			CalcStat();
		check[selected] = true;
		Search(selected + 1, selectedPeopleCnt + 1);
		check[selected] = false;
		Search(selected + 1, selectedPeopleCnt);
	}

	public static void CalcStat() {
		int startStat = 0;
		int linkStat = 0;
		for (int i = 0; i < check.length; i++)
			for (int j = 0; j < check.length; j++) {
				if (check[i] && check[j])
					startStat += stat[i][j];
				else if (!check[i] && !check[j])
					linkStat += stat[i][j];
			}
		answer = Math.min(answer, Math.abs(startStat - linkStat));
	}
}