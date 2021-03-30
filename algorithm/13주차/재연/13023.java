package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {

	static RelationShip[] relationship;
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		relationship = new RelationShip[n];
		visited = new boolean[n];
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int friend_1 = Integer.parseInt(st.nextToken());
			int friend_2 = Integer.parseInt(st.nextToken());
			if (relationship[friend_1] == null)
				relationship[friend_1] = new RelationShip();
			if (relationship[friend_2] == null)
				relationship[friend_2] = new RelationShip();
			relationship[friend_1].add(friend_2);
			relationship[friend_2].add(friend_1);
		}
		for (int i = 0; i < n; i++) {
			visited[i] = true;
			if (BFS(i, 1)) {
				System.out.println(1);
				return;
			}
			visited[i] = false;
		}
		System.out.println(0);
	}

	public static boolean BFS(int next, int visitCnt) {
		if (visitCnt == 5)
			return true;
		LinkedList<Integer> check = relationship[next].friends;
		for (int nextFriend: check)
			if (!visited[nextFriend]) {
				visited[nextFriend] = true;
				if (BFS(nextFriend, visitCnt + 1))
					return true;
				visited[nextFriend] = false;
			}
		return false;
	}
}

class RelationShip {
	LinkedList<Integer> friends;

	public RelationShip() {
		friends = new LinkedList<Integer>();
	}

	public void add(int friend) {
		friends.add(friend);
	}
}