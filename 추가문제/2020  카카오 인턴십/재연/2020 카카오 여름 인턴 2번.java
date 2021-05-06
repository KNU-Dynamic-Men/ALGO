package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * 2020 카카오 여름 인턴 문제
 * 수식이 주어질 때, *, +, - 연산자의 우선순위를 새로 정의하여 주어진 식의 절대값이 최대가 되도록 하려고 한다.
 * 우선순위를 정의할 때에는 같은 순위의 연산자가 존재하면 안된다.
 * 연산은 *, +, -만 사용한 입력이 주어진다.
 * @author Rave
 *
 */
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
		// 숫자는 numList에, 연산자는 opList에 순서대로 저장한다.
		for (int i = 0; i < expression.length(); i++) {
			char ch = expression.charAt(i);
			if (ch == '*' || ch == '+' || ch == '-') {
				opList.add(ch);
				numList.add(Integer.parseInt(expression.substring(0, i)));
				expression = expression.substring(i + 1);
				i = -1;
			}
		}
		// 마지막 남은 숫자를 넣어준다.
		numList.add(Integer.parseInt(expression));
		BruteForce(0, 0, numList, opList);
		return answer;
	}

	/**
	 * 브루트 포스를 사용하여 (*, +, -), (*, -, +) 등 모든 경우의 수를 전부 계산해본다.
	 * @param start op의 시작 지점
	 * @param depth 현재 연산을 수행한 횟수
	 * @param numList 연산에 사용될 숫자들
	 * @param opList 연산에 사용될 연산들
	 */
	public void BruteForce(int start, int depth, ArrayList<Integer> numList, ArrayList<Character> opList) {
		// 모든 연산자를 한 번씩 연산했다면 answer과 비교한다.
		if (depth == 3) {
			answer = Math.max(Math.abs(numList.get(0)), answer);
			return;
		}
		// -에서 시작하더라도 *, +를 탐색할 수 있어야 하므로 무조건 3번 for문을 돌게한다.
		for (int i = 0; i < 3; i++) {
			// 아직 사용하지 않은 연산이면 사용한다.
			if (!opVisited[(start + i) % 3]) {
				opVisited[(start + i) % 3] = true;
				// 연산자에 맞는 연산을 수행한 후의 값들을 저장한다.
				ArrayList<Integer> nextNum = findNextNumber(numList, opList, op[(start + i) % 3]);
				// 연산을 수행했으므로 수행한 연산을 모두 지워준다.
				ArrayList<Character> nextOp = findNextOp(opList, op[(start + i) % 3]);
				BruteForce(start + 1, depth + 1, nextNum, nextOp);
				opVisited[(start + i) % 3] = false;
			}
		}
	}

	/**
	 * op와 같은 연산자가 opList에 존재한다면 op의 연산을 수행한다. 
	 * @param numList 남은 숫자들
	 * @param opList 남은 연산자들
	 * @param op 연산을 수행할 연산자
	 * @return
	 */
	public ArrayList<Integer> findNextNumber(ArrayList<Integer> numList, ArrayList<Character> opList, char op) {
		ArrayList<Integer> next = new ArrayList<>();
		next.addAll(numList);
		// 연산을 수행한다면 next의 값들이 한 칸씩 앞으로 당겨진다.
		// 따라서 지운 만큼 i에서 빼주어 인덱스를 맞춰준다.
		int removeCnt = 0;
		// i번째 숫자와 i+1번째 숫자를 i번째 연산자로 연산을 수행한다.
		for (int i = 0; i < opList.size(); i++) {
			char ch = opList.get(i);
			if (ch != op)
				continue;
			int left = next.remove(i - removeCnt);
			// 2번 인덱스의 값을 지운다면 3번 인덱스가 2번 인덱스가 되므로 같은 인덱스를 한 번 더 지운다.
			int right = next.remove(i - removeCnt);
			// 연산을 수행하고 수행한 결과를 뺀내 인덱스와 동일한 인덱스에 넣는다.
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

	/**
	 * 이미 사용한 연산자를 opList에서 모두 지운다.
	 * @param opList 연산자들
	 * @param op 연산을 수행한 연산자
	 * @return 남은 연산자들
	 */
	public ArrayList<Character> findNextOp(ArrayList<Character> opList, char op) {
		ArrayList<Character> next = new ArrayList<>();
		for (char ch : opList) {
			if (ch != op)
				next.add(ch);
		}
		return next;
	}
}