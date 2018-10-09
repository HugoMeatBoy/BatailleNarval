package players

import board._
import game.Random._
import UI.Console._
import UI.Ascii._
import UI.SetupIA._
/*
    The AI can be implemented on 3 different levels of difficulty

    * Same createBoats function, done randomly
    * Evolutive shooting method attackRound
*/

//LEVEL 1
class IAlvl1 extends Player  {

    var grid = new Grid()

    //Lowest chance method of shoot : constant random
    def shoot:Tuple2[Int,Int]={
        pickRandomCell
    }

    //Override method from Player : Select a cell and check the result
    def attackRound(g : Grid): String={
        var cellShot = shoot

        g.checkCell(cellShot._1,cellShot._2) match {
            case "Empty" => {
                g.setCell(cellShot._1,cellShot._2,"Missed")                      //State of the cell targeted : Missed
                ("\n\n ** • : IA target missed \n\n ******************")
            }
            case "Ship" => {                                                    //SHIP HIT
                var boat = g.getHitBoat(cellShot._1,cellShot._2)                //Get the ship touched
                boat.hit                                                        //Reduce the number of cells alive in this boat

                if(boat.aliveCells==0){                                         //If it was the last cell not touched of this boat, it's declared sunk and remove from the grid
                    boat.sunk = true
                    g.boatSunk(boat)
                    ("\n\n ** X : IA sank a boat !!!\n\n ******************")
                }else{
                    g.setCell(cellShot._1,cellShot._2,"Touched")                //Else the cell is only update in the grid
                    ("\n\n ** x : IA touched a boat !\n\n ******************")
                }

            }
            case _ => {
                attackRound(g)
            }
        }
    }

    //SetupIA.createBoats to instantiate the 5 AI's ships
    def createBoard(){
        createBoats(grid)
    }
}





/*******************************************************************************************************************/




/*
    LEVEL 2

    * firstCellTouched : keeps in memory the first cell of the last touched boat.
    * searchNewBoat : indicates if the next shot needs to
*/
class IAlvl2 extends Player{
    var grid = new Grid()
    var firstCellTouched:Tuple2[Int,Int]=null


    var searchNewBoat:Boolean=true

    //If a cell has been found randomly and the boat is not sunk yet, try to turn around the touched cell
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


    //Trying to target last boat touched
    def shootLastBoat(g: Grid, index: Int = 1): Tuple2[Int,Int]={
        var x = firstCellTouched._1
        var y = firstCellTouched._2


        //Check in any direction (even diagonals) if there is something else than an old shot or the limit of the grid, and shoot

        //Left
        if(checkNextCell(x+index,y,g)){
            (x+index,y)
        }else if(checkNextCell(x+index,y+index,g)){
            (x+index,y+index)
        }
        //Down
        else if(checkNextCell(x,y+index,g)){
            (x, y+index)
        }else if(checkNextCell(x-index,y+index,g)){
            (x-index,y+index)
        }
        //Right
        else if(checkNextCell(x-index, y,g)){
            (x-index, y)
        }else if(checkNextCell(x-index,y-index,g)){
            (x-index,y-index)
        }else if(checkNextCell(x, y-index,g)){
            (x, y-index)
        }
        //Up
        else if(checkNextCell(x+index, y-index,g)){
            (x+index, y-index)
        }else{
            //Max size boat reached, so random pick
            if(index == 5){
                pickRandomCell

            //Try to target a boat, with a bigger range
            }else{
                shootLastBoat(g, index+1)
            }

        }
    }


    //Check if the next possible cell to shoot is not already shot, or off grid
    def checkNextCell(x: Int, y: Int, g: Grid): Boolean={
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
                ("\n\n ** • : IA target missed \n\n ******************")
            }
            case "Ship" => {
                var boat = g.getHitBoat(cellShot._1,cellShot._2)
                boat.hit

                if(boat.aliveCells==0){                                 //If ship sank
                    searchNewBoat = true                                //Reset the search of a new boat, and go back to random cell pick

                    boat.sunk = true
                    g.boatSunk(boat)
                    ("\n\n ** X : IA sank a boat !!!\n\n ******************")
                }else{
                    if(searchNewBoat){
                        searchNewBoat = false                           //Keep this boat in target and start firing around
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




/*******************************************************************************************************************/

/*
    LEVEL 3

    * firstCellTouched : First cell touched of the last boat
    * lastCellTouched : Last cell touched of the last boat
*/

class IAlvl3 extends Player {
    var grid = new Grid()


    var firstCellTouched:Tuple2[Int,Int]=null
    var lastCellTouched:Tuple2[Int,Int]=null

    var searchNewBoat:Boolean=true


    def shoot(g: Grid):Tuple2[Int,Int]={
        //As the first boat is touched, try to check if a touched Cell is not sunk
        if(firstCellTouched != null){
            shootLastBoat(g)
        }else{
            pickRandomCell
        }
    }


    //Retrieve last boat touched and target him
    def shootLastBoat(g: Grid, index: Int = 1): Tuple2[Int,Int]={
        var xF = firstCellTouched._1
        var yF = firstCellTouched._2
        var xL = lastCellTouched._1
        var yL = lastCellTouched._2

        //Check if first and last cell are on the same line (axis x) and try to find cells in this axis where it's ossible to shoot
        if(xF == xL && yL != yF && checkNextCell(xL,yL+index,g)){
            (xL,yL+index)
        }else if(xF == xL && yL != yF && checkNextCell(xL,yL-index,g)){
            (xL,yL-index)
        }else if(xF == xL && yL != yF && checkNextCell(xF,yF+index,g)){
            (xF,yF+index)
        }else if(xF == xL && yL != yF && checkNextCell(xF,yF-index,g)){
            (xF,yF-index)
        }

        //Check if first and last cell are on the same line (axis x) and try to find cells in this axis where it's ossible to shoot
        else if(xF != xL && yL == yF && checkNextCell(xL+index,yL,g)){
            (xL+index,yL)
        }else if(xF != xL && yL == yF && checkNextCell(xL-index,yL,g)){
            (xL-index,yL)
        }else if(xF != xL && yL == yF && checkNextCell(xF+index,yF,g)){
            (xF+index,yF)
        }else if(xF != xL && yL == yF && checkNextCell(xF-index,yF,g)){
            (xF-index,yF)

        //If the last boat sank, try to find and old cell touched
        //Option return to prevent errors if confusion, so pick a random cell
        }else if(xF != xL && yF != yL){
            searchOldHits(g).getOrElse(pickRandomCell)


        }else{

            //Check around the first touched cell as AI level 2
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
    }


    def checkNextCell(x: Int, y: Int, g: Grid): Boolean={
        if(x < 10 && x >= 0 && y < 10 && y >= 0){
            g.checkCell(x,y) match {
                case "Missed" | "Touched" | "Sunk" => false
                case _ => true
            }
        }else{
            false
        }
    }

    //Try to find old hits in ships not sunk
    def searchOldHits( g: Grid, x: Int = 0, y: Int = 0): Option[Tuple2[Int,Int]]={
        g.checkCell(x,y) match {
            case "Touched" => Some((x,y))
            case _ => {
                if(x == 9){
                    if(y == 9){
                        None
                    }else{
                        searchOldHits(g,x,y+1)
                    }
                }else{
                    searchOldHits(g,x+1,y)
                }
            }
        }
    }


    def attackRound(g : Grid): String={
        var cellShot = shoot(g)
        g.checkCell(cellShot._1,cellShot._2) match {
            case "Empty" => {
                g.setCell(cellShot._1,cellShot._2,"Missed")
                ("\n\n ** • : IA target missed \n\n ******************")
            }
            case "Ship" => {
                var boat = g.getHitBoat(cellShot._1,cellShot._2)
                boat.hit

                if(boat.aliveCells==0){
                    searchNewBoat = true
                    boat.sunk = true
                    g.boatSunk(boat)
                    ("\n\n ** X : IA sank a boat !!!\n\n ******************")
                }else{
                    if(searchNewBoat){
                        searchNewBoat = false
                        firstCellTouched = (cellShot._1,cellShot._2)            //save lastCellTouched
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
