/** 2020. 5. 26. 오후 10:03:01
 * @author ventulus95
 */
package greedy;

import java.util.Arrays;

public class TrainingSuite {

	public static void main(String[] args) {
		int n = 3; 
		int[] lost = {3};
		int[] reserve = {1};
		int arr[] = new int [n+1];
		Arrays.fill(arr, 1);
		for(int i=0; i<lost.length; i++){
			arr[lost[i]]--;
		}
		for(int i=0; i<reserve.length; i++){
			arr[reserve[i]]++;
		}
		for(int i=0; i<reserve.length; i++){
			int index =reserve[i];
			if(arr[index] == 2 ){
				if(arr[index-1] == 0){
					arr[index]--;
					arr[index-1]++;
				}
				if(index+1 <= n ){
					if(arr[index+1] == 0 && arr[index] > 1){
						arr[index]--;
						arr[index+1]++;
					}
				}
			}
		}
		int cnt =0;
		for(int i=1; i<=n; i++){
			if(arr[i] >= 1){
				cnt++;
			}
		}
		System.out.println(cnt);

	}

}
