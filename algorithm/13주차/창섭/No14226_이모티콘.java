/*
 * 문제 풀이 시작: 2021/03/26 6:41 오후
 * 맞은 시각: 2021/03/26
 * 소요 시간:
 * @author ventulus95
 */
package codeBaekJoon._2021;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class No14226_이모티콘 {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] cnt = new int[1001][1001];
        Queue<state> q = new LinkedList<>();
        q.add(new state(1,0));
        int ans = 0;
        while(!q.isEmpty()){
            state curr = q.poll();
            if(curr.c+curr.s==n){
                ans = cnt[curr.s][curr.c]+1;
                break;
            }
            int[] ns = {curr.s, curr.s+curr.c, curr.s-1};
            int[] nc = {curr.s, curr.c, curr.c};
            for (int i = 0; i <3; i++) {
                if(ns[i]<=0 || ns[i]>1000) continue;
                if(cnt[ns[i]][nc[i]]==0){
                    cnt[ns[i]][nc[i]] = cnt[curr.s][curr.c]+1;
                    q.add(new state(ns[i], nc[i]));
                }
            }
        }
        System.out.println(ans);
    }

    static class state{
        int s,c;
        public state(int s, int c){
            this.s = s;
            this.c = c;
        }

//        @Override
//        public String toString() {
//            return "state{" +
//                    "s=" + s +
//                    ", c=" + c +
//                    '}';
//        }
    }
}
