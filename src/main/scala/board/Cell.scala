package board

class Cell(s:String){
	var state :String = s

	def render():String={
		if(state.equals("Touched")) "Ø"
		else if(state.equals("Sunken")) "X"
		else if(state.equals("Ship")) "≡"
		if(state.equals("Missed")) "o"
		else " "
	}

	def renderHidden():String={
		if(state.equals("Missed")) "o"
		else if(state.equals("Touched")) "Ø"
		else if(state.equals("Sunk")) "X"
		else " "
	}


}
