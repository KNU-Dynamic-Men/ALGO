/*
 * 문제 풀이 시작: 2021/05/01 11:41 오후
 * 맞은 시각: 2021/05/02 12:08 오전
 * 소요 시간: 27분
 * @author ventulus95
 */
package codeBaekJoon._2021;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class No1068_트리 {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        ArrayList<Integer>[] tree = new ArrayList[n];
        for (int i = 0; i <n; i++) {
            tree[i] = new ArrayList<>();
        }
        int rootNode = 0;
        int[] parent = new int[n];
        for (int i = 0; i <n; i++) {
            int curr = Integer.parseInt(st.nextToken());
            parent[i] = curr;
            if(curr != -1)
                tree[curr].add(i);
            else
                rootNode = i;
        }
        int child = Integer.parseInt(br.readLine());
        if(child==rootNode){
            System.out.println(0);
        }
        else{
            for (int i = 0; i <tree[parent[child]].size(); i++) {
                if(child==tree[parent[child]].get(i)){
                    tree[parent[child]].remove(i);
                }
            }
            int cnt = 0;
            Queue<Integer> q = new LinkedList<>();
            q.add(rootNode);
            boolean[] visit = new boolean[n];
            visit[rootNode] = true;
            while(!q.isEmpty()){
                int curr = q.poll();
                if(tree[curr].size()==0){
                    cnt++;
                }
                for(int nxt :tree[curr]){
                    if(!visit[nxt]){
                        q.add(nxt);
                        visit[nxt] = true;
                    }
                }
            }
            System.out.println(cnt);
        }
    }
}


