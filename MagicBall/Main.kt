package KotlinHomework1.MagicBall

import java.util.*
import kotlin.random.Random

fun rand(start: Int, end: Int): Int {
    require(start <= end) { "Illegal Argument" }
    return Random(System.nanoTime()).nextInt(start, end + 1)
}

fun main() {
    var wish:Boolean=true
    val start = 1
    val end = 7
    var question: String
while(wish)
{
    println("Ask your question: ")
    val sc =Scanner(System.`in`)
    question=sc.nextLine()
    when (rand(start, end))
    {
        1-> println("Definitely yes")
        2-> println("Definitely no")
        3-> println("Probably yes")
        4-> println("Probably no")
        5-> println("There is a possibility")
        6-> println("There is a chance")
        7-> println("Incorrect question")
    }
    println("Do you want to continue asking questions? 1 - yes  2 - no")
    if(sc.nextInt()==2) {
        println("See you next time...")
        wish =false
    }
}
}