# Snake Game

![Alt Text](https://github.com/LinWeintraub/SnakeGame/blob/main/snake.gif)


## Introduction
Snake Game is a classic arcade game where the player controls a snake to eat food and grow in length. The goal of the game is to get the highest score possible without colliding with the snake's own body or the walls of the game board. This program is an implementation of the Snake Game using Java programming language.
This program uses several object-oriented programming concepts such as Interfaces, Polymorphism, Encapsulation, Single responsibility principle and Open–closed principle.

## Requirements

Java Development Kit (JDK)
Windows 10 or Higher

## Compilation and Running
Navigate to the SnakeGame Folder and execute: ```javac -d . src/*.java``` This will compile SnakeGame.
To run the game: ```java -cp . Main```

## How to Play
After running the program, the game will start automatically. Use the '[a] + enter'/'[d] + enter' keys on the keyboard to change the direction of the snake's movement. The snake will move continuously until it collides with its own body or the walls of the game board. The game will end when the snake collides with something or the player chooses to quit the game ('[q] + enter'). The player's score will be displayed at the end of the game.

## Modules
The program is implemented using object-oriented programming principles and interfaces. Here are the modules used in the program:

### Interfaces
GameController.java: an interface that defines method that controls the game and its input.
GameLogic.java: an interface that that defines game logic methods.
Graphic.java: an interface that defines the methods for displaying the game.
Board.java: an interface that defines the methods for the game board.
Character.java: an interface that defines the methods for the game character.
Food.Java: an interface that defines the methods for the behaviour of food in the game.

### Classes
ConsoleGame.java implements the GameController interface to run the game in console.
SnakeGame.java implements the GameLogic interface for the Snake Game.
ConsoleGraphic.java implements the Graphic interface, allows the game to display itself on console.
PlayBoard.java implements the Board interface for the Snake Game.
Snake.java implements the Character interface, an implementation of the main character in the Snake Game.
Apple.java implements the Food interface, the target for the character to increase its score.
Main.java the main entry point of the program.

### Flow Chart
![Alt Text](https://github.com/LinWeintraub/SnakeGame/blob/main/SnakeGame-Flowchart.jpeg)

### UML
![Alt Text](https://github.com/LinWeintraub/SnakeGame/blob/main/SnakeGame-UML.jpeg)


This Snake Game program is a fun way to spend your free time and exercise your brain. With its simple gameplay and classic design, it is sure to be a hit with gamers of all ages. 
Enjoy playing!


