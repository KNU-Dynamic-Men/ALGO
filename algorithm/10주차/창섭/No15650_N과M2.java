/** 2021. 3. 2. 오후 10:46:07
 * @author ventulus95
 */
package codeBaekJoon._2021;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class No15650_N과M2 {
	static int arr[];
	static boolean visited[];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String tc = br.readLine();
		int n = Integer.parseInt(tc.split(" ")[0]);
		int m = Integer.parseInt(tc.split(" ")[1]);
		arr = new int[m+1];
		visited = new boolean[n+1];
		dfs(n, m, 1);

	}

	private static void dfs(int n, int m, int start) {
		if(m==0){
			for(int i=1; i<=n; i++)  {
				if(visited[i])
					System.out.print(i+" ");
			}
			System.out.println();
			return;
		}
		for(int i=start; i<=n; i++){
				visited[i] = true;
				dfs(n,m-1, i+1);
				visited[i] = false;
		}
		
	}

}
