package KotlinHomework1.User

import java.util.*

data class User(var name: String, var surName: String, var age:Int)
{
    private var listofusers:MutableList<User> = mutableListOf()
    val sc = Scanner(System.`in`)
fun addUser()
{
    var user = User("","",0)
    println("Enter user's name")
    user.name=sc.nextLine()
    println("Enter user's surname")
    user.surName=sc.nextLine()
    println("Enter user's age")
    user.age=sc.nextInt()
    listofusers.add(user)
}
    fun showUsers()
    {
        for(item: User in listofusers)
        {
            println(item.toString())
        }
    }
}