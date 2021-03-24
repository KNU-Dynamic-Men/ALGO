package codeBaekJoon._2021;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No6603_로또 {

    static int n;
    static boolean visited[];
    static int arr[];
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String tc;
        StringTokenizer st;
        while(!(tc=br.readLine()).equals("0")){
            st = new StringTokenizer(tc, " ");
            n = Integer.parseInt(st.nextToken());
            arr = new int[n];
            visited = new boolean[n];
            for(int i=0; i<n ; i++){
                arr[i] = Integer.parseInt(st.nextToken());
            }
            dfs(0, 0);
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }

    private static void dfs(int deep, int start) {
        if(deep==6){
            for (int i = 0; i <n ; i++) {
                if(visited[i]){
                    sb.append(arr[i]+" ");
                }
            }
            sb.append("\n");
            return;
        }
        for (int i = start; i <n; i++) {
            if(!visited[i]){
                visited[i] = true;
                dfs(deep+1, i+1);
                visited[i] = false;
            }
        }
    }
}
