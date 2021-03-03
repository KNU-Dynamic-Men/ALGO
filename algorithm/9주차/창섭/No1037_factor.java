// 참고하면 좋을 것 > https://mygumi.tistory.com/122
package codeBaekJoon._2021;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class No1037_factor {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		int n = Integer.parseInt(br.readLine());
		long g[] = new long[1000001];
		long dp[] = new long[1000001];
		/*for(int i=1; i<=1000000; i++){
			for(int j=1; j<=i; j++){
				g[i] += n/j*j;
			}
		}*/
		for(int i=1; i<=1000000; i++){
			for(int j=1; j<=1000000/i; j++){
				g[i*j] += i;
			}
		}
		for(int i=1; i<=1000000; i++){
			dp[i] = dp[i-1]+g[i];
		}
		for(int i=1; i<=n; i++){
			int num = Integer.parseInt(br.readLine());
			System.out.println(dp[num]);
		}
	}
}
