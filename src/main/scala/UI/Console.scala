package UI

import board._
import Ascii._

/*
    Tools to interact quickly with the human player : Separator clicks panels, input cell & formating,   
*/
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
                    println("[ERR] * Input error, please enter a cell inside the grid\n")
                    takeCellInput
                }
            }
    }

    //Changing user input (A1 to tuple (0,0))
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


    //Separator panels between players
    def pressEnterToContinue(){
		readLine("\n*** Press enter to continue to next player !")
		println("\n\n*\n\n*\n\n*\n\n*\n\n*\n\n*\n\n*\n\n*\n\n*\n\n*\n\n*\n\n*\n\n*\n\n*\n\n*\n\n*\n\n*\n\n*\n\n*\n\n*\n\n*\n\n*\n\n*\n\n*\n\n*\n\n*\n\n*\n\n*\n\n*\n\n*\n\n*\n\n")
		readLine("\n*** Next player press enter !")
	}

    //Separator with IA turn
    def pressEnterToContinueIA(){
		readLine("\n*** Press enter to continue to play !")
		println("\n\n*\n\n*\n\n")
	}
}
