/*
 * 문제 풀이 시작: 2021/04/05 6:30 오후 7:19분 일시정지 9:12분 시작
 * 맞은 시각: 2021/04/05
 * 소요 시간: 1시간 7분
 * @author ventulus95
 */
package codeBaekJoon._2021;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class No20055_컨베이어벨트위의로봇 {

    static int n,k;
    static int[] arr;
    static boolean[] visit;
    static Queue<Integer> q = new LinkedList<>();

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        arr = new int[2*n];
        visit = new boolean[2*n];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i <2*n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int cnt = 1;
        while(true){
            turn();
            int size = q.size();
            while(size-->0){
                int curr = q.poll();
                int nxt = curr+1>=2*n?0:curr+1;
                if(nxt==n-1&&arr[nxt]>0&&!visit[nxt]){ //내려가는 위치에 로봇이 있을경우 아예 땅으로 내려가야한다.
                    visit[curr] = false;
                    arr[nxt]--;
                }
                else if(arr[nxt]>0&&!visit[nxt]) { //로봇이 이동하기 위해서는 이동하려는 칸에 로봇이 없으며, 그 칸의 내구도가 1 이상 남아 있어야 한다.
                    q.add(nxt);
                    arr[nxt]--;
                    visit[nxt] = true;
                    visit[curr] = false;
                }
                else{
                    q.add(curr); //만약 이동할 수 없다면 가만히 있는다
                }
            }
            if(!visit[0]&&arr[0]>0){
                q.add(0);
                arr[0]--;
            }
//            System.out.println(q.toString());
//            System.out.println(Arrays.toString(arr));
            int zero = 0;
            for(int i: arr){ //내구도가 0인 칸의 개수가 K개 이상이라면 과정을 종료한다.
                if(i==0)
                    zero++;
            }
            if(zero>=k){
                break;
            }

            cnt++;
        }
        System.out.println(cnt);
    }

    private static void turn() {
        int swap = arr[2*n-1];
        for (int i = 2*n-1; i>0 ; i--) {
            arr[i] = arr[i-1];
        }
        arr[0] = swap;
        int size = q.size(); //회전하면서 로봇 움직임도 계산해야함.
        while(size-->0){
            int curr = q.poll();
            int nxt = curr+1>=2*n?0:curr+1;
            if(nxt==n-1){ //내려가는 위치에 로봇이 있을경우 아예 땅으로 내려가야한다.
                visit[curr] = false;
            }
            else{
                q.add(nxt);
                visit[nxt] = true;
                visit[curr] = false;
            }
        }
    }
}
