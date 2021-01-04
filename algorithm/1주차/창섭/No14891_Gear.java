/** 2020. 12. 29. 오후 9:07:14
 * @author ventulus95
 */
package codeBaekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;


public class No14891_Gear {
	
	static int gear[][] = new int[4][8];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int i=0; i<4; i++){
			String t = br.readLine();
			for(int j=0; j<8; j++){
				gear[i][j] = t.charAt(j)-'0';
			}
		}
		int n = Integer.parseInt(br.readLine());
		for(int i=0; i<n; i++){
			String[] k = br.readLine().split(" ");
			int g = Integer.parseInt(k[0]);
			int dir = Integer.parseInt(k[1]);
			boolean check1to2 = gear[0][2] == gear[1][6];
			boolean check2to3 = gear[1][2] == gear[2][6];
			boolean check3to4 = gear[2][2] == gear[3][6];
			int arr[] = new int[5];
			if(g==1){
				if(!check1to2){
					rotate(2, dir*-1);
					arr[2] = dir*-1;
					if(!check2to3 && arr[2]!=0){
						rotate(3, arr[2]*-1);
						arr[3] = arr[2]*-1;
						if(!check3to4 && arr[3]!=0){
							rotate(4, arr[3]*-1);
						}
					}
				}
				rotate(g, dir);
			}
			else if(g==2){
				if(!check1to2){
					rotate(1, dir*-1);
				}
				if(!check2to3){
					rotate(3, dir*-1);
					arr[3] = dir*-1;
					if(!check3to4 && arr[3]!=0){
						rotate(4, arr[3]*-1);
						arr[4] = arr[3]*-1;
					}
				}
				rotate(g, dir);
			}
			else if(g==3){
				if(!check3to4){
					rotate(4, dir*-1);
				}
				if(!check2to3){
					rotate(2, dir*-1);
					arr[2] = dir*-1;
					if(!check1to2 && arr[2]!=0){
						rotate(1, arr[2]*-1);
					}
				}
				rotate(g, dir);
			}
			else{
				if(!check3to4){
					rotate(3, dir*-1);
					arr[3] = dir*-1;
					if(!check2to3 && arr[3]!=0){
						rotate(2, arr[3]*-1);
						arr[2] = arr[3]*-1;
						if(!check1to2 && arr[2]!=0){
							rotate(1, arr[2]*-1);
						}
					}
				}
				rotate(g, dir);
			}
		}
		System.out.println(gear[0][0]*1+gear[1][0]*2+gear[2][0]*4+gear[3][0]*8);
	}
	
	public static void rotate(int ge, int dir){
		int g = ge-1;
		if(dir==1){
			int temp = gear[g][7];
			for(int i=6; i>=0; i-- ){
				gear[g][i+1] = gear[g][i];  
			}
			gear[g][0] = temp;
		}
		else{
			int temp = gear[g][0];
			for(int i=1; i<=7; i++ ){
				gear[g][i-1] = gear[g][i];  
			}
			gear[g][7] = temp;
		}
	}

}
