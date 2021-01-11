package hash;

import java.util.HashMap;

public class A_2try {

	public static void main(String[] args) {
		String[] participant = {"mislav", "stanko", "mislav", "ana"};
		String[] completion = {"stanko", "ana", "mislav"};
		System.out.println(solution(participant, completion));
	}
	
	 public static String solution(String[] participant, String[] completion) {
		HashMap<String, Integer> map = new HashMap<>();
		for(String p: participant){
			if(map.containsKey(p)){
				int value = map.get(p);
				map.replace(p, value+1);
			}
			else{
				map.put(p, 0);
			}
		}
		for(String c: completion){
			if(map.containsKey(c)){
				int value= map.get(c);
				if(value>0){
					map.replace(c, value-1);
				}
				else{
					map.remove(c);
				}
			}
		}
		StringBuilder sb =new StringBuilder();
		map.forEach((a,b)-> sb.append(a));
		return sb.toString();
	 }
}
