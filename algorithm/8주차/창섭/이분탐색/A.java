package binarySearch;

import java.util.Arrays;

public class A {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static long solution(int n, int[] times) {
        long answer = 0;
        Arrays.sort(times);
        return binarySearch(times, n, times[times.length-1], answer);
    }

	private static long binarySearch(int[] arr, int n, int max, long answer) {
		long start = 1; 
		long end = max*n;
		while(start<=end){
			long mid = (start+end)/2;
			int people =0;
			for(int i: arr){
				people += mid/i;
			}
			if(people>=n){
				if(answer>mid){ //최소값 찾는거니까. 
					answer = mid;
				}
				end = mid-1;
			}
			else{
				start = mid+1; //명수 못채우므로, start 땡겨서 명수도 늘려야함.
			}
		}
		return answer;
	}

}
