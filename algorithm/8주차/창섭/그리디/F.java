package greedy;

import java.util.Arrays;

public class F {

	public static void main(String[] args) {
		int[][] routes = {{-20,15}, {-14,-5}, {-18,-13}, {-5,-3}};
		System.out.println(solution(routes));
	}

	public static int solution(int[][] routes) {
        int answer = 0;
        int min = Integer.MIN_VALUE;
        Arrays.sort(routes, (a,b)->a[1]-b[1]);
        for(int[] car: routes){
        		if(min<car[0]){ 
        			min = car[1];
        			answer++;
        		}
        }
        return answer;
    }
}
