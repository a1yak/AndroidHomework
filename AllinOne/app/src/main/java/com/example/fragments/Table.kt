package com.example.fragments

class Table(_height:Float, _length:Int,  _material:String):
    Furniture(_height, _length, _material)
{

    fun seeHeight():Float
    {
        return this.height/100
    }

    fun isStable(answer:String):Boolean
    {
        var check=false

       if(answer =="1"||answer=="no")
        {
            check=false
        }
        else if(answer == "2" || answer =="yes") {
           check = true
       }
        return check
    }

}