/*
 * 문제 풀이 시작: 2021/05/26 10:40 오전
 * 맞은 시각: 2021/05/26
 * 소요 시간:
 * @author ventulus95
 */
package codeBaekJoon._2021;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No17951_흩날리는시험지속 {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i <n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int left = 0;
        int right = 100000*20;
        int answer = 0;
        while(left<=right){
            int mid = (left+right)/2;
            int group = 1;
            int sum =0;
            for (int i = 0; i <n; i++) {
                sum+=arr[i];
                if(mid<sum){
                    sum = 0; //arr[i]로 잡으면 틀리고 0으로 잡으면 맞음. 왜? 모든 그룹이 MID 값 이상이여만 하므로, MID값 이상인 경우에만 그룹을 늘려줘야함.
                    // 그래서 arr[i]로 잡으면 MID값 이상인 그룹이 안생기게 됨. 내가 찾고싶은건 이 그룹내에서 최대 몇점을 받을수가 있는지가 중요함.
                    // GROUP이 3개가 되든 2개가되든 중요하는거는 아니다. 실제로 지금 2개로 쪼개진 경우에서 값이 존재하는가가 더중요
                    // 이거를 통해서 알수 있는점은 left 45 right 51일때  mid 48 -> 그룹이 3개로 쪼개져도(논리적으로는 2그룹임) 실제로 우리가 그룹을 쪼개는 경우는 50인경우를 찾을 수 있게금 코드 구성이 되있다.
                    // 그리고 이 탐색으로 통해 찾고 싶은거는 45~51안에 그룹 두개로 쪼개지는 경우가 존재하느냐가 주요목적. 
                    group++;
                }
            }
            if(group>k){
                left = mid+1;
            }
            else{
                right = mid -1;
                answer = mid;
            }
        }
        System.out.println(answer);
    }
}
