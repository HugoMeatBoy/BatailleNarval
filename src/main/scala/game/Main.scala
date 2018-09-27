package game


object Test extends App{

	var playerMap = new Grid()
	var attackMap = new Grid()

	playerMap.display

}

class Cell(s:Int){
	var state :Int = s

	def render():String={
		if(state == 0){
			return " "
		}else if(state == 1){
			return "B"
		}else{
			return "X"
		}
	}
}


class Grid(){
	var board = Array.ofDim[Cell](10,10)
	board(0)(0) = new Cell(1)
	board(0)(1) = new Cell(0)
	board(0)(2) = new Cell(0)
	board(0)(3) = new Cell(0)
	board(0)(4) = new Cell(0)
	board(0)(5) = new Cell(0)
	board(0)(6) = new Cell(0)
	board(0)(7) = new Cell(0)
	board(0)(8) = new Cell(1)
	board(0)(9) = new Cell(2)

	board(1)(0) = new Cell(2)
	board(1)(1) = new Cell(0)
	board(1)(2) = new Cell(1)
	board(1)(3) = new Cell(0)
	board(1)(4) = new Cell(5)
	board(1)(5) = new Cell(2)
	board(1)(6) = new Cell(2)
	board(1)(7) = new Cell(0)
	board(1)(8) = new Cell(0)
	board(1)(9) = new Cell(1)


	def display(){
		println("B = Boat, X = Shot missed \n")

		println("|   | A | B | C | D | E | F | G | H | I | J  ")
		println("|---|---|---|---|---|---|---|---|---|---|---")
		println("| 1 | " + board(0)(0).render + " | " + board(0)(1).render + " | " + board(0)(2).render + " | " + board(0)(3).render + " | " + board(0)(4).render + " | " + board(0)(5).render + " | "+ board(0)(6).render + " | "+ board(0)(7).render + " | " + board(0)(8).render + " | "+ board(0)(9).render)
		println("|---|---|---|---|---|---|---|---|---|---|---")
		println("| 2 | " + board(1)(0).render + " | " + board(1)(1).render + " | " + board(1)(2).render + " | " + board(1)(3).render + " | " + board(1)(4).render + " | " + board(1)(5).render + " | "+ board(1)(6).render + " | "+ board(1)(7).render + " | " + board(1)(8).render + " | " + board(1)(9).render)
		println("|---|---|---|---|---|---|---|---|---|---|---")
		println("| 3 | " + board(0)(0).render + " | " + board(0)(1).render + " | " + board(0)(2).render + " | " + board(0)(3).render + " | " + board(0)(4).render + " | " + board(0)(5).render + " | "+ board(0)(6).render + " | "+ board(0)(7).render + " | " + board(0)(8).render + " | "+ board(0)(9).render)
		println("|---|---|---|---|---|---|---|---|---|---|---")
		println("| 4 | " + board(0)(0).render + " | " + board(0)(1).render + " | " + board(0)(2).render + " | " + board(0)(3).render + " | " + board(0)(4).render + " | " + board(0)(5).render + " | "+ board(0)(6).render + " | "+ board(0)(7).render + " | " + board(0)(8).render + " | "+ board(0)(9).render)
		println("|---|---|---|---|---|---|---|---|---|---|---")
		println("| 5 | " + board(0)(0).render + " | " + board(0)(1).render + " | " + board(0)(2).render + " | " + board(0)(3).render + " | " + board(0)(4).render + " | " + board(0)(5).render + " | "+ board(0)(6).render + " | "+ board(0)(7).render + " | " + board(0)(8).render + " | "+ board(0)(9).render)
		println("|---|---|---|---|---|---|---|---|---|---|---")
		println("| 6 | " + board(0)(0).render + " | " + board(0)(1).render + " | " + board(0)(2).render + " | " + board(0)(3).render + " | " + board(0)(4).render + " | " + board(0)(5).render + " | "+ board(0)(6).render + " | "+ board(0)(7).render + " | " + board(0)(8).render + " | "+ board(0)(9).render)
		println("|---|---|---|---|---|---|---|---|---|---|---")
		println("| 7 | " + board(0)(0).render + " | " + board(0)(1).render + " | " + board(0)(2).render + " | " + board(0)(3).render + " | " + board(0)(4).render + " | " + board(0)(5).render + " | "+ board(0)(6).render + " | "+ board(0)(7).render + " | " + board(0)(8).render + " | "+ board(0)(9).render)
		println("|---|---|---|---|---|---|---|---|---|---|---")
		println("| 8 | " + board(0)(0).render + " | " + board(0)(1).render + " | " + board(0)(2).render + " | " + board(0)(3).render + " | " + board(0)(4).render + " | " + board(0)(5).render + " | "+ board(0)(6).render + " | "+ board(0)(7).render + " | " + board(0)(8).render + " | "+ board(0)(9).render)
		println("|---|---|---|---|---|---|---|---|---|---|---")
		println("| 9 | " + board(0)(0).render + " | " + board(0)(1).render + " | " + board(0)(2).render + " | " + board(0)(3).render + " | " + board(0)(4).render + " | " + board(0)(5).render + " | "+ board(0)(6).render + " | "+ board(0)(7).render + " | " + board(0)(8).render + " | "+ board(0)(9).render)
		println("|---|---|---|---|---|---|---|---|---|---|---")
		println("| 10| " + board(0)(0).render + " | " + board(0)(1).render + " | " + board(0)(2).render + " | " + board(0)(3).render + " | " + board(0)(4).render + " | " + board(0)(5).render + " | "+ board(0)(6).render + " | "+ board(0)(7).render + " | " + board(0)(8).render + " | "+ board(0)(9).render)
	}
}


class Player(name:String){

}
