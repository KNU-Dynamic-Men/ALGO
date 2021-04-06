package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int[][] map;
	static int[][] rotateMap;
	static int answer = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int l = Integer.parseInt(st.nextToken());
		map = new int[n][n];
		rotateMap = new int[n][n];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				rotateMap[j][i] = map[i][j];
			}
		}
		for (int i = 0; i < n; i++) {
			findRoad(map[i], l);
			findRoad(rotateMap[i], l);
		}
		System.out.println(answer);
	}

	public static void findRoad(int[] map, int length) {
		int prev = map[0];
		int count = 1;
		for (int i = 1; i < map.length; prev = map[i], i++) {
			if (prev == map[i]) {
				count++;
				continue;
			}
			if (Math.abs(prev - map[i]) != 1)
				return;
			if (prev > map[i]) {
				if (count < 0)
					return;
				count = 1 - length;
			} else {
				if (count - length < 0)
					return;
				count = 1;
			}
		}
		if (count >= 0)
			answer++;
	}
}