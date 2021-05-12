/*
 * 문제 풀이 시작: 2021/05/11 12:03 오전
 * 맞은 시각: 2021/05/11 12:26 오전
 * 소요 시간: 23분
 * @author ventulus95
 */
package codeBaekJoon._2021;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class No2470_두용액 {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i <n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        int start = 0;
        int end = n-1;
        int min = arr[start];
        int max = arr[end];
        int sum = Integer.MAX_VALUE;
        while(start!=end){
            int abs = Math.abs(arr[end] + arr[start]);
            sum = Math.min(sum, abs);
            if(sum== abs){
                max = arr[end];
                min = arr[start];
            }
            if(arr[end]+arr[start]>0) //뜨거운물의 온도를 맞추는거랑 비슷하다.
                end--;
            else{
                start++;
            }
        }
        System.out.println(min+" "+max);
    }
}
