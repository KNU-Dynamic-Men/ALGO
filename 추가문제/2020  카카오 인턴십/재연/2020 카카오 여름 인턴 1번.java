package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 2020 īī�� ���� ���� ����
 * Ű�е忡�� ������ �ϴ� ��ȣ���� �־��� ��, �� ��ȣ�� ������ ���� �޼����� ������������
 * ���ӵ� ���ڿ� ���·� ��ȯ�ϴ� ����
 * Ű�е�� �����հ������� �̿��Ͽ� ������, �����հ����� ����ϴ� ��Ģ�� ������ ����.
 * 1.�����հ����� �����¿� 4���� �������θ� �̵��� �� ������ Ű�е� �̵� �� ĭ�� �Ÿ��� 1�� �ش��մϴ�.
 * 2.���� ���� 3���� ���� 1, 4, 7�� �Է��� ���� �޼� �����հ����� ����մϴ�.
 * 3.������ ���� 3���� ���� 3, 6, 9�� �Է��� ���� ������ �����հ����� ����մϴ�.
 * 4.��� ���� 4���� ���� 2, 5, 8, 0�� �Է��� ���� �� �����հ����� ���� Ű�е��� ��ġ���� �� ����� �����հ����� ����մϴ�.
 * 	4-1. ���� �� �����հ����� �Ÿ��� ���ٸ�, ���������̴� ������ �����հ���, �޼����̴� �޼� �����հ����� ����մϴ�.
 * @author Rave
 *
 */
public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Solution s = new Solution();
		int[] numbers = //{ 1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5 };
			//{7, 0, 8, 2, 8, 3, 1, 5, 7, 6, 2};
			{1, 2, 3, 4, 5, 6, 7, 8, 9, 0};
		String hand = //"right";
			//"left";
				"right";
		System.out.println(s.solution(numbers, hand));
	}
}

class Solution {
	/**
	 * ó�� ���ʼ��� * ��翡 �ְ�, �������� #��翡 �ִ�.
	 * �� ��ġ�� Point�� ��Ƶΰ� Ű�е带 ���������� ��ġ�� ������Ʈ���ش�.
	 * ��ġ�� ������Ʈ�ϸ� ���ʼ����� �����ٸ� L�� ���������� �����ٸ� R�� answer�� �߰����ش�.
	 * @param numbers ������ �ϴ� ��ȣ��
	 * @param hand �޼����̶�� left, ���������̶�� right
	 * @return ���ڸ� ���� ���� ��� �������� ��Ÿ���� ���ڿ�
	 */
	public String solution(int[] numbers, String hand) {
		String answer = "";
		Point left = new Point(3, 0);
		Point right = new Point(3, 2);
		for (int num : numbers) {
			if (num == 1 || num == 4 || num == 7) {
				left = new Point(num / 3, 0);
				answer += "L";
			} else if (num == 3 || num == 6 || num == 9) {
				right = new Point(num / 3 - 1, 2);
				answer += "R";
			} else {
				Point numP = getPoint(num);
				int leftDistance = Math.abs(left.x - numP.x) + Math.abs(left.y - numP.y);
				int rightDistance = Math.abs(right.x - numP.x) + Math.abs(right.y - numP.y);
				char nextHand = findHand(leftDistance, rightDistance, hand);
				if (nextHand == 'L')
					left = numP;
				else
					right = numP;
				answer += nextHand;
			}
		}
		return answer;
	}

	public Point getPoint(int num) {
		if (num == 0)
			return new Point(3, 1);
		return new Point(num / 3, 1);
	}

	public char findHand(int leftD, int rightD, String hand) {
		if (leftD < rightD)
			return 'L';
		else if (rightD < leftD)
			return 'R';
		else if (hand.equals("right"))
			return 'R';
		else
			return 'L';
	}
}

class Point {
	int x, y;

	public Point(int _x, int _y) {
		this.x = _x;
		this.y = _y;
	}
}