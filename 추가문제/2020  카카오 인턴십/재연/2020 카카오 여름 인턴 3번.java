package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;

/**
 * 2020 īī�� ���� ���� ����
 * ����ġ�� ������ �����Ϸ��� �Ѵ�.
 * ����ġ�� ������ ��� ������ ��� �;��Ѵ�.
 * �� ��, ������ ��� ������ ������ ��� 1�� �̻� �����ϴ� ���� ª�� ������ ã�Ƽ� �����Ϸ��� �Ѵ�.
 * �� �� �������� �� �� �������� ��ߵǴ��� ���ϴ� ����
 * ���� ª�� ������ ���� ����� ���� ������ ��ȣ�� ���� ���� ������ ���Ѵ�.
 * @author Rave
 *
 */
public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Solution s = new Solution();
		String[] gems = { "DIA", "RUBY", "RUBY", "DIA", "DIA", "EMERALD", "SAPPHIRE", "DIA" };
		// { "AA", "AB", "AC", "AA", "AC" };
		// {"XYZ", "XYZ","XYZ"};
		// { "ZZZ", "YYY", "NNNN", "YYY", "BBB" };
		// {"A", "B", "B", "C", "A"};
		// { "A", "A", "B" };
		int[] result = s.solution(gems);
		System.out.println(result[0] + " " + result[1]);
	}
}

class Solution {
	HashSet<String> totalTypeOfGem = new HashSet<>();

	/**
	 * ������ ������ ���ϱ� ���� HashSet�� ��� ��� ������ ���Ѵ�.
	 * ���� �� �����͸� �̿��Ͽ� �� ĭ�� �÷����� ��� ������ ������ �� �� �ִ��� Ȯ���Ѵ�.
	 * start���� end������ ������ ������ ��ü ������ �������� �۴ٸ� end�� �÷� �� ���� ������ �����غ���.
	 * ��� ������ ��� �� ���� ������ �� �ִٸ� ���� ������ ���� ª�� �������� Ȯ���Ѵ�.
	 * ���� start�� ������Ű��, start�� �ִ� ������ Hash���� �����Ѵ�.
	 * @param gems ������ ������ ����
	 * @return ��� ������ ��� 1���� ��� ���� ���� ª�� ����
	 */
	public int[] solution(String[] gems) {
		int[] answer = { 1, gems.length };
		// ��ü ������ ������ �ľ��Ѵ�.
		for (String gem : gems)
			totalTypeOfGem.add(gem);
		int totalSize = totalTypeOfGem.size();
		int start = 0;
		int end = 0;
		HashMap<String, Integer> typeOfGem = new HashMap<>();
		// start�� �����ϴ� ��� end�� �������� �ʾ����Ƿ� put���� �ʾƾ� �Ѵ�.
		// ���� end�� �����ϴ� ��쿡�� put�ϵ��� �Ѵ�.
		boolean isIncreaseEnd = true;
		while (start <= end && end < gems.length) {
			if (isIncreaseEnd)
				typeOfGem.put(gems[end], typeOfGem.getOrDefault(gems[end], 0) + 1);
			if (typeOfGem.size() < totalSize) {
				end++;
				isIncreaseEnd = true;
			} else if (typeOfGem.size() == totalSize) {
				if (end - start < answer[1] - answer[0]) {
					answer[0] = start + 1;
					answer[1] = end + 1;
				}
				int remove = typeOfGem.get(gems[start]);
				if (remove == 1)
					typeOfGem.remove(gems[start]);
				else
					typeOfGem.replace(gems[start], remove - 1);
				start++;
				isIncreaseEnd = false;
			}
		}
		return answer;
	}
}