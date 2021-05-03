/*
 * 문제 풀이 시작: 2021/05/02 5:22 오후
 * 맞은 시각: 2021/05/02
 * 소요 시간:
 * @author ventulus95
 */
package codeBaekJoon._2021;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

public class No14675_단절점과단절선 {
    static int n;
    static int[][] testCase;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        HashMap<Integer, ArrayList<Integer>> tree = new HashMap<>();
        StringTokenizer st;
        testCase = new int[n][2];
        for (int i = 1; i <n; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            tree.putIfAbsent(a, new ArrayList<>());
            tree.putIfAbsent(b, new ArrayList<>());
            tree.get(a).add(b);
            tree.get(b).add(a);
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

    private static void query(HashMap<Integer, ArrayList<Integer>> tree, int a, int b) {
        if(a==1){
            System.out.println(tree.get(b).size() ==1 ? "no": "yes");
        }
        else{
            System.out.println("yes");
        }

    }

}
