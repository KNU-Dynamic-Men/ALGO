/** 2021. 3. 9. 오후 2:57:58
 * @author ventulus95
 */
package codeBaekJoon._2021;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class No1248_맞춰봐 {
	static int n;
	static int[] arr;
	static char[][] map;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		String tc = br.readLine();
		map = new char[n][n];
		int idx =0;
		for(int i=0; i<n; i++){
			for(int j=i; j<n; j++){
				map[i][j] = tc.charAt(idx);
				idx++;
			}
		}
		arr = new int [n];
		dfs(0);
		System.out.print(sb.toString());
	}

	private static void dfs(int deep) {
		if(sb.length()>0){
			return;
		}
		if(deep==n){
			for(int a: arr)
				sb.append(a+" ");
			return;
		}
		for(int i=-10; i<=10; i++){
			arr[deep] = i;
			if(check(deep))
				dfs(deep+1);
		}

	}

	private static boolean check(int deep) {
		for(int i=0; i<=deep; i++){
			int sum =0;
			for(int j=i; j<=deep; j++){
				sum += arr[j];
				if(!check(sum, map[i][j]))
					return false;
			}
		}
		return true;
	}

	private static boolean check(int i, char c) {
		if(c=='+'){
			return i>0;
		} else if(c=='-'){
			return i<0;
		} else{
			return i==0;
		}
	}

}
