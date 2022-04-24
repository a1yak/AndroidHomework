package Range

import java.util.*
import kotlin.random.Random
import kotlin.test.assertFalse


fun rand(start: Int, end: Int): Int {
    require(start <= end) { "Illegal Argument" }
    return Random(System.nanoTime()).nextInt(start, end + 1)
}

fun check(toCheck:Int):Boolean
{
    if(toCheck>25&&toCheck<100)
    {
        return true
    }
    else {return false}
}

fun main()
{

    var toExit:Boolean=false
    val sc = Scanner(System.`in`)
    var numToCheck:Int=0
    var answer:Int =0
    while(!toExit)
    {
        answer =100
       numToCheck= rand(5, 155)
        println("Computer generated random number, it is: "+numToCheck)
        Thread.sleep(1500)
        if(check(numToCheck))
        {
            println("This number belongs to (25;100) interval")
        }
        else
        {
            println("This number doesen't belong to (25;100) interval")
        }
        println("Do you want to continue? 1)Yes  2)No")
        while(answer!=1&&answer!=2)
        {
            answer =sc.nextInt()
           when(answer)
           {
               1->toExit=false
               2->toExit=true
               else->
               {
                   println("Incorrect input, try again...")
               }
           }
        }
    }
    sc.close()
}