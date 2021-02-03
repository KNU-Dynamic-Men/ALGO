package brutalForce;

import java.util.ArrayList;
import java.util.Arrays;

public class C {

	public static void main(String[] args) {
		int brown=14, yellow=4;
		System.out.println(Arrays.toString(solution(brown, yellow)));
	}

	public static int[] solution(int brown, int yellow) {
		int[] answer = new int[2];
		ArrayList<Integer> yh=new ArrayList<>(), yw=new ArrayList<>();
		for(int i=yellow; i>0; i--){
			if(yellow/i > i){
				break;
			}
			if(yellow%i==0){
				yw.add(i);
				yh.add(yellow/i);
			}
		}
		brown += yellow;
		for(int i=brown; i>0; i--){
			if(answer[0]>0){
				break;
			}
			if(brown/i > i){
				break;
			}
			if(brown%i==0){
				for(int j=0; j<yh.size(); j++){
					int yheight = yh.get(j);
					int ywidth = yw.get(j);
					if(i>=ywidth+2 && brown/i>=yheight+2){
						answer[0] = i;
						answer[1] = brown/i;
						break;
					}
				}
			}
		}
		

		return answer;
	}

}
