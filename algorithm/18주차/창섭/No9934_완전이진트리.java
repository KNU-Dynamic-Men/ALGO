/*
 * 문제 풀이 시작: 2021/05/01 10:51 오후
 * 맞은 시각: 2021/05/01 11:40 오후
 * 소요 시간: 1시간
 * @author ventulus95
 */
package codeBaekJoon._2021;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class No9934_완전이진트리 {

    static int[] level;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        level = new int[(int)Math.pow(2, n)-1];
        int start = 0;
        int idx = 0;
        for (int i = n-1; i>=0 ; i--) {
            for (int j =start; j < level.length; j+=(int)Math.pow(2, idx+1)) {
                level[j] = i;
            }
            start+=(int)Math.pow(2, idx);
            idx++;
        }
        System.out.println(Arrays.toString(level));
        StringTokenizer st = new StringTokenizer(br.readLine());
        ArrayList<Integer>[] list = new ArrayList[n];
        for (int i = 0; i <n; i++) {
            list[i] = new ArrayList<>();
        }
        for (int i = 0; i < level.length; i++) {
            list[level[i]].add(Integer.parseInt(st.nextToken()));
        }
        for (int i = 0; i <n; i++) {
            for (int k: list[i]){
                System.out.print(k+" ");
            }
            System.out.println();
        }
    }
}
