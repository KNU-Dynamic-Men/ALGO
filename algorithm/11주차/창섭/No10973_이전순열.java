/** 2021. 3. 7. 오후 11:29:54
 * @author ventulus95
 */
package codeBaekJoon._2021;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class No10973_이전순열 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine(), " "); 
		int[] arr = new int[n];
		for(int i=0; i<n; i++){
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int[] curr = Arrays.copyOf(arr, n);
		arr = prevPermutation(arr);
		if(Arrays.equals(curr, arr))
			System.out.println(-1);
		else
			for(int i: arr){
				System.out.print(i+" ");
			}
	}

	private static int[] prevPermutation(int[] arr) {
	        int i = arr.length - 1;
	        while (i > 0 && arr[i - 1] <= arr[i]) --i;

	        if (i == 0) return arr;

	        int j = i - 1;
	        while (j + 1 <= arr.length-1 && arr[j + 1] <= arr[i - 1]) ++j;

	        int temp = arr[i-1];
	        arr[i-1] = arr[j];
	        arr[j] = temp;

	        int k = arr.length-1;
	        while(i<k){
	            temp = arr[i];
	            arr[i] = arr[k];
	            arr[k] = temp;
	            i++; k--;
	        }
	        return arr;
	    }

}
