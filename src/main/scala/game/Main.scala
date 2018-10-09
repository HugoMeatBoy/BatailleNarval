package game

//Classes
import board._
import players._

//UI and Tests objects
import UI.Console._
import UI.Ascii._
import UI.SetupConsole._
import Tests._

//Java csv export
import export._

import scala.util.matching.Regex

/*
	Main class of the application

	The processing management of a battleship game

*/


object BattleShip extends App{
	//Display logo
	logo()


	//User input : Select game mode
	var menu = selectMode()
	var runGame = ""

	//One player vs IA
	if(menu == 1){
		//User input : Select AI level
		var levelIA = selectIA()

		var gridPlayer = createBoats()
		var player = new Human(gridPlayer)

		//Create AI grid and lauch game
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

	//Two players
	}else if(menu == 2){

		//Setup boats
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

		pressEnterToContinue

		//Start game
		println("Good luck, have fun ! o/\n\n\n")
		runGame = gameLoop(player1,player2,false)

	//Test mode : AI vs AI
	}else{
		println("\n\n\n****************  TESTING MODE *******************\n\n\n")

		//Running testes
		var test1 = testLoop12()
		var test2 = testLoop13()
		var test3 = testLoop23()


		println("IA2 won " + test1 + " times on 100 games vs IA1")
		println("IA3 won " + test2 + " times on 100 games vs IA1")
		println("IA3 won " + test3 + " times on 100 games vs IA2")

		//Exporting results in .csv via Java.export.CsvExport
		var csv = new CsvExport()
		csv.export(test1,test2,test3)

		runGame = "\n\n *** Tests runned  \n\n    Those results are exported in ProofOfConceptIAs.csv at the root of the project"
	}


	println(runGame)


	/*
		Mode 1P vs AI
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
				if(!p2.getClass.toString.equals("IAlvl3")){
						"\n***********                ***********\n*                   *\n Well Played  Player One ! o/ \n\n *************** Try out a harder mode !\n"
				}else{
					"\n***********                ***********\n*                   *\n GG Well Played  Player One ! o/ \n\n"
				}
			}else{
				if(!(p2.getClass.toString.equals("IAlvl1"))){
					"\n***********    ***********\n*                   *\n You lose, sorry. Maybe try an easier AI mode ! o/ \n\n\n"
				}else{
					"\n***********                ***********\n*                   *\n Well.. that was the easiest AI mode, only random.. \n\n Let's say it was a perfect rng for this time... \n\n"
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
		var mode = readLine("Select game mode :\n\n (0 -> AI test mode)\n 1 -> 1P vs CPU \n 2 -> 2P \n (1/2) : ")

		if(!(mode.equals("1") || mode.equals("2") || mode.equals("0"))) {
			println("[ERR] * Wrong input \n")
			selectMode
		}else mode.toInt
	}

	def selectIA():Int={
		var lvl = readLine("\n\n*** Select the IA level (1/2/3) : ")

		if(!(lvl.equals("1") || lvl.equals("2") ||lvl.equals("3"))) {
			println("[ERR] * Wrong input\n")
			selectIA
		}
		else lvl.toInt
	}
}
