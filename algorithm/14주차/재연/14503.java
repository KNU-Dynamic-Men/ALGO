package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, 1, 0, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int direction = Integer.parseInt(st.nextToken());

		int[][] map = new int[n][m];
		boolean[][] isClean = new boolean[n][m];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++)
				map[i][j] = Integer.parseInt(st.nextToken());
		}

		int answer = 0;
		start: while (true) {
			isClean[r][c] = true;
			answer++;
			while (true) {
				for (int i = 0; i < 4; i++) {
					direction = direction - 1 < 0 ? direction + 3 : direction - 1;
					int nextX = r + dx[direction];
					int nextY = c + dy[direction];
					if (!isClean[nextX][nextY] && map[nextX][nextY] == 0) {
						r = nextX;
						c = nextY;
						continue start;
					}
				}
				int back = (direction + 2) % 4;
				r = r + dx[back];
				c = c + dy[back];
				if (map[r][c] == 1)
					break start;
			}
		}
		System.out.println(answer);
	}
}