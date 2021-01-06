package codeBaekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No14503_robotCleaner {
	
	static int n,m,rx,ry,dir,cnt=0; 
	static int dx[] = {0,1,0,-1}; //북동남서
	static int dy[] = {1,0,-1,0};
	static int map[][];
	static boolean clean[][];
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		clean = new boolean[n][m];
		st = new StringTokenizer(br.readLine(), " ");
		ry = Integer.parseInt(st.nextToken());
		rx = Integer.parseInt(st.nextToken());
		dir = Integer.parseInt(st.nextToken());
		for(int i=0; i<n ;i++){
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<m ; j++){
				map[i][j] = Integer.parseInt(st.nextToken());
				clean[i][j] = true;
			}
		}
		robot(ry, rx, dir);
		System.out.println(cnt);
	}

	private static void robot(int y, int x, int dc) {
		clean[y][x] = false;
		cnt++;
		search(y,x,dc);
	}

	private static void search(int y, int x, int dc) {
		// 네 방향 모두 청소가 이미 되어있거나 벽이면서, 뒤쪽 방향이 벽이라 후진도 할 수 없는 경우에는 작동을 멈춘다.
		if(dc==4){
			int back = (dir+2)%4;
			int bx = x-dx[back];
			int by = y-dy[back];
			if(map[by][bx]!=1){
				robot(by, bx, 0);
			}
			else{
				return;
			}
		}
		int left = dir-1<0?3:dir-1;
		int nx = x+dx[left];
		int ny = y+dy[left];
		//왼쪽 방향에 아직 청소하지 않은 공간이 존재한다면, 그 방향으로 회전한 다음 한 칸을 전진하고 1번부터 진행한다.
		if(map[ny][nx]==0){
			dir = left;
			robot(ny, nx, 0);
		}
		//왼쪽 방향에 청소할 공간이 없다면, 그 방향으로 회전하고 2번으로 돌아간다.
		else{
			dir = left;
			search(y,x,dc+1);
		}
		
	}

}
