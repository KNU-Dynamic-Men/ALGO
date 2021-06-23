/*
 * 문제 풀이 시작: 2021/06/23 1:37 오후
 * 맞은 시각: 2021/06/23
 * 소요 시간:
 * @author ventulus95
 */
package codeBaekJoon._2021;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class No1949_우수마을 {

    static int n;
    static int[] town;
    static int[][] dp;
    static ArrayList<Integer>[] tree;
    static boolean[] visited;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        tree = new ArrayList[n+1];
        town = new int[n+1];
        visited = new boolean[n+1];
        for (int i = 1; i <=n; i++) {
            town[i] = Integer.parseInt(st.nextToken());
            tree[i] = new ArrayList<>();
        }
        for (int i = 0; i <n-1; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            tree[s].add(e);
            tree[e].add(s);
        }
        dp = new int[n+1][2];
        visited[1]=true;
        dfs(1);
        System.out.println(Math.max(dp[1][0], dp[1][1]));
    }

    private static void dfs(int x) {
        for (int nxt: tree[x]){
            if(visited[nxt]) continue;
            visited[nxt] = true;
            dfs(nxt);
            dp[x][0] += Math.max(dp[nxt][1], dp[nxt][0]); //우수 마을로 선택안한경우. -> 다음 마을이 선택하거나 안하거나 둘중하나
            dp[x][1] += dp[nxt][0]; //우수마을로 선택한 경우
        }
        dp[x][1]+=town[x];
    }
}
