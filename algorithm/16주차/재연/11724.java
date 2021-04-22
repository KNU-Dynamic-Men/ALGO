package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static boolean[][] map;
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		map = new boolean[n][n];
		visited = new boolean[n];
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int first = Integer.parseInt(st.nextToken()) - 1;
			int second = Integer.parseInt(st.nextToken()) - 1;
			map[first][second] = true;
			map[second][first] = true;
		}
		int answer = 0;
		for (int i = 0; i < n; i++)
			if (!visited[i]) {
				DFS(i);
				answer++;
			}
		System.out.println(answer);
	}

	public static void DFS(int next) {
		visited[next] = true;
		for (int i = 0; i < visited.length; i++)
			if (map[next][i] && !visited[i])
				DFS(i);
	}
}