/** 2020. 4. 19. 오후 8:20:28
 * @author ventulus95
 */
package hash;

import java.util.HashMap;
import java.util.Set;

public class C {
	
	static int answer = 0;
	
	public static void main(String[] args) {
		String[][] clothes ={{"a","aa"},{"b","aa"},{"c","aa"},{"a_a","bb"},{"b_b","bb"},{"c_c","bb"},{"aaa","cc"},{"bbb","cc"},{"ccc","cc"}};
		System.out.println(solution(clothes));
		
	}
	
	public static int solution(String[][] clothes) {
        HashMap<String, Integer> map = new HashMap<>();
        for(String[] arr: clothes){
        		String cloth = arr[1];
        		if(map.containsKey(cloth)){
        			int val = map.get(cloth);
        			map.replace(cloth, val+1);
        		}
        		else{
        			map.put(cloth, 1);
        		}
        }
        Set<String> keyset = map.keySet();
        int answer = 1;
        for(String key: keyset){
        		answer *= map.get(key)+1;
        }
//        Integer[] v = map.values().toArray(new Integer[keyset.size()]);
//        for(int i=1; i<=keyset.size(); i++){
//    		boolean[] visited = new boolean[keyset.size()];
//    			comb(v, visited, 0,keyset.size(), i);
//        }
        return answer-1;
    }
	
	
	static void comb(Integer[] v, boolean[] visited, int depth, int n, int r) {
	    if (r == 0) {
	        printa(v, visited, n);
	        return;
	    }

	    if (depth == n) {
	        return;
	    }

	    visited[depth] = true;
	    comb(v, visited, depth + 1, n, r - 1);

	    visited[depth] = false;
	    comb(v, visited, depth + 1, n, r);
	}
	
	static void printa(Integer[] arr, boolean[] visited, int n) {
        int comb = 1;
		for (int i = 0; i < n; i++) {
            if (visited[i]) {
            		comb *= arr[i];
            }
        }
		answer += comb;
    }

}
