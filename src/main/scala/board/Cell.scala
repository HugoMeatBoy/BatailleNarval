package board

class Cell(s: String){
	var state: String = s

	def render():String={
		if(state.equals("Touched")) "Ø"
		else if(state.equals("Sunk")) "X"
		else if(state.equals("Ship")) "s"
		else " "
	}

	def renderHidden():String={
		if(state.equals("Missed")) "•"
		else if(state.equals("Touched")) "Ø"
		else if(state.equals("Sunk")) "X"
		else " "
	}


}
