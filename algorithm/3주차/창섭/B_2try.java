package hash;

import java.util.HashMap;
import java.util.Set;

public class B_2try {
	
	static boolean checker = true; 
	
	public static void main(String[] args) {
		String[] phone_book ={"010111", "010", "789"};
		System.out.println(solution(phone_book));

	}
	
	public static boolean solution(String[] phone_book) {
		
		HashMap<String, Integer> map = new HashMap();
		for(String p: phone_book){
			Set<String> set = map.keySet();
			set.stream().forEach(a -> {
				if(p.startsWith(a)){
					checker = false;
				}
				if(a.startsWith(p)){
					checker = false;
				}
			});
			map.put(p, 0);
			if(!checker)
				break;
		}
		return checker; 
	}

}
