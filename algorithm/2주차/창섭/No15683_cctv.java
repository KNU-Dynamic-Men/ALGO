/** 2021. 1. 5. 오후 9:13:49
 * @author ventulus95
 */
package codeBaekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class No15683_cctv {

	static int[][] map, copyMap;
	static int[] dx = {1,0,-1,0};
	static int[] dy = {0,-1,0,1};
	static int result=99, n,m, cctv; 
	static int[] arr;
	static ArrayList<node15683> list= new ArrayList<>();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		cctv = 0;
		map = new int[n][m];
		copyMap = new int[n][m];
		for(int i=0; i<n; i++){
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<m; j++){
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j]>=1 && map[i][j]<6){
					list.add(new node15683(j, i));
					cctv++;
				}
					
			}
		}
		if(cctv==0){
			init();
			checker();
		}
		else{
			arr = new int[cctv];
			for(int i=0; i<4; i++){
				arr[0] = i;
				brute(0);
			}
		}
		System.out.println(result);
	}
	
	static void brute(int deep){
		if(deep==cctv-1){
			init();
			for(int i=0; i<cctv; i++){
				node15683 temp =list.get(i);
				setup(i,temp);
			}
			checker();
			return;
		}
		for(int i=0; i<4; i++){
			arr[deep+1] = i;
			brute(deep+1);
		}
	}
	
	static void init(){
		for(int i=0; i<n; i++){
			for(int j=0; j<m; j++){
				copyMap[i][j]=map[i][j];
			}
		}
	}
	
	static void setup(int idx ,node15683 n){
		if(map[n.y][n.x]==1){
			move(arr[idx], n);
		}
		else if(map[n.y][n.x]==2){
			move(arr[idx], n);
			move((arr[idx]+2)%4, n);
		}
		else if(map[n.y][n.x]==3){
			move(arr[idx], n);
			move((arr[idx]+1)%4, n);
		}
		else if(map[n.y][n.x]==4){
			move(arr[idx], n);
			move((arr[idx]+1)%4, n);
			move((arr[idx]+2)%4, n);
		}
		else if(map[n.y][n.x]==5){ //5 
			move(arr[idx], n);
			move((arr[idx]+1)%4, n);
			move((arr[idx]+2)%4, n);
			move((arr[idx]+3)%4, n);
		}
	}
	
	static void move(int dir, node15683 no){
		int sy = no.y;
		int sx = no.x;
		while(true){
			int cy = sy+dy[dir];
			int cx = sx+dx[dir];
			if(cy>=n || cy<0 || cx>=m || cx<0){
				break;
			}
			if(copyMap[cy][cx]==6)
				break;
			copyMap[cy][cx] = 9;
			sx=cx;
			sy=cy;
		}
	}
	
	static void checker(){
		int safe =0;
		for(int i=0; i<n; i++){
			for(int j=0; j<m; j++){
				if(copyMap[i][j]==0)
					safe++;
			}
		}
		result = Math.min(safe, result);
	}

}

class node15683{
	int x,y;
	public node15683(int x, int y) {
		this.x = x;
		this.y = y;
	}
}
