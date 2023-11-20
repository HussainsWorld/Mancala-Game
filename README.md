# Mancala
Program creates a mancala game
## Description

A Java version of the classic Mancala board game is available through the Mancala Game project. In the strategy game Mancala, two players take turns grabbing stones and tactically moving them across a board that has pits in it. The objective of the game is to accumulate more stones in each player's store by having them take turns sowing and capturing stones, according to the traditional Mancala rules.

## Getting Started

### Dependencies

* Java 17
* Gradle
* checkstyle
* JUnit

### Executing program

* Step 1: Compile
```
gradle build
```
* Step 2: Commands to run program
```
java -cp build/classes/java/main ui.TextUI
```
```
java -jar build/libs/Mancala.jar
```
* Step 3: Expected oucome
Text within the terminal showing the instructions and pathways for the game

## Limitations

Completed

## Author Information

Hussain Al-Shammari
alshammh@uoguelph.ca

## Development History

My code has much better practices of object oriented programming in comparison to the AI version as the AI version
has every method as public. Making methods package private where appropriate is good practice of encapsulation.
The idea of encapsulation is very heavily tied to the concepts of OOP. Also, to begin with, the code from chatGPT
provides a very half-implemented basis of the code. Thus, it tells us that chatGPT is viable to be used as a way
to get to the right direction, rather than providing the full answers needed. My code completes all the necessary
implementations that chatGPT said to complete. I also added my own method within Board and MancalaGame that keeps
track of if an extra turn needs to be taken. ChatGPT's code also doesn't have try catch statements for the 
exceptions that it throws. Also, chatGPT's toString() methods return objects in strings which will end up returning 
a null string. All of these things further validate my claim that chatGPT should only be used as a skeleton.

## Acknowledgments

Inspiration, code snippets, etc.
* [awesome-readme](https://github.com/matiassingers/awesome-readme)
* [simple-readme] (https://gist.githubusercontent.com/DomPizzie/7a5ff55ffa9081f2de27c315f5018afc/raw/d59043abbb123089ad6602aba571121b71d91d7f/README-Template.md)



