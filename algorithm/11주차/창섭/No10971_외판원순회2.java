/** 2021. 3. 9. 오전 11:22:36
 * @author ventulus95
 */
package codeBaekJoon._2021;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No10971_외판원순회2 {

	static int n, start, min=Integer.MAX_VALUE, sum;
	static int[][] route;
	static boolean[] visited;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		StringTokenizer st;
		visited = new boolean [n];
		route = new int[n][n];
		for(int i=0; i<n; i++){
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<n; j++){
				route[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for(int i=0; i<n; i++){
			start=i;
			sum =0;
			visited[i] = true;
			dfs(0,i);
			visited[i] = false;
		}
		System.out.println(min);
	}

	private static void dfs(int deep, int prev) {
		if(n-1==deep){
			if(route[prev][start] == 0){
				return;
			}
			sum += route[prev][start];
			min = Math.min(min, sum);
			sum -= route[prev][start];
			return;
		}
		for(int i=0; i<n; i++){
			if(!visited[i]&&route[prev][i]!=0){
				visited[i] = true;
				sum += route[prev][i];
				dfs(deep+1, i);
				visited[i] = false;
				sum -= route[prev][i];
			}
		}

	}
}