package UI

object Console{
        def takeCellInput():Tuple2[Char,Int] = {
        var target =  readLine("Select a cell : ")
        val regex = "[A,B,C,D,E,F,G,H,I,J,a,b,c,d,e,f,g,h,i,j][1,2,3,4,5,6,7,8,9]".r
        val regexTen = "[A,B,C,D,E,F,G,H,I,J,a,b,c,d,e,f,g,h,i,j][1][0]".r


        target match {
            case regex() | regexTen() => {
            var xTarget = target.charAt(0)

            var yTarget = 0

            if(target.length == 3){
                yTarget = 10
            }else{
                yTarget = target.charAt(1).asDigit
            }
            (xTarget,yTarget)
            }
            case _ => {
                println("Input error, please enter a cell inside the grid")
                takeCellInput
            }
        }
    }
}
