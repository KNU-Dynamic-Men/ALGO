package sort;

import java.util.ArrayList;
import java.util.Arrays;

public class A {

	public static void main(String[] args) {
		int[] array = {1, 5, 2, 6, 3, 7, 4};
		int[][] commands = {{2, 5, 3},{4, 4, 1},{1, 7, 3}};
		System.out.println(Arrays.toString(solution(array, commands)));
	}
	
	public static int[] solution(int[] array, int[][] commands) {
        ArrayList<Integer> answer = new ArrayList<>();
        for(int i=0; i<commands.length; i++){
        		int s = commands[i][0];
        		int e = commands[i][1];
        		int n = commands[i][2];
        		ArrayList<Integer> sort = new ArrayList<>();
        		for(int j=s-1; j<e; j++){
        			sort.add(array[j]);
        		}
        		int[] arr =Arrays.stream(sort.toArray(new Integer[sort.size()])).mapToInt(Integer::intValue).sorted().toArray();
        		answer.add(arr[n-1]);
        		
        }
        return Arrays.stream(answer.toArray(new Integer[answer.size()])).mapToInt(Integer::intValue).toArray();
    }

}
