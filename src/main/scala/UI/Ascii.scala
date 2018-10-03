package UI

import board.Grid

object Ascii{

    def logo(){
            println("\n\n                                     # #  ( )")
            println("                                  ___#_#___|__")
            println("                              _  |____________|  _")
            println("                       _=====| | |            | | |==== _")
            println("              =====| |.---------------------------. | |====")
            println("    <--------------------'   .  .  .  .  .  .  .  .   '--------------/")
            println("     \\                                                             /")
            println("      \\______________SCALA_BATTLESHIP_______by_Hugo_FAZIO_________/)\n\n")

            println("\n----------------------- Welcome for a new game ! ------------------------------\n")
        }


    def displayOwn(g:Grid){
        println("\n\n ************** Your grid\n")
        println("≡ = Ship, Ø = Ship touched, X = Ship sunk \n")

        println("        | A | B | C | D | E | F | G | H | I | J  ")
        println("     ---|---|---|---|---|---|---|---|---|---|---")
        println("      1 | " + g.board(0)(0).render + " | " + g.board(1)(0).render + " | " + g.board(2)(0).render + " | " + g.board(3)(0).render + " | " + g.board(4)(0).render + " | " + g.board(5)(0).render + " | "+ g.board(6)(0).render + " | "+ g.board(7)(0).render + " | " + g.board(8)(0).render + " | " + g.board(9)(0).render)
        println("     ---|---|---|---|---|---|---|---|---|---|---")
        println("      2 | " + g.board(0)(1).render + " | " + g.board(1)(1).render + " | " + g.board(2)(1).render + " | " + g.board(3)(1).render + " | " + g.board(4)(1).render + " | " + g.board(5)(1).render + " | "+ g.board(6)(1).render + " | "+ g.board(7)(1).render + " | " + g.board(8)(1).render + " | " + g.board(9)(1).render)
        println("     ---|---|---|---|---|---|---|---|---|---|---")
        println("      3 | " + g.board(0)(2).render + " | " + g.board(1)(2).render + " | " + g.board(2)(2).render + " | " + g.board(3)(2).render + " | " + g.board(4)(2).render + " | " + g.board(5)(2).render + " | "+ g.board(6)(2).render + " | "+ g.board(7)(2).render + " | " + g.board(8)(2).render + " | " + g.board(9)(3).render)
        println("     ---|---|---|---|---|---|---|---|---|---|---")
        println("      4 | " + g.board(0)(3).render + " | " + g.board(1)(3).render + " | " + g.board(2)(3).render + " | " + g.board(3)(3).render + " | " + g.board(4)(3).render + " | " + g.board(5)(3).render + " | "+ g.board(6)(3).render + " | "+ g.board(7)(3).render + " | " + g.board(8)(3).render + " | " + g.board(9)(3).render)
        println("     ---|---|---|---|---|---|---|---|---|---|---")
        println("      5 | " + g.board(0)(4).render + " | " + g.board(1)(4).render + " | " + g.board(2)(4).render + " | " + g.board(3)(4).render + " | " + g.board(4)(4).render + " | " + g.board(5)(4).render + " | "+ g.board(6)(4).render + " | "+ g.board(7)(4).render + " | " + g.board(8)(4).render + " | " + g.board(9)(4).render)
        println("     ---|---|---|---|---|---|---|---|---|---|---")
        println("      6 | " + g.board(0)(5).render + " | " + g.board(1)(5).render + " | " + g.board(2)(5).render + " | " + g.board(3)(5).render + " | " + g.board(4)(5).render + " | " + g.board(5)(5).render + " | "+ g.board(6)(5).render + " | "+ g.board(7)(5).render + " | " + g.board(8)(5).render + " | " + g.board(9)(5).render)
        println("     ---|---|---|---|---|---|---|---|---|---|---")
        println("      7 | " + g.board(0)(6).render + " | " + g.board(1)(6).render + " | " + g.board(2)(6).render + " | " + g.board(3)(6).render + " | " + g.board(4)(6).render + " | " + g.board(5)(6).render + " | "+ g.board(6)(6).render + " | "+ g.board(7)(6).render + " | " + g.board(8)(6).render + " | " + g.board(9)(6).render)
        println("     ---|---|---|---|---|---|---|---|---|---|---")
        println("      8 | " + g.board(0)(7).render + " | " + g.board(1)(7).render + " | " + g.board(2)(7).render + " | " + g.board(3)(7).render + " | " + g.board(4)(7).render + " | " + g.board(5)(7).render + " | "+ g.board(6)(7).render + " | "+ g.board(7)(7).render + " | " + g.board(8)(7).render + " | " + g.board(9)(7).render)
        println("     ---|---|---|---|---|---|---|---|---|---|---")
        println("      9 | " + g.board(0)(8).render + " | " + g.board(1)(8).render + " | " + g.board(2)(8).render + " | " + g.board(3)(8).render + " | " + g.board(4)(8).render + " | " + g.board(5)(8).render + " | "+ g.board(6)(8).render + " | "+ g.board(7)(8).render + " | " + g.board(8)(8).render + " | " + g.board(9)(8).render)
        println("     ---|---|---|---|---|---|---|---|---|---|---")
        println("      10| " + g.board(0)(9).render + " | " + g.board(1)(9).render + " | " + g.board(2)(9).render + " | " + g.board(3)(9).render + " | " + g.board(4)(9).render + " | " + g.board(5)(9).render + " | "+ g.board(6)(9).render + " | "+ g.board(7)(9).render + " | " + g.board(8)(9).render + " | " + g.board(9)(9).render)

    }



    def displayVS(g:Grid){
        println("\n\n ************** Opponent grid\n")
        println("x = Ship touched, X = Ship sunk, o = Shot missed \n")

        println("        | A | B | C | D | E | F | G | H | I | J  ")
        println("     ---|---|---|---|---|---|---|---|---|---|---")
        println("      1 | " + g.board(0)(0).renderHidden + " | " + g.board(1)(0).renderHidden + " | " + g.board(2)(0).renderHidden + " | " + g.board(3)(0).renderHidden + " | " + g.board(4)(0).renderHidden + " | " + g.board(5)(0).renderHidden + " | "+ g.board(6)(0).renderHidden + " | "+ g.board(7)(0).renderHidden + " | " + g.board(8)(0).renderHidden + " | " + g.board(9)(0).renderHidden)
        println("     ---|---|---|---|---|---|---|---|---|---|---")
        println("      2 | " + g.board(0)(1).renderHidden + " | " + g.board(1)(1).renderHidden + " | " + g.board(2)(1).renderHidden + " | " + g.board(3)(1).renderHidden + " | " + g.board(4)(1).renderHidden + " | " + g.board(5)(1).renderHidden + " | "+ g.board(6)(1).renderHidden + " | "+ g.board(7)(1).renderHidden + " | " + g.board(8)(1).renderHidden + " | " + g.board(9)(1).renderHidden)
        println("     ---|---|---|---|---|---|---|---|---|---|---")
        println("      3 | " + g.board(0)(2).renderHidden + " | " + g.board(1)(2).renderHidden + " | " + g.board(2)(2).renderHidden + " | " + g.board(3)(2).renderHidden + " | " + g.board(4)(2).renderHidden + " | " + g.board(5)(2).renderHidden + " | "+ g.board(6)(2).renderHidden + " | "+ g.board(7)(2).renderHidden + " | " + g.board(8)(2).renderHidden + " | " + g.board(9)(3).renderHidden)
        println("     ---|---|---|---|---|---|---|---|---|---|---")
        println("      4 | " + g.board(0)(3).renderHidden + " | " + g.board(1)(3).renderHidden + " | " + g.board(2)(3).renderHidden + " | " + g.board(3)(3).renderHidden + " | " + g.board(4)(3).renderHidden + " | " + g.board(5)(3).renderHidden + " | "+ g.board(6)(3).renderHidden + " | "+ g.board(7)(3).renderHidden + " | " + g.board(8)(3).renderHidden + " | " + g.board(9)(3).renderHidden)
        println("     ---|---|---|---|---|---|---|---|---|---|---")
        println("      5 | " + g.board(0)(4).renderHidden + " | " + g.board(1)(4).renderHidden + " | " + g.board(2)(4).renderHidden + " | " + g.board(3)(4).renderHidden + " | " + g.board(4)(4).renderHidden + " | " + g.board(5)(4).renderHidden + " | "+ g.board(6)(4).renderHidden + " | "+ g.board(7)(4).renderHidden + " | " + g.board(8)(4).renderHidden + " | " + g.board(9)(4).renderHidden)
        println("     ---|---|---|---|---|---|---|---|---|---|---")
        println("      6 | " + g.board(0)(5).renderHidden + " | " + g.board(1)(5).renderHidden + " | " + g.board(2)(5).renderHidden + " | " + g.board(3)(5).renderHidden + " | " + g.board(4)(5).renderHidden + " | " + g.board(5)(5).renderHidden + " | "+ g.board(6)(5).renderHidden + " | "+ g.board(7)(5).renderHidden + " | " + g.board(8)(5).renderHidden + " | " + g.board(9)(5).renderHidden)
        println("     ---|---|---|---|---|---|---|---|---|---|---")
        println("      7 | " + g.board(0)(6).renderHidden + " | " + g.board(1)(6).renderHidden + " | " + g.board(2)(6).renderHidden + " | " + g.board(3)(6).renderHidden + " | " + g.board(4)(6).renderHidden + " | " + g.board(5)(6).renderHidden + " | "+ g.board(6)(6).renderHidden + " | "+ g.board(7)(6).renderHidden + " | " + g.board(8)(6).renderHidden + " | " + g.board(9)(6).renderHidden)
        println("     ---|---|---|---|---|---|---|---|---|---|---")
        println("      8 | " + g.board(0)(7).renderHidden + " | " + g.board(1)(7).renderHidden + " | " + g.board(2)(7).renderHidden + " | " + g.board(3)(7).renderHidden + " | " + g.board(4)(7).renderHidden + " | " + g.board(5)(7).renderHidden + " | "+ g.board(6)(7).renderHidden + " | "+ g.board(7)(7).renderHidden + " | " + g.board(8)(7).renderHidden + " | " + g.board(9)(7).renderHidden)
        println("     ---|---|---|---|---|---|---|---|---|---|---")
        println("      9 | " + g.board(0)(8).renderHidden + " | " + g.board(1)(8).renderHidden + " | " + g.board(2)(8).renderHidden + " | " + g.board(3)(8).renderHidden + " | " + g.board(4)(8).renderHidden + " | " + g.board(5)(8).renderHidden + " | "+ g.board(6)(8).renderHidden + " | "+ g.board(7)(8).renderHidden + " | " + g.board(8)(8).renderHidden + " | " + g.board(9)(8).renderHidden)
        println("     ---|---|---|---|---|---|---|---|---|---|---")
        println("      10| " + g.board(0)(9).renderHidden + " | " + g.board(1)(9).renderHidden + " | " + g.board(2)(9).renderHidden + " | " + g.board(3)(9).renderHidden + " | " + g.board(4)(9).renderHidden + " | " + g.board(5)(9).renderHidden + " | "+ g.board(6)(9).renderHidden + " | "+ g.board(7)(9).renderHidden + " | " + g.board(8)(9).renderHidden + " | " + g.board(9)(9).renderHidden)
    }
}
