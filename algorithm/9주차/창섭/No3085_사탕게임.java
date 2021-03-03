package codeBaekJoon._2021;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class No3085_사탕게임 {

	static char map[][];
	static int max = 0;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		map = new char[n][n];
		for(int i=0; i<n; i++){
			String tc = br.readLine();
			for(int j=0; j<n; j++){
				map[i][j] = tc.charAt(j);
			}
		}
		for(int i=0; i<n; i++){
			for(int j=0; j<n; j++){
				//아래
				if(i+1<n){
					char swap = map[i+1][j];
					map[i+1][j] = map[i][j];
					map[i][j] = swap;
					check(n);
					map[i][j] = map[i+1][j];
					map[i+1][j] = swap;
				}
				//위 
				if(i-1>=0){
					char swap = map[i-1][j];
					map[i-1][j] = map[i][j];
					map[i][j] = swap;
					check(n);
					map[i][j] = map[i-1][j];
					map[i-1][j] = swap;
				}
				if(j+1<n){
					char swap = map[i][j+1];
					map[i][j+1] = map[i][j];
					map[i][j] = swap;
					check(n);
					map[i][j] = map[i][j+1];
					map[i][j+1] = swap;
				}
				if(j-1>=0){
					char swap = map[i][j-1];
					map[i][j-1] = map[i][j];
					map[i][j] = swap;
					check(n);
					map[i][j] = map[i][j-1];
					map[i][j-1] = swap;
				}
			}
		}
		System.out.println(max);
	}

	private static void check(int n) {
		//가로 체크;
		for(int i=0; i<n; i++){
			int cnt = 1;
			char prev = map[i][0];
			for(int j=1; j<n; j++){
				if(map[i][j]==prev){
					cnt++;
					max = Math.max(max, cnt);
				}
				else{
					prev = map[i][j];
					cnt =1;
				}
			}
		}
		//세로 체크;
		for(int i=0; i<n; i++){
			int cnt = 1;
			char prev = map[0][i];
			for(int j=1; j<n; j++){
				if(map[j][i]==prev){
					cnt++;
					max = Math.max(max, cnt);
				}
				else{
					prev = map[j][i];
					cnt =1;
				}
			}
		}
	}

}

