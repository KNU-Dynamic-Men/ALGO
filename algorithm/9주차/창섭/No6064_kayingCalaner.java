/** 2021. 1. 17. 오후 12:46:51
 * @author ventulus95
 */
package codeBaekJoon._2021;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No6064_kayingCalaner {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for(int i =0; i<n; i++){
			st = new StringTokenizer(br.readLine(), " ");
			int M = Integer.parseInt(st.nextToken());
			int N = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			System.out.println(kaying(M, N, x, y));
		}

	}

	private static int kaying(int m, int n, int x, int y) {
		int cnt = x%(m+1);
		int mod = x;
		int max = lcm(m,n);
		for(int i=0; i<n; i++){
			int tempy = mod%n==0?n:mod%n;
			if(tempy == y){
				break;
			}
			mod = tempy+ m;
			cnt+=m;
		}
		if(max<cnt)
			return -1;
		return cnt;
	}
	
	private static int gcd(int a, int b){
		while(b!=0){
			int r = a%b;
			a= b;
			b= r;
		}
		return a;
	}

	private static int lcm(int a, int b){
	    return a * b / gcd(a,b);
	}

}
