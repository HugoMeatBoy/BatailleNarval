package players

import board._
import game.Random._
import UI.Console._
import UI.Ascii._
import UI.SetupIA._

class IAlvl1 extends Player  {

    var grid = new Grid()
    def shoot:Tuple2[Int,Int]={
        pickRandomCell
    }

    def attackRound(g : Grid): String={
        var cellShot = shoot

        g.checkCell(cellShot._1,cellShot._2) match {
            case "Empty" => {
                g.setCell(cellShot._1,cellShot._2,"Missed")
                ("\n\n ** o : Target missed ")
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
                attackRound(g)
            }
        }
    }

    def createBoard(){
        createBoats(grid)
    }
}















class IAlvl2 extends Player{
    var grid = new Grid()
    var firstCellTouched:Tuple2[Int,Int]=null

    var searchNewBoat:Boolean=true                          //false at the first touch, to search around this point


    def shoot(g: Grid):Tuple2[Int,Int]={
        if(firstCellTouched != null){
            if(!searchNewBoat){
                shootLastBoat(g)
            }else{
                pickRandomCell
            }
        }else{
            pickRandomCell
        }
    }



    def shootLastBoat(g: Grid, index: Int = 1): Tuple2[Int,Int]={
        var x = firstCellTouched._1
        var y = firstCellTouched._2


        if(checkNextCell(x+index,y,g)){
            (x+index,y)
        }else if(checkNextCell(x,y+index,g)){
            (x, y+index)
        }else if(checkNextCell(x-index,y,g)){
            (x-index,y)
        }else if(checkNextCell(x, y-index,g)){
            (x, y-index)
        }else{
            if(index == 5){
                pickRandomCell
            }else{
                shootLastBoat(g, index+1)
            }

        }
    }


    def checkNextCell(x: Int, y: Int, g: Grid):Boolean={
        if(x < 10 && x >= 0 && y < 10 && y >= 0){
            g.checkCell(x,y) match {
                case "Missed" | "Touched" | "Sunk" => false
                case _ => true
            }
        }else{
            false
        }
    }


    def attackRound(g : Grid): String={
        var cellShot = shoot(g)
        g.checkCell(cellShot._1,cellShot._2) match {
            case "Empty" => {
                g.setCell(cellShot._1,cellShot._2,"Missed")
                ("\n\n ** o : IA target missed \n\n ******************")
            }
            case "Ship" => {
                var boat = g.getHitBoat(cellShot._1,cellShot._2)
                boat.hit

                if(boat.aliveCells==0){

                    searchNewBoat = true                                //last targeted boat destroyed, back to search

                    boat.sunk = true
                    g.boatSunk(boat)
                    ("\n\n ** X : IA sunk a boat !!!\n\n ******************")
                }else{
                    if(searchNewBoat){
                        searchNewBoat = false
                        firstCellTouched = (cellShot._1,cellShot._2)
                    }

                    g.setCell(cellShot._1,cellShot._2,"Touched")
                    ("\n\n ** x : IA touched a boat !\n\n ******************")
                }

            }
            case _ => {
                attackRound(g)
            }
        }
    }

    def createBoard(){
        createBoats(grid)
    }

}





class IAlvl3 extends Player {
    var grid = new Grid()
    var firstCellTouched:Tuple2[Int,Int]=null
    var lastCellTouched:Tuple2[Int,Int]=null

    var searchNewBoat:Boolean=true                          //false at the first touch, to search around this point


    def shoot(g: Grid):Tuple2[Int,Int]={
        if(firstCellTouched != null){
            if(!searchNewBoat){
                shootLastBoat(g)
            }else{
                pickRandomCell
            }
        }else{
            pickRandomCell
        }
    }



    def shootLastBoat(g: Grid, index: Int = 1): Tuple2[Int,Int]={
        var xF = firstCellTouched._1
        var yF = firstCellTouched._2
        var xL = lastCellTouched._1
        var yL = lastCellTouched._2

        if(!(xL == xF && yL == xL)){
            if(xF == xL){

                if(checkNextCell(xL,yL+index,g)){
                    (xL,yL+index)
                }else if(checkNextCell(xL,yL-index,g)){
                    (xL,yL-index)
                }else if(checkNextCell(xF,yF+index,g)){
                    (xF,yF-index)
                }else if(checkNextCell(xF,yF-index,g)){
                    (xF,yF-index)
                }
            }else if (yF == yL){
        
                if(checkNextCell(xL+index,yL,g)){
                    (xL+index,yL)
                }else if(checkNextCell(xL-index,yL,g)){
                    (xL-index,yL)
                }else if(checkNextCell(xF+index,yF,g)){
                    (xF+index,yF)
                }else if(checkNextCell(xF-index,yF,g)){
                    (xF-index,yF)
                }
            }
        }

        if(checkNextCell(xF+index,yF,g)){
            (xF+index,yF)
        }else if(checkNextCell(xF,yF+index,g)){
            (xF, yF+index)
        }else if(checkNextCell(xF-index,yF,g)){
            (xF-index,yF)
        }else if(checkNextCell(xF, yF-index,g)){
            (xF, yF-index)
        }else{
            if(index == 5){
                pickRandomCell
            }else{
                shootLastBoat(g, index+1)
            }

        }
    }


    def checkNextCell(x: Int, y: Int, g: Grid):Boolean={
        if(x < 10 && x >= 0 && y < 10 && y >= 0){
            g.checkCell(x,y) match {
                case "Missed" | "Touched" | "Sunk" => false
                case _ => true
            }
        }else{
            false
        }
    }


    def attackRound(g : Grid): String={
        var cellShot = shoot(g)
        g.checkCell(cellShot._1,cellShot._2) match {
            case "Empty" => {
                g.setCell(cellShot._1,cellShot._2,"Missed")
                ("\n\n ** o : IA target missed \n\n ******************")
            }
            case "Ship" => {
                var boat = g.getHitBoat(cellShot._1,cellShot._2)
                boat.hit

                if(boat.aliveCells==0){

                    searchNewBoat = true                                //last targeted boat destroyed, back to search

                    boat.sunk = true
                    g.boatSunk(boat)
                    ("\n\n ** X : IA sunk a boat !!!\n\n ******************")
                }else{
                    if(searchNewBoat){
                        searchNewBoat = false
                        firstCellTouched = (cellShot._1,cellShot._2)
                    }
                    lastCellTouched = (cellShot._1,cellShot._2)

                    g.setCell(cellShot._1,cellShot._2,"Touched")
                    ("\n\n ** x : IA touched a boat !\n\n ******************")
                }

            }
            case _ => {
                attackRound(g)
            }
        }
    }

    def createBoard(){
        createBoats(grid)
    }
}
