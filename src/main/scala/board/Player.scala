package board

abstract class Player {
    var grid: Grid
//    var boat5,boat4,boat3_1,boat3_2,boat2: Boat
    def hasBoatsLeft:Boolean
    def attackRound(g: Grid):Boolean
}



class Human extends Player{
    var grid = new Grid()
    def hasBoatsLeft:Boolean={true}
/*    var boat5 = new Boat(5)
    var boat4 = new Boat(4)
    var boat3_1 = new Boat(3)
    var boat3_2 = new Boat(3)
    var boat2 = new Boat(2)
*/






	def attackRound(g : Grid): Boolean={
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
			  println("Input error, please enter a cell inside the grid")
			  takeinput
		  }
	  	}
	}

	def attack(g:Grid, xT:Char, yT:Int): Boolean = {
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

		if(g.board(x)(y).checkState){
			if(g.board(x)(y).state.equals("Empty")) {
				g.board(x)(y).state = "Missed"
				false
			}else{
				g.board(x)(y).state = "Touched"
				true
			}
		}else{
			println("Target already destroyed, please shoot again")
			attackRound(g)
			false
		}
	}
}
