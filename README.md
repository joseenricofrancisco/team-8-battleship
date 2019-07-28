
# Battleship

- CPSC233 T02-TEAM8
- Project Name: **Battleship**
- Project Description：
  The game that we are planning on making is based on a famous guessing game that was published by various companies as a pad-and-pencil game in the 1930s.  The computer will ramdomly place 5 of the players' ships on a 10 by 10 grid. The locations of the ships are unknown for the other player. Players make their guess by turn and try to "shots" at the other player's ships, the objective of the game is to destroy all the opposing player's ships. 

***
There are two version now: text-version and GUI.

Text-version and GUI-verision are compressed as "Demo2.zip" in this git.



## How to start text-version:
    
    1. Download the file "Demo2.zip" in https://github.com/joseenricofrancisco/team-8-battleship

    2. Unzip the file and locate the folder you unzipped in your command terminal.

    3. Locate your position into "Demo2" folder in your command terminal.

    4. Use command "javac Main.java" to compile.

    5. Use command "java Main" to run the game.

## How to start GUI-version:
    
    1. Download the files in https://github.com/joseenricofrancisco/team-8-battleship

    2. Unzip the file and locate the folder you unzipped in your command terminal.

    3. Locate your position into "Demo2" folder in your command terminal.

    4. Use command "javac Main.java" to compile.

    5. Use command "java Main" to run the game.

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

