package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * �巡�� Ŀ�긦 �����Ͽ� �� �������� �巡�� Ŀ���� �Ϻ��� ���� ������ ���ϴ� ����
 * �巡�� Ŀ��� ���� ��, ���� ����, ������ ������ ������ �ִ�.
 * ���� ����� ���� ������ �� ���� �������� 90�� ȸ�� ��Ų ��, �װ��� �� ���� �̾� ���� ���̴�.
 * ���� ������ 0, 1, 2, 3 �� �ϳ��̸� ������ ����.
 * 0: x��ǥ�� �����ϴ� ����(������)
 * 1: y��ǥ�� �����ϴ� ����(��)
 * 2: x��ǥ�� �����ϴ� ����(����)
 * 3: y��ǥ�� �����ϴ� ����(�Ʒ�)
 * @author Rave
 *
 */
public class Main {

	static ArrayList<DragonCurve> dragonCurve = new ArrayList<DragonCurve>();;
	static int[] dx = { 1, 0, -1, 0 };
	static int[] dy = { 0, -1, 0, 1 };
	static boolean[][] map = new boolean[101][101];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		for (int i = 0; i < t; i++) {
			dragonCurve.clear();
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			int g = Integer.parseInt(st.nextToken());
			// ù �巡�� Ŀ�긦 �����Ͽ� ArrayList�� �ִ´�.
			DragonCurve start = new DragonCurve(x, y, x + dx[d], y + dy[d], d);
			dragonCurve.add(start);
			// ù �巡�� Ŀ���� �������� true�� ǥ���Ѵ�.
			map[x][y] = true;
			map[start.x2][start.y2] = true;
			// g�� 0�� ��� �����ϰ� �����ϹǷ� �޼ҵ带 �������� �ʵ��� �Ѵ�.
			if (g > 0)
				CreateDragonCurve(g);
		}
		int answer = 0;
		for (int i = 0; i < map.length - 1; i++)
			for (int j = 0; j < map[0].length - 1; j++)
				// �� �������� �巡�� Ŀ���� �Ϻ����� Ȯ���Ѵ�.
				if (map[i][j] && map[i + 1][j] && map[i][j + 1] && map[i + 1][j + 1])
					answer++;
		System.out.println(answer);
	}

	/**
	 * �巡�� Ŀ�긦 �����ϴ� �޼ҵ�
	 * ������ ��� ȣ���� ���Ͽ� 1������� g������� ���ʴ�� �����Ѵ�.
	 * @param generation ������ �巡�� Ŀ���� ����
	 */
	public static void CreateDragonCurve(int generation) {
		if (generation > 1)
			CreateDragonCurve(generation - 1);
		// �巡�� Ŀ���� ������ ���� ���� ���� �巡�� Ŀ�긦 �ٿ��ֱ� ���� ������ �巡�� Ŀ�긦 �����Ѵ�.
		DragonCurve last = dragonCurve.get(dragonCurve.size() - 1);
		for (int i = dragonCurve.size() - 1; i >= 0; i--) {
			// ���� �巡�� Ŀ���� ������ ���� �巡�� Ŀ���� ���� + 1�̴�.
			int nextD = (dragonCurve.get(i).d + 1) % 4;
			DragonCurve next = new DragonCurve(last.x2, last.y2, last.x2 + dx[nextD], last.y2 + dy[nextD], nextD);
			map[next.x2][next.y2] = true;
			dragonCurve.add(next);
			last = next;
		}
	}
}

class DragonCurve {
	int x, y, x2, y2, d;

	public DragonCurve(int _x, int _y, int _x2, int _y2, int _d) {
		this.x = _x;
		this.y = _y;
		this.x2 = _x2;
		this.y2 = _y2;
		this.d = _d;
	}

	public String toString() {
		return x + " " + y + " " + x2 + " " + y2 + " " + d;
	}
}