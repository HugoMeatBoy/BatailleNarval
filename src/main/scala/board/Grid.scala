package board



class Grid(){
	var board = Array.ofDim[Cell](10,10)
	createBoard(this,0,0)

	def createBoard(g:Grid, x:Int, y:Int){
		g.board(x)(y) = new Cell("Empty")

		if(x == 9){
			if(y != 9){
				createBoard(g,0,y+1)
			}
		}else{
			createBoard(g,x+1,y)
		}
	}

    def display(){
		println("B = Boat, X = Shot missed \n")

		println("|   | A | B | C | D | E | F | G | H | I | J  ")
		println("|---|---|---|---|---|---|---|---|---|---|---")
		println("| 1 | " + board(0)(0).render + " | " + board(0)(1).render + " | " + board(0)(2).render + " | " + board(0)(3).render + " | " + board(0)(4).render + " | " + board(0)(5).render + " | "+ board(0)(6).render + " | "+ board(0)(7).render + " | " + board(0)(8).render + " | "+ board(0)(9).render)
		println("|---|---|---|---|---|---|---|---|---|---|---")
		println("| 2 | " + board(1)(0).render + " | " + board(1)(1).render + " | " + board(1)(2).render + " | " + board(1)(3).render + " | " + board(1)(4).render + " | " + board(1)(5).render + " | "+ board(1)(6).render + " | "+ board(1)(7).render + " | " + board(1)(8).render + " | "+ board(1)(9).render)
		println("|---|---|---|---|---|---|---|---|---|---|---")
		println("| 3 | " + board(2)(0).render + " | " + board(2)(1).render + " | " + board(2)(2).render + " | " + board(2)(3).render + " | " + board(2)(4).render + " | " + board(2)(5).render + " | "+ board(2)(6).render + " | "+ board(2)(7).render + " | " + board(2)(8).render + " | "+ board(2)(9).render)
		println("|---|---|---|---|---|---|---|---|---|---|---")
		println("| 4 | " + board(3)(0).render + " | " + board(3)(1).render + " | " + board(3)(2).render + " | " + board(3)(3).render + " | " + board(3)(4).render + " | " + board(3)(5).render + " | "+ board(3)(6).render + " | "+ board(3)(7).render + " | " + board(3)(8).render + " | "+ board(3)(9).render)
		println("|---|---|---|---|---|---|---|---|---|---|---")
		println("| 5 | " + board(4)(0).render + " | " + board(4)(1).render + " | " + board(4)(2).render + " | " + board(4)(3).render + " | " + board(4)(4).render + " | " + board(4)(5).render + " | "+ board(4)(6).render + " | "+ board(4)(7).render + " | " + board(4)(8).render + " | "+ board(4)(9).render)
		println("|---|---|---|---|---|---|---|---|---|---|---")
		println("| 6 | " + board(5)(0).render + " | " + board(5)(1).render + " | " + board(5)(2).render + " | " + board(5)(3).render + " | " + board(5)(4).render + " | " + board(5)(5).render + " | "+ board(5)(6).render + " | "+ board(5)(7).render + " | " + board(5)(8).render + " | "+ board(5)(9).render)
		println("|---|---|---|---|---|---|---|---|---|---|---")
		println("| 7 | " + board(6)(0).render + " | " + board(6)(1).render + " | " + board(6)(2).render + " | " + board(6)(3).render + " | " + board(6)(4).render + " | " + board(6)(5).render + " | "+ board(6)(6).render + " | "+ board(6)(7).render + " | " + board(6)(8).render + " | "+ board(6)(9).render)
		println("|---|---|---|---|---|---|---|---|---|---|---")
		println("| 8 | " + board(7)(0).render + " | " + board(7)(1).render + " | " + board(7)(2).render + " | " + board(7)(3).render + " | " + board(7)(4).render + " | " + board(7)(5).render + " | "+ board(7)(6).render + " | "+ board(7)(7).render + " | " + board(7)(8).render + " | "+ board(7)(9).render)
		println("|---|---|---|---|---|---|---|---|---|---|---")
		println("| 9 | " + board(8)(0).render + " | " + board(8)(1).render + " | " + board(8)(2).render + " | " + board(8)(3).render + " | " + board(8)(4).render + " | " + board(8)(5).render + " | "+ board(8)(6).render + " | "+ board(8)(7).render + " | " + board(8)(8).render + " | "+ board(8)(9).render)
		println("|---|---|---|---|---|---|---|---|---|---|---")
		println("| 10| " + board(9)(0).render + " | " + board(9)(1).render + " | " + board(9)(2).render + " | " + board(9)(3).render + " | " + board(9)(4).render + " | " + board(9)(5).render + " | "+ board(9)(6).render + " | "+ board(9)(7).render + " | " + board(9)(8).render + " | "+ board(9)(9).render)
	}
}
