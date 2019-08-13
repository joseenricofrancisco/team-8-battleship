

# Battleship

- CPSC233 T02-TEAM8
- Project Name: **Battleship**
- Project Description：
  Adapted from the original game of battleship, our game has similar mechanics but different rules from the original. The user loads into the game, which displays 10*10 buttons on the game board. There are two ships which are randomly located on the game board by the computer. The user and AI randomly press the buttons on the game board by turns, the user will go first at the beginning of this game. If the user or AI presses the right buttons where the ships are located, the buttons will show an “X”, this means the user or AI has hit the ship once. If the user or AI presses the wrong buttons where there are no ships located there, then the buttons will show an “O”, this means the user or the AI has not hit the ship. Additionally, the board has numbered borders, and there is a “Ship updated” label which will show the ships and the health it has left. When all ships have been sunk, the game will end. If the user has damaged more ships than the AI, then the user will win, otherwise AI will win.
  
***
There are two version now: text-version and GUI.

Text-version and GUI-version are compressed as "Final.zip" in this git.



## Technologies:
- Java 8 or 9
- JUnit 4
- Eclipse IDE (version 4.12 was used for this project)

## How to start text-version:
    
    1. Download the file "Final.zip" in https://github.com/joseenricofrancisco/team-8-battleship

    2. Unzip the file and locate the folder you unzipped in your command terminal.

	3. Locate your position into "src" folder in your command terminal.

    4. Use command "java battleship.gui.GUIStarter" to run the game.

## How to start GUI-version:
    
    1. Download the file "Final.zip" in https://github.com/joseenricofrancisco/team-8-battleship

    2. Unzip the file and locate the folder you unzipped in your command terminal.

	3. Locate your position into "src" folder in your command terminal.

    4. Use command "java battleship.gui.GUIStarter" to run the game.

## How to run JUnit test:

#### Board JUnit test
In "Source" folder, there is a folder named "Testfile". From there access te file "BoardJUnit".


The folder contains 4 files:
- BoardTest.java
- Board.java
- hamcrest-core-1.3.jar
- junit-4.12.jar

1. Download the files in https://github.com/joseenricofrancisco/team-8-battleship/tree/master/Source/Testfile/BoardJUnit

2. Locate your position into "Testfile" folder in your command terminal.

3. Copy and paste this command into your terminal and hit enter to compile.

   javac -cp .:junit-4.12.jar:hamcrest-core-1.3.jar *.java

4. Copy and paste this command into your terminal and hit enter to run tests.

   java -cp .:junit-4.12.jar:hamcrest-core-1.3.jar org.junit.runner.JUnitCore BoardTest

***
#### Ship JUnit test
To run the JUnit test (in Eclipse) for the Ship class, please follow https://github.com/joseenricofrancisco/team-8-battleship/tree/master/Source/Testfile/ShipJUnit for detailed instructions.
    
## Addtional resoures
- Here's a our sample Battleship board.
- ![enter image description here](https://lh3.googleusercontent.com/pEBTamnuMio1JII_3dQfE61FUOHsGn9I-FRc_f2Q8FZAuEO2VYTgoZSfEEcnVT_bXMqvL2Ro0QU "Battleship Game Board")





