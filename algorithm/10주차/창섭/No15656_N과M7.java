/** 2021. 3. 2. 오후 10:46:07
 * @author ventulus95
 */
package codeBaekJoon._2021;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class No15656_N과M7 {
	
	static int arr[], num[];
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
		dfs(n, m, 0);
		System.out.print(sb.toString());

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
				arr[cnt] = num[i];
				dfs(n,m,cnt+1);
		}
	}

}
