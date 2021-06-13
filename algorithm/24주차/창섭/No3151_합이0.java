/*
 * 문제 풀이 시작: 2021/05/11 11:15 오전
 * 맞은 시각: 2021/05/11
 * 소요 시간: 해답 참조. -> 30분 걸림.
 * @author ventulus95
 */
package codeBaekJoon._2021;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class No3151_합이0 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine().replaceAll(" ",""));
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i <n; i++) {
            arr[i] =Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        int start = 0;
        int cnt =0;
        while(start<n-2){
            int left= start+1;
            int right = n-1;
            int sum = arr[start]*-1;
            int idx = n;
            while(left<right){
                int other = arr[left]+arr[right];
                if(other>sum){
                    right--;
                }
                else if(other<sum){
                    left++;
                }
                else{
                    if(arr[left]==arr[right]) {
                        cnt += right - left; // 둘이 같으면, 퉁치면 댐. 
                    }
                    else{
                        if(idx>right){
                            idx=right; //현재 R과 같은 값을 가지는 게 몇개 있는지 체크
                            while(idx>=0 && arr[idx-1]==arr[right])
                                idx--;
                        }
                        cnt+=right-idx+1;
                    }
                    left++;
                }
            }
            start++;
        }
        System.out.println(cnt);
    }
}
