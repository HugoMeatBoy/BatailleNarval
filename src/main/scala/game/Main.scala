package game

import board._
import UI.Console._
import UI.Ascii._

import scala.util.matching.Regex

object BattleShip extends App{
	logo()


	var menu = selectMode()
	var runGame = ""

	if(menu == 1){
		var levelIA = selectIA()

		var gridPlayer = createBoats()
		var player = new Human(gridPlayer)

		levelIA match {
			case 1 => {
				var ia = new IAlvl1()
				runGame = gameLoopIA(player,ia,false)
			}
			case 2 =>{
				var ia = new IAlvl2()
				runGame = gameLoopIA(player,ia,false)
			}
			case 3 => {
				var ia = new IAlvl3()
				runGame = gameLoopIA(player,ia,false)
			}
			case _ => {
				var ia = new IAlvl1()
				runGame = gameLoopIA(player,ia,false)
			}
		}
	}else{

		println("\n********* Boats setup - Player 1 ********* \n")
		var gridPlayer1 = createBoats()
		gridPlayer1.displayOwn
		var player1 = new Human(gridPlayer1)


		pressEnterToContinue

		println("\n********* Boats setup - Player 2 ********* \n")
		var gridPlayer2 = createBoats()
		gridPlayer2.displayOwn
		var player2 = new Human(gridPlayer2)

		pressEnterToContinue()
		println("Good luck, have fun ! o/\n\n\n")

		runGame = gameLoop(player1,player2,false)


	}









	println(runGame)



	def gameLoopIA(p1: Player, p2: Player,winner : Boolean):String={
		displayOwn(p1.grid)
		displayVS(p2.grid)
		if(!winner){
			println("\n********* Next turn ********* \n")


			p1.attackRound(p2.grid)
			//defRound(p2)

			if(p1.grid.isEmpty() || p2.grid.isEmpty()){
				gameLoopIA(p1, p2, true)
			}else{
				gameLoopIA(p1, p2, false)
			}


		}else{
			"GG WP"
		}


	}

	def gameLoop(p1: Player, p2: Player,winner : Boolean):String={

		if(!winner){

			/*
				Player One
			*/
			println("\n********* Next turn - Player 1 ********* \n")

			//Visualization
			displayOwn(p1.grid)
			displayVS(p2.grid)

			//Attack
			var attP1 = p1.attackRound(p2.grid)

			//Result
			println(attP1)
			displayVS(p2.grid)

			//Next
			pressEnterToContinue



			/*
				Player Two
			*/
			println("\n********* Next turn - Player 2 ********* \n")

			//Visualization
			displayOwn(p2.grid)
			displayVS(p1.grid)

			//Attack
			println(p2.attackRound(p1.grid))

			//Result
			displayVS(p1.grid)



			//Next
			pressEnterToContinue

			if(p1.grid.isEmpty() || p2.grid.isEmpty()){
				gameLoop(p1, p2, true)
			}else{
				gameLoop(p1, p2, false)
			}


		}else{
			"GG WP"
		}


	}

	def selectMode():Int={

		var mode = readLine("Select game mode :\n 1 -> 1P vs CPU \n 2 -> 2P VS \n (1/2) : ")

		if(!(mode.equals("1") || mode.equals("2"))) {
			println("[ERR] * Wrong input \n")
			selectMode
		}else{
			mode.toInt
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

	def pressEnterToContinue(){
		readLine("\n*** Press enter to continue to next player !")
		println("\n\n*\n\n*\n\n*\n\n*\n\n*\n\n*\n\n*\n\n*\n\n*\n\n*\n\n*\n\n*\n\n*\n\n*\n\n*\n\n*\n\n*\n\n*\n\n*\n\n*\n\n*\n\n*\n\n*\n\n*\n\n*\n\n*\n\n*\n\n*\n\n*\n\n*\n\n*\n\n")
		readLine("\n*** Next player press enter !")
	}

}
