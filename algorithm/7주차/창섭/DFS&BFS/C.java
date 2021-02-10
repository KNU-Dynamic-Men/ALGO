/** 2021. 2. 9. 오후 12:41:38
 * @author ventulus95
 */
package bfs_dfs;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class C {

	static HashMap<String, Integer> visited = new HashMap<>();

	public static void main(String[] args) {
		String begin="hit"; String target="cog"; 
		String[] words={"hot", "dot", "dog", "lot", "log"};
		System.out.println(solution(begin, target, words));
	}

	public static int solution(String begin, String target, String[] words) {
		int answer = 0;
		for(String word: words){
			visited.put(word, -1);
		}
		visited.put(begin, -1);
		bfs(begin, target, words, 0);
		if(visited.containsKey(target))
			answer = visited.get(target);
		return answer;
	}

	private static void bfs(String begin, String target, String[] words ,int deep) {
		Queue<String> q = new LinkedList<String>();
		visited.replace(begin, deep);
		q.add(begin);
		while(!q.isEmpty()){
			String temp = q.poll();
			int cdeep = visited.get(temp);
			for(String word: words){
				int num=0;
				for(int i=0; i<temp.length(); i++){
					if(temp.charAt(i)==word.charAt(i))
						num++;
				}
				if(num==temp.length()-1&&visited.get(word)<0){
					visited.replace(word, cdeep+1);
					q.add(word);
				}
			}
		}
	}

}
