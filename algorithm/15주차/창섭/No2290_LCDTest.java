/*
 * 문제 풀이 시작: 2021/04/08 7:35 오후
 * 맞은 시각: 2021/04/08 8:16 오후
 * 소요 시간: 41분
 * @author ventulus95
 */
package codeBaekJoon._2021;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No2290_LCDTest {

    static int s;
    static StringBuilder[] set = new StringBuilder[5];
    static StringBuilder answer = new StringBuilder();


    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        s = Integer.parseInt(st.nextToken());
        for (int i = 0; i <5; i++) {
            set[i] = new StringBuilder();
        }
        for(int i=0; i<s+2; i++){
            if(i==0||i==s+1){
                set[0].append(" ");
                set[4].append("|");
            }
            else{
                set[0].append("-");
                set[4].append(" ");
            }
        }
        for(int i=0; i<s+2; i++){
            set[1].append(" ");
        }
        for(int i=0; i<s+2; i++){
            if(i==0)
                set[2].append("|");
            else
                set[2].append(" ");
        }
        for(int i=0; i<s+2; i++){
            if(i==s+1)
                set[3].append("|");
            else
                set[3].append(" ");
        }


        String token = st.nextToken();
        for(int h = 0; h<2*s+3; h++){
            for(int i=0; i<token.length(); i++){
                int num = token.charAt(i)-'0';
                printNum(num, h);
                answer.append(" ");
            }
            answer.append("\n");
        }
        System.out.println(answer.toString());
    }

    private static void printNum(int num, int height) {
        switch (num){
            case 0:
                if(height%(s+1)==0)
                    if (height==s+1)
                        answer.append(set[1]);
                    else
                        answer.append(set[0]);
                else
                    answer.append(set[4]);
                break;
            case 1:
                if(height%(s+1)==0)
                    answer.append(set[1]);
                else
                    answer.append(set[3]);
                break;
            case 2:
                if(height%(s+1)==0)
                    answer.append(set[0]);
                else if (height<s+1)
                    answer.append(set[3]);
                else{
                    answer.append(set[2]);
                }
                break;
            case 3:
                if(height%(s+1)==0)
                    answer.append(set[0]);
                else
                    answer.append(set[3]);
                break;
            case 4:
                if(height%(s+1)==0)
                    if(height==0||height==(s+1)*2)
                        answer.append(set[1]);
                    else
                        answer.append(set[0]);
                else if (height<s+1)
                    answer.append(set[4]);
                else
                    answer.append(set[3]);
                break;
            case 5:
                if(height%(s+1)==0)
                    answer.append(set[0]);
                else if (height<s+1)
                    answer.append(set[2]);
                else{
                    answer.append(set[3]);
                }
                break;
            case 6:
                if(height%(s+1)==0)
                    answer.append(set[0]);
                else if (height<s+1)
                    answer.append(set[2]);
                else{
                    answer.append(set[4]);
                }
                break;
            case 7:
                if(height%(s+1)==0)
                    if(height==0)
                        answer.append(set[0]);
                    else
                    answer.append(set[1]);
                else
                    answer.append(set[3]);
                break;
            case 8:
                if(height%(s+1)==0)
                    answer.append(set[0]);
                else{
                    answer.append(set[4]);
                }
                break;
            case 9:
                if(height%(s+1)==0)
                    answer.append(set[0]);
                else if (height<s+1)
                    answer.append(set[4]);
                else{
                    answer.append(set[3]);
                }
                break;
        }
    }
}
