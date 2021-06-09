/*
 * 문제 풀이 시작: 2021/06/09 3:56 오후
 * 맞은 시각: 2021/06/09 5:53 -> 접기로 결정.
 * 소요 시간:
 * @author ventulus95
 */
package codeBaekJoon._2021;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class No12757_전설의JBNU {

    static ArrayList<Data> list = new ArrayList<>();

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        for (int i = 0; i <n; i++) {
            st = new StringTokenizer(br.readLine());
            int key  = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());
            list.add(new Data(key, value));
        }
        Collections.sort(list);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i <m; i++) {
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            int key = Integer.parseInt(st.nextToken());
            int value = -1;
            if(num<3) {
                value = Integer.parseInt(st.nextToken());
            }
            String val = find(num, key, value, k);
            if(!val.equals(""))
                sb.append(val).append("\n");
        }
        System.out.print(sb.toString());
        System.out.println(list);
    }

    private static String find(int num, int key, int value, int k) {
        int idx = low_bound(key);
        if(num==3||num==2){
            if(key==list.get(idx).k){
                if(idx==0){
                    if(list.get(idx+1).k!=key){
                        if(num==2)
                            list.get(idx).v = value;
                        else
                            return String.valueOf(list.get(idx).v);
                    }
                    else{
                        return "?";
                    }
                }
                else if(idx== list.size()-1){
                    if(num==2)
                        list.get(idx).v = value;
                    else
                        return String.valueOf(list.get(idx).v);
                }
                else{
                    if(list.get(idx+1).k!=key)
                        if(num==2)
                            list.get(idx).v = value;
                        else
                        return String.valueOf(list.get(idx).v);
                    else
                        if(num==3)
                            return "?";
                }
            }
            else{
                if(idx==0 || idx==list.size()-1){ //맨앞
                    if(Math.abs(key-list.get(idx).k)<=k){
                        if(num==2)
                            list.get(idx).v = value;
                        else{
                            return String.valueOf(list.get(idx).v);
                        }
                    }
                    else{
                        return "-1";
                    }
                }
                else{
                    int left = Math.abs(key-list.get(idx-1).k);
                    int right = Math.abs(key-list.get(idx).k);
                    if(left<right){
                        if(left<=k){
                            if(num==2)
                                list.get(idx-1).v = value;
                            else{
                                return String.valueOf(list.get(idx-1).v);
                            }
                        }
                        else{
                            return "-1";
                        }
                    }
                    else if(right<left){
                        if(right<=k){
                            if(num==2)
                                list.get(idx).v = value;
                            else{
                                return String.valueOf(list.get(idx).v);
                            }
                        }
                        else{
                            return "-1";
                        }
                    }
                    else{
                        if(num==3)
                            return "?";
                    }
                }
            }
        }
        else{
            if(idx<list.size()-1)
                list.add(idx, new Data(key, value));
            else
                if(list.get(idx).k<key)
                    list.add(new Data(key, value));
                else{
                    list.add(idx, new Data(key, value));
                }
        }
        return "";
    }

    private static int low_bound(int key) {
        int left = 0;
        int right = list.size()-1;
        while(left<right){
            int mid = (left+right)/2;
            if(key <=list.get(mid).k)
                right = mid;
            else
                left =mid+1;
        }
        return left;
    }

    static class Data implements Comparable<Data>{
        int k, v;

        public Data(int k, int v) {
            this.k = k;
            this.v = v;
        }

        @Override
        public int compareTo(Data o) {
            return this.k-o.k;
        }

        @Override
        public String toString() {
            return "Data{" +
                    "k=" + k +
                    ", v=" + v +
                    '}';
        }
    }
}
