package stack_queue;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class B {

	public static void main(String[] args) {
		int[] progresses = {95, 90, 99, 99, 80, 99};
		int[] speeds = {1, 1, 1, 1, 1, 1};
		System.out.println(Arrays.toString(solution(progresses, speeds)));
	}

	public static int[] solution(int[] progresses, int[] speeds) {
		Queue<Integer> q = new LinkedList<Integer>();
		for(int i=0; i<progresses.length; i++){
			q.add(i);
		}
		int cnt = 0;
		LinkedList<Integer> list = new LinkedList<>();
		while(!q.isEmpty()){
			int idx = q.peek();
			if(progresses[idx]>=100){
				q.poll();
				cnt++;
			}
			else{
				if(cnt>0){
					list.add(cnt);
					cnt =0;
				}
				for(int i=0; i<progresses.length; i++){
					progresses[i]+=speeds[i];
				}
			}
		}
		if(cnt>0){
			list.add(cnt);
		}
		return Arrays.stream(list.toArray(new Integer[list.size()])).mapToInt(Integer::intValue).toArray();
	}

}
