/*
 * 문제 풀이 시작: 2021/05/11 10:29 오전
 * 맞은 시각: 2021/05/11 11:05 오전
 * 소요 시간: 36분
 * @author ventulus95
 */
package codeBaekJoon._2021;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No1806_부분합 {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i <n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int start = 0;
        int end =1;
        int sum = arr[start];
        int length = Integer.MAX_VALUE;
        while(start<end){
            if(sum>=s){
                sum-=arr[start];
                start++;
                length = Math.min(length, end-start+1);
            }
            else{
                if(end<n) {
                    sum += arr[end];
                    end++;
                }
                else{
                    sum-=arr[start];
                    start++;
                }
            }
        }
        System.out.println(length==Integer.MAX_VALUE?0:length);

    }
}
