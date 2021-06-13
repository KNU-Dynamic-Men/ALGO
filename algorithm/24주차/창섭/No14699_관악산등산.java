/*
 * 문제 풀이 시작: 2021/06/12 4:55 오후
 * 맞은 시각: 2021/06/12 -> DP
 * 소요 시간:
 * @author ventulus95
 * 참고: https://burningjeong.tistory.com/388?category=823254
 */
package codeBaekJoon._2021;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class No14699_관악산등산 {

    static int n,m;
    static TreeMap<Integer, Integer>[] graph;
    static int[] height;
    static int[] dp;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        graph = new TreeMap[n];
        for (int i = 0; i <n; i++) {
            graph[i] = new TreeMap<>();
        }
        height = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i <n; i++) {
            height[i] = Integer.parseInt(st.nextToken());
        }
        for (int i = 0; i <m; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken())-1;
            int e = Integer.parseInt(st.nextToken())-1;
            if(height[s]<height[e])
                graph[s].put(e, height[s]); // 높은쪽밖에 못가니까 단방향 그래프로 전환해줄것.
            else
                graph[e].put(s, height[e]);
        }
        dp = new int[n]; //중복으로 발생하는 오류 제거 해줘야함.
        for (int i = 0; i <n; i++) {
            System.out.println(dfs(i));
        }
    }

    private static int dfs(int cur) {
        if(dp[cur]!=0) //현재 방문한적 있는거면 바로 출력.
            return dp[cur];
        for (int key: graph[cur].keySet()) { //현 위치에서 갈 수 있는 모든곳 쭈르륵 돌기.
            dp[cur] = Math.max(dp[cur], dfs(key)); //현위치 DP랑 다음 위치에서도 갈 수 있는지 확인
        }
        return ++dp[cur]; //그렇게 DP구성되었으면 전치 연산해서 처리
        //예를 들어서 예제 5처럼 갈 수 없는데, DP도 0이고 실제로 갈 수 있는 공간이 없는 경우에는
        // 자기자신 쉼터를 방문한 경우 1로 해줘야하기 때문.
    }
}
