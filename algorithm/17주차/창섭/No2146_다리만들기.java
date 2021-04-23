/*
 * 문제 풀이 시작: 2021/04/16 5:14 오후
 * 맞은 시각: 2021/04/16 7:00 오후
 * 소요 시간: 1시간 46분 해답 참조.
 * @author ventulus95
 */
package codeBaekJoon._2021;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class No2146_다리만들기 {
    static int n, answer = Integer.MAX_VALUE;
    static int[][] map, visit, visited;
    static int[] dx= {0,1,0,-1};
    static int[] dy= {1,0,-1,0};
    static ArrayList<node2146> island = new ArrayList<>();
    static Queue<node2146> iq;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        visit = new int[n][n];
        visited = new int[n][n];
        StringTokenizer st;
        for (int i = 0; i <n ; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j <n ; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int islandNum = 1;
        iq = new LinkedList<>();
        for (int i = 0; i <n ; i++) {
            for (int j = 0; j <n; j++) {
                if(map[i][j]==1&& visit[i][j]==0){
                    bfs(i, j, islandNum);
                    iq.add(new node2146(i, j));
                    visited = new int[n][n];
                    answer = Math.min(distance(islandNum), answer);
//                    System.out.println(islandNum+"의 거리 측정기");
//                    vprint();
//                    System.out.println("위는 영역 뭘로 칠해져있는지 확인");
                    islandNum++;
//                    print();
//                    System.out.println();
                }
            }
        }
        System.out.println(answer-1);
    }

    private static int distance(int cnt) {
        int distance = 999;
        while(!iq.isEmpty()&&distance==999){
            node2146 curr = iq.poll();
            for (int k = 0; k <4; k++) {
                int ny = curr.y+dy[k];
                int nx = curr.x+dx[k];
                if(ny<0 || ny>=n || nx<0 || nx>=n) continue;
                if(map[ny][nx]==0&&visited[ny][nx]==0){
                    visited[ny][nx]=visited[curr.y][curr.x]+1;
                    iq.add(new node2146(ny, nx));
                }
                if(map[ny][nx]==1&&visit[ny][nx]!=cnt&&visited[ny][nx]==0){
                    distance = visited[curr.y][curr.x]+1;
                }
            }
        }
        iq.clear();
        return distance;
    }

    private static void bfs(int i, int j, int cnt) {
        Queue<node2146> q = new LinkedList<>();
        q.add(new node2146(i, j));
        visit[i][j] = cnt;
        while(!q.isEmpty()){
            node2146 curr = q.poll();
            for (int k = 0; k <4; k++) {
                int ny = curr.y+dy[k];
                int nx = curr.x+dx[k];
                if(ny<0 || ny>=n || nx<0 || nx>=n) continue;
                if(map[ny][nx]==1&&visit[ny][nx]==0){
                    q.add(new node2146(ny, nx));
                    visit[ny][nx] = cnt;
                    iq.add(new node2146(ny, nx));
                }
            }
        }
    }

    private static void print() {
        for(int[] v: visited){
            for (int t: v){
                System.out.print(t+ " ");
            }
            System.out.println();
        }
    }

    private static void vprint() {
        for(int[] v: visit){
            for (int t: v){
                System.out.print(t+ " ");
            }
            System.out.println();
        }
    }
}

class node2146{
    int y,x;

    public node2146(int y, int x){
        this.y = y;
        this.x = x;
    }
}
/*
4
1 0 0 0
1 1 0 0
0 0 0 0
0 0 1 1*/
/*
4
1 0 0 0
1 1 0 0
0 0 0 0
0 1 0 0*/
