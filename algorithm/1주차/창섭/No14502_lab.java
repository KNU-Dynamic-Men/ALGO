/** 2020. 12. 30. 오후 5:49:31
 * @author ventulus95
 */
package codeBaekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class No14502_lab {
	
	static int[][] map, copy;
	static boolean[][] visited;
	static int[] dx = {1,0,-1,0};
	static int[] dy = {0,-1,0,1};
	static int result, x,y; 

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		y = Integer.parseInt(st.nextToken());
		x = Integer.parseInt(st.nextToken());
		map=new int[y][x];
		copy = new int[y][x];
		visited = new boolean[y][x];
		for(int i=0; i<y; i++){
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<x; j++){
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		wallMaker(0,0,0);
		System.out.println(result);
	}

	static void wallMaker(int a, int b, int cnt){
		if(cnt==3){
			bfs();
			return;
		}
		if(a>=x){
			wallMaker(0,b+1,cnt);
			return;
		}
		if(b>=y) return;
		if(map[b][a]==0){
			map[b][a]=1;
			wallMaker(a+1, b, cnt+1);
			map[b][a]=0;
		}
		wallMaker(a+1, b, cnt);
	}
	
	static void bfs(){
		Queue<node14502> q = new LinkedList<>();
		for(int i=0; i<y; i++){
			for(int j=0; j<x; j++){
				copy[i][j]=map[i][j];
				visited[i][j] = false;
				if(copy[i][j]==2){
					q.add(new node14502(j, i));
					visited[i][j] = true;
				}
			}
		}
		while(!q.isEmpty()){
			node14502 temp = q.poll();
			for(int i=0; i<4; i++){
				int cx = temp.x+dx[i];
				int cy = temp.y+dy[i];
				if(cx>=x || cx<0 || cy>=y || cy<0)
					continue;
				if(visited[cy][cx] == true)
					continue;
				if(copy[cy][cx]==0){
					copy[cy][cx]=2;
					visited[cy][cx] = true;
					q.add(new node14502(cx, cy));
 				}
			}
		}
//		Arrays.stream(copy).forEach((k)->{for (int t: k) {
//			System.out.print(t+" ");
//		}
//		System.out.println();});
		int cnt =0;
		for(int i=0; i<y; i++){
			for(int j=0; j<x; j++){
				if(copy[i][j]==0)
					cnt++;
			}
		}
		result = Math.max(cnt, result);
	}
}

class node14502{
	int x,y;
	public node14502(int x, int y){
		this.x=x;
		this.y=y;
	}
}