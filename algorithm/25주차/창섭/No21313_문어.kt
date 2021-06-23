package codeBaekJoon._2021

import java.io.BufferedReader
import java.io.InputStreamReader

/*
 * 문제 풀이 시작: 2021/06/17 6:52 오후
 * 맞은 시각: 2021/06/17 
 * 소요 시간: 
 * @author ventulus95
*/

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val n  = readLine().toInt()
    val arr = Array(n+1) { IntArray(9) }
    val answer = mutableListOf<Int>()
    for (curr in 1..n){
        for(j in 1..8){
            if(curr!=n&&arr[curr+1][j] == arr[curr][j]){
                answer.add(j)
                arr[curr+1][j] =1
                arr[curr][j] = 1
                break
            }
            else if(curr==n && arr[curr][j]==0 && arr[1][j] == arr[curr][j]){
                answer.add(j)
                arr[1][j] =1
                arr[curr][j] = 1
                break
            }
        }
    }
    for (el in answer)
        print("$el ")
}