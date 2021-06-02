/*
 * 문제 풀이 시작: 2021/05/30 3:29 오후
 * 맞은 시각: 2021/05/30
 * 소요 시간:
 * @author ventulus95
 */
package codeBaekJoon._2021개인적;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;

public class No14003_가장긴증가하는부분수열5 {

        public static void main(String[] args) throws Exception{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringBuilder sb = new StringBuilder();
            int n = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            long[] arr = new long[n];
            int[] index = new int[n];
            ArrayList<Long> dp = new ArrayList<>();
            for (int i = 0; i <n; i++) {
                arr[i] = Long.parseLong(st.nextToken());
            }
            int idx=0;
            for (int i = 0; i <n; i++) {
                if(i==0){
                    dp.add(arr[0]);
                    index[0] = idx;
                    idx++;
                }
                else{
                    if(dp.get(idx-1)<arr[i]){
                        dp.add( arr[i]);
                        index[i] = idx;
                        idx++;
                    }
                    else{ // 인덱스 범위안에서  자기가 대처될만한 공간을 비집고 들어가자. 그모양이 실제로 만들어질 수 있는 배열 모양이 아니더라도...
                        int left = 0;
                        int right= idx-1;
                        while(left<right){
                            int mid = (left+right)/2;
                            if(dp.get(mid)<arr[i]){
                                left = mid+1;
                            }
                            else{
                                right = mid;
                            }
                        }
                        index[i] = left;
                        dp.set(left,arr[i]);
                    }
                }
            }
            sb.append(dp.size()).append("\n");
            idx--;
            Stack<Long> stack = new Stack<>();
            for (int i = n-1; i>=0; i--) {
                if(index[i]==idx){
                    stack.push(arr[i]);
                    idx--;
                }
            }
            while (!stack.isEmpty()){
                sb.append(stack.pop()).append(" ");
            }
            System.out.println(sb.toString());
        }
    }

