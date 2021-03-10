/** 2021. 3. 9. 오전 10:41:05
 * @author ventulus95
 */
package codeBaekJoon._2021;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class No1759_암호만들기 {
	
	static int L,C;
	static boolean visited[];
	static String arr[];
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		arr = new String[C];
		visited = new boolean[C];
		arr = br.readLine().split(" ");
		Arrays.sort(arr);
		dfs(0,0);
		System.out.println(sb.toString());
	}

	private static void dfs(int deep, int start) {
		if(deep==L){
			String[] check = {"a","e", "i", "o", "u"};
			int vowels = 0;
			int cons =0; 
			for(int i=0; i<C; i++){
				if(visited[i]){
					boolean flags = false;
					for(String c: check){
						if(arr[i].equals(c)){
							vowels++;
							flags = true;
						}
					}
					if(!flags){
						cons++;
					}
				}
			}
			if(vowels>=1 && cons>=2){
				for(int i=0; i<C; i++){
					if(visited[i]){
						sb.append(arr[i]);
					}
				}
				sb.append("\n");
			}
		}
		for(int i=start; i<C; i++){
			if(!visited[i]){
				visited[i] = true;
				dfs(deep+1, i+1);
				visited[i] = false;
			}
		}
		
	}

}
