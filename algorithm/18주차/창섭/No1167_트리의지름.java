/*
 * 문제 풀이 시작: 2021/04/16 2:29 오후
 * 맞은 시각: 2021/04/16
 * 소요 시간:
 * @author ventulus95
 */
package codeBaekJoon._2021개인적;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/*7
1 2 1 3 1 -1
2 1 1 -1
3 1 1 4 3 5 2 -1
4 3 3 -1
5 3 2 6 3 7 10 -1
6 5 3 -1
7 5 10 -1*/
public class No1167_트리의지름 {

    static HashMap<Integer, Integer>[] tree;
    static int[] visited;
    static int  max = 0;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        tree = new HashMap[n+1];
        visited = new int[n+1];
        for (int i = 1; i <=n; i++) {
            tree[i] = new HashMap<>();
        }
        while(n-->0){
            st = new StringTokenizer(br.readLine(), " ");
            int node = Integer.parseInt(st.nextToken());
            int child;
            while((child=Integer.parseInt(st.nextToken()))!=-1){
                int distance = Integer.parseInt(st.nextToken());
                tree[node].put(child, distance);
                tree[child].put(node, distance);
            }
        }
        int longNode = longdistance(1);
        visited = new int[tree.length];
        max = 0;
        longdistance(longNode);
        System.out.println(max);

    }

    private static int longdistance(int n) {
        Queue<Integer> q = new LinkedList<>();
        q.add(n);
        while(!q.isEmpty()){
            int node = q.poll();
            for(int nxt : tree[node].keySet()){
                if(visited[nxt]==0&&nxt!=n){
                    visited[nxt] = visited[node]+tree[node].get(nxt);
                    q.add(nxt);
                }
            }
        }
        int idx = 0;
        for (int i = 1; i <tree.length; i++) {
            max = Math.max(visited[i], max);
            if(max == visited[i])
                idx = i;
        }
        return idx;
    }
}
