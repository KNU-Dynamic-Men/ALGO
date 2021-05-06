package kakaoIntern2020;

import java.util.Arrays;
import java.util.HashMap;

public class C_틀림 {

    public static void main(String[] args) {
        String[] gems = {"DIA", "RUBY", "RUBY", "DIA", "DIA", "EMERALD", "SAPPHIRE", "DIA"};
        System.out.println(Arrays.toString(solution(gems)));

    }

    public static int[] solution(String[] gems) {
        int length = Integer.MAX_VALUE;
        int[] answer = new int[2];
        HashMap<String, Integer> hash = new HashMap<>();
        for (String gem: gems){
            hash.putIfAbsent(gem, 0);
        }
        HashMap<String, Integer>[] arr = new HashMap[gems.length];
        for (int i = 0; i <arr.length; i++) {
            int value = hash.get(gems[i]);
            hash.replace(gems[i], value+1);
            arr[i] = new HashMap<>(hash);
        }
        if(hash.size()==1){
            return new int[]{1,1};
        }
        for (int i = arr.length-1; i>=0 ; i--) {
            //모든 값이 0이상인지 체크 스타트지점이 모든 보석을 가지고 있긴 있어야하니까.
            int cnt = hash.size();
            for (int val: arr[i].values()){
                if(val>0)
                    cnt--;
            }
            if(cnt>0)
                break;
            //그 지점으로 부터 -1 지점인 부분을 다 체크해서
            for (int j = i-1; j>=0 ; j--) {
                cnt = hash.size();
                for (String key :hash.keySet()){
                    if(arr[i].get(key)-arr[j].get(key)==0)
                        break;
                    cnt--;
                }
                if(cnt==0){
                    length = Math.min(length, i-j-1);
                    if(length == i-j-1){
                        answer[0] = j+2;
                        answer[1] = i+1;
                    }
                }
            }
            if(length>=i){
                answer[0] = 1;
                answer[1] = i+1;
                length = i;
            }
        }
        for (HashMap<String, Integer> a: arr){
            System.out.println(a);
        }
        return answer;
    }
}


