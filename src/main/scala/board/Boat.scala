package board

class Boat(s: Int,xB: Int, yB : Int, dir:String){
    var size:Int = s
    var x:Int = xB
    var y:Int = yB
    var direction:String = dir
    var sunk: Boolean = false

    def hit():Option[String]={
        size -=1
        if(size == 0){
            sunk = true
            Some("Ship sunk !")
        }else{
            None
        }
    }
}
