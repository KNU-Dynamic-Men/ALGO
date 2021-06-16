/*
 * 문제 풀이 시작: 2021/06/13 6:54 오후
 * 맞은 시각: 2021/06/13
 * 소요 시간:
 * @author ventulus95
 */
package codeBaekJoon._2021;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No1717_집합의표현 {

    static int[] parent;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(st.nextToken());
        parent = new int[n+1];
        for (int i = 0; i <=n; i++) {
            parent[i] = i;
        }
        int m = Integer.parseInt(st.nextToken());
        for (int i = 0; i <m; i++) {
            st = new StringTokenizer(br.readLine());
            int c = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if(c==0){
               union(a, b);
            }
            else{
                if (find(a)==find(b))
                    sb.append("YES\n");
                else
                    sb.append("NO\n");
            }
        }
        System.out.print(sb.toString());
    }

    public static int find(int a){
        if(parent[a] ==a) //자기자신이 부모인 경우는 그냥 그거 뱉어내기
            return a;
        else //부모가 자기자신이 아니면, 그 부모의 부모를 찾아서... 원래 a에 넣기
            return parent[a]=find(parent[a]);
    }

    public static void union(int a, int b){
        a = find(a); // 부모부터 찾기
        b = find(b);
        if(a!=b) //부모가 안 같으면, B의 부모를 a로.
            parent[b] = a;
    }
}
