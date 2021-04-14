package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static boolean[][] computers;
	static boolean[] visited;
	static int answer = -1;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int pc = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		computers = new boolean[pc + 1][pc + 1];
		visited = new boolean[pc + 1];
		for (int i = 0; i < m; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int first = Integer.parseInt(st.nextToken());
			int second = Integer.parseInt(st.nextToken());
			computers[first][second] = true;
			computers[second][first] = true;
		}
		DFS(1);
		System.out.println(answer);
	}

	public static void DFS(int next) {
		visited[next] = true;
		answer++;
		for (int i = 2; i < computers.length; i++)
			if (computers[next][i] && !visited[i])
				DFS(i);
	}
}