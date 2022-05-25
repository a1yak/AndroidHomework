package com.example.fragments

open class Furniture(val _height:Float,val _length:Int,val _material:String)
{
    protected var height:Float=0.0f
    protected var length:Int=0
    protected var material:String=""

    init
    {
    this.height=_height
    this.length=_length
    this.material=_material
    }

}