# Zoo Management System

A menu-driven Java console application for managing the animals in a zoo. Built with object-oriented programming, file persistence and JUnit testing.

Developed as coursework for BEng (Hons) Software Engineering at Ulster University.

## Features

- Add, remove and modify animals (Birds, Fish and Lions)
- View all animals, each with its own species-specific sound message
- Search animals by name or colour
- Daily care routine, with different care steps for each animal type
- Zoo report showing the total of each animal type and the most common colour
- Input validation: names, colours and breeds must be letters only, numbers can't be negative, and water type must be Freshwater or Saltwater
- Data is saved to text files on exit and loaded again on startup

## Concepts demonstrated

- Abstraction: `Animal` is an abstract class with abstract methods `makeSound()` and `getType()`
- Inheritance: `Bird`, `Fish` and `Lion` extend `Animal`
- Polymorphism: `Zoo` stores everything as `Animal` objects in an `ArrayList`, and `makeSound()`, `dailyCare()` and `toString()` behave differently for each type
- Interfaces: `Bird` implements `Flyable` and `Fish` implements `Swimmable`
- Encapsulation: private fields with getters and setters
- File I/O: reading and writing with `Scanner` and `PrintWriter`, with `FileNotFoundException` handled
- Unit testing: JUnit 5 tests in `AnimalTest.java`

## Project structure

```
src/
  Main.java         Menu, user input and validation
  Zoo.java          Manages the animal list, searching, reports and file I/O
  Animal.java       Abstract base class
  Bird.java         Extends Animal, implements Flyable
  Fish.java         Extends Animal, implements Swimmable
  Lion.java         Extends Animal
  Flyable.java      Interface
  Swimmable.java    Interface
  AnimalTest.java   JUnit tests
AnimalDetails.txt   Sample animal data
ZooDetails.txt      Sample zoo name
```

## Planned improvements

- Validate the main menu input (currently it expects a number)
- Case-insensitive searching
- Replace the type checks and casting in `saveToFile` with polymorphism
- Move the repeated input validation into reusable helper methods
- Call `fly()` and `swim()` from an "animal show" menu option
- More unit tests, including tests for `Zoo`

