package UI

import Console._
import Ascii._
import board._
import game.Random._

/*
    Boats setup - for human player
*/
object SetupConsole{
    def createBoats():Grid={
		var g = new Grid
		println("\n*** Now place your boats !\n")

        displayOwn(g)

		var dir5 = getDirection(5)

        println("\nSelectionnez la première case du bateau (en haut à droite) :")
        g.addBoat(insertBoat(dir5, 5, g), 5)
        displayOwn(g)

        var dir4 = getDirection(4)

        println("\nSelectionnez la première case du bateau (en haut à droite) :")
        g.addBoat(insertBoat(dir4, 4, g), 4)
        displayOwn(g)

        var dir3 = getDirection(3)

        println("\nSelectionnez la première case du bateau (en haut à droite) :")
        g.addBoat(insertBoat(dir3, 3, g), 3)
        displayOwn(g)

        var dir2 = getDirection(3)

        println("\nSelectionnez la première case du bateau (en haut à droite) :")
        g.addBoat(insertBoat(dir2, 3, g), 3)
        displayOwn(g)

        var dir1 = getDirection(2)

        println("\nSelectionnez la première case du bateau (en haut à droite) :")
        g.addBoat(insertBoat(dir1, 2, g), 2)

        g
	}


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

    def insertBoat(dir: String, size: Int, g : Grid): Boat={
        var cell = checkValidCell(takeCellInput())

        if(checkValidBoat(dir, size, cell, g)){
            var b1 = new Boat(size, cell._1, cell._2, dir)
            return b1
        }else{
            insertBoat(dir, size,g)
        }
    }

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
    Boats setup - for IA (no logs)
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
