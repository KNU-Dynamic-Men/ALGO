package bfs_dfs;

public class B {

	static int[] visited;
	static int answer = 1;
	
	public static void main(String[] args) {
		int n=3; 
		int[][] computers= {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};
//			{{1, 1, 0}, {1, 1, 1}, {0, 1, 1}};
		System.out.println(solution(n, computers));

	}
	
	public static int solution(int n, int[][] computers) {
        visited = new int[n];
        for(int i=0; i<n; i++){
        		if(visited[i]==0){
        			dfs(i, computers);
            		answer++;
        		}
        }
        return answer-1;
    }

	private static void dfs(int i, int[][] computers) {
		if(visited[i]>0){
			return;
		}
		else{
			visited[i] = answer;
			for(int j=0; j<computers.length; j++){
				if(j!=i && computers[i][j] ==1)
					dfs(j, computers);
			}
		}
	}

}
