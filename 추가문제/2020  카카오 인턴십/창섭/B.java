package kakaoIntern2020;

import java.util.*;

public class B {

    static ArrayList<String> list;
    static long answer;

    public static void main(String[] args) {
        String[] expression = {"100-200*300-500+20", "50*6-3*2"};
        for (String e: expression){
            System.out.println(solution(e));
        }
    }

    public static long solution(String expression) {
        answer = 0;
        HashSet<String> exp = new HashSet<>();
        StringTokenizer st = new StringTokenizer(expression, "-+*", true);
        list = new ArrayList<>();
        while(st.hasMoreTokens()){
            list.add(st.nextToken());
            if(st.hasMoreTokens()){
                String e = st.nextToken(); //연산자
                exp.add(e);
                list.add(e);
            }
        }
        String[] array = list.toArray(new String[0]);
        String[] earr = exp.toArray(new String[0]);
        boolean[] visited = new boolean[exp.size()];
        permutation(exp.size(),0, new LinkedList<>(),visited, earr);
        return answer;
    }

    private static void permutation(int size, int deep, Deque<String> q, boolean[] visited, String[] exp) {
        if(deep==size){
            System.out.print("우선순위: ");
            System.out.println(q);
            ArrayList<String> temp = new ArrayList<>(list);
            System.out.println(temp);
            for (String e: q){
                Stack<String> check = new Stack<>();
                int i=0;
                for (; i< temp.size(); i++) {
                    if(temp.get(i).equals(e)){
                        String a = check.pop();
                        check.add(calc(a, temp.get(i), temp.get(i+1)));
                        i+=1;
                    }
                    else{
                        check.add(temp.get(i));
                    }
                }
                temp = new ArrayList<>(check);
                System.out.println(temp);
            }
            long num = Math.abs(Long.parseLong(temp.get(0)));
            answer = Math.max(num, answer);
        }
        for (int i = 0; i <size; i++) {
            if(!visited[i]){
                q.add(exp[i]);
                visited[i] = true;
                permutation(size, deep+1, q, visited, exp);
                q.removeLast();
                visited[i] =false;
            }
        }
    }

    private static String calc(String a, String exp, String b) {
        if(exp.equals("*")){
            return String.valueOf(Long.parseLong(a)*Long.parseLong(b));
        }
        else if(exp.equals("+")){
            return String.valueOf(Long.parseLong(a)+Long.parseLong(b));
        }
        else{
            return String.valueOf(Long.parseLong(a)-Long.parseLong(b));
        }
    }
}
