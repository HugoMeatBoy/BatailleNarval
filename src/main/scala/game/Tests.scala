package game

import board._
import players._

/*
    Tools for testing AI's levels :
    Each test will create the wanted AI instances and launch a game loop 100 times, while collecting the results : adding 1 if the favourite AI wins, 0 else

*/
object Tests{
    def testLoop12(nb: Int = 0, countWin: Int = 0): Int={
		if(nb < 100){
			var ia1 = new IAlvl1()
			ia1.createBoard
			var ia2 = new IAlvl2()
			ia2.createBoard


            testLoop13(nb+1,countWin+gameLoopTest(ia1,ia2,false))
		}else{
			countWin
		}
	}

    def testLoop23(nb: Int = 0, countWin: Int = 0): Int={
		if(nb < 100){
			var ia2 = new IAlvl2()
			ia2.createBoard
			var ia3 = new IAlvl3()
			ia3.createBoard

            testLoop13(nb+1,countWin+gameLoopTest(ia2,ia3,false))
		}else{
			countWin
		}
	}

    def testLoop13(nb: Int = 0, countWin: Int = 0): Int={
        if(nb < 100){
            var ia1 = new IAlvl1()
            ia1.createBoard
            var ia3 = new IAlvl3()
            ia3.createBoard



            testLoop13(nb+1,countWin+gameLoopTest(ia1,ia3,false))

        }else{
            countWin
        }
    }

    //Game loop between AIs, without logs
	def gameLoopTest(p1: Player, p2: Player,winner : Boolean): Int={
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
			if(p2.grid.isEmpty()) 0
            else 1
		}
	}
}
