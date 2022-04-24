package Cat

class Cat(name:String, weight:Float, _height:Float, length: Int, colour:String)
{
    private val jumpIndex:Float=0.12f
    private var name:String=""
    private var weight:Float=0.0f
    private var colour:String=""
    private var height:Float=0.0f
    private var strength:Float=0.0f
    private var length:Int=0
init {
    this.name=name
    this.weight=weight
    this.length=length
    this.colour=colour
    this.height=_height
}
    fun getStrength():Float
    {
        strength=(length+height)/weight
        return strength
    }

    fun getName():String
    {
        return this.name
    }

    fun jumpHeight():Float
    {
        return getStrength()*jumpIndex
    }
}