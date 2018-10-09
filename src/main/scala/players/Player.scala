package players

import board._
import UI.SetupConsole._
import UI.Console._

//Abstract class for human player and IA
abstract class Player {
    var grid: Grid
    def attackRound(g: Grid):String
}


class Human(g: Grid) extends Player{
    var grid: Grid = g

    //Function called by the main game loop to fire a cell
	def attackRound(g : Grid): String={
        //User input : Cell to target
		var target = takeCellInput

        //Get the result of the shot
		attack(g, target._1,target._2)
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

        //Check state of targeted cell
		g.checkCell(x,y) match {
            case "Empty" => {
                g.setCell(x,y,"Missed")
                "\n\n ** • : Target missed "
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
