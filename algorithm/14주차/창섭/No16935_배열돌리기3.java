/*
 * 문제 풀이 시작: 2021/04/05 5:19 오후
 * 맞은 시각: 2021/04/05
 * 소요 시간:
 * @author ventulus95
 */
package codeBaekJoon._2021;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class No16935_배열돌리기3 {
    static int n, m,r ;
    static ArrayList<int[][]> round = new ArrayList<>();

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        round.add(new int[n][m]);
        int[][] map = round.get(0);
        for (int i = 0; i <n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j <m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i <r; i++) {
            int pos = Integer.parseInt(st.nextToken());
            roll(i, pos);
        }
        int[][] cm = round.get(r);
        for(int[] arr: cm){
            for(int idx: arr){
                System.out.print(idx+" ");
            }
            System.out.println();
        }

    }

    private static void roll(int num, int pos) {
        int n = round.get(num).length;
        int m = round.get(num)[0].length;
        switch (pos){
            case 1:
                round.add(new int[n][m]);
                for (int j = 0; j <m; j++) {
                    for(int i=0; i<n; i++){
                        round.get(num+1)[i][j] = round.get(num)[n-1-i][j];
                    }
                }
                break;
            case 2:
                round.add(new int[n][m]);
                for(int i=0; i<n; i++){
                    for (int j = 0; j <m; j++) {
                        round.get(num+1)[i][j] = round.get(num)[i][m-1-j];
                    }
                }
                break;
            case 3:
                round.add(new int[m][n]);
                for(int i=0; i<n; i++){
                    for (int j = 0; j <m; j++) {
                        round.get(num+1)[j][n-1-i] = round.get(num)[i][j];
                    }
                }
                break;
            case 4:
                round.add(new int[m][n]);
                for(int i=0; i<n; i++){
                    for (int j = 0; j <m; j++) {
                        round.get(num+1)[m-1-j][i] = round.get(num)[i][j];
                    }
                }
                break;
            case 5:
                round.add(new int[n][m]);
                for(int i=0; i<n/2; i++){ //1->2
                    for (int j = 0; j <m/2; j++) {
                        round.get(num+1)[i][j+m/2] = round.get(num)[i][j];
                    }
                }
                for(int i=0; i<n/2; i++){ //2->3
                    for (int j = m/2; j <m; j++) {
                        round.get(num+1)[i+n/2][j] = round.get(num)[i][j];
                    }
                }
                for(int i=n/2; i<n; i++){ //3->4
                    for (int j = m/2; j <m; j++) {
                        round.get(num+1)[i][j-m/2] = round.get(num)[i][j];
                    }
                }
                for(int i=n/2; i<n; i++){ //4->1
                    for (int j = 0; j <m/2; j++) {
                        round.get(num+1)[i-n/2][j] = round.get(num)[i][j];
                    }
                }
                break;
            case 6:
                round.add(new int[n][m]);
                for(int i=0; i<n/2; i++){ //1->4
                    for (int j = 0; j <m/2; j++) {
                        round.get(num+1)[i+n/2][j] = round.get(num)[i][j];
                    }
                }
                for(int i=n/2; i<n; i++){ //4->1
                    for (int j = 0; j <m/2; j++) {
                        round.get(num+1)[i][j+m/2] = round.get(num)[i][j];
                    }
                }
                for(int i=n/2; i<n; i++){ //3->2
                    for (int j = m/2; j <m; j++) {
                        round.get(num+1)[i-n/2][j] = round.get(num)[i][j];
                    }
                }
                for(int i=0; i<n/2; i++){ //2->1
                    for (int j = m/2; j <m; j++) {
                        round.get(num+1)[i][j-m/2] = round.get(num)[i][j];
                    }
                }
                break;
        }
    }
}
