/*
 * 문제 풀이 시작: 2021/04/17 11:01 오후
 * 맞은 시각: 2021/04/18 11:50 오후 10:24분~
 * 소요 시간:  1시간 30분 + 알파
 * @uthor ventulus95
 */
package codeBaekJoon._2021;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class No17071_숨바꼭질5 {

    static int n,k,answer=0;
    static int[][] visited;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        visited = new int[500001][2];
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        System.out.println(bfs(n));
    }


    // 이방법으로는 17 5를 풀수없슴. ->4가 나와야 정답이나, 1:16 2:15 3:16 4:15가 될수 있게 구현을 해야하는데... 음... 잘 모르겠음.
    private static int bfs(int n) {
        if(n==k){
            return 0;
        }
        Queue<Integer> q = new LinkedList<>();
        q.add(n);
        int second = 0;
        while (!q.isEmpty()){
            int size = q.size();
            while(size-->0){
                int curr = q.poll();
                for (int i: new int[]{curr-1, curr+1, 2*curr}){
                    if(i<0 || i>500000) continue;
                    if(visited[i][(second+1)%2]==0){
                        visited[i][(second+1)%2] = visited[curr][second%2]+1;
                        q.add(i);
                    }
                }
            }
            second++;
            k+=second;
            if(k>=0 && k<=500000){
                if(visited[k][second%2]!=0)
                    return second;
            }
            else{
                return -1;
            }
        }
        return -1;
    }
}
