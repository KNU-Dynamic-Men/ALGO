/*
 * 문제 풀이 시작: 2021/06/13 7:12 오후
 * 맞은 시각: 2021/06/13
 * 소요 시간:
 * @author ventulus95
 */
package codeBaekJoon._2021;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No1976_여행가자 {

    static int[] parent;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        StringTokenizer st;
        parent = new int[n+1];
        for (int i = 0; i <n; i++) {
            parent[i] = i;
        }
        for (int i = 1; i <=n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <=n; j++) {
                int cases = Integer.parseInt(st.nextToken());
                if(cases==1)
                    union(i, j);
            }
        }
        st = new StringTokenizer(br.readLine());
        int start = find(Integer.parseInt(st.nextToken()));
        for (int i =1; i <m; i++) {
            if(find(start)!=find(Integer.parseInt(st.nextToken()))) {
                System.out.println("NO");
                return;
            }
        }
        System.out.println("YES");
    }

    public static int find(int a){
        if(parent[a] ==a)
            return a;
        else
            return parent[a]=find(parent[a]);
    }

    public static void union(int a, int b){
        a = find(a);
        b = find(b);
        if(a!=b)
            parent[b] = a;
    }
}
