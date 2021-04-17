/*
 * 문제 풀이 시작: 2021/04/14 5:10 오후
 * 맞은 시각: 2021/04/14 6:27 오후
 * 소요 시간: 1시간 17분
 * @author ventulus95
 */
package codeBaekJoon._2021;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class No5214_환승 {

    static HashSet<Integer>[] graph;
    static HashSet<Integer>[] hyper;
    static int[] visited;
    static int[] hvisited;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        visited = new int[n+1];
        hvisited = new int[m];
        hyper = new HashSet[m];
        graph = new HashSet[n + 1];
        for (int i = 0; i <m; i++) {
            hyper[i] = new HashSet<>();
        }
        for (int i = 1; i <=n; i++) {
            graph[i] = new HashSet<>();
        }
        for (int i = 0; i <m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j <k; j++) {
                int node = Integer.parseInt(st.nextToken());
                hyper[i].add(node);
                graph[node].add(i);
            }
        }
        bfs(1);
//        System.out.println(Arrays.toString(hvisited));
        System.out.println(visited[n]!=0?visited[n]:-1);
//        for(int i=1; i<graph.length; i++){
//            System.out.println(i +"의 연결 노드");
//            HashSet<Integer> list = graph[i];
//            for(int a :list){
//                System.out.print(a+" ");
//            }
//            System.out.println();
    }


    private static void bfs(int i) {
        Queue<node> q = new LinkedList<>();
        q.add(new node(i, false));
        visited[i] =1;
        while(!q.isEmpty()){
            node curr = q.poll();
            if(curr.hyper){
                for (int nxt: hyper[curr.idx]){
                    if(visited[nxt]==0&& i!=nxt){
                        q.add(new node(nxt, false));
                        visited[nxt] = hvisited[curr.idx]+1;
                    }
                }
            }
            else{
                for (int nxt: graph[curr.idx]){
                    if(hvisited[nxt]==0){
                        q.add(new node(nxt, true));
                        hvisited[nxt] = visited[curr.idx];
                    }
                }
            }

        }

    }

    static class node {
        int idx;
        boolean hyper;
        public node(int idx, boolean hyper) {
            this.idx = idx;
            this.hyper = hyper;
        }
    }
}
