package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * 드래곤 커브를 생성하여 네 꼭짓점이 드래곤 커브의 일부인 것의 개수를 구하는 문제
 * 드래곤 커브는 시작 점, 시작 방향, 세대의 정보를 가지고 있다.
 * 다음 세대는 이전 세대의 끝 점을 기준으로 90도 회전 시킨 후, 그것을 끝 점에 이어 붙인 것이다.
 * 시작 방향은 0, 1, 2, 3 중 하나이며 다음과 같다.
 * 0: x좌표가 증가하는 방향(오른쪽)
 * 1: y좌표가 감소하는 방향(위)
 * 2: x좌표가 감소하는 방향(왼쪽)
 * 3: y좌표가 증가하는 방향(아래)
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
			// 첫 드래곤 커브를 생성하여 ArrayList에 넣는다.
			DragonCurve start = new DragonCurve(x, y, x + dx[d], y + dy[d], d);
			dragonCurve.add(start);
			// 첫 드래곤 커브의 꼭짓점을 true로 표시한다.
			map[x][y] = true;
			map[start.x2][start.y2] = true;
			// g가 0인 경우 생성하고 종료하므로 메소드를 실행하지 않도록 한다.
			if (g > 0)
				CreateDragonCurve(g);
		}
		int answer = 0;
		for (int i = 0; i < map.length - 1; i++)
			for (int j = 0; j < map[0].length - 1; j++)
				// 네 꼭짓점이 드래곤 커브의 일부인지 확인한다.
				if (map[i][j] && map[i + 1][j] && map[i][j + 1] && map[i + 1][j + 1])
					answer++;
		System.out.println(answer);
	}

	/**
	 * 드래곤 커브를 생성하는 메소드
	 * 생성은 재귀 호출을 통하여 1세대부터 g세대까지 차례대로 생성한다.
	 * @param generation 생성할 드래곤 커브의 세대
	 */
	public static void CreateDragonCurve(int generation) {
		if (generation > 1)
			CreateDragonCurve(generation - 1);
		// 드래곤 커브의 마지막 점에 새로 만든 드래곤 커브를 붙여주기 위해 마지막 드래곤 커브를 저장한다.
		DragonCurve last = dragonCurve.get(dragonCurve.size() - 1);
		for (int i = dragonCurve.size() - 1; i >= 0; i--) {
			// 다음 드래곤 커브의 방향은 이전 드래곤 커브의 방향 + 1이다.
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