package dp;

public class D {

	public static void main(String[] args) {
		int[] money = {1, 2, 3, 1};
		System.out.println(solution(money));
	}
	
	public static int solution(int[] money) {
        int dp0[] = new int[money.length]; //첫집 털고 마지막 집 못 터는 경우.
        int dp1[] = new int[money.length]; // 두번째 집 털고 마지막 집 터는 경우.
//        dp0[0] = money[0];
//        dp0[2] = dp0[0]+money[2];
//        for(int i=3; i<=money.length-1; i++ ){
//        		dp0[i] = Math.max(dp0[i-2]+money[i], dp0[i-3]+money[i]);
//        }
//        dp1[1] = money[1];
//        dp1[3] = money[3]+dp1[1];
//        for(int i=4; i<=money.length-1; i++ ){
//    			dp1[i] = Math.max(dp1[i-2]+money[i], dp1[i-3]+money[i]);
//        }
        dp0[0] = money[0];
        dp0[1] = money[0];
        for(int i=2; i<=money.length-1; i++ ){
        		dp0[i] = Math.max(dp0[i-2]+money[i], dp0[i-1]);
        }
        dp1[0] = 0;
        dp1[1] = money[1];
        for(int i=2; i<=money.length-1; i++ ){
    			dp1[i] = Math.max(dp1[i-2]+money[i], dp1[i-1]);
        }
        return Math.max(dp1[money.length-1], dp0[money.length-2]);
    }

}
