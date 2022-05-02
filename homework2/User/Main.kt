package User

import java.util.*


fun main()
{
    val sc = Scanner(System.`in`)
    var choise =0
    var user= User("","",0)
    while(choise!=5)
    {
        println("Choose variant 1-5: 1)Add user    2)Show list of users   3)sort list of users   4)delete users older certain age  5)exit")
        choise=sc.nextInt()
        when(choise)
        {
            1->user.addUser()
            2->user.showUsers()
            3->user.sortListOfUsers(user.getList())
            4->user.deleteOldUsers(user.getList())
            5-> println("finished")
            else->{
                println("Wrong Input, try again")
            }
        }
    }
sc.close()
}