/*
 * 문제 풀이 시작: 2021/05/03 12:54 오전
 * 맞은 시각: 2021/05/03
 * 소요 시간:
 * @author ventulus95
 */
package codeBaekJoon._2021;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class No17073_나무위의빗물 {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n  = Integer.parseInt(st.nextToken());
        double w  = Double.parseDouble(st.nextToken());
        ArrayList<Integer>[] tree = new ArrayList[n+1];
        for (int i = 0; i <=n; i++) {
            tree[i] = new ArrayList<>();
        }
        for (int i = 0; i <n-1; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            tree[u].add(v);
            tree[v].add(u);
        }
        double leaf = 0;
        for (int i = 2; i <=n; i++) {
            if(tree[i].size()==1){
                leaf++;
            }
        }
        System.out.println(w/leaf);
    }
}
