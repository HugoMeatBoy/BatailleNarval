package game

import board._
import UI.Console._
import scala.util.matching.Regex

object BattleShip extends App{
	logo()


	var levelIA = selectIA()

	var player = new Human()//With Boats
	/*
		-Select VS or IA lvl
		-> Players names
		-> IA level
	*/
	var runGame = ""
	var gridPlayer = createBoats()



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
			println("\n********* Tour Suivant ********* \n")


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

	
}
