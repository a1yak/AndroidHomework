package KotlinHomework1

import KotlinHomework1.User.User
import java.util.*


    fun main()
    {
        val sc = Scanner(System.`in`)
        var choise:Int=0
        var user= User("","",0)
        while(choise!=3)
        {
            println("Choose variant 1-3: 1)Add user 2)Show list of users 3)exit")
            choise=sc.nextInt()
            when(choise)
            {
                1->user.addUser()
                2->user.showUsers()
                3-> println("finished")
                else->{
                    println("Wrong Input, try again")
                }
            }
        }

    }
