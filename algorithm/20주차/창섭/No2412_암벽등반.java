/*
 * 문제 풀이 시작: 2021/05/17 11:53 오후
 * 맞은 시각: 2021/05/17
 * 소요 시간:
 * @author ventulus95
 */
package codeBaekJoon._2021;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No2412_암벽등반 {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());
        int left = 0;
        int right = Integer.MAX_VALUE;
        while(left<=right){//최소 이동횟수 찾는건 알겠는데....
            int mid = (right+left)/2;


        }

    }
}
