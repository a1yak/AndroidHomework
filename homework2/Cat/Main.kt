package Cat

import java.util.*

fun abilityToJump(cat: Cat, table: Table):Boolean
{
    cat.getStrength()
    if(cat.jumpHeight()>table.seeHeight())
    {
        return true
    }
    else
    {return false}
}

fun main()
{
    var answer=0
    var tempCheck=false
    var toExit=false
    var name:String
    var colour:String
    var weight:Float
    var height:Float=0.0f
    var length:Int
    var material:String
    var legs:Int
    val sc = Scanner(System.`in`)

    while(!toExit)
    {
        answer =100
        val sc = Scanner(System.`in`)
    println("Enter cat's name: ")
    name=sc.nextLine()
    println("Enter cat's colour: ")
    colour=sc.nextLine()
        println("Average cat size  Height=25cm; Length=45cm; Weight=4kg")
        Thread.sleep(2000)
    println("Enter cat's weight in kg: ")
    weight=sc.nextFloat()
    println("Enter cat's height in cm: ")
    height=sc.nextFloat()
    println("Enter cat's length in cm: ")
    length=sc.nextInt()
        val cat=Cat(name, weight, height, length, colour)
        println("$name will try to jump up the table\nSet table height in cm:")
        height=sc.nextFloat()
        println("Set table length in cm: ")
        length=sc.nextInt()
        println("Set table material: ")
        material= readLine()!!
        answer=100
        println("Set table colour: ")
        colour= readLine()!!
        println("How many leggs does table have? ")
        legs = sc.nextInt()
        val table=Table(height, length, colour, material, legs)
        tempCheck=table.isStable()
        if(abilityToJump(cat, table)&&tempCheck)
        {
            println("${cat.getName()} can jump up this table")
        }
        else {println("${cat.getName()} can't jump up this table, it's too high for it")}

        println("Do you want to continue? 1)Yes   2)No")
        while(answer!=1&&answer!=2)
        {
            answer = sc.nextInt()
            when (answer) {
                1 -> toExit = false
                2 -> {
                    println("finishing...")
                    toExit = true
                }
                else -> {
                    println("Incorrect input, try again...")
                }
            }
        }
    }
    sc.close()
}