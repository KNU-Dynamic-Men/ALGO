/*
 * 문제 풀이 시작: 2021/05/18 4:30 오전
 * 맞은 시각: 2021/05/18 5:11
 * 소요 시간: 2일쯤? 풀다 말다 풀다말다 했음.
 * @author ventulus95
 */
package codeBaekJoon._2021;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class No1477_휴게소세우기 {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());
        int[] arr = new int[n+2];
        st = new StringTokenizer(br.readLine());
        arr[0] = 0;
        for (int i = 1; i <=n; i++) {
            arr[i]= Integer.parseInt(st.nextToken());
        }
        arr[n+1] = l;
        Arrays.sort(arr);
        int left = 1;
        int right= l-1;
        while(left<=right){
            int mid = (left+right)/2;
            int cnt = 0;
            for (int i = 1; i <n+2; i++) {
                int div = arr[i]-arr[i-1]-1;
                cnt += div/mid;
            }
            if(cnt>m){
                left = mid+1;
            }
            else{
                right = mid-1;
            }
        }
        System.out.println(left);
    }
}
