package board


trait IA {
    def shoot:Tuple2[Int,Int]
/*    var boat5 = new Boat(5)
    var boat4 = new Boat(4)
    var boat3_1 = new Boat(3)
    var boat3_2 = new Boat(3)
    var boat2 = new Boat(2)*/
}


class IAlvl1 extends Player with IA {
    var grid = new Grid()
    override def shoot:Tuple2[Int,Int]={(1,1)}
    def attackRound(g : Grid): Boolean={true}
}

class IAlvl2 extends Player with IA {
    var grid = new Grid()
    def shoot:Tuple2[Int,Int]={(1,1)}
    def attackRound(g : Grid): Boolean={true}
}

class IAlvl3 extends Player with IA {
    var grid = new Grid()
    def shoot:Tuple2[Int,Int]={(1,1)}
    def attackRound(g : Grid): Boolean={true}
}
