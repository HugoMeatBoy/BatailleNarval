package board

class Boat(s: Int,xB: Int, yB : Int, dir:String){
    var size:Int = s
    var aliveCells:Int = s
    var x:Int = xB
    var y:Int = yB
    var direction:String = dir
    var sunk: Boolean = false

    def hit(){
        aliveCells -= 1
    }

    def isVertical():Boolean ={
        if(direction.equals("V") || direction.equals("v")){true}
        else false
    }

    def isHorizontal():Boolean ={
        if(direction.equals("H") || direction.equals("h")){true}
        else false
    }
}
