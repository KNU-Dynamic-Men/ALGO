package heap;

import java.util.PriorityQueue;

public class A {

	public static void main(String[] args) {
		int[] scoville={1,2}; 
		int K=3;
		System.out.println(solution(scoville, K));
	}
	
	public static int solution(int[] scoville, int K) {
		PriorityQueue<Integer> q = new PriorityQueue<>();
		for(int i:scoville){
			q.add(i);
		}
		int answer =0;
		while(q.peek()<=K){
			int min = q.poll();
			if(!q.isEmpty()){
				int min2 = q.poll();
				int sum = min+(min2*2);
				q.add(sum);
				answer++;
			}
			else{
				answer = -1;
				break;
			}
		}
		return answer;
	}

}
