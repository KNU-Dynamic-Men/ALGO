/*
 * 문제 풀이 시작: 2021/05/26 9:14 오전
 * 맞은 시각: 2021/05/26
 * 소요 시간:
 * @author ventulus95
 */
package codeBaekJoon._2021;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class No3020_개똥벌레 {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());
        int[] up = new int[n/2];
        int[] down = new int[n/2];
        for (int i = 0; i <n/2; i++) {
            down[i] = Integer.parseInt(br.readLine());
            up[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(up);
        Arrays.sort(down);
        int min = Integer.MAX_VALUE;
        int cnt =1;
        for (int i = 1; i <=h; i++) {
            int temp = n/2 - lowerBound(down, i);
            temp += n/2 - upperBound(up, h-i);
            if(min==temp)
                cnt++;
            else if(min>temp){
                min = temp;
                cnt =1;
            }
        }
        System.out.println(min+" "+cnt);
    }

    private static int lowerBound(int[] data, int target) {
        int begin = 0;
        int end = data.length;

        while(begin < end) {
            int mid = (begin + end) / 2;

            if(data[mid] >= target) {
                end = mid;
            }
            else {
                begin = mid + 1;
            }
        }
        return end;
    }

    private static int upperBound(int[] data, int target) {
        int begin = 0;
        int end = data.length;

        while(begin < end) {
            int mid = (begin + end) / 2;

            if(data[mid] <= target) {
                begin = mid + 1;
            }
            else {
                end = mid;
            }
        }
        return end;
    }
}