package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 2020 카카오 여름 인턴 문제
 * 키패드에서 눌러야 하는 번호들이 주어질 때, 각 번호를 누르는 손이 왼손인지 오른손인지를
 * 연속된 문자열 형태로 반환하는 문제
 * 키패드는 엄지손가락만을 이용하여 누르고, 엄지손가락을 사용하는 규칙은 다음과 같다.
 * 1.엄지손가락은 상하좌우 4가지 방향으로만 이동할 수 있으며 키패드 이동 한 칸은 거리로 1에 해당합니다.
 * 2.왼쪽 열의 3개의 숫자 1, 4, 7을 입력할 때는 왼손 엄지손가락을 사용합니다.
 * 3.오른쪽 열의 3개의 숫자 3, 6, 9를 입력할 때는 오른손 엄지손가락을 사용합니다.
 * 4.가운데 열의 4개의 숫자 2, 5, 8, 0을 입력할 때는 두 엄지손가락의 현재 키패드의 위치에서 더 가까운 엄지손가락을 사용합니다.
 * 	4-1. 만약 두 엄지손가락의 거리가 같다면, 오른손잡이는 오른손 엄지손가락, 왼손잡이는 왼손 엄지손가락을 사용합니다.
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
	 * 처음 왼쪽손은 * 모양에 있고, 오른손은 #모양에 있다.
	 * 각 위치를 Point로 잡아두고 키패드를 누를때마다 위치를 업데이트해준다.
	 * 위치를 업데이트하며 왼쪽손으로 눌렀다면 L을 오른손으로 눌렀다면 R을 answer에 추가해준다.
	 * @param numbers 눌러야 하는 번호들
	 * @param hand 왼손잡이라면 left, 오른손잡이라면 right
	 * @return 숫자를 누른 손이 어느 손인지를 나타내는 문자열
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