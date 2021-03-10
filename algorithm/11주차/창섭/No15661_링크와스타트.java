/** 2021. 3. 7. 오후 6:31:49
 * @author ventulus95
 */
package codeBaekJoon._2021;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class No15661_링크와스타트 {
	static boolean visited[];
	static int map[][];
	static int n, answer=Integer.MAX_VALUE, t1sum;
	
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		map = new int[n+1][n+1];
		visited = new boolean[n+1];
		StringTokenizer st;
		for(int i=1; i<=n; i++){
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=1; j<=n; j++){
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for(int i=2; i<=n/2; i++){
			teamdivide(i, 1);
		}
		System.out.println(answer);
	}

	private static void teamdivide(int m, int start) {
		if(m==0){
			LinkedList<Integer> t1 = new LinkedList<>();
			LinkedList<Integer> t2 = new LinkedList<>();
			for(int i=1; i<=n; i++)  {
				if(visited[i])
					t1.add(i);
				else
					t2.add(i);
			}
			
			int[] team1 = Arrays.stream(t1.toArray(new Integer[t1.size()])).mapToInt(Integer::intValue).toArray();
			int[] team2 = Arrays.stream(t2.toArray(new Integer[t2.size()])).mapToInt(Integer::intValue).toArray();
			t1sum = 0;
//			teamSum(0, t1);
			int a  = teamSum(0, t1);;
			t1sum = 0;
//			teamSum(0, t2);
			int b = teamSum(0, t2);;
			answer = Math.min(Math.abs(a-b), answer);
			return;
		}
		for(int i=start; i<=n; i++){
				visited[i] = true;
				teamdivide(m-1, i+1);
				visited[i] = false;
		}
		
	}
	
	private static void teamSum(int cnt, boolean[] visited, int[] arr, int[] num, int n) {
		if(cnt==2){
			t1sum += map[arr[0]][arr[1]];
		}
		for(int i=0; i<num.length; i++){
			if(visited[i]==false){
				arr[cnt] = num[i];
				visited[i] = true;
				teamSum(cnt+1, visited, arr, num, n);
				visited[i] = false;
			}
		}
	}
	
	private static int teamSum(int sum, LinkedList<Integer> team) {
        for (int i = 0; i < team.size(); i++) {
            for (int j = 0; j < team.size(); j++) {
                if (i == j) continue;
                sum += map[team.get(i)][team.get(j)];
            }
        }
        return sum;
    }
	

}
