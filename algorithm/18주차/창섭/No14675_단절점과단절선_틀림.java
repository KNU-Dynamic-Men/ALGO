/*
 * 문제 풀이 시작: 2021/05/02 5:22 오후
 * 맞은 시각: 2021/05/02
 * 소요 시간:
 * @author ventulus95
 */
package codeBaekJoon._2021;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class No14675_단절점과단절선_틀림 {
    static int n;
    static int[][] testCase;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        HashMap<Integer, TreeMap<Integer, Integer>> tree = new HashMap<>();
        StringTokenizer st;
        testCase = new int[n][2];
        for (int i = 1; i <n; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            tree.putIfAbsent(a, new TreeMap<>());
            tree.get(a).put(b, a);
            testCase[i][0] = a;
            testCase[i][1] = b;
        }
        int k = Integer.parseInt(br.readLine());
        for (int i = 0; i <k; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            query(tree ,a, b);
        }
    }

    private static void query(HashMap<Integer, TreeMap<Integer, Integer>> tree, int a, int b) {
        boolean[] visited = new boolean[n+1];
        int start = 0;
        TreeMap<Integer, Integer> temp = null;
        if(a==1){ //단절점인 경우.
            temp =tree.remove(b);
            for (int key: tree.keySet()){
                start = key;
                break;
            }
            visited[b] = true;
        }
        else{ //단절선인 경우.
            int u = testCase[b][0];
            tree.get(u).remove(testCase[b][1]);
            for (int key: tree.keySet()){
                if(tree.get(key).size()>0){
                    start = key;
                    break;
                }
            }
        }
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        visited[start] = true;
        while(!q.isEmpty()){
            int curr = q.poll();
            for (int nxt: tree.getOrDefault(curr, new TreeMap<Integer, Integer>()).keySet()){
                if(!visited[nxt]) {
                    q.add(nxt);
                    visited[nxt] = true;
                }
            }
        }
        if(a==1){
            tree.put(b, temp);
        }
        else{
            tree.get(testCase[b][0]).put(testCase[b][1], 0);
        }
        for (int i = 1; i <=n; i++) {
            if(!visited[i]) {
                System.out.println("yes");
                return;
            }
        }
        System.out.println("no");
    }

}
