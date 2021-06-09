/*
 * 문제 풀이 시작: 2021/06/09 11:00 오전
 * 맞은 시각: 2021/06/09
 * 소요 시간:
 * @author ventulus95
 */
package codeBaekJoon._2021;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class No13565_침투 {

    static int n,m;
    static int[][] map;
    static boolean[][] visited;
    static int[] dy = {0,0,-1,1};
    static int[] dx = {-1,1,0,0};

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        map = new int[m][n];
        visited = new boolean[m][n];
        for (int i = 0; i <m; i++) {
            String s = br.readLine();
            for (int j = 0; j <n; j++) {
                map[i][j] = s.charAt(j)-'0';
            }
        }
        for (int i = 0; i <n; i++) {
            if(!visited[0][i] && map[0][i]==0)
                bfs(i);
        }
        for (int i = 0; i <n; i++) {
            if(visited[m-1][i]) {
                System.out.println("YES");
                return;
            }
        }
        for(boolean[] arr: visited){
            for (boolean a: arr){
                System.out.print(a+" ");
            }
            System.out.println();
        }
        System.out.println("NO");
    }
    private static void bfs(int x) {
        Queue<Node> q = new LinkedList<>();
        visited[0][x] = true;
        q.add(new Node(0, x));
        while(!q.isEmpty()){
            Node curr = q.poll();
            for (int i = 0; i <4; i++) {
                int ny = curr.y+dy[i];
                int nx = curr.x+dx[i];
                if(ny<0 || ny>=m || nx<0 || nx>=n) continue;
                if(map[ny][nx]==0 && !visited[ny][nx]){
                    visited[ny][nx] = true;
                    q.add(new Node(ny, nx));
                }
            }
        }
    }

    static class Node{
        int y,x;

        public Node(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
}
