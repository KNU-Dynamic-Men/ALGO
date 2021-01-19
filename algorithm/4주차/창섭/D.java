package stack_queue;

import java.util.LinkedList;
import java.util.Queue;

public class D {

	public static void main(String[] args) {
		int[] priorities= {1, 1, 9, 1, 1, 1};
		int location = 0;
		System.out.println(solution(priorities,location));
	}

	public static int solution(int[] priorities, int location) {
        Queue<Integer> q = new LinkedList<>();
        int cnt = 0;
        for(int i=0; i<priorities.length; i++){
        		q.add(i);
        }
        int idx = 101;
        while(!q.isEmpty()){
        		if(idx==location){
        			break;
        		}
        		int print = q.poll();
        		int prior = priorities[print];
        		boolean flag = true;
        		for(int i=0; i<priorities.length; i++){
        			if(prior<priorities[i]){
        				flag = false;
        			}
        		}
        		if(!flag){
        			q.add(print);
        		}
        		else{
        			idx = print;
        			priorities[print] = -9;
        			cnt++;
        		}
        }
		return cnt;
	}
}
