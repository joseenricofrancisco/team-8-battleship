Board JUnit test:

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