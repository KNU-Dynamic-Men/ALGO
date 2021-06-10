/*
 * 문제 풀이 시작: 2021/06/05 2:02 오후
 * 맞은 시각: 2021/06/05
 * 소요 시간:
 * @author ventulus95
 */
package codeBaekJoon._2021;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class No1269_대칭차집합 {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int cnt = a+b;
        st = new StringTokenizer(br.readLine());
        HashMap<Integer, Integer> A = new HashMap<>();
        for (int i = 0; i <a; i++) {
            A.put(Integer.parseInt(st.nextToken()), 1);
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i <b; i++) {
            if(A.getOrDefault(Integer.parseInt(st.nextToken()), -1) != -1){
                cnt-=2;
            }
        }
        System.out.println(cnt);
    }
}
