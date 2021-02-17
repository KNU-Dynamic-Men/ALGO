package greedy;

import java.util.Arrays;
import java.util.LinkedList;

public class D {

	public static void main(String[] args) {
		int[] people={70, 50, 80, 50}; 
		int limit=100;
		System.out.println(solution(people, limit));

	}

	public static int solution(int[] people, int limit) {
		int answer = 0;
		Arrays.sort(people);
		LinkedList<Integer> list = new LinkedList<>();
		for(int i: people){
			list.add(i);
		}
		while(!list.isEmpty()){
			int min = list.getFirst();
			int max = list.getLast();
			if(limit<min+max){
				list.removeLast();
				answer++;
			}
			else{
				if(list.size()>=2){
					list.removeFirst();
					list.removeLast();
				}
				else{
					list.removeFirst();
				}
				answer++;
			}
		}
		return answer;
	}

}
