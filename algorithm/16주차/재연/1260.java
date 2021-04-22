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
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int v = Integer.parseInt(st.nextToken());
		map = new boolean[n + 1][n + 1];
		visited = new boolean[n + 1];
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int first = Integer.parseInt(st.nextToken());
			int second = Integer.parseInt(st.nextToken());
			map[first][second] = true;
			map[second][first] = true;
		}
		DFS(v);
		sb.append("\n");
		visited = new boolean[n + 1];
		BFS(v);
		System.out.println(sb);
	}

	public static void DFS(int next) {
		visited[next] = true;
		sb.append(next + " ");
		for (int i = 1; i < visited.length; i++)
			if (map[next][i] && !visited[i])
				DFS(i);
	}

	public static void BFS(int start) {
		Queue<Integer> q = new LinkedList<>();
		q.add(start);
		visited[start] = true;
		while (!q.isEmpty()) {
			int cur = q.poll();
			sb.append(cur + " ");
			for (int i = 1; i < visited.length; i++)
				if (map[cur][i] && !visited[i]) {
					q.add(i);
					visited[i] = true;
				}
		}
	}
}