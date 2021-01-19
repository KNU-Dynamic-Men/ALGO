package stack_queue;

import java.util.Arrays;
import java.util.LinkedList;

public class A {

	public static void main(String[] args) {
		int[] prices = {1, 2, 3, 2, 3};
		System.out.println(solution(prices));
	}
	
	public static int[] solution(int[] prices) {
		LinkedList<Integer> li = new LinkedList<>(); 
		for(int i=0; i<prices.length; i++){
			int price = prices[i];
			int cnt =0;
			for(int j=i+1; j<prices.length; j++){
				if(price>prices[j]){
					break;
				}
				cnt++;
			}
			li.add(cnt);
		}
        return Arrays.stream(li.toArray(new Integer[li.size()])).mapToInt(Integer::intValue).toArray();
    }

}
