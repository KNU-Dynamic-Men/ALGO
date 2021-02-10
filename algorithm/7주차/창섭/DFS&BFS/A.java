package bfs_dfs;

public class A {
	
	static int answer = 0;
	
	public static void main(String[] args) {
		int[] numbers={1, 1, 1, 1, 1};
		int target=3;
		System.out.println(solution(numbers, target));
	}
	
	public static int solution(int[] numbers, int target) {
        for(int i=1; i<numbers.length; i++){
        		combination(numbers, new boolean[numbers.length], 0,numbers.length, i, target);
        }
        return answer;
    }

	static void combination(int[] arr, boolean[] visited, int start, int n, int r, int target) {
	    if(r == 0) {
	    		int sum =0;
	    		for(int i=0; i<arr.length; i++){
	    			sum+= visited[i]?arr[i]:-arr[i];
	    		}
	    		if(sum==target)
	    			answer++;
	        return;
	    } 

	    for(int i=start; i<n; i++) {
	        visited[i] = true;
	        combination(arr, visited, i + 1, n, r - 1, target);
	        visited[i] = false;
	    }
	}
}
