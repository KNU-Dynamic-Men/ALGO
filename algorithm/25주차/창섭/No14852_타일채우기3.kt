package codeBaekJoon._2021

import java.io.BufferedReader
import java.io.InputStreamReader

/*
 * 문제 풀이 시작: 2021/06/17 9:05 오후
 * 맞은 시각: 2021/06/17 
 * 소요 시간: 
 * @author ventulus95
*/

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val DIV =  1000000007
    val n = readLine().toInt()
    var dp = Array(n+1){LongArray(3)};
    dp[1][0] = 1 //1*1
    dp[1][1] = 1 //2*1 l
    dp[1][2] = 0 //1*2 ㅡ
    dp[2][0] = 2
    dp[2][1] = 2
    dp[2][2] = 3
    for (i in 3..n){
        dp[i][0] = (dp[i-1][0] + dp[i-1][1]+dp[i-1][2])%DIV
        dp[i][1] = (dp[i-1][0] + dp[i-1][1]+dp[i-1][2])%DIV
        dp[i][2] = ((dp[i-2][0] + dp[i-2][1])*3+(dp[i-2][2])*2)%DIV
    }
    var sum = 0L
    for (el in dp[n]){
        sum += el
        sum %= DIV
    }
    println(sum)
}