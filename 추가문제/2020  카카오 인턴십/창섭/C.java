package kakaoIntern2020;

import java.util.Arrays;
import java.util.HashMap;

public class C {

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
        //투포인터로 하면 안되나...?
        for (int i = 0; i <arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                int cnt = hash.size();
                for (String key :hash.keySet()){
                    if(arr[j].get(key)-arr[i].get(key)==0)
                        break;
                    cnt--;
                }
                if(cnt==0){
                    length = Math.min(length, j-i-1);
                    if(length == j-i-1){
                        if(answer[0]<i+2){
                            answer[0] = i+2;
                            answer[1] = j+1;
                        }
                    }
                    break;
                }
            }
        }
        return answer;
    }
}


