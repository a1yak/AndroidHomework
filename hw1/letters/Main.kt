package KotlinHomework1.letters

import java.util.*


fun main()
{
    var num:Int
    var result: Int=0
    var tempstring:String
    val sc = Scanner(System.`in`)
    println("Enter number of words you want to work with: ")
    num=sc.nextInt()
    while(num!=0)
    {
        val sc = Scanner(System.`in`)
        println("Enter your next word: ")
        tempstring = sc.nextLine()
        tempstring = tempstring.lowercase()
        result += convertWordToNumber(tempstring)
        num--
    }
    println("Your words are add up to "+result)
}
fun convertWordToNumber(word:String):Int
{

    var number:Int=0
    var tempArray: CharArray = word.toCharArray()
    for(i in tempArray)
    {
        if(i.toInt()<1077){
        number += i.toInt() - 1071
        }
        else {number += i.toInt() - 1070}
    }
    return number
}