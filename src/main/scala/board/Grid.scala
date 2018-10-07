package board

import scala.collection.mutable.ListBuffer

class Grid(){
	var board = Array.ofDim[Cell](10,10)
	var boats = new ListBuffer[Boat]()
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


	def checkCell(x: Int, y: Int):String={
		board(x)(y).state
	}

	def setCell(x: Int, y: Int, state: String){
		board(x)(y).state = state
	}




	def addBoat(b : Boat, length: Int){
		boats += b
		adddBoatOnGrid(b,length)
	}


	def adddBoatOnGrid(b: Boat, length: Int){
		if(length != 0){
			if(b.direction.equals("v") || b.direction.equals("V")){
					var xb = b.x
					var yb = b.y + (b.size - length)
					if(this.checkCell(xb,yb) == "Empty"){
						this.setCell(xb,yb,"Ship")
					}
			}else{
				var xb = b.x + (b.size - length)
				var yb = b.y
				if(this.checkCell(xb,yb) == "Empty"){
					this.setCell(xb,yb,"Ship")
				}
			}
			adddBoatOnGrid(b,length - 1)
		}
	}


	def getHitBoat(x: Int, y: Int, listBoats: List[Boat] = boats.toList): Boat={
		if(listBoats.head.x == x && listBoats.head.y <= y && y < (listBoats.head.y + listBoats.head.size) && listBoats.head.isVertical){
			return listBoats.head

		}else if(listBoats.head.y == y && listBoats.head.x <= x && x < (listBoats.head.size + listBoats.head.x) && listBoats.head.isHorizontal){
			return listBoats.head

		}else{
			getHitBoat(x,y,listBoats.tail)
		}
	}

	def boatSunk(b: Boat, acc: Int = 0){
		if(acc < b.size){
			if(b.direction.equals("v") || b.direction.equals("V")){
					var xb = b.x
					var yb = b.y + acc
					if(this.checkCell(xb,yb) == "Ship" || this.checkCell(xb,yb) == "Touched"){
						this.setCell(xb,yb,"Sunk")
					}
			}else{
				var xb = b.x + acc
				var yb = b.y
				if(this.checkCell(xb,yb) == "Ship" || this.checkCell(xb,yb) == "Touched"){
					this.setCell(xb,yb,"Sunk")
				}
			}
			boatSunk(b, acc+1)
		}
	}



	def isEmpty(lb: List[Boat] = boats.toList):Boolean={
		if(lb.size > 0){
			if(lb.head.sunk){
				isEmpty(lb.tail)
			}else{
				false
			}
		}else{
			true
		}


	}
}
