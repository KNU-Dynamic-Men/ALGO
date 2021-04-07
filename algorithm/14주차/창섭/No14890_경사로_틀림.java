/*
 * 문제 풀이 시작: 2021/04/02 10:07 오후
 * 맞은 시각: 2021/04/02
 * 소요 시간: 2시간이 넘어서 -> 걍 새로 다시 짜보는게 좋을듯. (큐로만 짜려다가 망한 케이스)
 * @author ventulus95
 */
package codeBaekJoon._2021;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class No14890_경사로_틀림 {

    static int n, l, cnt=0;
    static int[][] map;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());
        map = new int[n][n];
        for (int i = 0; i <n ; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j <n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for (int i = 0; i <n; i++) {
            //가로
            int hidx= map[i][0];
            Queue<Integer> q = new LinkedList<>();
            q.add(hidx);
            int j = 1;
            int count = 0;
            for ( ;j <n; j++) {
                if(hidx==map[i][j]){
                    q.add(map[i][j]);
                    continue;
                }
                if(hidx-1==map[i][j]) { //내리막으로 경사로를 넣으면.
                    if(count<l)
                        count++;
                    else if (count == l) {
                        hidx=map[i][j];
                        count = 0;
                        q.clear();
                    }
                }
                else if(hidx+1==map[i][j]){ //오르막인경우
                    if(q.size() >= l) {
                        hidx = map[i][j];
                        q.clear();
                    }
                    else{
                        break;
                    }
                }
                else{ //단차가 더 심하게 나면 아예 X
                    break;
                }
            }
            if(j==n&&(count==0||count==l)){
                cnt++;
                System.out.println("가로 "+i+" 번째 줄");
            }

            //세로
            int vidx = map[0][i];
            q = new LinkedList<>();
            q.add(vidx);
            j = 1;
            count = 0;
            for ( ;j <n; j++) {
                if(vidx==map[j][i]){
                    q.add(map[j][i]);
                    continue;
                }
                if(vidx-1==map[j][i]) { //내리막으로 경사로를 넣으면.
                    if(count<l)
                        count++;
                    else if (count == l) {
                        vidx = map[j][i];
                        count = 0;
                        q.clear();
                    }
                }
                else if(vidx+1==map[j][i]){ //오르막인경우
                    if(q.size() >= l) {
                        vidx = map[j][i];
                        q.clear();
                    }
                    else{
                        break;
                    }
                }
                else{ //단차가 더 심하게 나면 아예 X
                    break;
                }
            }
            if(j==n&&(count==0||count==l)){
//            for (; j <n; j++) {
//                if(vidx!=map[j][i]){
//                    if (q.isEmpty()){
//                        q.add(map[j][i]);
//                    }
//                    else{
//                        if(q.peek()!=map[j][i]){ //단차남.
//                            break;
//                        }
//                        else{
//                            if(q.size()<l)
//                                q.add(map[j][i]);
//                            else if(q.size()==l){
//                                vidx = q.peek();
//                                q.clear();
//                            }
//                        }
//                    }
//                }
//            }
//            if((q.isEmpty()||q.size()==l)&&j==n){
                cnt++;
                System.out.println("세로 "+i+" 번째 줄");
            }

        }
        System.out.println(cnt);
    }
}
