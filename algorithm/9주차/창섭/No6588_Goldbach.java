package codeBaekJoon._2021;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class No6588_Goldbach {

	public static final int MAX = 1000000;


	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String tc;
		ArrayList<Integer> primeList = new ArrayList<Integer>();
		boolean isPrime[] = new boolean[MAX + 1];
		for(int i = 2; i <= MAX; i++) {
			isPrime[i] = true;
		}
		for(int i = 2; i <= MAX; i++) {
			if(!isPrime[i]) continue;
			else primeList.add(i);
			for(int j = i*2; j <= MAX; j += i) {
				isPrime[j] = false;
			}
		}
		while(!(tc=br.readLine()).equals("0")){
			int num = Integer.parseInt(tc);
			boolean check = true; 
			for(int i=2; i<=num/2; i++){
				if(isPrime[i]&&isPrime[num-i]){
					System.out.println(num+" = "+i+" + "+(num-i));
					check = false;
					break;
				}
			}
			if(check){
				System.out.println("Goldbach's conjecture is wrong.");
			}
		}
	}

}
