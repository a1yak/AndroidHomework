package User

import java.util.*

data class User(var name: String, var surName: String, var age:Int)
{
    private var listofusers:MutableList<User> = mutableListOf()

    fun addUser()
    {
        val scanner = Scanner(System.`in`)
        var user = User("","",0)
        println("Enter user's name")
        user.name=scanner.nextLine()
        println("Enter user's surname")
        user.surName=scanner.nextLine()
        println("Enter user's age")
        user.age=scanner.nextInt()
        listofusers.add(user)
    }

    fun getList():MutableList<User>
    {
        return listofusers
    }

    fun showUsers()
    {
        if(listofusers.size==0) println("List is empty...")
        for(item: User in listofusers)
        {
            println(item.toString())
        }
    }

    fun deleteOldUsers(list: MutableList<User>):MutableList<User>
    {
        if(listofusers.size==0) {
            println("List is empty...")
            return list
        }
        val scan = Scanner(System.`in`)
        println("Enter maximum age for users")
        var maxAge = scan.nextInt()
      list.removeIf { it.age>maxAge }
        return list
    }

    fun sortListOfUsers(list:MutableList<User>):MutableList<User>
    {
        if(listofusers.size==0) {
            println("List is empty...")
            return list
        }
        list.sortBy { it.name }
        return list
    }

}