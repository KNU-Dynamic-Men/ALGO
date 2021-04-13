/*
 * 문제 풀이 시작: 2021/04/13 10:30 오후
 * 맞은 시각: 2021/04/12 12:30 오후
 * 소요 시간:2시간 답지 도움 많이 받음.
 * @author ventulus95
 */
package codeBaekJoon._2021;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No20327_배열돌리기6 {

    static int n, k;
    static int[][] map;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        n = pow(n);
        map = new int[n][n];
        for (int i = 0; i <n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j <n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        while(k-->0){
            st = new StringTokenizer(br.readLine(), " ");
            int r = Integer.parseInt(st.nextToken());
            int l = Integer.parseInt(st.nextToken());
            int size = pow(l);
            if(r<5){
                for (int j = 0; j <n; j+=size) {
                    for (int k = 0; k <n; k+=size) {
                        int[][] part = new int[size][size];
                        for (int m = 0; m <size; m++) {
                            for (int o = 0; o <size; o++) {
                                part[m][o] = map[j+m][k+o];
                            }
                        }
                        part = partRoll(r, part);
                        for (int m = 0; m <size; m++) {
                            for (int o = 0; o <size; o++) {
                                map[j+m][k+o] = part[m][o];
                            }
                        }
                    }
                }
            }
            else{
                roll(r, l);
            }
        }
        for (int[] arr : map){
            for (int idx: arr){
                System.out.print(idx+" ");
            }
            System.out.println();
        }
    }

    private static void roll(int r, int l) {
        int size = pow(l);
        int[][] curr = new int[n][n];
        for (int i = 0; i <n; i++) {
            for (int j = 0; j <n; j++) {
                curr[i][j] = map[i][j];
            }
        }
        switch (r){
            case 5:
                for (int i = 0; i <n; i+=size) {
                    for (int j = 0; j <n; j+=size) {
                        int term = n-i-size;
                        for (int o = 0; o <size; o++) {
                            for (int m = 0; m <size; m++) {
                                map[i+m][j+o] = curr[term+m][j+o];

                            }
                        }
                    }
                }
                break;
            case 6:
                for (int i = 0; i <n; i+=size) {
                    for (int j = 0; j <n; j+=size) {
                        int term = n-size-j;
                        for (int m = 0; m <size; m++) {
                            for (int o = 0; o <size; o++) {
                                map[i+m][j+o] = curr[i+m][term+o];
                            }
                        }

                    }
                }
                break;
            case 7:
                for (int i = 0; i <n; i+=size) {
                    for (int j = 0; j <n; j+=size) {
                        int term = n-i-size;
                        for (int m = 0; m <size; m++) {
                            for (int o = 0; o <size; o++) {
                                map[j+m][term+o] = curr[i+m][j+o];
                            }
                        }
                    }
                }
                break;
            case 8:
                for (int i = 0; i <n; i+=size) {
                    for (int j = 0; j <n; j+=size) {
                        int term = n-size-j;
                        for (int m = 0; m <size; m++) {
                            for (int o = 0; o <size; o++) {
                                map[term+m][i+o] = curr[i+m][j+o];
                            }
                        }
                    }
                }
                break;
        }
    }

    private static int[][] partRoll(int r, int[][] part) {
        int n = part.length;
        int[][] temp = new int[n][n];
        switch (r){
            case 1:
                for (int j = 0; j <n; j++) {
                    for(int i=0; i<n; i++){
                        temp[i][j] = part[n-1-i][j];
                    }
                }
                return temp;
            case 2:
                for(int i=0; i<n; i++){
                    for (int j = 0; j <n; j++) {
                        temp[i][j] = part[i][n-1-j];
                    }
                }
                return temp;
            case 3:
                for(int i=0; i<n; i++){
                    for (int j = 0; j <n; j++) {
                        temp[j][n-1-i] = part[i][j];
                    }
                }
                return temp;
            case 4:
                for(int i=0; i<n; i++){
                    for (int j = 0; j <n; j++) {
                        temp[n-1-j][i] = part[i][j];
                    }
                }
                return temp;
        }
        return temp;
    }


    private static int pow(int n) {
        int sum = 1;
        for(int i=0; i<n; i++){
            sum*=2;
        }
        return sum;
    }
}
