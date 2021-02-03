package brutalForce;

import java.util.ArrayList;
import java.util.HashMap;

public class B {
	static int answer = 0;
	static boolean[] visited;
	static ArrayList<Character> list = new ArrayList<>();
	static HashMap<Integer, Integer> check = new HashMap<>();  

	public static void main(String[] args) {
		String numbers = "011";
		System.out.println(solution(numbers));

	}

	public static int solution(String numbers) {
		char[] num = new char[numbers.length()];
		visited = new boolean[numbers.length()];
		for(int i=0; i<numbers.length(); i++){
			num[i] = numbers.charAt(i);
		}
		for(int i=1; i<=numbers.length(); i++){
			list.clear();
			brute(num, 0, i);
		}
		return answer;
	}
	
	//소수체크
	public static void prime(int num){
		boolean flag = true;
		if(num<2){
			return;
		}
		if(num==2){
			answer++;
			return;
		}
		for(int i=2; i<num; i++){
			if(num%i==0){
				flag=false;
				return;
			}
		}
		if(flag==true){
			answer++;
			return;
		}

	}
	
	//만들수 있는 모든 경우 만들기
	public static void brute(char[] num,int deep, int n){
		if(deep==n){
			String temp="";
			for(char k: list){
				temp+=k;
			}
			int key = Integer.valueOf(temp);
			if(!check.containsKey(key)){
				check.put(key, 0);
				prime(Integer.valueOf(temp));
			}
			return;
		}
		else{
			for(int i=0; i<num.length; i++){
				if(visited[i]==false){
					list.add(num[i]);
					visited[i] = true;
					brute(num, deep+1, n);
					list.remove(deep);
					visited[i] = false;
				}
			}
		}
	}

}
