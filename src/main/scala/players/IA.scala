package players

import board._
import game.Random._
import UI.Console._
import UI.Ascii._
import UI.SetupIA._

trait IA {
    def shoot():Tuple2[Int,Int]
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
        createBoats(grid)
        displayOwn(grid)
    }
}















class IAlvl2 extends Player with IA {
    var grid = new Grid()
    def shoot:Tuple2[Int,Int]={(1,1)}
    def attackRound(g : Grid): String={" 0 "}
    def createBoard(){
        createBoats(grid)
    }
}

class IAlvl3 extends Player with IA {
    var grid = new Grid()
    def shoot:Tuple2[Int,Int]={(1,1)}
    def attackRound(g : Grid): String={" 0 "}
    def createBoard(){
        createBoats(grid)
    }

}
