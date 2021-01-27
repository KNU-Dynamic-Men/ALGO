package heap;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class C {

	public static void main(String[] args) {
		String[] operations = //{"I 16", "I -5643", "D -1", "D 1", "D 1", "I 123", "D -1"};
		//{"I -45", "I 653", "D 1", "I -642", "I 45", "I 97", "D 1", "D -1", "I 333"};
			{"I 4", "I 3", "I 2", "I 1", "D 1", "D 1", "D -1", "D -1", "I 5", "I 6"};
		System.out.println(Arrays.toString(solution(operations)));

	}
	
	public static int[] solution(String[] operations) {
        int[] answer = new int[2];
        PriorityQueue<Integer> min = new PriorityQueue<>();
        Comparator<Integer> comparator = new Comparator<Integer>() {
			public int compare(Integer o1, Integer o2) {
				return o2-o1;
			}
		};
        PriorityQueue<Integer> max = new PriorityQueue<>(comparator);
        int size = 0;
        for(String temp: operations){
        		String command =temp.split(" ")[0];
        		int num = Integer.parseInt(temp.split(" ")[1]);
        		if(command.equals("I")){
        			min.add(num);
        			max.add(num);
        			size++;
        		}
        		else{
        			if(num==1){
        				max.poll();
        				size--;
        			}
        			else{
        				min.poll();
        				size--;
        			}
        		}
        }
        if(size>0){
        		answer[1] = min.poll();
        		answer[0] = max.poll();
        }
        return answer;
    }

}
