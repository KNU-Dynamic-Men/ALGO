package kakaoIntern2020;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class A {

    public static void main(String[] args) {
        int[][] numbers = {{1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5}, {7, 0, 8, 2, 8, 3, 1, 5, 7, 6, 2}, {1, 2, 3, 4, 5, 6, 7, 8, 9, 0}};
        String[] hand = {"right", "left", "right"};
        for (int i=0; i<numbers.length; i++){
            System.out.println(solution(numbers[i], hand[i]));
        }


    }

    public static String solution(int[] numbers, String hand) {
        StringBuilder answer = new StringBuilder();
        HashMap<Integer ,Point> keypad = new HashMap<>();
        int cnt = 1;
        for (int j = 0; j <3; j++) {
            for (int k = 0; k <3; k++) {
                keypad.put(cnt, new Point(j,k));
                cnt++;
            }
        }
        keypad.put(0, new Point(3, 1));
        Point left = new Point(3,0);
        Point right = new Point(3,2);
        for(int num : numbers){
            if(num==1||num==4||num==7){
                answer.append("L");
                left = keypad.get(num);
            }
            else if(num==3||num==6||num==9){
                answer.append("R");
                right = keypad.get(num);
            }
            else{
                Point key = keypad.get(num);
                int ld = Math.abs(key.x- left.x)+Math.abs(key.y- left.y);
                int rd = Math.abs(key.x- right.x)+Math.abs(key.y- right.y);
                if(ld==rd){
                    if(hand.equals("right")) {
                        answer.append("R");
                        right = keypad.get(num);
                    }
                    else{
                        answer.append("L");
                        left = keypad.get(num);
                    }
                }
                else{
                    if(ld>rd){
                        answer.append("R");
                        right = keypad.get(num);
                    }
                    else{
                        answer.append("L");
                        left = keypad.get(num);
                    }
                }
            }
        }
        return answer.toString();
    }

    static class Point{
        int y, x;

        public Point(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
}
