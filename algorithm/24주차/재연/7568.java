package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * N명의 사람들의 덩치를 비교하여 등수를 매기려고 한다.
 * 덩치는 키와 몸무게 모두 큰 사람이 덩치가 크다고 할 수 있다.
 * N명의 사람들의 덩치의 순위를 구하는 문제
 * @author Rave
 *
 */
public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();
		int n = Integer.parseInt(br.readLine());
		Person[] people = new Person[n];
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int weight = Integer.parseInt(st.nextToken());
			int height = Integer.parseInt(st.nextToken());
			people[i] = new Person(weight, height);
		}
		for (int i = 0; i < n; i++) {
			int sum = 0;
			// 자기보다 덩치가 큰 사람의 수를 구한다.
			for (int j = 0; j < n; j++)
				if (i != j && people[j].compareTo(people[i]) < 0)
					sum++;
			// sum에 1을 더한 값이 i번째 사람의 등수가 된다.
			sb.append((sum + 1) + "\n");
		}
        System.out.print(sb);
	}
}

class Person implements Comparable<Person> {
	int weight, height;

	public Person(int _weight, int _height) {
		this.weight = _weight;
		this.height = _height;
	}
    
	@Override
	public int compareTo(Person o) {
		if (weight > o.weight && height > o.height)
			return -1;
		return 0;
	}
}