/*
 * 문제 풀이 시작: 2021/05/17 6:44 오후
 * 맞은 시각: 2021/05/17
 * 소요 시간:
 * @author ventulus95
 */
package codeBaekJoon._2021;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No13397_구간나누기2 {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        int max = Integer.MIN_VALUE;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i <n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            max = Math.max(arr[i], max);
        }
        int left = 0;
        int right = Integer.MAX_VALUE;
        while(left<=right){
            int mid = (left+right)/2;
            int cnt =1;
            int mxn = 0;
            int mnn = 10001;
            for (int i = 0; i <n; i++) {
                if(mxn<arr[i]) mxn = arr[i];
                if(mnn>arr[i]) mnn = arr[i];
                if(mxn-mnn>mid){
                    cnt++;
                    mxn = arr[i];
                    mnn = arr[i];
                }
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
