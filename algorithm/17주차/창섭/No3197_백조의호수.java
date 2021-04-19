/*
 * 문제 풀이 시작: 2021/04/17 6:21 오후
 * 맞은 시각: 2021/04/18 10:24 오후
 * 소요 시간: 2시간 반 + 알파(시작하고 나서 밥먹고 뭐하고 그랬음.)
 * @author ventulus95
 */
package codeBaekJoon._2021;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
/*3 3
LXX
XXX
XXL*/
public class No3197_백조의호수 {

    static int n,m,answer=0;
    static char[][] map;
    static boolean[][] svisited;
    static int[][] visited;
    static int[] dx = {0,0,1,-1};
    static int[] dy = {1,-1,0,0};
    static Queue<node> q = new LinkedList<>();
    static Queue<node> swan = new LinkedList<>();
    static int sy=-1, sx=-1, ey=-1, ex=-1;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new char[n][m];
        visited = new int[n][m];
        svisited = new boolean[n][m];
        for (int i = 0; i <n; i++) {
            String tc = br.readLine();
            for (int j = 0; j <m; j++) {
                map[i][j] = tc.charAt(j);
                if(map[i][j]=='L'){
                    q.add(new node(i, j));
                    if(sy==-1){
                        sy=i;
                        sx=j;
                        swan.add(new node(i,j));
                        svisited[i][j] = true;
                    }
                    else{
                        ey=i;
                        ex=j;
                    }
                }
                if(map[i][j] == '.'){
                    q.add(new node(i, j));
                }
            }
        }
        swan = moveSwan();
        q = meltIce();
        while(!svisited[ey][ex]){
            q = meltIce();
            swan = moveSwan();
            answer++;
        }
        System.out.println(answer);
    }

    private static Queue<node> moveSwan() {
        Queue<node> boundswan = new LinkedList<>();
        while (!swan.isEmpty()){
            node curr = swan.poll();
            for (int i = 0; i <4; i++) {
                int ny = curr.y+dy[i];
                int nx = curr.x+dx[i];
                if(ny<0|| ny>=n || nx<0 || nx>=m) continue;
                if(!svisited[ny][nx]){
                    svisited[ny][nx] = true;
                    if(map[ny][nx]=='X'){
                        boundswan.add(new node(ny,nx));
                        continue;
                    }
                    swan.add(new node(ny,nx));
                }
            }
        }
        return boundswan;
    }

    private static Queue<node> meltIce() {
        Queue<node> boundIce = new LinkedList<>();
        while (!q.isEmpty()){
            node curr = q.poll();
            map[curr.y][curr.x] = '.';
            for (int i = 0; i <4; i++) {
                int ny = curr.y+dy[i];
                int nx = curr.x+dx[i];
                if(ny<0|| ny>=n || nx<0 || nx>=m) continue;
                if(map[ny][nx]=='X' && visited[ny][nx]==0){
                    boundIce.add(new node(ny,nx));
                    visited[ny][nx] = visited[curr.y][curr.x]+1;
                }
            }
        }
        return boundIce;
    }

    private static void print() {
        for(char[] ck : map){
            for (char c: ck){
                System.out.print(c+" ");
            }
            System.out.println();
        }
    }

    private static void vprint() {
        for(int[] ck : visited){
            for (int c: ck){
                System.out.print(c+" ");
            }
            System.out.println();
        }
    }


    static class node{
        int y,x;
        public node(int y, int x){
            this.y = y;
            this.x = x;
        }
    }
}
