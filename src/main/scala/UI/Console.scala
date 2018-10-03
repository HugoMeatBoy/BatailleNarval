package UI

import board._

object Console{


    def takeCellInput():Tuple2[Char,Int] = {
            var target =  readLine("Select a cell : ")
            val regex = "[A,B,C,D,E,F,G,H,I,J,a,b,c,d,e,f,g,h,i,j][1,2,3,4,5,6,7,8,9]".r
            val regexTen = "[A,B,C,D,E,F,G,H,I,J,a,b,c,d,e,f,g,h,i,j][1][0]".r


            target match {
                case regex() | regexTen() => {
                var xTarget = target.charAt(0)

                var yTarget = 0

                if(target.length == 3){
                    yTarget = 10
                }else{
                    yTarget = target.charAt(1).asDigit
                }
                (xTarget,yTarget)
                }
                case _ => {
                    println("Input error, please enter a cell inside the grid")
                    takeCellInput
                }
            }
    }

    def checkValidCell(coord : Tuple2[Char,Int]): Tuple2[Int,Int] = {
        var x = {
			coord._1 match {
				case 'A'|'a' => 0
				case 'B'|'b' => 1
				case 'C'|'c' => 2
				case 'D'|'d' => 3
				case 'E'|'e' => 4
				case 'F'|'f' => 5
				case 'G'|'g' => 6
				case 'H'|'h' => 7
				case 'I'|'i' => 8
				case 'J'|'j' => 9
			}
		}
		var y = coord._2 - 1
        (x,y)
    }


    def checkValidBoat(dir: String, size: Int, coord : Tuple2[Int,Int], g : Grid): Boolean= {
        if(dir.equals("V") || dir.equals("v")){
            if(coord._1 + size >= 10){
                println("There is not enough space for this boat")
                false
            }
        }else{
            if(coord._2 + size >= 10){
                println("There is not enough space for this boat " + ())
                false
            }
        }
        if(!checkAvailabilty(dir,size,coord,g)){
            println("There is already a boat here")
            false
        }else{
            true
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

    def insertBoat(dir: String, size: Int, g : Grid): Boat={
        var cell = checkValidCell(takeCellInput())

        if(checkValidBoat(dir, size, cell, g)){
            var b1 = new Boat(size, cell._1, cell._2, dir)
            return b1
        }else{
            insertBoat(dir, size,g)
        }
    }

    def createBoats():Grid={
		var g = new Grid
		println("\n*** Now place your boats !\n")

        g.displayOwn

		var dir5 = getDirection(5)

        println("\nSelectionnez la première case du bateau (en haut à droite) :")
        g.addBoat(insertBoat(dir5, 5, g), 5)
        g.displayOwn

        var dir4 = getDirection(4)

        println("\nSelectionnez la première case du bateau (en haut à droite) :")
        g.addBoat(insertBoat(dir4, 4, g), 4)
        g.displayOwn

        var dir3 = getDirection(3)

        println("\nSelectionnez la première case du bateau (en haut à droite) :")
        g.addBoat(insertBoat(dir3, 3, g), 3)
        g.displayOwn

        var dir2 = getDirection(3)

        println("\nSelectionnez la première case du bateau (en haut à droite) :")
        g.addBoat(insertBoat(dir2, 3, g), 3)
        g.displayOwn

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
}
