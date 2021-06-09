/*
 * 문제 풀이 시작: 2021/06/09 7:26 오후
 * 맞은 시각: 2021/06/09
 * 소요 시간:
 * @author ventulus95
 */
package codeBaekJoon._2021;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class No10986_나머지합 {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        long[] psum = new long[n];
        HashMap<Long, Integer> map = new HashMap<>();
        st = new StringTokenizer(br.readLine());
        long sum =0;
        for (int i = 0; i <n; i++) {
            long in = Long.parseLong(st.nextToken());
            sum += in;
            psum[i] = sum;
        }
        long cnt = 0;
        for (int i = 0; i <n; i++) {
            if(psum[i]%k==0)
                cnt++;
            cnt += map.getOrDefault(psum[i]%k, 0);
            map.put(psum[i]%k, map.getOrDefault(psum[i]%k, 0)+1);
        }
        System.out.println(cnt);
    }
}
