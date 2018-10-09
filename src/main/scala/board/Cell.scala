package board

/*
	The smallest class of the grid
*/

class Cell(s: String){
	var state: String = s

	//From Ascii.displayOwn()
	def render():String={
		if(state.equals("Missed")) "•"
		else if(state.equals("Touched")) "Ø"
		else if(state.equals("Sunk")) "X"
		else if(state.equals("Ship")) "s"
		else " "
	}

	//From Ascii.displayVS(), hide the alive ships
	def renderHidden():String={
		if(state.equals("Missed")) "•"
		else if(state.equals("Touched")) "Ø"
		else if(state.equals("Sunk")) "X"
		else " "
	}


}
