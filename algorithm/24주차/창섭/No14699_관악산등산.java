/*
 * 문제 풀이 시작: 2021/06/12 4:55 오후
 * 맞은 시각: 2021/06/12 -> DP
 * 소요 시간:
 * @author ventulus95
 */
package codeBaekJoon._2021;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.SortedMap;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class No14699_관악산등산 {

    static int n,m;
    static TreeMap<Integer, Integer>[] graph;
    static int[] height;
    static boolean[] visited;
    static ArrayList<Integer> list = new ArrayList<>();

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
            graph[s].put(height[e], e);
            graph[e].put(height[s], s);
        }
        for (int i = 0; i <n; i++) {
            visited = new boolean[n];
            list.add(1);
            dfs(i, i,1);
        }
        for (int i:list){
            System.out.println(i);
        }
    }

    private static void dfs(int start, int index,int cnt) {
        visited[start] = true;
        Integer key = graph[start].higherKey(height[start]);
        if (key != null) {
            SortedMap<Integer, Integer> lis = graph[start].tailMap(key);
            for (int end : lis.values()){
                if (!visited[end]) {
                    dfs(end, index, cnt + 1);
                    visited[end] = false;
                }
            }
        }
        if(list.get(index)<cnt){
            list.set(index, cnt);
        }
    }
}
