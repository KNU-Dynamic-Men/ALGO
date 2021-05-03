/*
 * 문제 풀이 시작: 2021/05/02 4:15 오후
 * 맞은 시각: 2021/05/02 4:50 오후
 * 소요 시간: 35분
 * @author ventulus95
 */
package codeBaekJoon._2021;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

public class No6416_트리인가 {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int u = 9;
        int v = 9;
        int k = 1;
        HashMap<Integer, ArrayList<Integer>> tree = new HashMap<>();
        HashMap<Integer, ArrayList<Integer>> outNode = new HashMap<>();
        while(u!=-1&&v!=-1){
            StringTokenizer st = new StringTokenizer(br.readLine());
            while(st.hasMoreTokens()){
                u = Integer.parseInt(st.nextToken());
                v = Integer.parseInt(st.nextToken());
                if(u==0&&v==0){
                    treecheck(tree, outNode, k);
                    k++;
                    tree = new HashMap<>();
                    outNode = new HashMap<>();
                }
                else{
                    tree.putIfAbsent(u, new ArrayList<>());
                    tree.get(u).add(v);
                    outNode.putIfAbsent(v, new ArrayList<>());
                    outNode.get(v).add(u);
                }
            }
        }
    }

    private static void treecheck(HashMap<Integer, ArrayList<Integer>> tree, HashMap<Integer, ArrayList<Integer>> outNode, int k) {
        if(tree.isEmpty()&&outNode.isEmpty()) {
            System.out.println("Case " + k + " is a tree.");
            return;
        }
//        들어오는 간선이 하나도 없는 단 하나의 노드가 존재한다. 이를 루트(root) 노드라고 부른다.
//        = 즉 들어오는 간선이 하나도 없는 노드가 두개인경우는 트리가아님.
        int count = tree.size();
        for (int root: tree.keySet()){
            if(outNode.containsKey(root))
                count--;
        }
        if(count==1){
//        루트 노드를 제외한 모든 노드는 반드시 단 하나의 들어오는 간선이 존재한다.
//        = 루트노드 빼고 들어오는 노드가 두개 이상이면 안됨. 이 조건으로 아래 3번 조건도 만족시킬수있음.
            for(int key: outNode.keySet()){
                if(outNode.get(key).size()>1){
                    System.out.println("Case "+k+" is not a tree.");
                    return;
                }
            }
            System.out.println("Case "+k+" is a tree.");
        }
        else{
            System.out.println("Case "+k+" is not a tree.");
        }


    }
}
