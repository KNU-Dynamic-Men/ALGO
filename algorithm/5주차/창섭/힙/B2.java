package heap;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class B2 {

	public static void main(String[] args) {
		int[][] jobs = {{0, 10}, {2, 10}, {9, 10}, {15, 2}};
		System.out.println(solution(jobs));

	}
	
//	public static int solution(int[][] jobs) {
//        int answer = 0;
//        int curr = 0;
//        PriorityQueue<Job> q = new PriorityQueue<>();
//        for(int[] job: jobs){
//        		int start = job[0];
//        		int during = job[1];
//        		q.add(new Job(start, during));
//        }
//        while(!q.isEmpty()){
//        		Job temp = q.poll();
//        		curr += temp.during;
//        		answer += curr - temp.start;
//        }
//        return (int)Math.ceil(answer/jobs.length);
//    }
	
	public static int solution(int[][] jobs) {
		int answer = 0;
		int len = jobs.length;
		int time = 0;
		int idx = 0;
		Queue<int[]> q = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
		
		Arrays.sort(jobs, (o1, o2) -> o1[0] - o2[0]);
		
		while (idx < len || !q.isEmpty()) {
			while (idx < len && jobs[idx][0] <= time)
				q.offer(jobs[idx++]);
			
			if (q.isEmpty())
				time = jobs[idx][0];
			else {
				int[] job = q.poll();
				answer += time - job[0] + job[1];
				time += job[1];
			}
		}
		
		return answer / len;
	}
}

class Job implements Comparable<Job>{
	int start, during;

	public Job(int start, int during) {
		this.start = start;
		this.during = during;
	}

	@Override
	public int compareTo(Job o) {
		if(this.during==o.during){
			if(this.start-o.start>0){
				return 1;
			}
			else if(this.start-o.start<0){
				return -1;
			}
		}
		return o.during-this.during;
	}
	
}
