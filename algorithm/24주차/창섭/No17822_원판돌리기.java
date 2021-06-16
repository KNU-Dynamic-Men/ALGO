/*
 * 문제 풀이 시작: 2021/05/12 5:37 오후
 * 맞은 시각: 2021/05/12 7:57 오후
 * 소요 시간: 2시간 24
 * @author ventulus95
 */
package codeBaekJoon._2021;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class No17822_원판돌리기 {

    static int n,m,t,cCnt;
    static int[][] circle;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        t = Integer.parseInt(st.nextToken());
        circle = new int[n+1][m+1];
        for (int i = 1; i <=n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <=m; j++) {
                circle[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        cCnt = n*m;
//        System.out.println(Arrays.deepToString(circle));
        for (int i = 0; i <t; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            turn(x, d, k);

        }
        int sum = 0;
        for (int i = 1; i <=n; i++) {
            for (int j = 1; j <=m; j++) {
                if(circle[i][j]==-999)
                    continue;
                sum+=circle[i][j];
            }
        }
        System.out.println(sum);
    }

    private static void turn(int x, int d, int k) {
        for (int i = 1; i <=n/x; i++) {
            int cnt = k%m;
            while(cnt-->0){
                if(d==0)
                    turnTime(x*i);
                else{
                    turnReverse(x*i);
                }
            }
        }
//        System.out.println("돌고난뒤");
//        System.out.println(Arrays.deepToString(circle));
        //TODO 돌고난다음에 인접값 체크
        int prev = cCnt;
        checkNear();
        cCnt =n*m;
//        System.out.println("인접삭제");
//        System.out.println(Arrays.deepToString(circle));
        for (int i = 1; i <=n; i++) {
            for (int j = 1; j <=m; j++) {
                if(circle[i][j]==-999)
                    cCnt--;
            }
        }
        if(prev==cCnt){
            //TODO 전체수 확인해서 평균 +-
            Queue<Node> q = new LinkedList<>();
            double avg = 0;
            for (int i = 1; i <=n; i++) {
                for (int j = 1; j <=m; j++) {
                    if(circle[i][j]==-999)
                        continue;
                    avg+=circle[i][j];
                    q.add(new Node(i,j));
                }
            }
//            System.out.println(avg+" "+cCnt);
            avg /=cCnt;
//            System.out.println(avg);
            while (!q.isEmpty()){
                Node curr = q.poll();
                if(avg<circle[curr.y][curr.x]){
                    circle[curr.y][curr.x]--;
                }
                else if(avg>circle[curr.y][curr.x]){
                    circle[curr.y][curr.x]++;
                }
            }
//            System.out.println("인접값 처리한 뒤");
//            System.out.println(Arrays.deepToString(circle));
        }
    }

    private static void checkNear() {
        Queue<Node> q = new LinkedList<>();
        for (int i = 1; i <=n; i++) {
            for (int j = 1; j <= m; j++) {
                boolean in = true;
                if (circle[i][j] == -999)
                    continue;
                int left = j - 1 == 0 ? m : j - 1;//(i, 1)은 (i, 2), (i, M)과 인접하다.
                int right = j + 1 == m + 1 ? 1 : j + 1;//(i, M)은 (i, M-1), (i, 1)과 인접하다.
                int up = i == n ? -99 : i + 1; //(1, j)는 (2, j)와 인접하다.
                int down = i == 1 ? -99 : i - 1; //(N, j)는 (N-1, j)와 인접하다.
                if (circle[i][j] == circle[i][left]) {
                    q.add(new Node(i, left));
                    in = false;
                }
                if (circle[i][j] == circle[i][right]) {
                    q.add(new Node(i, right));
                    in = false;
                }
                if (up != -99 && circle[i][j] == circle[up][j]) {
                    q.add(new Node(up, j));
                    in = false;
                }
                if (down != -99 && circle[i][j] == circle[down][j]) {
                    q.add(new Node(down, j));
                    in = false;
                }
                if (!in)
                    q.add(new Node(i, j));
            }
        }
        while (!q.isEmpty()) {
            Node curr = q.poll();
            circle[curr.y][curr.x] = -999;
        }
    }

    private static void turnTime(int x) {
        int temp = circle[x][m];
        for (int i = m; i>1; i--) {
            circle[x][i] = circle[x][i-1];
        }
        circle[x][1] = temp;
    }

    private static void turnReverse(int x) {
        int temp = circle[x][1];
        for (int i = 1; i<m; i++) {
            circle[x][i] = circle[x][i+1];
        }
        circle[x][m] = temp;
    }

    static class Node{
        int y,x;
        public Node(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
}
