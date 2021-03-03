/** 2021. 3. 2. 오후 10:46:07
 * @author ventulus95
 */
package codeBaekJoon._2021;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class No15649_N과M1 {
	
	static int arr[];
	static boolean visited[];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String tc = br.readLine();
		int n = Integer.parseInt(tc.split(" ")[0]);
		int m = Integer.parseInt(tc.split(" ")[1]);
		arr = new int[n+1];
		visited = new boolean[n+1];
		dfs(n, m, 0);

	}

	private static void dfs(int n, int m, int cnt) {
		if(cnt==m){
			for(int i=0; i<m; i++)  {
				System.out.print(arr[i]+" ");
			}
			System.out.println();
			return;
		}
		for(int i=1; i<=n; i++){
			if(visited[i]==false){
				arr[cnt] = i;
				visited[i] = true;
				dfs(n,m,cnt+1);
				visited[i] = false;
			}
		}
		
	}

}
