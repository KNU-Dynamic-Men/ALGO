package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Solution s = new Solution();
		 int[][] board = 
				 //{{0,0,0},{0,0,0},{0,0,0}};
		 //{{0,0,0,0,0,0,0,1},{0,0,0,0,0,0,0,0},{0,0,0,0,0,1,0,0},{0,0,0,0,1,0,0,0},{0,0,0,1,0,0,0,1},{0,0,1,0,0,0,1,0},{0,1,0,0,0,1,0,0},{1,0,0,0,0,0,0,0}};
		 //{{0,0,1,0},{0,0,0,0},{0,1,0,1},{1,0,0,0}};
		 {{0,0,0,0,0,0},{0,1,1,1,1,0},{0,0,1,0,0,0},{1,0,0,1,0,1},{0,1,0,0,0,1},{0,0,0,0,0,0}};
		 System.out.println(s.solution(board));
	}
}

class Solution {
	int[][] visited;
	int[] dx = { 0, 1, 0, -1 };
	int[] dy = { 1, 0, -1, 0 };

	public int solution(int[][] board) {
		int n = board.length;
		visited = new int[n][n];
		Queue<Point> q = new LinkedList<>();
		q.add(new Point(0, 0, 0));
		q.add(new Point(0, 0, 1));
		while (!q.isEmpty()) {
			Point cur = q.poll();
			if (cur.x == n - 1 && cur.y == n - 1)
				continue;
			for (int i = 0; i < 4; i++) {
				int nextX = cur.x + dx[i];
				int nextY = cur.y + dy[i];
				try {
					if (board[nextX][nextY] == 1)
						continue;
					int nextCost = visited[cur.x][cur.y] + 100;
					if (cur.direction != i)
						nextCost += 500;
					if (visited[nextX][nextY] == 0 || nextCost <= visited[nextX][nextY]) {
						visited[nextX][nextY] = nextCost;
						;
						q.add(new Point(nextX, nextY, i));
					}
				} catch (Exception e) {
				}
			}
		}
		return visited[n - 1][n - 1];
	}
}

class Point {
	int x, y, direction;

	public Point(int _x, int _y, int _direction) {
		this.x = _x;
		this.y = _y;
		this.direction = _direction;
	}

	public String toString() {
		return x + " " + y + " " + direction;
	}
}