package codeBaekJoon._2021

import java.io.BufferedReader
import java.io.InputStreamReader

/*
 * 문제 풀이 시작: 2021/06/11 11:19 오후
 * 맞은 시각: 2021/06/11 
 * 소요 시간: 
 * @author ventulus95
*/
fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val n = readLine().toInt()
    var ans = IntArray(n)
    var arr = Array(n) { Pair(0,0) }
    for(i in 0 until n){
        val (w,h) = readLine().split(' ').map { it.toInt() }
        arr[i] = Pair(w,h);
    }
    for(i in 0 until n){
        val curr = arr[i]
        for (j in 0 until n){
            if(i!=j && curr.first<arr[j].first && curr.second<arr[j].second)
                ans[i]++
        }
    }
    for (i in 0 until n){
        print("${ans[i]+1} ")
    }
}

