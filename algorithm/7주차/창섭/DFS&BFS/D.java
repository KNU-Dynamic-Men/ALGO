package bfs_dfs;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.TreeMap;

public class D {
	
	static HashMap<String, TreeMap<String, String>> visited = new HashMap<>();
	static boolean[] visit;
	static LinkedList<String> answers = new LinkedList<>();
	static String[] answer;

	public static void main(String[] args) {
		String[][] tickets = //{{"ICN", "JFK"},{"HND", "IAD"},{"JFK", "HND"}};
		 {{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL", "SFO"}};
//				{{"ICN", "A"}, {"ICN", "B"}, {"B", "ICN"}};
		System.out.println(Arrays.toString(solution(tickets)));
	}
	
	public static String[] solution(String[][] tickets) {
		visit = new boolean[tickets.length];
		
        for(String[] ticket: tickets){
        		if(!visited.containsKey(ticket[0])){
        			visited.put(ticket[0], new TreeMap<String, String>());
        			visited.get(ticket[0]).put(ticket[1], "");
        		}
        		else{
        			visited.get(ticket[0]).put(ticket[1], "");
        		}
        }
        answers.add("ICN");
        dfs(0,"ICN", tickets);
        return answer;
    }

	private static void dfs(int deep ,String string, String[][] tickets) {
		if(deep==tickets.length){
			answer = answers.toArray(new String[answers.size()]);
			return;
		}
		for(int i=0; i<tickets.length; i++){
			if(!visit[i] && tickets[i][0].equals(string) ){
				visit[i] = true;
				answers.add(tickets[i][1]);
				dfs(deep+1, tickets[i][1], tickets);
				visit[i] = false;
				answers.remove(tickets[i][1]);
			}
		}
	}

}
