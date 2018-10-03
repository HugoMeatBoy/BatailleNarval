package board

class Boat(s: Int,xB: Int, yB : Int, dir:String){
    var size:Int = s
    var aliveCells:Int = s
    var x:Int = xB
    var y:Int = yB
    var direction:String = dir
    var sunk: Boolean = false

    def hit(){
        aliveCells -=1
        println(aliveCells + " <ac|size>" + size)
    }

    def isVertical():Boolean ={
        direction.equals("V") || direction.equals("V"))
    }

    def isHorizontal():Boolean ={
        direction.equals("H") || direction.equals("h"))
    }
}
