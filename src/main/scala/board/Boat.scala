package board

/*
    A boat is initially defined by its size, first cell (at the left top), direction

    * sunk:Boolean allows to know if the ship is not alive anymore.
    * aliveCell:Int reduces when the boat is hit. Used to determine if a boat has been sank
*/
class Boat(s: Int,xB: Int, yB : Int, dir:String){
    var size:Int = s
    var aliveCells:Int = s
    var x:Int = xB
    var y:Int = yB
    var direction:String = dir
    var sunk: Boolean = false

    //Triggered when this ship is targeted
    def hit(){
        aliveCells -= 1
    }

    //Return the direction of the ship, to check if this boat was hit, in board.Grid
    def isVertical():Boolean ={
        if(direction.equals("V") || direction.equals("v")){true}
        else false
    }
    def isHorizontal():Boolean ={
        if(direction.equals("H") || direction.equals("h")){true}
        else false
    }
}
