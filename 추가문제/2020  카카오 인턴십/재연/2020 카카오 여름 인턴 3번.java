package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;

/**
 * 2020 카카오 여름 인턴 문제
 * 어피치가 보석을 쇼핑하려고 한다.
 * 어피치는 진열된 모든 보석을 사고 싶어한다.
 * 이 때, 진열된 모든 종류의 보석을 적어도 1개 이상 포함하는 가장 짧은 구간을 찾아서 구매하려고 한다.
 * 몇 번 보석부터 몇 번 보석까지 사야되는지 구하는 문제
 * 가장 짧은 구간이 여러 개라면 시작 진열대 번호가 가장 작은 구간을 구한다.
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
	 * 보석의 종류를 구하기 위해 HashSet에 모두 담아 종류를 구한다.
	 * 이후 투 포인터를 이용하여 한 칸씩 늘려가며 모든 보석의 종류를 살 수 있는지 확인한다.
	 * start부터 end까지의 보석의 종류가 전체 보석의 종류보다 작다면 end를 늘려 더 많은 보석을 구매해본다.
	 * 모든 보석을 적어도 한 개씩 구매할 수 있다면 현재 구간이 가장 짧은 구간인지 확인한다.
	 * 이후 start를 증가시키고, start에 있던 보석을 Hash에서 제거한다.
	 * @param gems 진열된 보석의 종류
	 * @return 모든 보석을 적어도 1개씩 사기 위한 가장 짧은 구간
	 */
	public int[] solution(String[] gems) {
		int[] answer = { 1, gems.length };
		// 전체 보석의 종류를 파악한다.
		for (String gem : gems)
			totalTypeOfGem.add(gem);
		int totalSize = totalTypeOfGem.size();
		int start = 0;
		int end = 0;
		HashMap<String, Integer> typeOfGem = new HashMap<>();
		// start가 증가하는 경우 end는 증가하지 않았으므로 put하지 않아야 한다.
		// 따라서 end가 증가하는 경우에만 put하도록 한다.
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