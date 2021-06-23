/*
 * 문제 풀이 시작: 2021/06/22 10:39 오후
 * 맞은 시각: 2021/06/22 10:56 오후
 * 소요 시간: 17분
 * @author ventulus95
 */
package codeBaekJoon._2021;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class No17836_공주님을구해라 {

    static int n, m,t;
    static int[][] map;
    static boolean[][][] visited;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1,-1, 0, 0};

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        t = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        visited = new boolean[n][m][2];
        for (int i = 0; i <n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j <m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        System.out.println(bfs());
    }

    private static String bfs() {
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(0, 0, 0, false));
        int answer = -1;
        while(!q.isEmpty()){
            Node curr = q.poll();
            if(curr.y==n-1&& curr.x==m-1) {
                answer = curr.time;
                break;
            }
            if(curr.time>t)
                break;
            for (int i = 0; i <4; i++) {
                int ny = curr.y+dy[i];
                int nx = curr.x+dx[i];
                if(ny<0 || ny>=n || nx<0 || nx>=m) continue;
                if(!curr.sword){ // 칼없는 경우
                    if(!visited[ny][nx][0]&&map[ny][nx]!=1){
                        if(map[ny][nx]==2){ //다음자리가 칼있는 경우면...
                            q.add(new Node(ny, nx, curr.time+1, true));
                            visited[ny][nx][1] = true;
                        }
                        else{
                            q.add(new Node(ny, nx, curr.time+1, false));
                            visited[ny][nx][0] = true;
                        }
                    }
                }
                else{
                    if(!visited[ny][nx][1]){
                        q.add(new Node(ny, nx, curr.time+1, true));
                        visited[ny][nx][1] = true;
                    }
                }
            }
        }
        if(answer==-1)
            return "Fail";
        return String.valueOf(answer);
    }

    static class Node{
        int y, x, time;
        boolean sword;

        public Node(int y, int x, int time, boolean sword) {
            this.y = y;
            this.x = x;
            this.time = time;
            this.sword = sword;
        }
    }
}
