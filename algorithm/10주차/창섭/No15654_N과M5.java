/** 2021. 3. 2. 오후 10:46:07
 * @author ventulus95
 */
package codeBaekJoon._2021;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class No15654_N과M5 {
	
	static int arr[], num[];
	static boolean visited[];
	static StringBuilder sb = new StringBuilder(); 
			

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " "); 
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		arr = new int[n+1];
		num = new int[n+1];
		st = new StringTokenizer(br.readLine(), " ");
		for(int i=1; i<=n; i++){
			num[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(num);
		visited = new boolean[n+1];
		dfs(n, m, 0);
		System.out.println(sb.toString());

	}

	private static void dfs(int n, int m, int cnt) {
		if(cnt==m){
			for(int i=0; i<m; i++)  {
				sb.append(arr[i]+" ");
			}
			sb.append("\n");
			return;
		}
		for(int i=1; i<=n; i++){
			if(visited[i]==false){
				arr[cnt] = num[i];
				visited[i] = true;
				dfs(n,m,cnt+1);
				visited[i] = false;
			}
		}
		
	}

}
