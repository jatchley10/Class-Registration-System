# Class-Registration-System
## Running the Program
1. Install Netbeans 8.2
2. Create a new project 
3. Paste the `.java` files into the src folder.
4. Paste the `procext1input.csv` file into the project folder.

## Overview of the project
This is a program written in java which uses the Model-View-Control design pattern. It takes in a tab seperated value file and creates different class objects out of the information given. This file is included in the repository and is titled `project1input.csv`. It then creates different class objects out of the information and adds them to a list of total courses. At the menu, you will see the following screen.
```
1) Search Courses
2) Register for Course
3) View Trial Schedule
4) Quit
```
To search for courses, you ,must enter the course number. To register for the course you will be prompted to enter the CRN number. The program will throw an error if you try to register for classes that share a day and share a meeting time. Once you have finished adding classes, you can print out your trial schedule by selecting option #3. To exit the program, choose #4.

## Class objects

