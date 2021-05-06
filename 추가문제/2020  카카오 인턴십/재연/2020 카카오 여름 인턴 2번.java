package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * 2020 īī�� ���� ���� ����
 * ������ �־��� ��, *, +, - �������� �켱������ ���� �����Ͽ� �־��� ���� ���밪�� �ִ밡 �ǵ��� �Ϸ��� �Ѵ�.
 * �켱������ ������ ������ ���� ������ �����ڰ� �����ϸ� �ȵȴ�.
 * ������ *, +, -�� ����� �Է��� �־�����.
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
		// ���ڴ� numList��, �����ڴ� opList�� ������� �����Ѵ�.
		for (int i = 0; i < expression.length(); i++) {
			char ch = expression.charAt(i);
			if (ch == '*' || ch == '+' || ch == '-') {
				opList.add(ch);
				numList.add(Integer.parseInt(expression.substring(0, i)));
				expression = expression.substring(i + 1);
				i = -1;
			}
		}
		// ������ ���� ���ڸ� �־��ش�.
		numList.add(Integer.parseInt(expression));
		BruteForce(0, 0, numList, opList);
		return answer;
	}

	/**
	 * ���Ʈ ������ ����Ͽ� (*, +, -), (*, -, +) �� ��� ����� ���� ���� ����غ���.
	 * @param start op�� ���� ����
	 * @param depth ���� ������ ������ Ƚ��
	 * @param numList ���꿡 ���� ���ڵ�
	 * @param opList ���꿡 ���� �����
	 */
	public void BruteForce(int start, int depth, ArrayList<Integer> numList, ArrayList<Character> opList) {
		// ��� �����ڸ� �� ���� �����ߴٸ� answer�� ���Ѵ�.
		if (depth == 3) {
			answer = Math.max(Math.abs(numList.get(0)), answer);
			return;
		}
		// -���� �����ϴ��� *, +�� Ž���� �� �־�� �ϹǷ� ������ 3�� for���� �����Ѵ�.
		for (int i = 0; i < 3; i++) {
			// ���� ������� ���� �����̸� ����Ѵ�.
			if (!opVisited[(start + i) % 3]) {
				opVisited[(start + i) % 3] = true;
				// �����ڿ� �´� ������ ������ ���� ������ �����Ѵ�.
				ArrayList<Integer> nextNum = findNextNumber(numList, opList, op[(start + i) % 3]);
				// ������ ���������Ƿ� ������ ������ ��� �����ش�.
				ArrayList<Character> nextOp = findNextOp(opList, op[(start + i) % 3]);
				BruteForce(start + 1, depth + 1, nextNum, nextOp);
				opVisited[(start + i) % 3] = false;
			}
		}
	}

	/**
	 * op�� ���� �����ڰ� opList�� �����Ѵٸ� op�� ������ �����Ѵ�. 
	 * @param numList ���� ���ڵ�
	 * @param opList ���� �����ڵ�
	 * @param op ������ ������ ������
	 * @return
	 */
	public ArrayList<Integer> findNextNumber(ArrayList<Integer> numList, ArrayList<Character> opList, char op) {
		ArrayList<Integer> next = new ArrayList<>();
		next.addAll(numList);
		// ������ �����Ѵٸ� next�� ������ �� ĭ�� ������ �������.
		// ���� ���� ��ŭ i���� ���־� �ε����� �����ش�.
		int removeCnt = 0;
		// i��° ���ڿ� i+1��° ���ڸ� i��° �����ڷ� ������ �����Ѵ�.
		for (int i = 0; i < opList.size(); i++) {
			char ch = opList.get(i);
			if (ch != op)
				continue;
			int left = next.remove(i - removeCnt);
			// 2�� �ε����� ���� ����ٸ� 3�� �ε����� 2�� �ε����� �ǹǷ� ���� �ε����� �� �� �� �����.
			int right = next.remove(i - removeCnt);
			// ������ �����ϰ� ������ ����� ���� �ε����� ������ �ε����� �ִ´�.
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
	 * �̹� ����� �����ڸ� opList���� ��� �����.
	 * @param opList �����ڵ�
	 * @param op ������ ������ ������
	 * @return ���� �����ڵ�
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