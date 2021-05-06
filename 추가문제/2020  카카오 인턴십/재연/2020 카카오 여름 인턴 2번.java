package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Solution s = new Solution();
		String expression =  "100-200*300-500+20";
				//"50*6-3*2";
		System.out.println(s.solution(expression));
	}
}

class Solution {
	char[] op = { '*', '+', '-' };
	boolean[] opVisited = new boolean[3];
	long answer = 0;

	public long solution(String expression) {
		ArrayList<Integer> numList = new ArrayList<>();
		ArrayList<Character> opList = new ArrayList<>();
		for (int i = 0; i < expression.length(); i++) {
			char ch = expression.charAt(i);
			if (ch == '*' || ch == '+' || ch == '-') {
				opList.add(ch);
				numList.add(Integer.parseInt(expression.substring(0, i)));
				expression = expression.substring(i + 1);
				i = -1;
			}
		}
		numList.add(Integer.parseInt(expression));
		BruteForce(0, 0, numList, opList);
		return answer;
	}

	public void BruteForce(int start, int depth, ArrayList<Integer> numList, ArrayList<Character> opList) {
		if (depth == 3) {
			answer = Math.max(Math.abs(numList.get(0)), answer);
			return;
		}
		for (int i = 0; i < 3; i++) {
			if (!opVisited[(start + i) % 3]) {
				opVisited[(start + i) % 3] = true;
				ArrayList<Integer> nextNum = findNextNumber(numList, opList, op[(start + i) % 3]);
				ArrayList<Character> nextOp = findNextOp(opList, op[(start + i) % 3]);
				BruteForce(start + 1, depth + 1, nextNum, nextOp);
				opVisited[(start + i) % 3] = false;
			}
		}
	}

	public ArrayList<Integer> findNextNumber(ArrayList<Integer> numList, ArrayList<Character> opList, char op) {
		ArrayList<Integer> next = new ArrayList<>();
		next.addAll(numList);
		int removeCnt = 0;
		for (int i = 0; i < opList.size(); i++) {
			char ch = opList.get(i);
			if (ch != op)
				continue;
			int left = next.remove(i - removeCnt);
			int right = next.remove(i - removeCnt);
			if (op == '*')
				next.add(i - removeCnt, left * right);
			else if (op == '+')
				next.add(i - removeCnt, left + right);
			else
				next.add(i - removeCnt, left - right);
			removeCnt++;
		}
		return next;
	}

	public ArrayList<Character> findNextOp(ArrayList<Character> opList, char op) {
		ArrayList<Character> next = new ArrayList<>();
		for (char ch : opList) {
			if (ch != op)
				next.add(ch);
		}
		return next;
	}
}