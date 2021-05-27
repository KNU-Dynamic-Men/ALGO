/*
 * 문제 풀이 시작: 2021/05/26 2:04 오후
 * 맞은 시각: 2021/05/26
 * 소요 시간:
 * @author ventulus95
 */
package codeBaekJoon._2021;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class No9007_카누선수 {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringTokenizer st;
        while(t-->0){
            st = new StringTokenizer(br.readLine());
            int target = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            int[][] arr = new int[4][k];
            for (int i = 0; i <4; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j <k; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            ArrayList<Integer> list1 = new ArrayList<>();
            ArrayList<Integer> list2 = new ArrayList<>();
            for (int i = 0; i <k; i++) {
                for (int j = 0; j <k; j++) { //일단 두개 골라두고
                    list1.add(arr[0][i]+arr[1][j]);
                    list2.add(arr[2][i]+arr[3][j]);
                }
            }
            list1.sort(Integer::compareTo);
            list2.sort(Integer::compareTo);

        }
    }
}
