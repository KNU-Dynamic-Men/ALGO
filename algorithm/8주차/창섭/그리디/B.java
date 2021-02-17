//https://parksuu.github.io/139-프로그래머스-조이스틱-(java)/
package greedy;

public class B {

	public static void main(String[] args) {
		

	}
	
    public int solution(String name) {
        int answer = 0;
        int min_move = name.length()-1;
        for(int i=0; i<name.length(); i++){
    			//위 아래로, 글자바뀌는 경우만 체크
        		answer += Math.min(name.charAt(i)-'A', 'Z'-name.charAt(i)+1);
        		int next = i+1;
        		while(next<name.length() && name.charAt(next)=='A')
        			next++;
        		/* 여기서는 왼쪽으로 가는게 유리한지 오른쪽으로 한칸씩 이동하는게 유리한지여기서는 왼쪽으로 가는게 유리한지 오른쪽으로 한칸씩 이동하는게 유리한지
        		 * 현위치에서 0위치로 돌아가서, 역순으로 가는게 유리한지를 선택하는 것.
        		 * min_move에서는 그저 AAA가 끝나는 위치 지점까지 가는 <- 방향 갯수와 현 위치에서 >갯수 + 0으로 돌아오는 < 갯수를 모두 더한케이스를 알려준다.
        		 * 계산하면서 알았던 것이지만, A가 다음처럼 있는 경우 BBAAAAAABBAAAABB이렇게 있을때는 두번 while문을 도는데 이방식으로 돌때는 첫번째 AA에 대해서는 역순으로
        		 * 두번째 연속 AA에 대해서는 정방향이 유리하다고 나타난다.
        		 * 이말은 결국 두번째 BB를 갈때는 왼쪽으로 가는게 유리하다는 뜻이된다. 뭐 확실하지는 않지만. 중간지점 이상부터는 현위치에서 다시 0위치로 돌아가는게 더 커져서
        		 * 안돌아가는 것이 좋다는 뜻이 되기도 한다. i가 커질수록 min_move를 바꿀 이유가 딱히 없어지는 것.
        		 */
        		min_move = Math.min(min_move, i+name.length()-next+i);
        }
        answer+= min_move;
        return answer;
    }

}
