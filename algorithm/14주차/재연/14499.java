package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int[][] map;
	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { 1, -1, 0, 0 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		int t = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++)
				map[i][j] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		int[] dice = new int[6]; // 상 하 좌 우 앞 뒤
		for (int i = 0; i < t; i++) {
			int direction = Integer.parseInt(st.nextToken()) - 1;
			try {
				int value = map[x + dx[direction]][y + dy[direction]];
				dice = Move(dice, direction);
				x = x + dx[direction];
				y = y + dy[direction];
				if (value == 0)
					map[x][y] = dice[1];
				else {
					dice[1] = value;
					map[x][y] = 0;
				}
				sb.append(dice[0] + "\n");
			} catch (Exception e) {
			}
		}
		System.out.println(sb);
	}

	public static int[] Move(int[] dice, int direction) {
		switch (direction) {
		case 0:
			return new int[] { dice[2], dice[3], dice[1], dice[0], dice[4], dice[5] };
		case 1:
			return new int[] { dice[3], dice[2], dice[0], dice[1], dice[4], dice[5] };
		case 2:
			return new int[] { dice[5], dice[4], dice[2], dice[3], dice[0], dice[1] };
		case 3:
			return new int[] { dice[4], dice[5], dice[2], dice[3], dice[1], dice[0] };
		}
		return null;
	}
}