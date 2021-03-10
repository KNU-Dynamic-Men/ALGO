/** 2021. 3. 5. 오전 12:04:38
 * @author ventulus95
 */
package codeBaekJoon._2021;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class No2529_부등호 {
	static String mx, mn;
	static long max, min=Long.MAX_VALUE;
	static int n;
	static boolean visited[];
	static char sign[];
	static LinkedList<Integer> list = new LinkedList<>();  

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		String st = br.readLine();
		visited = new boolean[10];
		sign = new char[n];
		int cnt = 0;
		for(int i =0; i<st.length(); i++){
			if(st.charAt(i)!=' '){
				sign[cnt] = st.charAt(i);
				cnt++;
			}
		}
		for(int i=0; i<10; i++){
			list.add(i);
			visited[i] = true;
			dfs(0);
			list.removeLast();
			visited[i] = false;
		}
		System.out.println(mx);
		System.out.println(mn);
	}

	private static void dfs(int d) {
		if(d==n){
			String k = "";
			for(int v: list){
				 k += v;
			}
			Long num = Long.parseLong(k);
			min = Math.min(min, num);
			max = Math.max(max, num);
			if(min==num)
				mn = k;
			if(max==num)
				mx = k;
			return;
		}
		for(int i=0; i<10; i++){
			char s = sign[d];
			int temp = list.getLast();
			boolean check = true;
			if(s == '>'){
				check = temp>i;
			}
			if(s == '<'){
				check = temp<i;
			}
			if(!visited[i] && check){
				list.add(i);
				visited[i] = true;
				dfs(d+1);
				list.removeLast();
				visited[i] = false;
			}
		}
		
	}
	

}
