package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Solution s = new Solution();
		String[] gems = // { "DIA", "RUBY", "RUBY", "DIA", "DIA", "EMERALD","SAPPHIRE", "DIA" };
				// {"AA", "AB", "AC", "AA", "AC"};
				// {"XYZ", "XYZ","XYZ"};
				{ "ZZZ", "YYY", "NNNN", "YYY", "BBB" };

		int[] result = s.solution(gems);
		System.out.println(result[0] + " " + result[1]);
	}
}

class Solution {
	HashSet<String> totalTypeOfGem = new HashSet<>();

	public int[] solution(String[] gems) {
		int[] answer = { 1, gems.length };
		for (String gem : gems)
			totalTypeOfGem.add(gem);
		int totalSize = totalTypeOfGem.size();
		int start = 0;
		int end = 0;
		HashSet<String> typeOfGem = new HashSet<>();
		while (start <= end && end < gems.length) {
			for (int i = start; i <= end; i++)
				typeOfGem.add(gems[i]);
			if (typeOfGem.size() < totalSize)
				end++;
			else if (typeOfGem.size() == totalSize) {
				if (end - start < answer[1] - answer[0]) {
					answer[0] = start + 1;
					answer[1] = end + 1;
				}
				start++;
			}
			typeOfGem.clear();
		}
		return answer;
	}
}