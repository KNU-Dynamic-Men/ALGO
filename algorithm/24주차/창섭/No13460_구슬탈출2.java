/*
 * 문제 풀이 시작: 2021/06/16 5:50 오후
 * 맞은 시각: 2021/06/16
 * 소요 시간:
 * @author ventulus95
 */
package codeBaekJoon._2021;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class No13460_구슬탈출2 {

    static int n,m;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        char[][] map = new char[n][m];
        for (int i = 0; i <n; i++) {
            map[i] = br.readLine().toCharArray();
        }
        System.out.println(bfs(map));
    }

    private static int bfs(char[][] map) {
        Queue<Board> q = new LinkedList<>();
        q.add(new Board(map, 0));
        while(!q.isEmpty()){
            Board curr = q.poll();
            if(curr.count>=10)
                return -1;
            for (int i = 0; i <4; i++) {
                char[][] slopeMap = slope(curr.map, i);
                int status = isPossible(slopeMap);
                if(status==1){
                    q.add(new Board(slopeMap, curr.count+1));
                }
                else if(status==2){
                    return curr.count+1;
                }
            }
        }
        return -1;
    }

    private static int isPossible(char[][] map) {
        int r=0; int b =0;
        for (char[] arr: map) {
            for (char a: arr) {
                if(a=='R')
                    r++;
                else if(a=='B')
                    b++;
            }
        }
        if(r==0&&b==0)
            return -1;
        else if (r==1&b==1)
            return 1;
        else if(r==0&&b==1)
            return 2;
        else
            return -1;
    }

    private static char[][] slope(char[][] map1, int dir) {
        char[][] map = new char[n][m];
        for (int i = 0; i <n; i++) {
            System.arraycopy(map1[i], 0, map[i], 0, m);
        }
        if(dir<2){ //가로일때
            for (int i = 0; i <n; i++) {
                if(dir==0){ // 오른쪽
                    for (int j = m-1; j>=0; j--) {
                        if(map[i][j]=='R' || map[i][j]=='B'){
                            char c = map[i][j];
                            map[i][j]='.';
                            for (int k = j; k<m; k++) {
                               if(map[i][k]!='.'){
                                    if(map[i][k]!='O')
                                        map[i][k-1] = c;
                                    break;
                                }
                            }
                        }
                    }
                }
                else{
                    for (int j = 0; j <m; j++) {
                        if(map[i][j]=='R' || map[i][j]=='B'){
                            char c = map[i][j];
                            map[i][j]='.';
                            for (int k = j; k>=0; k--) {
                                if(map[i][k]!='.'){
                                    if(map[i][k]!='O')
                                        map[i][k+1] = c;
                                    break;
                                }
                            }
                        }
                    }
                }
            }
        }
        else{//세로일때
            for (int i = 0; i <m; i++) {
                if(dir==2) { //아래
                    for (int j = n-1; j>=0; j--) {
                        if(map[j][i]=='R' || map[j][i]=='B'){
                            char c = map[j][i];
                            map[j][i]='.';
                            for (int k = j; k<n; k++) {
                                if(map[k][i]!='.'){
                                    if(map[k][i]!='O')
                                        map[k-1][i] = c;
                                    break;
                                }
                            }
                        }
                    }
                }
                else{ //위
                    for (int j = 0; j <n; j++) {
                        if(map[j][i]=='R' || map[j][i]=='B'){
                            char c = map[j][i];
                            map[j][i]='.';
                            for (int k = j; k>=0; k--) {
                                if(map[k][i]!='.'){
                                    if(map[k][i]!='O')
                                        map[k+1][i] = c;
                                    break;
                                }
                            }
                        }
                    }
                }
            }
        }
        return map;
    }

    static class Board{
        char[][] map;
        int count;

        public Board(char[][] map, int count) {
            this.map = map;
            this.count = count;
        }
    }
}
