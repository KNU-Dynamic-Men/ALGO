package codeBaekJoon._2021;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class No14391_종이조각 {
    static int n,m,answer=0;
    static int[][] map;
    static boolean[][] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nm = br.readLine().split(" ");
        n = Integer.parseInt(nm[0]);
        m = Integer.parseInt(nm[1]);
        map = new int[n][m];
        visited = new boolean[n][m];
        for(int i=0; i<n; i++){
            String tc =br.readLine();
            for(int j=0; j<m; j++){
                map[i][j] = tc.charAt(j)-'0';
            }
        }
        dfs(0,0);
        System.out.println(answer);
    }

    // 좌->우로 탐색 범위 넘으면 아래로 한칸내려가고
    private static void dfs(int y, int x) {
        if(y>=n){
            sum();
            return;
        }
        if(x>=m){
            dfs(y+1,0);
            return;
        }
        visited[y][x] = true; //가로
        dfs(y, x+1);
        visited[y][x] = false; //세로
        dfs(y, x+1);
    }

    private static void sum() {
        int sum =0;
        StringBuilder sb;
        for(int i=0; i<n; i++){
            sb = new StringBuilder();
            for(int j=0; j<m; j++){
                if(visited[i][j]) {
                    sb.append(map[i][j]);
                }
                else{
                    if(sb.length()>0)
                        sum += Integer.parseInt(sb.toString());
                    sb = new StringBuilder();
                }
            }
            if(sb.length()>0)
                sum += Integer.parseInt(sb.toString());
        }
        //세로 합
        for(int i=0; i<m; i++ ){
            sb = new StringBuilder();
            for (int j = 0; j <n ; j++) {
                if(!visited[j][i]) {
                    sb.append(map[j][i]);
                }
                else{
                    if(sb.length()>0)
                        sum += Integer.parseInt(sb.toString());
                    sb = new StringBuilder();
                }
            }
            if(sb.length()>0)
                sum += Integer.parseInt(sb.toString());
        }
        answer = Math.max(answer, sum);
    }
}
