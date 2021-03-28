/*
 * 문제 풀이 시작: 2021/03/26 6:07 오후
 * 맞은 시각: 2021/03/26
 * 소요 시간:
 * @author ventulus95
 */
package codeBaekJoon._2021;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class No13023_ABCDE {

    static int n,m,ans=0;
    static TreeMap<Integer, ArrayList<Integer>> tree = new TreeMap<>();
    static boolean[] visited;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        for (int i = 0; i <n ; i++) {
            tree.put(i, new ArrayList<>());
        }
        while(m-->0){
            st = new StringTokenizer(br.readLine(), " ");
            int key = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());
            tree.get(key).add(value);
            tree.get(value).add(key);
        }
        for (int i = 0; i <n; i++) {
            visited = new boolean[n];
            if(ans==1)
                break;
            visited[i] = true;
            dfs(i,0);
        }
        System.out.println(ans);
    }

    private static void dfs(int v, int deep) {
        if(deep==4){
            ans = 1;
            return;
        }
        for(int nxt :tree.get(v)){
            if(!visited[nxt]){
                visited[nxt] = true;
                dfs(nxt, deep+1);
                visited[nxt] = false;
            }
        }

    }
}
