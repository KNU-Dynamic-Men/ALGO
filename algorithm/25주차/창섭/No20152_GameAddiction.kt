package codeBaekJoon._2021

import java.io.BufferedReader
import java.io.InputStreamReader

/*
 * 문제 풀이 시작: 2021/06/18 10:59 오후
 * 맞은 시각: 2021/06/18 
 * 소요 시간: 
 * @author ventulus95
*/

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    var (h, n) = readLine().split(" ").map { it.toInt() }
    if(h==n) print(1)
    else {
        if(h>n) {
            val temp = n
            n = h
            h = temp
        }
        var map = Array(n+1){LongArray(n+1)}
        for(i in h..n){
            map[h][i] = 1
        }
        println(map[h][h])
        for(i in h+1..n){
            for (j in h+1..n){
                if(i<=j) map[i][j] = map[i-1][j] + map[i][j-1]
            }
        }
        print(map[n][n])
    }
}