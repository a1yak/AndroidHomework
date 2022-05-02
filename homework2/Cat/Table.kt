package Cat

class Table(_height:Float, _length:Int, _colour:String, _material:String, number: Int):Furniture(_height, _length, _colour, _material)
{
    private var numberoflegs:Int=0
init{
    this.numberoflegs=number
}

    fun seeHeight():Float
    {
        return this.height/100
    }

    fun isStable():Boolean
    {
        var check=false
        var answer:String=""
        println("Will this material fall apart from touching?  1)Yes   2)No")
        while(answer!="1"&&answer!="2")
        {
            answer = readLine()!!
            when (answer) {
                "1" -> check = false
                "2" -> check = true
                else -> {
                    println("Incorrect input, try again...")
                }

            }
        }
        return check
    }

}