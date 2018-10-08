# BattleSheep / Bataille Narval

  First Scala SBT project : AWI IG5 - Polytech Montpellier


## Getting Started

This is a simple battleship game for 1 or 2 players fully displayed on console.


### Prerequisites

The only thing you need is SBT, an interactive Scala build tool
* [SBT Install](https://www.scala-sbt.org/1.0/docs/Setup.html)


### Installing & Running

1. Clone this repo and move to this directory
2. Execute the SBT tool to access the BattleShip project

```
 git clone https://github.com/HugoMeatBoy/BatailleNarval
 cd /BatailleNarval
 sbt
```

3. Run BattleShip

```
sbt:BattleShip> run
```

You can now play by following the instructions


## Proof of Concept : IAs

By selecting the '0' menu at start (hidden), you will access the testing mode of the IA :
It will only run 1000 games between IA 1 and IA 2, then between IA 2 and IA 3, and display you the results.

This is only to confirm the right levelling of implemented IAs.
