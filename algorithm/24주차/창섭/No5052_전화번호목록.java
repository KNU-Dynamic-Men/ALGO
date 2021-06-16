/*
 * 문제 풀이 시작: 2021/06/12 9:20 오후
 * 맞은 시각: 2021/06/12
 * 소요 시간:
 * @author ventulus95
 */
package codeBaekJoon._2021;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class No5052_전화번호목록 {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T  = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while(T-->0){
            int n = Integer.parseInt(br.readLine());
            Trie trie = new Trie();
            boolean isDone = true;
            while(n-->0){
                String s = br.readLine();
                if(!isDone) continue;
                if(!trie.insert(s)){
                    sb.append("NO\n");
                    isDone = false;
                }
            }
            if(isDone)
                sb.append("YES\n");
        }
        System.out.print(sb.toString());

    }

    static class Trie{
        TrieNode root = new TrieNode();

        boolean insert(String word){
            TrieNode node = root; //루트트리에서 시작하므로,
            for (int i = 0; i <word.length(); i++) { // 그 단어 쪼개서 한개씩 넣을것이다.
                int n = word.charAt(i)-'0';  //이건 숫자니까 0으로 나타내기
                if(node.childNodes.get(n) == null){ //그렇게 해서 ChildNode에 그 숫자가 있는지 확인
                    node.childNodes.put(n, new TrieNode()); //=>없으면, 숫자 추가하고 새로운 트라이 노드 추가.
                }
                node = node.childNodes.get(n); //그렇게 생겨먹은 TrieNode를 기준 노드로 승격하고..
                if(node.isLast) return false; //현재 노드가 끝난걸 확인할 수 있으면, PreFix인 숫자가 있다는 뜻이니까... false
            }
            if(node.childNodes.size()!=0) return false; //글을 다 넣었는데, 뒤에 글자가 있는 경우에는 자기가 접두사라는 뜻이고 처리해줘야함.
            node.isLast = true; //그리고 글 끝났으니까 그 위치의 node에는 true처리
            return true;
        }
    }

    static class TrieNode{
        Map<Integer, TrieNode> childNodes = new HashMap<>();
        boolean isLast;
    }
}
