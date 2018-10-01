package game

import board._
import scala.util.matching.Regex

object BattleShip extends App{
	println("[*******************************************]")
	println("[*************SCALA BATTLESHIP**************]")
	println("[*******************************************]\n")

	println("Welcome for a new game !")
	var levelIA = selectIA()

	var player = new Human()


	levelIA match {
		case 1 => var ia = new IAlvl1()
		case 2 => var ia = new IAlvl2()
		case 3 => var ia = new IAlvl3()
	}

	var playerMap = new Grid()
	var attackMap = new Grid()



	var runGame = gameLoop(playerMap,attackMap,false)


	def gameLoop(gridPlayer : Grid, gridAttack : Grid, winner : Boolean){
		gridAttack.display
		if(!winner){
			println("Tour Suivant :")
			attackRound(gridAttack)


			gameLoop(gridPlayer, gridAttack, false)
		}


	}



	def selectIA():Int={
		var lvl = readLine("Select the IA level [1-2-3] : ").toInt
		if(!(lvl.equals("1") || lvl.equals("2") ||lvl.equals("3"))) {
			println("Wrong input")
			selectIA
		}
		else lvl
	}









	def attackRound(g : Grid){

		var target = takeinput()
		attack(g, target._1,target._2)

	}

	def takeinput():Tuple2[Char,Int] = {
		var target =  readLine("Entrez une case à viser : ")
		val regex = "[A,B,C,D,E,F,G,H,I,J][1,2,3,4,5,6,7,8,9]".r
		val regexTen = "[A,B,C,D,E,F,G,H,I,J][1][0]".r


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
				case 'A' => 0
				case 'B' => 1
				case 'C' => 2
				case 'D' => 3
				case 'E' => 4
				case 'F' => 5
				case 'G' => 6
				case 'H' => 7
				case 'I' => 8
				case 'J' => 9
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
