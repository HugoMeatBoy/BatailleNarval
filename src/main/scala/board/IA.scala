package board
import Random._
import UI.Console._
import UI.Ascii._

trait IA {
    def shoot():Tuple2[Int,Int]
    def createBoard():Unit
}


class IAlvl1 extends Player with IA {

    var grid = new Grid()
    def shoot:Tuple2[Int,Int]={
        pickRandomCell
    }

    def attackRound(g : Grid): String={
        var cellShot = shoot

        g.checkCell(cellShot._1,cellShot._2) match {
            case "Empty" => {
                g.setCell(cellShot._1,cellShot._2,"Missed")
                "\n\n ** o : Target missed"
            }
            case "Ship" => {
                var boat = g.getHitBoat(cellShot._1,cellShot._2)
                boat.hit

                if(boat.aliveCells==0){
                    boat.sunk = true
                    g.boatSunk(boat)
                    ("\n\n ** X : Ship sunk !!!")
                }else{
                    g.setCell(cellShot._1,cellShot._2,"Touched")
                    ("\n\n ** x : Ship touched !")
                }

            }
            case _ => {
                println("[ERR] * Target already destroyed, please shoot again\n")

                attackRound(g)
            }
        }
    }

    def createBoard(){
        createBoat(5)
        displayOwn(grid)
    }

    def createBoat(size: Int){
        if(size>0){
            var dir = pickRandomDir
            var cell = pickRandomCell

            if(size<3){

                if(checkValidBoat(dir, size + 1, cell, grid)){
                    println(size)
                    grid.addBoat(new Boat(size+1, cell._1, cell._2, dir), size+1)
                    createBoat(size-1)
                }else{
                    createBoat(size)
                }
            }else{
                if(checkValidBoat(dir, size, cell, grid)){
                    println(size)
                    grid.addBoat(new Boat(size, cell._1, cell._2, dir), size)
                    createBoat(size-1)
                }else{
                    createBoat(size)
                }
            }
        }
    }
}















class IAlvl2 extends Player with IA {
    var grid = new Grid()
    def shoot:Tuple2[Int,Int]={(1,1)}
    def attackRound(g : Grid): String={" 0 "}
    def createBoard(){

    }
}

class IAlvl3 extends Player with IA {
    var grid = new Grid()
    def shoot:Tuple2[Int,Int]={(1,1)}
    def attackRound(g : Grid): String={" 0 "}
    def createBoard(){ }
}


object Random{
    def pickRandomCell():Tuple2[Int,Int]={
        var rc = scala.util.Random
        var xR = rc.nextInt(10)
        var yR = rc.nextInt(10)
        (xR,yR)
    }
    def pickRandomDir():String={
        var rd = scala.util.Random
        var d = rd.nextInt(2)
        d match {
            case 1 => "h"
            case _ => "v"
        }
    }
}
