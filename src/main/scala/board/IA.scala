package board


trait IA {
    def shoot:Tuple2[Int,Int]
}


class IAlvl1 extends Player with IA {
    var grid = new Grid()
    override def shoot:Tuple2[Int,Int]={(1,1)}
}

class IAlvl2 extends Player with IA {
    var grid = new Grid()
    def shoot:Tuple2[Int,Int]={(1,1)}
}

class IAlvl3 extends Player with IA {
    var grid = new Grid()
    def shoot:Tuple2[Int,Int]={(1,1)}
}
