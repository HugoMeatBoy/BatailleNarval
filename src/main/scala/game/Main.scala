package game

import board._
import UI.Console._
import scala.util.matching.Regex

object BattleShip extends App{
	println("[*******************************************]")
	println("[*************SCALA BATTLESHIP**************]")
	println("[*******************************************]\n")

	println("Welcome for a new game !")
	var levelIA = selectIA()
	var playerGrid = new Grid

	var runGame = ""
	var boats = createBoats(playerGrid)


	var player = new Human()//With Boats
	levelIA match {
		case 1 => {
			var ia = new IAlvl1()
			runGame = gameLoop(player,ia,false)
		}
		case 2 =>{
			var ia = new IAlvl2()
			runGame = gameLoop(player,ia,false)
		}
		case 3 => {
			var ia = new IAlvl3()
			runGame = gameLoop(player,ia,false)
		}
		case _ => {
			var ia = new IAlvl1()
			runGame = gameLoop(player,ia,false)
		}
	}






	println(runGame)



	def gameLoop(p1: Player, p2: Player, winner : Boolean):String={
		p1.grid.displayOwn
		p2.grid.displayVS
		if(!winner){
			println("\n********* Tour Suivant ******* \n")


			p1.attackRound(p2.grid)
			//defRound(p2)

			gameLoop(p1, p2, false)
		}else{
			if(p1.hasBoatsLeft){
				"YOU LOSE"
			}else{
				"GG"
			}
		}


	}




	def selectIA():Int={
		var lvl = readLine("Select the IA level [1-2-3] : ")
		if(!(lvl.equals("1") || lvl.equals("2") ||lvl.equals("3"))) {
			println("Wrong input")
			selectIA
		}
		else lvl.toInt
	}

	def createBoats(g : Grid)/*:List[Boat]*/={
		println("\nNow place your boats !\n")


		var dir = readLine("\nSelect a direction for your 5-cell ship (Horizontally:H,Vertically:V) : ")
		println("Selectionnez la première case du bateau (en haut à droite) :")
		var cell = takeCellInput()

		var x = {
			cell._1 match {
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
		var y = cell._2 - 1

		var b1 = new Boat(5, x, y, dir)
		g.addBoat(b1, 5)

		g.displayOwn


	}


}
