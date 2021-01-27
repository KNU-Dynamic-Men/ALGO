package sort;

import java.util.Arrays;
import java.util.Comparator;

public class B {

	public static void main(String[] args) {
		int[] numbers = {3, 30, 34, 5, 9};
		System.out.println(solution(numbers));

	}
	
	public static String solution(int[] numbers) {
        StringBuilder answer = new StringBuilder();
        String[] arr = new String[numbers.length];
        for(int i=0; i<numbers.length; i++){
        		arr[i] = String.valueOf(numbers[i]);
        }
        Arrays.sort(arr, new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				return ((o1+o2).compareTo(o2+o1));
			}
		});
        if(arr[0].equals("0")){
        		return "0";
        }
        for(String a: arr){
        		answer.append(a);
        }
        return answer.toString();
    }

}
