/*
 * 문제 풀이 시작: 2021/05/16 5:27 오후
 * 맞은 시각: 2021/05/16
 * 소요 시간:
 * @author ventulus95
 */
package codeBaekJoon._2021;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;

public class No1939_중량제한 {

    static TreeMap<Integer, ArrayList<Long>>[] tree;
    static int n;

    public static void main(String[] args) throws Exception{
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new FileReader("/Users/LeeChnagSup/Downloads/in1.txt"));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        int m =Integer.parseInt(st.nextToken());
        tree = new TreeMap[n+1];
        for (int i = 0; i <=n; i++) {
            tree [i] = new TreeMap<>();
        }
        long high = 0;
        for (int i = 0; i <m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            long w = Long.parseLong(st.nextToken());
            high = Math.max(high, w);
            tree[a].putIfAbsent(b, new ArrayList<>());
            tree[b].putIfAbsent(a, new ArrayList<>());
            tree[a].get(b).add(w);
            tree[b].get(a).add(w);
        }
        st = new StringTokenizer(br.readLine());
        int s = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
        long low = 0;
        while(low<=high){
            long mid = (low+high)/2;
            if(bfs(mid, s, e)){
                low = mid+1;
            }
            else{
                high = mid-1;
            }
        }
        System.out.println(high);
    }

    private static boolean bfs(long mid, int s, int e) {
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[n+1];
        visited[s] = true;
        q.add(s);
        while(!q.isEmpty()){
            int curr = q.poll();
            for (int nxt :tree[curr].keySet()){
                if(!visited[nxt]){
                    for (Long weight: tree[curr].get(nxt)){
                        if(mid <= weight) {
                            visited[nxt] = true;
                            q.add(nxt);
                        }
                    }
                }
            }
        }
        return visited[e];
    }

}
