package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		int testCase = Integer.parseInt(br.readLine());
		while (testCase-- > 0) {
			int n = Integer.parseInt(br.readLine());
			Trie trie = new Trie();
			boolean check = true;
			while (n-- > 0)
				if (!trie.addPhoneNumber(br.readLine()))
					check = false;
			sb.append(check ? "YES\n" : "NO\n");
		}
		System.out.println(sb);
	}
}

class Trie {
	private Node root = new Node();

	public boolean addPhoneNumber(String number) {
		Node cur = root;
		for (int i = 0; i < number.length(); i++) {
			if (cur.getIsEnd())
				return false;
			cur = cur.add(number.charAt(i));
		}
		if (cur.getSize() != 0)
			return false;
		return cur.end();
	}
}

class Node {
	private HashMap<Character, Node> hash = new HashMap<>();
	private boolean isEnd = false;

	public Node add(char ch) {
		hash.putIfAbsent(ch, new Node());
		return hash.get(ch);
	}

	public int getSize() {
		return hash.size();
	}

	public boolean getIsEnd() {
		return isEnd;
	}

	public boolean end() {
		return isEnd = true;
	}
}