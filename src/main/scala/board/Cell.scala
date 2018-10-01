package board

class Cell(s:String){
	var state :String = s

	def render():String={
		if(state.equals("Missed")){
			return "o"
		}else if(state.equals("Touched")){
			return "x"
		}else if(state.equals("Sunken")){
			return "X"
		}else if(state.equals("Ship")){
			return "S"
		}else{
			" "
		}
	}

	def checkState: Boolean = {
		state.equals("Empty") || state.equals("Ship")
	}
}
