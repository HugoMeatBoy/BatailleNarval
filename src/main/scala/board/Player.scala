package board

abstract class Player {
    var grid: Grid
    def attackRound(g: Grid):String
}



class Human(g: Grid) extends Player{
    var grid: Grid = g



	def attackRound(g : Grid): String={
		var target = takeinput()
		attack(g, target._1,target._2)
	}


	def takeinput():Tuple2[Char,Int] = {
		var target =  readLine("Entrez une case à viser : ")
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
			  println("[ERR] * Input error, please enter a cell inside the grid \n")
			  takeinput
		  }
	  	}
	}

	def attack(g:Grid, xT:Char, yT:Int): String = {
		var x = {
			xT match {
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
		var y = yT - 1

		g.checkCell(x,y) match {
            case "Empty" => {
                g.setCell(x,y,"Missed")
                "\n\n ** o : Target missed"
            }
            case "Ship" => {
                var boat = g.getHitBoat(x,y)
                boat.hit

                if(boat.aliveCells==0){
                    boat.sunk = true
                    g.boatSunk(boat)
                    ("\n\n ** X : Ship sunk !!!")
                }else{
                    g.setCell(x,y,"Touched")
                    ("\n\n ** x : Ship touched !")
                }

            }
            case _ => {
                println("[ERR] * Target already destroyed, please shoot again\n")

    			attackRound(g)
            }
        }



	}
}
