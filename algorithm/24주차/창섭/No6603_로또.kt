package codeBaekJoon._2021

import java.io.BufferedReader
import java.io.InputStreamReader

/*
 * 문제 풀이 시작: 2021/06/12 4:14 오후
 * 맞은 시각: 2021/06/12 
 * 소요 시간: 
 * @author ventulus95
*/
var sb = StringBuilder()

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    var line = readLine()
    while (!line.equals("0")){
        var st = line.split(" ").map { it.toInt() }
        st = st.subList(1, st.size);
        dfs(6, 0, st, mutableListOf<Int>())
        sb.append("\n")
        line = readLine()
    }
}

fun dfs(deep: Int, curr: Int, st: List<Int>, list: MutableList<Int>) {
    if(deep==0) {
        for (e in list)
            sb.append("$e ")
        sb.append("\n")
    }
    for(i in curr until st.size){
        list.add(st[i])
        dfs(deep-1, i+1, st, list)
        list.remove(st[i])
    }
}
