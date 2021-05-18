/*
 * 문제 풀이 시작: 2021/05/16 9:43 오후
 * 맞은 시각: 2021/05/16
 * 소요 시간:
 * @author ventulus95
 */
package codeBaekJoon._2021;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class No2473_세용액 {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long[] arr = new long[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i <n; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }
        Arrays.sort(arr);
        long min = Long.MAX_VALUE;
        long[] answer = new long[3];
        for (int i = 0; i <n-2; i++) {
            long k = arr[i];
            int left = i+1;
            int right = n-1;
            while(left<right){
                 long sum = arr[left]+arr[right]+k;
                 if(min>Math.abs(sum)){
                     min= Math.abs(sum);
                     answer = new long[]{k, arr[left], arr[right]};
                 }
                 if(sum>0){
                     right--;
                 }
                 else{
                    left++;
                 }
            }
        }
        System.out.println(Arrays.toString(answer));

    }
}
