/*
 * 문제 풀이 시작: 2021/04/08 8:37 오후
 * 맞은 시각: 2021/04/08 10:10 오후
 * 소요 시간: 1시간 33분
 * @author ventulus95
 */
package codeBaekJoon._2021;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
//중복 발생 케이스
/*3 3 1 1
1 2 3 0
4 6 8 3
7 12 14 6
0 7 8 9*/
/*4 4 1 1
1 1 1 1 0
1 2 2 2 1
1 2 2 2 1
1 2 2 2 1
0 1 1 1 1*/
public class No19967_배열복원하기 {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int h = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int[][] map = new int[h+x][w+y];
        int[][] arr = new int[h][w];
        for (int i = 0; i <h+x; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j <w+y; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for (int i = 0; i <h+x; i++) {
            for (int j = 0; j <w+y; j++) {
                boolean flag1 = false;
                boolean flag2 = false;
                if((i>=0&&i<h)&&(j>=0&&j<w)) //이동전 이차원 배열에 있음.
                    flag1 = true;
                if((i>=x&&i<h+x)&&(j>=y&&j<w+y)) //이동후 이차원 배열에 있음.
                    flag2 = true;
                if(flag1){
                    if(flag2){ //tt
                        arr[i][j] = map[i][j];
                        arr[i][j] -= arr[i-x][j-y];
                    }
                    else{ //t f
                        arr[i][j] = map[i][j];
                    }
                }
                else{
                    if(flag2){ // f t
                        arr[i-x][j-y] = map[i][j];
                    }
                }
            }
        }
        for(int[] ver: arr){
            for (int i: ver){
                System.out.print(i+" ");
            }
            System.out.println();
        }
    }
}
