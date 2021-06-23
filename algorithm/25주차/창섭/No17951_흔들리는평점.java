/*
 * 문제 풀이 시작: 2021/06/22 11:12 오후
 * 맞은 시각: 2021/06/22
 * 소요 시간:
 * @author ventulus95
 */
package codeBaekJoon._2021;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No17951_흔들리는평점 {
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
        int answer = 0;
        int left = 0;
        int right = 2000000;
        while(left<=right){
            int mid = (left+right)/2;
            int group = 1; // 그룹은 처음 생성시 한개 무조건 만들어지니까 한개로 하고 넘어가야됨.
            int sum = 0;
            int start = 0;
            while(start<n){
                sum+=arr[start];
                if(sum>mid){ //sum==mid으로 딱떨어지면 일단 그룹 제끼고 무조건 크게해서 처리
                    group++;
                    sum = 0;
                }
                start++;
            }
            if(group>k){
                left = mid+1; // 그룹이 잘게 쪼개지는건 합이 너무 작은거니까 left를 mid+1만큼 올려서 값올려치기
            }
            else{
                right = mid-1; //그룹이 너무 크거나, 딱 맞는 경우는 right로 최대 범위를 쭐쭐 좁혀가기
                answer = mid;
            }
        }
        System.out.println(answer);
    }
}
