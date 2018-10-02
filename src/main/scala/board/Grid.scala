package board

class Grid(){
	var board = Array.ofDim[Cell](10,10)

	createBoard(0,0);





	def createBoard(x:Int, y:Int){
		this.board(x)(y) = new Cell("Empty")

		if(x == 9){
			if(y != 9){
				createBoard(0,y+1)
			}
		}else{
			createBoard(x+1,y)
		}
	}



	def addBoat(b : Boat, length: Int){
		if(length != 0){
			if(b.direction.equals("v") || b.direction.equals("V")){
					var xb = b.x
					var yb = b.y + (b.size - length)
					if(this.board(xb)(yb).state == "Empty"){
						this.board(xb)(yb).state = "Ship"
						println(xb + " " + yb)
					}else{
						println("Y a un bateau")
					}
			}else{
				var xb = b.x + (b.size - length)
				var yb = b.y
				if(this.board(xb)(yb).state == "Empty"){
					this.board(xb)(yb).state = "Ship"
					println(xb + " " + yb)
				}else{
					println("Y a un bateau")
				}
			}
			addBoat(b,length - 1)
		}

	}


	def displayOwn(){
		println("B = Boat, X = Shot missed \n")

		println("|   | A | B | C | D | E | F | G | H | I | J  ")
		println("|---|---|---|---|---|---|---|---|---|---|---")
		println("| 1 | " + board(0)(0).render + " | " + board(1)(0).render + " | " + board(2)(0).render + " | " + board(3)(0).render + " | " + board(4)(0).render + " | " + board(5)(0).render + " | "+ board(6)(0).render + " | "+ board(7)(0).render + " | " + board(8)(0).render + " | " + board(9)(0).render)
		println("|---|---|---|---|---|---|---|---|---|---|---")
		println("| 2 | " + board(0)(1).render + " | " + board(1)(1).render + " | " + board(2)(1).render + " | " + board(3)(1).render + " | " + board(4)(1).render + " | " + board(5)(1).render + " | "+ board(6)(1).render + " | "+ board(7)(1).render + " | " + board(8)(1).render + " | " + board(9)(1).render)
		println("|---|---|---|---|---|---|---|---|---|---|---")
		println("| 3 | " + board(0)(2).render + " | " + board(1)(2).render + " | " + board(2)(2).render + " | " + board(3)(2).render + " | " + board(4)(2).render + " | " + board(5)(2).render + " | "+ board(6)(2).render + " | "+ board(7)(2).render + " | " + board(8)(2).render + " | " + board(9)(3).render)
		println("|---|---|---|---|---|---|---|---|---|---|---")
		println("| 4 | " + board(0)(3).render + " | " + board(1)(3).render + " | " + board(2)(3).render + " | " + board(3)(3).render + " | " + board(4)(3).render + " | " + board(5)(3).render + " | "+ board(6)(3).render + " | "+ board(7)(3).render + " | " + board(8)(3).render + " | " + board(9)(3).render)
		println("|---|---|---|---|---|---|---|---|---|---|---")
		println("| 5 | " + board(0)(4).render + " | " + board(1)(4).render + " | " + board(2)(4).render + " | " + board(3)(4).render + " | " + board(4)(4).render + " | " + board(5)(4).render + " | "+ board(6)(4).render + " | "+ board(7)(4).render + " | " + board(8)(4).render + " | " + board(9)(4).render)
		println("|---|---|---|---|---|---|---|---|---|---|---")
		println("| 6 | " + board(0)(5).render + " | " + board(1)(5).render + " | " + board(2)(5).render + " | " + board(3)(5).render + " | " + board(4)(5).render + " | " + board(5)(5).render + " | "+ board(6)(5).render + " | "+ board(7)(5).render + " | " + board(8)(5).render + " | " + board(9)(5).render)
		println("|---|---|---|---|---|---|---|---|---|---|---")
		println("| 7 | " + board(0)(6).render + " | " + board(1)(6).render + " | " + board(2)(6).render + " | " + board(3)(6).render + " | " + board(4)(6).render + " | " + board(5)(6).render + " | "+ board(6)(6).render + " | "+ board(7)(6).render + " | " + board(8)(6).render + " | " + board(9)(6).render)
		println("|---|---|---|---|---|---|---|---|---|---|---")
		println("| 8 | " + board(0)(7).render + " | " + board(1)(7).render + " | " + board(2)(7).render + " | " + board(3)(7).render + " | " + board(4)(7).render + " | " + board(5)(7).render + " | "+ board(6)(7).render + " | "+ board(7)(7).render + " | " + board(8)(7).render + " | " + board(9)(7).render)
		println("|---|---|---|---|---|---|---|---|---|---|---")
		println("| 9 | " + board(0)(8).render + " | " + board(1)(8).render + " | " + board(2)(8).render + " | " + board(3)(8).render + " | " + board(4)(8).render + " | " + board(5)(8).render + " | "+ board(6)(8).render + " | "+ board(7)(8).render + " | " + board(8)(8).render + " | " + board(9)(8).render)
		println("|---|---|---|---|---|---|---|---|---|---|---")
		println("| 10| " + board(0)(9).render + " | " + board(1)(9).render + " | " + board(2)(9).render + " | " + board(3)(9).render + " | " + board(4)(9).render + " | " + board(5)(9).render + " | "+ board(6)(9).render + " | "+ board(7)(9).render + " | " + board(8)(9).render + " | " + board(9)(9).render)
		println("|---|---|---|---|---|---|---|---|---|---|---")

	}



    def displayVS(){
		println("B = Boat, X = Shot missed \n")

		println("|   | A | B | C | D | E | F | G | H | I | J  ")
		println("|---|---|---|---|---|---|---|---|---|---|---")
		println("| 1 | " + board(0)(0).renderHidden + " | " + board(1)(0).renderHidden + " | " + board(2)(0).renderHidden + " | " + board(3)(0).renderHidden + " | " + board(4)(0).renderHidden + " | " + board(5)(0).renderHidden + " | "+ board(6)(0).renderHidden + " | "+ board(7)(0).renderHidden + " | " + board(8)(0).renderHidden + " | " + board(9)(0).renderHidden)
		println("|---|---|---|---|---|---|---|---|---|---|---")
		println("| 2 | " + board(0)(1).renderHidden + " | " + board(1)(1).renderHidden + " | " + board(2)(1).renderHidden + " | " + board(3)(1).renderHidden + " | " + board(4)(1).renderHidden + " | " + board(5)(1).renderHidden + " | "+ board(6)(1).renderHidden + " | "+ board(7)(1).renderHidden + " | " + board(8)(1).renderHidden + " | " + board(9)(1).renderHidden)
		println("|---|---|---|---|---|---|---|---|---|---|---")
		println("| 3 | " + board(0)(2).renderHidden + " | " + board(1)(2).renderHidden + " | " + board(2)(2).renderHidden + " | " + board(3)(2).renderHidden + " | " + board(4)(2).renderHidden + " | " + board(5)(2).renderHidden + " | "+ board(6)(2).renderHidden + " | "+ board(7)(2).renderHidden + " | " + board(8)(2).renderHidden + " | " + board(9)(3).renderHidden)
		println("|---|---|---|---|---|---|---|---|---|---|---")
		println("| 4 | " + board(0)(3).renderHidden + " | " + board(1)(3).renderHidden + " | " + board(2)(3).renderHidden + " | " + board(3)(3).renderHidden + " | " + board(4)(3).renderHidden + " | " + board(5)(3).renderHidden + " | "+ board(6)(3).renderHidden + " | "+ board(7)(3).renderHidden + " | " + board(8)(3).renderHidden + " | " + board(9)(3).renderHidden)
		println("|---|---|---|---|---|---|---|---|---|---|---")
		println("| 5 | " + board(0)(4).renderHidden + " | " + board(1)(4).renderHidden + " | " + board(2)(4).renderHidden + " | " + board(3)(4).renderHidden + " | " + board(4)(4).renderHidden + " | " + board(5)(4).renderHidden + " | "+ board(6)(4).renderHidden + " | "+ board(7)(4).renderHidden + " | " + board(8)(4).renderHidden + " | " + board(9)(4).renderHidden)
		println("|---|---|---|---|---|---|---|---|---|---|---")
		println("| 6 | " + board(0)(5).renderHidden + " | " + board(1)(5).renderHidden + " | " + board(2)(5).renderHidden + " | " + board(3)(5).renderHidden + " | " + board(4)(5).renderHidden + " | " + board(5)(5).renderHidden + " | "+ board(6)(5).renderHidden + " | "+ board(7)(5).renderHidden + " | " + board(8)(5).renderHidden + " | " + board(9)(5).renderHidden)
		println("|---|---|---|---|---|---|---|---|---|---|---")
		println("| 7 | " + board(0)(6).renderHidden + " | " + board(1)(6).renderHidden + " | " + board(2)(6).renderHidden + " | " + board(3)(6).renderHidden + " | " + board(4)(6).renderHidden + " | " + board(5)(6).renderHidden + " | "+ board(6)(6).renderHidden + " | "+ board(7)(6).renderHidden + " | " + board(8)(6).renderHidden + " | " + board(9)(6).renderHidden)
		println("|---|---|---|---|---|---|---|---|---|---|---")
		println("| 8 | " + board(0)(7).renderHidden + " | " + board(1)(7).renderHidden + " | " + board(2)(7).renderHidden + " | " + board(3)(7).renderHidden + " | " + board(4)(7).renderHidden + " | " + board(5)(7).renderHidden + " | "+ board(6)(7).renderHidden + " | "+ board(7)(7).renderHidden + " | " + board(8)(7).renderHidden + " | " + board(9)(7).renderHidden)
		println("|---|---|---|---|---|---|---|---|---|---|---")
		println("| 9 | " + board(0)(8).renderHidden + " | " + board(1)(8).renderHidden + " | " + board(2)(8).renderHidden + " | " + board(3)(8).renderHidden + " | " + board(4)(8).renderHidden + " | " + board(5)(8).renderHidden + " | "+ board(6)(8).renderHidden + " | "+ board(7)(8).renderHidden + " | " + board(8)(8).renderHidden + " | " + board(9)(8).renderHidden)
		println("|---|---|---|---|---|---|---|---|---|---|---")
		println("| 10| " + board(0)(9).renderHidden + " | " + board(1)(9).renderHidden + " | " + board(2)(9).renderHidden + " | " + board(3)(9).renderHidden + " | " + board(4)(9).renderHidden + " | " + board(5)(9).renderHidden + " | "+ board(6)(9).renderHidden + " | "+ board(7)(9).renderHidden + " | " + board(8)(9).renderHidden + " | " + board(9)(9).renderHidden)
		println("|---|---|---|---|---|---|---|---|---|---|---")
	}
}
