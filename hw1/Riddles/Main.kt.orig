package KotlinHomework1.Riddles

import java.util.*
import kotlin.random.Random

fun rand(start: Int, end: Int): Int {
    require(start <= end) { "Illegal Argument" }
    return Random(System.nanoTime()).nextInt(start, end + 1)
}

fun main()
{
    val sc =Scanner(System.`in`)
    var toExit:Int=0
    var riddles = hashMapOf("Что это такое: синий, большой, с усами и полностью набит зайцами?" to "Троллейбус", "Вспушит она свои бока, Свои четыре уголка, И тебя, как ночь настанет, Все равно к себе притянет." to "Подушка",
    "Не ездок, а со шпорами, Не будильник, а всех будит." to "Петух", "Сижу верхом, Не ведаю на ком." to "Шапка","Ношу их много лет, не знаю им счета" to "Волосы",
    "Три глаза - три приказа,Красный - самый опасный." to "Светофор", "Кто приходит, кто уходит, Все ее за ручку водят." to "Дверь", "Кто меня сделал, не сказывает. Кто меня не знает, принимает. А кто знает, на двор не пускает." to "Фальшивая монета"
    , "Если б не было его, Не сказал бы ничего." to "Язык", "Кругом вода, а с питьем беда." to "Море")
    val start = 1
    val end = 9
    var counter =1
    var randomed=0
    var tries=1
    var answer: String
    println("This is riddle-asking program...\nYou have 3 tries on each riddle")

    while(toExit!=10)
    {
        val sc = Scanner(System.`in`)
        tries =1
        randomed=rand(start,end)
        println("Riddle: " + riddles.keys.elementAt(randomed)+"\n")
        answer=sc.nextLine().lowercase()

       while(tries!=3 ||answer==riddles.values.elementAt(randomed).lowercase())
       {
           if (answer == riddles.values.elementAt(randomed).lowercase())
           {
               println("Да, это действительно $answer , отлично...")
               break
           }
           else
           {
               println("Неправильно (у вас осталось ${3-tries} попыток, попробуйте еще раз...")
               answer=sc.nextLine().lowercase()
               tries++
           }
       }

        println("Хотите продолжить отгадывать загадки? 1)да   2)нет")
        randomed=100

       while(randomed!=1 && randomed!=2)
       {
           randomed=sc.nextInt()
           when (randomed)
           {
               1 -> counter++
               2 -> toExit = 10
               else -> {println("incorrect output...")}
           }
       }
    }
    sc.close()
    println("Спасибо за участие, Увидимся в следующий раз...")
}