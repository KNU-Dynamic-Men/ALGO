/*
 * 문제 풀이 시작: 2021/04/03 12:15 오전
 * 맞은 시각: 2021/04/03 1:13 오전
 * 소요 시간: 58분
 * @author ventulus95
 */
package codeBaekJoon._2021;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No15662_톱니바퀴2 {

    static int t;
    static int[][] arr;
    static boolean[] turned;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        t = Integer.parseInt(br.readLine());
        arr = new int[t][8];
        for (int i = 0; i <t ; i++) {
            String tc = br.readLine();
            for (int j = 0; j <tc.length() ; j++) {
                arr[i][j]  = tc.charAt(j)-'0';
            }
        }
        int k = Integer.parseInt(br.readLine());
        StringTokenizer st;
        while(k-->0){
            st = new StringTokenizer(br.readLine(), " ");
            int n = Integer.parseInt(st.nextToken())-1;
            int dir = Integer.parseInt(st.nextToken());
            turned = new boolean[t];
            turn(n, dir);

        }
        int answer= 0;
        for (int i = 0; i <t; i++) {
            if(arr[i][0]==1)
                answer++;
        }
        System.out.println(answer);
    }

    private static void turn(int n, int dir) {
        turned[n] = true;
        if(n==0){
            if(!turned[1]&&arr[0][2]!=arr[1][6]){
                turn(n+1, dir*-1);
            }
        }
        else if(n==t-1){
            if(!turned[t-2]&&arr[t-1][6]!=arr[t-2][2]){
                turn(n-1, dir*-1);
            }
        }
        else{
            if(!turned[n+1]&&arr[n][2]!=arr[n+1][6]){
                turn(n+1, dir*-1);
            }
            if(!turned[n-1]&&arr[n][6]!=arr[n-1][2]){
                turn(n-1, dir*-1);
            }
        }
        if(dir==1){ //시계
            int swap = arr[n][7];
            for (int i = 7; i>0; i--) {
                arr[n][i] = arr[n][i-1]; // -> 시계방향의 커멘드를 잘못짬.
            }
            arr[n][0] = swap;
        }
        if(dir==-1) { //반시계
            int swap = arr[n][0];
            for (int i = 0; i<7; i++) {
                arr[n][i] = arr[n][i+1];
            }
            arr[n][7] = swap;
        }

    }
}
