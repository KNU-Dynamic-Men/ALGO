/** 2021. 3. 2. 오후 10:46:07
 * @author ventulus95
 */
package codeBaekJoon._2021;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class No15652_N과M4 {
	
	static boolean visited[];
	static LinkedList<Integer> list = new LinkedList<>();
	static StringBuffer sb = new StringBuffer();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String tc = br.readLine();
		int n = Integer.parseInt(tc.split(" ")[0]);
		int m = Integer.parseInt(tc.split(" ")[1]);
		visited = new boolean[n+1];
		dfs(n, m, 1);
		System.out.println(sb.toString());

	}

	private static void dfs(int n, int m, int start) {
		if(m==0){
			for(int i: list)  {
				sb.append(i+" ");
			}
			sb.append("\n");
			return;
		}
		for(int i=start; i<=n; i++){
				list.add(i);
				dfs(n,m-1, i);
				list.removeLast();
		}
		
	}

}
