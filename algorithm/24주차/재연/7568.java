package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * N���� ������� ��ġ�� ���Ͽ� ����� �ű���� �Ѵ�.
 * ��ġ�� Ű�� ������ ��� ū ����� ��ġ�� ũ�ٰ� �� �� �ִ�.
 * N���� ������� ��ġ�� ������ ���ϴ� ����
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
			// �ڱ⺸�� ��ġ�� ū ����� ���� ���Ѵ�.
			for (int j = 0; j < n; j++)
				if (i != j && people[j].compareTo(people[i]) < 0)
					sum++;
			// sum�� 1�� ���� ���� i��° ����� ����� �ȴ�.
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