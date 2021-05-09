package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 2020 īī�� ���� ���� ����
 * �Ҹ��� �ڵ��� ���ַθ� �Ǽ��Ϸ��� �Ѵ�.
 * ���ַδ� (0, 0)���� (n-1, n-1)ĭ���� ���� ���ַ��̴�.
 * ���� ���δ� 100�� �����, �ڳʴ� 500�� ����� ���.
 * 0�� ����ִ� ĭ, 1�� ������ �̷���� board�� �־��� ��
 * ���� �Ǽ��� �ּ� ����� ���ϴ� ����
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
	 * �ڵ����� (0, 0)���� �����ʰ� �Ʒ� �������� �� �� �����Ƿ� 2���� ����Ʈ�� �߰��ϰ� �����Ѵ�.
	 * ���� dx, dy�� i��° �ε����� �ڵ����� ������ ���ٸ� ��������, �ٸ��ٸ� �ڳ��̴�.
	 * �̸� Ȱ���Ͽ� BFS Ž���� �õ��Ѵ�.
	 * �ڳ��� ���� �������κ��� ũ�Ƿ� Ž���� ������ �õ��غ���.
	 * @param board �ڵ��� ���ַ��� ���� ����
	 * @return ���ַθ� �Ǽ��ϴµ� ��� �ּ� ���
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
					// distance�� ���� �ƴ϶� cur�� cost���� �̿��ؾ� �Ѵ�. <- �� ������?
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