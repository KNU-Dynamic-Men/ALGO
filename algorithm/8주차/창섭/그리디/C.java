// https://geehye.github.io/programmers-greedy-02/
package greedy;

public class C {

	public static void main(String[] args) {
		String number="534289"; 
		int k=3;
		System.out.println(solution(number, k));
	}
	
	public static String solution(String number, int k) {
		int idx =0;
		char max;
		StringBuilder sb = new StringBuilder();
		if(number.charAt(0)=='0')
			return "0";
		for(int i=0; i<number.length()-k; i++){ // k개를 지우는게 아니라 반대로 k개만 남기고 선택하는걸로 바꿈
			max = '0';
			for(int j=idx; j<=k+i; j++){ // index위치에서 k+i만만 더 선택함. 
				//k+i를 설정하는 이유는 마지막까지 선택하지 못하게 해서, 억지로라도 length-k개 만큼 뽑을 수 있게 함.
				if(max<number.charAt(j)){
					max = number.charAt(j); //max보다 크면, 걍 선택 (큰수만드는게 목적이므로)
					idx = j+1; //그리고 인덱스 위치 변경. 앞에 버린거 신경안쓰고 걍 뒤에만 체킹할거임. 
				}
			}
			sb.append(max);
		}
		return sb.toString();
	}
}
