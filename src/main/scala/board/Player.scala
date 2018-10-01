package board

abstract class Player {
    var grid: Grid
}



class Human extends Player{
    var grid = new Grid()
}
