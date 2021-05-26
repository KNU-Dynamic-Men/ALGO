/*
 * 문제 풀이 시작: 2021/05/26 2:25 오후
 * 맞은 시각: 2021/05/26
 * 소요 시간:
 * @author ventulus95
 */
package codeBaekJoon._2021;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No2467_용액 {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int  n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i <n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int left = 0;
        int right = n-1;
        int sum = Integer.MAX_VALUE;
        int[] ans = new int[2];
        while(left<right){
            int abs = Math.abs(arr[left]+arr[right]);
            if(abs<sum){
                sum = abs;
                ans[0] = arr[left];
                ans[1] = arr[right];
            }
            if(arr[left]+arr[right]>0) right--;
            else left++;
        }
        System.out.println(ans[0]+" "+ans[1]);
    }
}
