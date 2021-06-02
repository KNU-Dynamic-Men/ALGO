/*
 * 문제 풀이 시작: 2021/06/02 2:04 오후
 * 맞은 시각: 2021/06/02
 * 소요 시간:
 * @author ventulus95
 */
package codeBaekJoon._2021;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 합친LIS {

    static int[][] cache;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int c = Integer.parseInt(br.readLine());
        StringTokenizer st;
        while (c-->0){
            st = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());
            cache = new int[n1+1][n2+1];
            for (int i = 0; i <n1+1; i++) {
                Arrays.fill(cache[i], -1);
            }
            int[] arr1 = new int[n1];
            int[] arr2 = new int[n2];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i <n1; i++) {
                arr1[i] = Integer.parseInt(st.nextToken());
            }
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i <n2; i++) {
                arr2[i] = Integer.parseInt(st.nextToken());
            }
            int answer = getMax(-1, -1, arr1, arr2) -2;
            System.out.println(answer);
        }
    }

    private static int getMax(int a, int b, int[] arr1, int[] arr2) {
        if(cache[a+1][b+1]!=-1) return cache[a+1][b+1];
        long am = a==-1?Long.MIN_VALUE: arr1[a];
        long bm = b==-1?Long.MIN_VALUE: arr2[b];
        long max = Math.max(am, bm);
        int sum = 2;
        for (int i = a+1; i <arr1.length; i++) {
            if(max< arr1[i])
                sum = Math.max(sum, getMax(i, b, arr1, arr2)+1);
        }
        for (int i = b+1; i <arr2.length; i++) {
            if(max< arr2[i])
                sum = Math.max(sum, getMax(a, i, arr1, arr2)+1);
        }
        cache[a+1][b+1] = sum;
        return sum;
    }
}
