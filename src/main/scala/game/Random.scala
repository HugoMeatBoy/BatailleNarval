package game

//Tools for random picks, used by AI to shoot and place ships
object Random{
    def pickRandomCell():Tuple2[Int,Int]={
        var rc = scala.util.Random
        var xR = rc.nextInt(10)
        var yR = rc.nextInt(10)
        (xR,yR)
    }
    def pickRandomDir():String={
        var rd = scala.util.Random
        var d = rd.nextInt(2)
        d match {
            case 1 => "h"
            case _ => "v"
        }
    }
}
