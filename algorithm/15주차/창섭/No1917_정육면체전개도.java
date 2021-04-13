/*
 * 문제 풀이 시작: 2021/04/13 3:47
 * 맞은 시각: 2021/04/13 5:00
 * 소요 시간: 1시간 13분.
 * @author ventulus95
 */
package codeBaekJoon._2021;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No1917_정육면체전개도 {

    static int [][][] defaultMap ={ {{1,0,0,0},{1,1,1,1},{1,0,0,0}}, {{1,0,0,0},{1,1,1,1},{0,1,0,0}}, {{1,0,0,0},{1,1,1,1},{0,0,1,0}}, {{1,0,0,0},{1,1,1,1},{0,0,0,1}},
            {{0,1,0,0},{1,1,1,1},{0,1,0,0}}, {{0,1,0,0},{1,1,1,1},{0,0,1,0}},
            {{1,1,0,0},{0,1,1,1},{0,1,0,0}}, {{1,1,0,0},{0,1,1,1},{0,0,0,1}},{{1,1,0,0},{0,1,1,1},{0,0,1,0}},
            {{1,1,0,0},{0,1,1,0},{0,0,1,1}}, {{1,1,1,0,0},{0,0,1,1,1}}
    };
    static boolean flag;
    static int[][] curr;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int k = 3;
        StringTokenizer st;
        while(k-->0){
            flag = false;
            curr = new int[6][6];
            for (int i = 0; i <6; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                for (int j = 0; j <6; j++) {
                    curr[i][j] = Integer.parseInt(st.nextToken());
                }
            }
//            check(0,0);
            for (int i = 0; i <6; i++) {
                for (int j = 0; j <6; j++) {
                    if(!flag)
                        check(i, j);
                }
            }
            System.out.println(flag?"yes":"no");
        }

    }

    private static void check(int y, int x) {
        for (int[][] arr: defaultMap){
            if(flag)
                break;
            for (int i = 0; i <=8; i++) {
                arr = turn(arr);
                if(i==5){
                    mirror(arr);
                }
                int n = arr.length;
                int m = arr[0].length;
                boolean checker = false;
                for (int j = 0; j <n; j++) {
                    if(checker)
                        break;
                    for (int k = 0; k <m; k++) {
                        if(y+j>=6 || x+k>=6){
                            checker = true;
                            continue;
                        }
                        if(curr[y+j][x+k]!=arr[j][k]){
                            checker = true;
                        }
                    }
                }
                if(!checker) {
                    flag = true;
                }
            }
        }
    }

    private static int[][] mirror(int[][] arr) {
        int n = arr.length;
        int m = arr[0].length;
        for (int i = 0; i <n ; i++) {
            for (int j = 0; j <m/2; j++) {
                int swap = arr[i][j];
                arr[i][j] = arr[i][m-1-j];
                arr[i][m-1-j] = swap;
            }
        }
//        System.out.println("대칭됨!");
        return arr;
    }

    private static int[][] turn(int[][] arr) {
        int n = arr.length;
        int m = arr[0].length;
        int[][] temp = new int[m][n];
        for(int i=0; i<n; i++){
            for (int j = 0; j <m; j++) {
                temp[j][n-1-i] = arr[i][j];
            }
        }
        return temp;
    }


}
