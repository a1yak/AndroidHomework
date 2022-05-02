package SummOfNumbers

import java.util.*

fun main()
{
    val sc = Scanner(System.`in`)
    var number:Int=0
    var result:Int=0
    var tempnumber:Int=0
    println("Enter your number: ")
    number = sc.nextInt()
    while(number>=1)
    {
        tempnumber=number%10
        result+=tempnumber
        number/=10
    }
    println("Summ of all separate numbers in your number is: $result ...")
    sc.close()
}