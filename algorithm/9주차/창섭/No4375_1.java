/** 2021. 2. 18. 오후 2:30:33
 * @author ventulus95
 */
package codeBaekJoon._2021;

import java.util.Scanner;

public class No4375_1 {

	public static void main(String[] args) throws Exception {
		Scanner input = new Scanner(System.in); 
		StringBuilder sb; 
		while(input.hasNextLine()){
			String line = input.nextLine();
			int num = Integer.parseInt(line);
			int n =0;
			for(int i=1; i<=num; i++){
				n = n * 10 + 1;
				n%=num;
				if(n==0){
					System.out.println(i);
					break;
				}
			}
		}
	}
}
