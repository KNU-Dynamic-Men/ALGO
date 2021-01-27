package sort;

import java.util.Arrays;

public class C {

	public static void main(String[] args) {
		int[] citations = {4, 4, 4};
		System.out.println(solution(citations));

	}
	
	public static  int solution(int[] citations) {
        Arrays.sort(citations);
        int h = 0; 
        for(int i=0; i<citations[citations.length-1]; i++){
        		int curr = i;
        		int hi = 0;
        		for(int j=0; j<citations.length; j++){
        			if(curr<=citations[j]){
        				hi++;
        			}
        		}
        		if(curr<=hi){
        			h= Math.max(h, curr);
        		}
        }
        return h;
    }

}
