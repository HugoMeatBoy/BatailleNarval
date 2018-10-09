package game

import board._
import players._

import UI.Console._
import UI.Ascii._
import UI.SetupConsole._
import Tests._


import export._

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
				ia.createBoard
				runGame = gameLoopIA(player,ia,false)
			}
			case 2 =>{
				var ia = new IAlvl2()
				ia.createBoard
				runGame = gameLoopIA(player,ia,false)
			}
			case 3 => {
				var ia = new IAlvl3()
				ia.createBoard
				runGame = gameLoopIA(player,ia,false)
			}
			case _ => {
				var ia = new IAlvl1()
				runGame = gameLoopIA(player,ia,false)
			}
		}

	}else if(menu == 2){

		println("\n********* Boats setup - Player 1 ********* \n")
		var gridPlayer1 = createBoats()
		displayOwn(gridPlayer1)
		var player1 = new Human(gridPlayer1)


		pressEnterToContinue

		println("\n********* Boats setup - Player 2 ********* \n")
		var gridPlayer2 = createBoats()
		displayOwn(gridPlayer2)
		var player2 = new Human(gridPlayer2)
		println("\n *** Boats placed \n\n")
		pressEnterToContinue()


		println("Good luck, have fun ! o/\n\n\n")

		runGame = gameLoop(player1,player2,false)

	}else{
		println("\n\n\n****************  TESTING MODE *******************\n\n\n")

		var test1 = testLoop12()
		var test2 = testLoop13()
		var test3 = testLoop23()


		println("IA2 won " + test1 + " times on 100 games vs IA1")

		println("IA3 won " + test2 + " times on 100 games vs IA1")

		println("IA3 won " + test3 + " times on 100 games vs IA2")
		var csv = new CsvExport()

		csv.export(test1.toInt,test2.toInt,test3.toInt)

		runGame = "\n\n *** Tests runned  \n\n    Those results are exported in ProofOfConceptIAs.csv at the root of the project"
	}


	println(runGame)





	/*
		Mode 1P vs IA
	*/
	def gameLoopIA(p1: Player, p2: Player,winner : Boolean):String={
		if(!winner){
			println("\n****************************************\n********* Next turn - Player 1 ********* \n")

			/*
				Player One
			*/

			//Visualization
			displayOwn(p1.grid)
			displayVS(p2.grid)

			//Attack
			println(p1.attackRound(p2.grid))

			//Result
			displayVS(p2.grid)

			if(!p2.grid.isEmpty()){
				//Next
				pressEnterToContinue

				/*
					Player Two
				*/
				println("\n********* IA's turn... ********* \n")

				//Attack
				println(p2.attackRound(p1.grid))
				pressEnterToContinueIA

				if(!p1.grid.isEmpty()){
					gameLoopIA(p1, p2, false)
				}else{
					gameLoopIA(p1, p2, true)
				}
			}else{
				gameLoopIA(p1, p2, true)
			}
		}else{
			if(p2.grid.isEmpty()){
				if(!(p2.getClass.toString.equals("IAlvl3"))){
						"\n***********                ***********\n*                   *\n Well Played  Player One ! o/ \n\n *************** Try out a harder mode (COMING SOON) !\n"
				}else{
					"\n***********                ***********\n*                   *\n Well Played  Player One ! o/ \n\n"

				}

			}else{
				if(!(p2.getClass.toString.equals("IAlvl1"))){
					"\n***********    ***********\n*                   *\n You lose, sorry. Maybe try an easier IA mode ! o/ \n\n\n"
				}else{
					"\n***********                ***********\n*                   *\n Well.. that was the easiest IA mode, only random.. \n\n Let's say it was a perfect rng for this time... \n\n"

				}

			}
		}


	}


	/*
		Mode 2P
	*/
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
			println(p1.attackRound(p2.grid))

			//Result + Check winner
			displayVS(p2.grid)
			if(!p2.grid.isEmpty()){

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

				if(!p1.grid.isEmpty()){
					//Next
					pressEnterToContinue
					gameLoop(p1, p2, false)
				}else{
					gameLoop(p1, p2, true)
				}
			}else{
				gameLoop(p1, p2, true)
			}

		}else{
			if(p1.grid.isEmpty()){
				"\n***********    ***********\n*                   *\n Well Played  Player One ! o/ \n\n\n"
			}else{
				"\n***********    ***********\n*                   *\n Well Played  Player Two ! o/ \n\n\n"
			}

		}


	}

	def selectMode():Int={
		var mode = readLine("Select game mode :\n\n 1 -> 1P vs CPU \n 2 -> 2P VS \n (1/2) : ")

		if(!(mode.equals("1") || mode.equals("2") || mode.equals("0"))) {
			println("[ERR] * Wrong input \n")
			selectMode
		}else mode.toInt
	}

	def selectIA():Int={
		var lvl = readLine("\n\n*** Select the IA level [1-2-3] : ")

		if(!(lvl.equals("1") || lvl.equals("2") ||lvl.equals("3"))) {
			println("[ERR] * Wrong input\n")
			selectIA
		}
		else lvl.toInt
	}





}
