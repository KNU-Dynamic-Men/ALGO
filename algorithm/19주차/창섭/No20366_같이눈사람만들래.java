/*
 * 문제 풀이 시작: 2021/05/12 3:14 오후
 * 맞은 시각: 2021/05/11 ?
 * 소요 시간:
 * @author ventulus95
 */
package codeBaekJoon._2021;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class No20366_같이눈사람만들래 {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i <n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i <n; i++) {
            for (int j = i+3; j <n; j++) {
                int left = i+1;
                int right = j-1;
                while(left<right){
                    int diff = (arr[i]+arr[j])- (arr[left]+arr[right]);
                    if(Math.abs(diff)<Math.abs(ans)){
                        ans = Math.abs(diff);
                    }
                    if(diff<0){
                        right--;
                    }
                    else{
                        left++;
                    }
                }
            }
        }
        System.out.println(ans);

    }
}
