package codeBaekJoon._2021

import java.io.BufferedReader
import java.io.InputStreamReader

fun main(args: Array<String>) = with(BufferedReader(InputStreamReader(System.`in`))) {
    val N = readLine().toInt()
    for (i in 1 until N){
        if(N==divSum(i)){
            println(i)
            return
        }
    }
    println(0)
}

private fun divSum(Num: Int): Any? {
    var sum = Num;
    val NumString = Num.toString()
    for (element in NumString){
        sum+= element -'0';
    }
    return sum;
}