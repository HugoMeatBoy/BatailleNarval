package game

import board._
import players._

object Tests{
    def testLoop(nb: Int = 0, countWin: Int = 0): String={
		if(nb <= 1000){
			var ia1 = new IAlvl1()
			ia1.createBoard
			var ia2 = new IAlvl2()
			ia2.createBoard

			if(gameLoopTest(ia1,ia2,false).equals("1")){
				testLoop(nb+1,countWin+1)
			}else{
				testLoop(nb+1,countWin)
			}
		}else{    
			countWin.toString
		}
	}

	def gameLoopTest(p1: Player, p2: Player,winner : Boolean):String={
		if(!winner){
			p1.attackRound(p2.grid)

			if(!p2.grid.isEmpty()){
				p2.attackRound(p1.grid)

				if(!p1.grid.isEmpty()){
					gameLoopTest(p1, p2, false)
				}else{
					gameLoopTest(p1, p2, true)
				}
			}else{
				gameLoopTest(p1, p2, true)
			}
		}else{
			if(p2.grid.isEmpty()) "0"
            else "1"
		}
	}
}
