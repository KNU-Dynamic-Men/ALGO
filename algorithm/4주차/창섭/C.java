package stack_queue;

import java.util.LinkedList;
import java.util.Queue;

public class C {

	public static void main(String[] args) {
		int bridge_length =100 , weight=100; 
		int[] truck_weights ={10,10,10,10,10,10,10,10,10,10};
		System.out.println(solution(bridge_length, weight, truck_weights));
	}

	public static int solution(int bridge_length, int weight, int[] truck_weights) {
		int answer = 0;
		Queue<truck> q = new LinkedList<>();  
		int cw = weight;
		int cnt = bridge_length;
		int idx=0;
		while(true){
			if(idx==truck_weights.length && q.isEmpty()){
				break;
			}
			if(idx!=truck_weights.length &&cw-truck_weights[idx]>=0 && cnt>=0 ){
				q.add(new truck(idx, bridge_length));
				cw-=truck_weights[idx];
				idx +=1;
				cnt-=1;
			}
			int size = q.size();
			while(size>0){
				truck temp = q.poll();
				if(temp.location-1>0){
					temp.location = temp.location-1;
					q.add(temp);
				}
				else{
					cw+=truck_weights[temp.idx];
					cnt+=1;
				}
				size--;
			}
			answer++;
		}
		return answer+1;
	}
	
}

class truck{
	int idx, location;
	public truck(int i, int l){
		this.idx = i;
		this.location = l;
	}
	@Override
	public String toString() {
		return "truck [idx=" + idx + ", location=" + location + "]";
	}
}