/*
 * 문제 풀이 시작: 2021/06/05 3:39 오후
 * 맞은 시각: 2021/06/05
 * 소요 시간:
 * @author ventulus95
 */
package codeBaekJoon._2021;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class No11687_팩토리얼0의갯수 {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int sum =0;
        for (int i = 1; i <100000000; i++) {
            int tmp = i;
            int num = 1;
            while (tmp % 5 == 0) {
                num++;
                tmp /= 5;
            }
            sum += num;
            if (sum == n) {
                System.out.println(5 * i);
                return;
            }
            else if (sum > n) {
                System.out.println(-1);
                return;
            }
        }
    }
}
