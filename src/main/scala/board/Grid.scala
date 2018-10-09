package board

import scala.collection.mutable.ListBuffer


/*
	Main element of the board. Each player got a single grid.

	* A-J is the x axis, from 0 to 9
	* 1-10 is the y axis, from 0 to 9


		| A | B | C | D | E | F | G | H | I | J
	______________________________________________-> x

	1	|   |   |   |   |   |   |   |   |   |
	____________________________________________

	2	|   |   |   |   |   |   |   |   |   |
	____________________________________________

	3	|   |   |   |   |   |   |   |   |   |
	____________________________________________

	4	|   |   |   |   |   |   |   |   |   |
	____________________________________________

	5	|   |   |   |   |   |   |   |   |   |
	____________________________________________

	6	|   |   |   |   |   |   |   |   |   |
	____________________________________________

	7	|   |   |   |   |   |   |   |   |   |
	____________________________________________

	8	|   |   |   |   |   |   |   |   |   |
	____________________________________________

	9	|   |   |   |   |   |   |   |   |   |
	____________________________________________

	10	|   |   |   |   |   |   |   |   |   |


*/

class Grid(){
	var board = Array.ofDim[Cell](10,10)
	var boats = new ListBuffer[Boat]()
	createBoard(0,0);

	//Initializer
	def createBoard(x:Int, y:Int){
		board(x)(y) = new Cell("Empty")

		if(x == 9){
			if(y != 9){
				createBoard(0,y+1)
			}
		}else{
			createBoard(x+1,y)
		}
	}

	//Return the state of the cell
	def checkCell(x: Int, y: Int):String={
		board(x)(y).state
	}

	//Set a new state to the cell
	def setCell(x: Int, y: Int, state: String){
		board(x)(y).state = state
	}


	//Add a boat to the grid
	def addBoat(b : Boat, length: Int){
		boats += b
		addBoatOnGrid(b,length)
	}

	//Setting the state of each cell of the boat
	def addBoatOnGrid(b: Boat, length: Int){
		if(length != 0){
			if(b.direction.equals("v") || b.direction.equals("V")){
					var xb = b.x
					var yb = b.y + (b.size - length)
					if(checkCell(xb,yb) == "Empty"){
						setCell(xb,yb,"Ship")
					}
			}else{
				var xb = b.x + (b.size - length)
				var yb = b.y
				if(checkCell(xb,yb) == "Empty"){
					setCell(xb,yb,"Ship")
				}
			}
			addBoatOnGrid(b,length - 1)
		}
	}

	//Obtain the boat instance hit by a shot
	def getHitBoat(x: Int, y: Int, listBoats: List[Boat] = boats.toList): Boat={
		if(listBoats.head.x == x && listBoats.head.y <= y && y < (listBoats.head.y + listBoats.head.size) && listBoats.head.isVertical){
			return listBoats.head

		}else if(listBoats.head.y == y && listBoats.head.x <= x && x < (listBoats.head.size + listBoats.head.x) && listBoats.head.isHorizontal){
			return listBoats.head

		}else{
			getHitBoat(x,y,listBoats.tail)
		}
	}

	//Remove a sinking boat from the grid and update the state of the cells
	def boatSunk(b: Boat, acc: Int = 0){
		if(acc < b.size){
			if(b.direction.equals("v") || b.direction.equals("V")){
					var xb = b.x
					var yb = b.y + acc
					if(checkCell(xb,yb) == "Ship" || checkCell(xb,yb) == "Touched"){
						setCell(xb,yb,"Sunk")
					}
			}else{
				var xb = b.x + acc
				var yb = b.y
				if(checkCell(xb,yb) == "Ship" || checkCell(xb,yb) == "Touched"){
					setCell(xb,yb,"Sunk")
				}
			}
			boatSunk(b, acc+1)
		}
	}


	//Check if there is no boat left on grid, to proclaim a winner at the end of a turn
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
