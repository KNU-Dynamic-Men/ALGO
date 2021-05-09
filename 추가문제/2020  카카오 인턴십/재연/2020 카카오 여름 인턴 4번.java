package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 2020 카카오 여름 인턴 문제
 * 죠르디가 자동차 경주로를 건설하려고 한다.
 * 경주로는 (0, 0)에서 (n-1, n-1)칸으로 가는 경주로이다.
 * 직선 도로는 100의 비용이, 코너는 500의 비용이 든다.
 * 0은 비어있는 칸, 1은 벽으로 이루어진 board가 주어질 때
 * 도로 건설의 최소 비용을 구하는 문제
 * @author Rave
 *
 */
public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Solution s = new Solution();
		int[][] board =  { { 0, 0, 0 }, { 0, 0, 0 }, { 0, 0, 0 } };
				// {{0,0,0,0,0,0,0,1},{0,0,0,0,0,0,0,0},{0,0,0,0,0,1,0,0},{0,0,0,0,1,0,0,0},{0,0,0,1,0,0,0,1},{0,0,1,0,0,0,1,0},{0,1,0,0,0,1,0,0},{1,0,0,0,0,0,0,0}};
				// {{0,0,1,0},{0,0,0,0},{0,1,0,1},{1,0,0,0}};
				//{ { 0, 0, 0, 0, 0, 0 }, { 0, 1, 1, 1, 1, 0 }, { 0, 0, 1, 0, 0, 0 }, { 1, 0, 0, 1, 0, 1 },
						//{ 0, 1, 0, 0, 0, 1 }, { 0, 0, 0, 0, 0, 0 } };
		System.out.println(s.solution(board));
	}
}

class Solution {
	int[][] distance;
	int[] dx = { 0, 1, 0, -1 };
	int[] dy = { 1, 0, -1, 0 };

	/**
	 * 자동차는 (0, 0)에서 오른쪽과 아래 방향으로 갈 수 있으므로 2개의 포인트를 추가하고 시작한다.
	 * 이후 dx, dy의 i번째 인덱스와 자동차의 방향이 같다면 직선도로, 다르다면 코너이다.
	 * 이를 활용하여 BFS 탐색을 시도한다.
	 * 코너의 값이 직선도로보다 크므로 탐색을 끝까지 시도해본다.
	 * @param board 자동차 경주로의 설계 도면
	 * @return 경주로를 건설하는데 드는 최소 비용
	 */
	public int solution(int[][] board) {
		int answer = Integer.MAX_VALUE;
		int n = board.length;
		distance = new int[n][n];
		Queue<Point> q = new LinkedList<>();
		q.add(new Point(0, 0, 0, 0));
		q.add(new Point(0, 0, 1, 0));
		while (!q.isEmpty()) {
			Point cur = q.poll();
			if (cur.x == n - 1 && cur.y == n - 1) {
				answer = Math.min(answer, cur.cost);
				continue;
			}
			for (int i = 0; i < 4; i++) {
				int nextX = cur.x + dx[i];
				int nextY = cur.y + dy[i];
				try {
					if (board[nextX][nextY] == 1)
						continue;
					// distance의 값이 아니라 cur의 cost값을 이용해야 한다. <- 왜 안햇지?
					int nextCost = cur.cost + 100;
					if (cur.direction != i)
						nextCost += 500;
					if (distance[nextX][nextY] == 0 || nextCost <= distance[nextX][nextY]) {
						distance[nextX][nextY] = nextCost;
						q.add(new Point(nextX, nextY, i, nextCost));
					}
				} catch (Exception e) {
				}
			}
		}
		return answer;
	}
}

class Point {
	int x, y, direction, cost;

	public Point(int _x, int _y, int _direction, int _cost) {
		this.x = _x;
		this.y = _y;
		this.direction = _direction;
		this.cost = _cost;
	}
}