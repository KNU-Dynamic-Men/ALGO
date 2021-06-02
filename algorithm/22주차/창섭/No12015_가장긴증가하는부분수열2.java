/*
 * 문제 풀이 시작: 2021/05/28 10:53 오후
 * 맞은 시각: 2021/05/28
 * 소요 시간:
 * @author ventulus95
 */
package codeBaekJoon._2021개인적;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class No12015_가장긴증가하는부분수열2 {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        for (int i = 0; i <n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int idx=0;
        for (int i = 0; i <n; i++) {
            if(i==0){
                dp[0] = arr[0];
                idx++;
            }
            else{
                if(dp[idx-1]<arr[i]){
                    dp[idx] = arr[i];
                    idx++;
                }
                else{ // 인덱스 범위안에서  자기가 대처될만한 공간을 비집고 들어가자. 그모양이 실제로 만들어질 수 있는 배열 모양이 아니더라도...
                    int left = 0;
                    int right= idx-1;
                    while(left<right){
                        int mid = (left+right)/2;
                        if(dp[mid]<arr[i]){
                            left = mid+1;
                        }
                        else{
                            right = mid;
                        }
                    }
                    dp[left] = arr[i];
                }
            }
        }
        int cnt = 0;
        for(int c: dp)
            if(c>0) cnt++;
        System.out.println(cnt);
    }
}
