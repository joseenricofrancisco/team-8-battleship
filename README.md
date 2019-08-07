
# Battleship

- CPSC233 T02-TEAM8
- Project Name: **Battleship**
- Project Description：
  The game that we planned to make is adapted from a famous guessing game, Battleship, that was published by various companies as a pad-and-pencil game in the 1930s. For our adapted version, the game will have similar mechanics with different rules. The game starts with 5 ships being randomly placed on a 10 by 10 grid. The locations of the ships are unknown for both players which are the user player and the computer. Each player will take turns and guess a coordinate present in the boards boundaries. Players will try to shoot down the ships on the board, the objective of the game is to destroy more ships than the opposing player. 

***
There are two version now: text-version and GUI.

Text-version and GUI-version are compressed as "Demo3.zip" in this git.



## How to start text-version:
    
    1. Download the file "Demo3.zip" in https://github.com/joseenricofrancisco/team-8-battleship

    2. Unzip the file and locate the folder you unzipped in your command terminal.

	3. Locate your position into "src" folder in your command terminal.

    4. Use command "java battleship.gui.GUIStarter" to run the game.

## How to start GUI-version:
    
    1. Download the file "Demo3.zip" in https://github.com/joseenricofrancisco/team-8-battleship

    2. Unzip the file and locate the folder you unzipped in your command terminal.

	3. Locate your position into "src" folder in your command terminal.

    4. Use command "java battleship.gui.GUIStarter" to run the game.

## How to run JUnit test:

In "Source" folder, there is a folder named "Testfile"


The folder contains 4 files:
- BoardTest.java
- Board.java
- hamcrest-core-1.3.jar
- junit-4.12.jar

1. Download the files in https://github.com/joseenricofrancisco/team-8-battleship

2. Locate your position into "Testfile" folder in your command terminal.

3. Copy and paste this command into your terminal and hit enter to compile.

   javac -cp .:junit-4.12.jar:hamcrest-core-1.3.jar *.java

4. Copy and paste this command into your terminal and hit enter to run tests.

   java -cp .:junit-4.12.jar:hamcrest-core-1.3.jar org.junit.runner.JUnitCore BoardTest
    
## Addtional resoures
- Here's a sample Battleship board.
![Battleship board](https://upload.wikimedia.org/wikipedia/commons/thumb/6/65/Battleship_game_board.svg/1280px-Battleship_game_board.svg.png)

