package board

class Cell(s:String){
	var state :String = s

	def render():String={
		if(state.equals("Touched")) "x"
		else if(state.equals("Sunken")) "X"
		else if(state.equals("Ship")) "S"
		else " "
	}

	def renderHidden():String={
		if(state.equals("Missed")) "o"
		else if(state.equals("Touched")) "x"
		else if(state.equals("Sunk")) "X"
		else " "
	}


}
