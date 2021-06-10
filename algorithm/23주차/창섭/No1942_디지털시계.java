/*
 * 문제 풀이 시작: 2021/06/09 10:27 오전
 * 맞은 시각: 2021/06/09
 * 소요 시간:
 * @author ventulus95
 */
package codeBaekJoon._2021;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No1942_디지털시계 {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        for (int i = 0; i <3; i++) {
            st = new StringTokenizer(br.readLine());
            int[] start = new int[3];
            StringTokenizer stoken = new StringTokenizer(st.nextToken(), ":");
            for (int j = 0; j <3; j++) {
                start[j] = Integer.parseInt(stoken.nextToken());
            }
            StringTokenizer etoken = new StringTokenizer(st.nextToken(), ":");
            int[] end = new int[3];
            for (int j = 0; j <3; j++) {
                end[j] = Integer.parseInt(etoken.nextToken());
            }
            int cnt =0;
            while (!check(start, end)) {
                if(wordcheck(start))
                    cnt++;
                start[2]++;
                if (start[2] == 60) {
                    start[2] = 0;
                    start[1]++;
                    if (start[1] == 60) {
                        start[1] = 0;
                        start[0]++;
                        if (start[0] == 24) {
                            start[0] = 0;
                        }
                    }
                }
            }
            if(wordcheck(end))
                cnt++;
            System.out.println(cnt);
        }
    }

    private static boolean wordcheck(int[] arr) {
        StringBuilder sb = new StringBuilder();
        sb.append(arr[0]).append(arr[1]).append(arr[2]);
        if(Integer.parseInt(sb.toString())%3==0)
            return true;
        return false;
    }

    private static boolean check(int[] start, int[] end) {
        for (int i = 0; i <3; i++) {
            if(start[i]!=end[i])
                return false;
        }
        return true;
    }

}
