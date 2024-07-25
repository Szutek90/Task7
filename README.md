# Simple program imitating voting
![Install](https://img.shields.io/badge/install-passing-green)
![Install](https://img.shields.io/badge/coverage-67%25-light%20green)

This project was created during my early days of learning programming. The project allows for an election simulation in which voters vote for candidates from their constituency. The election results are analyzed to determine the winner. In the event of a tie, an additional round of voting is organized until a clear leader is selected.


## Technologies and libraries used

* Java
* Maven
* Lombok
* JUnit
* AssertJ

## Jacoco Coverage

![App Screenshot](src/test/resources/jacoco_raport.PNG)

## Required files

* Candidates file with pattern:

  name;surname;id;district

* Voters with pattern:

  id;district

## Description

### Candidate Class:

* Fields: name, surname, number of votes, electoral district.
* Methods: Necessary for the proper functioning of the class.

### Voter Class:

* Fields: electoral district, collection of Candidate class objects (initially empty, sorted by name, surname, electoral district).
* Methods: Necessary for the proper functioning of the class.

### Class Elections:

Static collections:
* Candidates (no duplicates, sorted by name, surname, electoral district).
* Voters (no duplicates).

Methods:
* Filling the voter collection with candidates from the same constituency.

Voting simulation:
* Voters vote for candidates from their district, vote count updated.
* Selection of the winner based on the leader search algorithm.
*  second round of elections if there is no clear winner in the first round.
