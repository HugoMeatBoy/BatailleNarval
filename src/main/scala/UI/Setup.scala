package UI

import Console._
import Ascii._
import board._
import game.Random._

/*
    Boats setup - for human player
*/
object SetupConsole{
    //Main process
    def createBoats():Grid={
		var g = new Grid
		println("\n*** Now place your boats !\n")

        displayOwn(g)

		var dir5 = getDirection(5)

        println("\nSelect the first cell of the boat (at left top) :")
        g.addBoat(insertBoat(dir5, 5, g), 5)
        displayOwn(g)

        var dir4 = getDirection(4)

        println("\nSelect the first cell of the boat (at left top) :")
        g.addBoat(insertBoat(dir4, 4, g), 4)
        displayOwn(g)

        var dir3 = getDirection(3)

        println("\nSelect the first cell of the boat (at right top) :")
        g.addBoat(insertBoat(dir3, 3, g), 3)
        displayOwn(g)

        var dir2 = getDirection(3)

        println("\nSelect the first cell of the boat (at right top) :")
        g.addBoat(insertBoat(dir2, 3, g), 3)
        displayOwn(g)

        var dir1 = getDirection(2)

        println("\nSelect the first cell of the boat (at right top) :")
        g.addBoat(insertBoat(dir1, 2, g), 2)

        g
	}

    //User input : Direction of his next boat (H/V)
    def getDirection(sizeBoat: Int):String={
        var d = readLine("\nSelect a direction for your "+ sizeBoat +"-cell ship (Horizontally:H,Vertically:V) : ")
        d match {
            case "h" | "H" | "v" |  "V" => d.toLowerCase
            case _ => {
                println("[ERR] * Wrong input")
                getDirection(sizeBoat)
            }
        }
    }

    //User input : First cell (left top) of his next boat
    def insertBoat(dir: String, size: Int, g : Grid): Boat={
        var cell = checkValidCell(takeCellInput())

        if(checkValidBoat(dir, size, cell, g)){
            var b1 = new Boat(size, cell._1, cell._2, dir)
            return b1
        }else{
            insertBoat(dir, size,g)
        }
    }

    //Check if a cell of a boat can't be placed : Because of another boat or the limits of the grid
    def checkValidBoat(dir: String, size: Int, coord : Tuple2[Int,Int], g : Grid): Boolean= {
        if(dir.equals("h") || dir.equals("H")){
            if(coord._1 + size > 10){
                println("[ERR] * There is not enough space for this boat\n")
                false
            }else if(!checkAvailabilty(dir,size,coord,g)){
                println("[ERR] * There is already a boat here")
                false
            }else{
                true
            }
        }else{
            if(coord._2 + size > 10){
                println("[ERR] * There is not enough space for this boat \n")
                false
            }else if(!checkAvailabilty(dir,size,coord,g)){
                println("[ERR] * There is already a boat here")
                false
            }else{
                true
            }
        }
    }

    //Validator of checkValidBoat() on each cell of the future ship
    def checkAvailabilty(dir: String, size: Int, coord : Tuple2[Int,Int],g: Grid): Boolean={
        if(size > 0){
            if(g.checkCell(coord._1,coord._2) == "Ship"){
                false
            }else{
                if(dir.equals("V") || dir.equals("v")){
                    var tuple = (coord._1,coord._2+1)
                    checkAvailabilty(dir, size-1, tuple,g)
                }else{
                    var tuple = (coord._1+1,coord._2)
                    checkAvailabilty(dir, size-1, tuple ,g)
                }
            }
        }else{
            true
        }

    }
}








/*
    Boats setup - for AI (no logs)
    The process is similar from the Human interface Setup, except the random picks if cells and directions.
*/
object SetupIA{
    def createBoats(g: Grid):Grid={
        createRandomBoat(5,g)
        g
    }

    def createRandomBoat(size: Int, g: Grid){
        if(size>0){
            var dir = pickRandomDir
            var cell = pickRandomCell

            if(size<3){

                if(checkValidBoat(dir, size + 1, cell, g)){
                    g.addBoat(new Boat(size+1, cell._1, cell._2, dir), size+1)
                    createRandomBoat(size-1,g)
                }else{
                    createRandomBoat(size,g)
                }
            }else{
                if(checkValidBoat(dir, size, cell, g)){
                    g.addBoat(new Boat(size, cell._1, cell._2, dir), size)
                    createRandomBoat(size-1,g)
                }else{
                    createRandomBoat(size,g)
                }
            }
        }
    }


    def checkValidBoat(dir: String, size: Int, coord : Tuple2[Int,Int], g : Grid): Boolean= {
        if(dir.equals("h") || dir.equals("H")){
            if(coord._1 + size > 10){
                false
            }else if(!checkAvailabilty(dir,size,coord,g)){
                false
            }else{
                true
            }
        }else{
            if(coord._2 + size > 10){
                false
            }else if(!checkAvailabilty(dir,size,coord,g)){
                false
            }else{
                true
            }
        }
    }

    def checkAvailabilty(dir: String, size: Int, coord : Tuple2[Int,Int],g: Grid): Boolean={
        if(size > 0){
            if(g.checkCell(coord._1,coord._2) == "Ship"){
                false
            }else{
                if(dir.equals("V") || dir.equals("v")){
                    var tuple = (coord._1,coord._2+1)
                    checkAvailabilty(dir, size-1, tuple,g)
                }else{
                    var tuple = (coord._1+1,coord._2)
                    checkAvailabilty(dir, size-1, tuple ,g)
                }
            }
        }else{
            true
        }

    }
}
