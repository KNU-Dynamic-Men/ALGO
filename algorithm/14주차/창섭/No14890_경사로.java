/*
 * 문제 풀이 시작: 2021/04/05 2:21 오후
 * 맞은 시각: 2021/04/05 3:25 오후
 * 소요 시간: 1시간 4분
 * @author ventulus95
 */
package codeBaekJoon._2021;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No14890_경사로 {

    static int n, l, cnt=0;
    static int[][] map;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());
        map = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i <n; i++) {
            int hidx= map[i][0];
            int count = 0;
            boolean isDone = true;
            for (int j = 0; j <n; j++) { // 가로
                if(hidx==map[i][j]) // 같은 연속되는 숫자가 나오는 경우.
                    count++;
                else if(hidx-1==map[i][j]){ //내리막
                    int desc = 0;
                    for (int k = j; k<n&&k<j+l; k++) {
                        if(map[i][k]==hidx-1){
                            desc++;
                        }
                    }
                    if(desc!=l){
                        isDone = false;
                        break;
                    }
                    j+=l-1;
                    hidx--;
                    count=0;
                }
                else if(hidx+1==map[i][j]){ //오르막
                    if(count<l){
                        isDone = false;
                        break;
                    }
                    else{
                        hidx=map[i][j];
                        count=1;
                    }
                }
                else{
                    isDone = false;
                    break;
                }
            }
            if (isDone){
                cnt++;
                System.out.println("가로 "+i+" 번째 줄은 가능");
            }
            int vidx= map[0][i]; //세로
            int vcount = 0;
            boolean isvDone = true;
            for (int j = 0; j <n; j++) {
                if(vidx==map[j][i]) // 같은 연속되는 숫자가 나오는 경우.
                    vcount++;
                else if(vidx-1==map[j][i]){ //내리막
                    int desc = 0;
                    for (int k = j; k<n&&k<j+l; k++) {
                        if(map[k][i]==vidx-1){
                            desc++;
                        }
                    }
                    if(desc!=l){
                        isvDone = false;
                        break;
                    }
                    j+=l-1;
                    vidx--;
                    vcount=0;
                }
                else if(vidx+1==map[j][i]){ //오르막
                    if(vcount<l){
                        isvDone = false;
                        break;
                    }
                    else{
                        vidx=map[j][i];
                        vcount=1;
                    }
                }
                else{
                    isvDone = false;
                    break;
                }
            }
            if (isvDone){
                cnt++;
                System.out.println("ㅅㅔ로 "+i+" 번째 줄은 가능");
            }
        }
        System.out.println(cnt);
    }
}
