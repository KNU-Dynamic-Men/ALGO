/*
 * 문제 풀이 시작: 2021/05/02 3:36 오후
 * 맞은 시각: 2021/05/02 3:50
 * 소요 시간: 14분 -> 해답참조.
 * @author ventulus95
 */
package codeBaekJoon._2021;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class No5639_이진검색트리 {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Node root = new Node(Integer.parseInt(br.readLine()));
        String tc = "";
        while((tc=br.readLine())!=null && tc.length()!=0){
            int n = Integer.parseInt(tc);
            root = insert(root, n);
        }
        postOrder(root);
    }

    private static void postOrder(Node root) {
        if(root.left!=null){
            postOrder(root.left);
        }
        if(root.right!=null){
            postOrder(root.right);
        }
        System.out.println(root.value);
    }

    static class Node{
        Node left;
        Node right;
        int value;

        public Node(int value) {
            this.value = value;
        }
    }

    static Node insert(Node node, int val){
        Node curr = null;
        if(node ==null){
            return new Node(val);
        }
        if(node.value> val){
            curr = insert(node.left, val);
            node.left = curr;
        }
        else if(node.value< val){
            curr = insert(node.right, val);
            node.right = curr;
        }
        return node;

    }

}
