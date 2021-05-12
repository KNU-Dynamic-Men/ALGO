/*
 * 문제 풀이 시작: 2021/05/11 11:55 오전
 * 맞은 시각: 2021/05/11
 * 소요 시간:
 * @author ventulus95
 */
package codeBaekJoon._2021;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No15961_회전초밥 {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n =Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int[] arr = new int[n+1];
        int[] cnt = new int[d+1];
        for (int i = 0; i <n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        int start = 0;
        int end = k-1;
        int sushi = 0;
        for (int i = 0; i <k ; i++) {
            if(cnt[arr[i]]==0) {
                sushi++;
            }
            cnt[arr[i]]++;
        }
        if(cnt[c]==0) {
            cnt[c]++;
            sushi++;
        }
        int answer = sushi;
        while(end<n-1+k){
            if(cnt[arr[(start)%n]]-1==0){
                sushi--;
            }
            cnt[arr[(start)%n]]--;
            start++;
            end++;
            if(end>=n-1+k)
                break;
            if(cnt[arr[end%n]]==0) {
                sushi++;
            }
            cnt[arr[end%n]]++;
            if(cnt[c]==0){
                cnt[c]++;
                sushi++;
            }
            answer = Math.max(sushi, answer);
        }
        System.out.println(answer);
    }
}
