package graph;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class A {
	
	static int[] visited;
	static HashMap<Integer, LinkedList<Integer>> graph= new HashMap<>();

	public static void main(String[] args) {
		int n=6; int[][] edge={{3, 6}, {4, 3}, {3, 2}, {1, 3}, {1, 2}, {2, 4}, {5, 2}};
		System.out.println(solution(n, edge));
		
	}
	
    public static int solution(int n, int[][] edge) {
        int answer = 0;
        visited = new int[n+1];
        Arrays.fill(visited, -1);
        for(int[] arr : edge){
        		if(!graph.containsKey(arr[0]))
    				graph.put(arr[0], new LinkedList<Integer>());
        		if(!graph.containsKey(arr[1])){
        			graph.put(arr[1], new LinkedList<Integer>());
        		}
        		graph.get(arr[0]).add(arr[1]);
        		graph.get(arr[1]).add(arr[0]);
        }
        bfs(1);
        int max = 0;
        for(int i: visited){
        		max = Math.max(i, max);
        }
        for(int i: visited){
        		if(i==max)
        			answer++;
        }
        return answer;
    }

	private static void bfs(int i) {
		Queue<Integer> q = new LinkedList<>();
		q.add(i);
		visited[i] = 0;
		while(!q.isEmpty()){
			int temp = q.poll();
			int tvisit = visited[temp];
			for(int v :graph.get(temp)){
				if(visited[v]<0){
					visited[v] = tvisit+1;
					q.add(v);
				}
			}
		}
	}
}
