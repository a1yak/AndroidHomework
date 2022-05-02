package Cat

open class Furniture(val _height:Float,val _length:Int,val _colour:String,val _material:String)
{
    protected var height:Float=0.0f
    protected var length:Int=0
    protected var colour:String=""
    protected var material:String=""

    init
    {
    this.height=_height
    this.length=_length
    this.colour=_colour
    this.material=_material
    }

}