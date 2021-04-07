/*
 * 문제 풀이 시작: 2021/03/31 9:26 오전
 * 맞은 시각: 2021/03/31 10:00 오전
 * 소요 시간: 34분
 * @author ventulus95
 */
package codeBaekJoon._2021;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class No16926_배열돌리기1 {

    static int n,m;
    static int[][] map;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        for (int i = 0; i <n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j <m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        ArrayList<LinkedList<Integer>> group = new ArrayList<>();
        int groupNum = Math.min(n,m)/2;
        //그룹지어서 뽑아내기.
        for (int k = 0; k<groupNum; k++) {
            group.add(new LinkedList<>());
            LinkedList<Integer> g = group.get(k);
            for (int i = k; i <=m-2-k; i++) {
                g.add(map[k][i]);
            }
            for (int i = k; i <=n-2-k; i++) {
                g.add(map[i][m-1-k]);
            }
            for(int i=m-1-k; i>=k+1; i--){
                g.add(map[n-1-k][i]);
            }
            for (int i=n-1-k; i>=k+1 ; i--) {
                g.add(map[i][k]);
            }
        }
        //회전하는것.
        for (int k = 0; k<groupNum; k++) {
            LinkedList<Integer> g = group.get(k);
            int grotate = r%g.size();
            for (int i = 0; i <grotate; i++) {
                int first = g.removeFirst();
                g.addLast(first);
            }
        }
        //다시 집어넣기.
        for (int k = 0; k<groupNum; k++) {
            LinkedList<Integer> g = group.get(k);
            for (int i = k; i <=m-2-k; i++) {
                map[k][i] = g.removeFirst();
            }
            for (int i = k; i <=n-2-k; i++) {
                map[i][m-1-k] = g.removeFirst();
            }
            for(int i=m-1-k; i>=k+1; i--){
                map[n-1-k][i]  = g.removeFirst();
            }
            for (int i=n-1-k; i>=k+1 ; i--) {
                map[i][k] = g.removeFirst();
            }
        }
        for (int i = 0; i <n ; i++) {
            for (int j = 0; j <m; j++) {
                if(j!=m-1)
                    System.out.print(map[i][j]+" ");
                else
                    System.out.println(map[i][j]);
            }

        }
    }
}
