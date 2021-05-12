/*
 * 문제 풀이 시작: 2021/05/10 11:29 오후
 * 맞은 시각: 2021/05/11 12:00 오전
 * 소요 시간: 31분
 * @author ventulus95
 */
package codeBaekJoon._2021;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class No20922_겹치는건싫어 {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i <n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int start = 0;
        int end = 0;
        int length = 0;
        while(start<=end){
            if(start>=n||end>=n)
                break;
            map.putIfAbsent(arr[end], 0);
            int val = map.get(arr[end]);
            map.replace(arr[end], val+1);
            while(map.get(arr[end])>k){
                int value =map.get(arr[start]);
                map.replace(arr[start], value-1);
                start++;
            }
            end++;
            length = Math.max(length, end-start);
        }
        System.out.println(length);
    }

}
