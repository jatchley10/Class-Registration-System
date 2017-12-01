# Class-Registration-System
## Running the Program
1. Install Netbeans 8.2
2. Create a new project 
3. Paste the `.java` files into the src folder.
4. Paste the `procext1input.csv` file into the project folder.

## Cell Formatting 
Each cell of the file must be formatted like so in order for the program to work. 
```
1.Introduction to Information Technology	2.21729	3.CS 201	4.10	5.3	6.14:30	7.16:00	8.TR	9.Ayers Hall 357	10.Lecture	11.Matthew R Burns
Introduction to Information Technology	21730	CS 201	11	3	World Wide Web	Thomas D White				
```
The numbers included in the first cell DO NOT need to be included in the file. I just included them to show what variable they are assigned to.
1. Class Name
2.CRN Number
3.Course Number
4.Section Number
5.Credit Hours
6.Start Time
7.End Time
8.Days Met
9. Room
10.Course Type


11. Instructor
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
The program reads in the file and splits it on the `\t` character. It then tests the length of the array in order to determine if it is a `Traditional Course` or `Online Course`. Both of these are subclasses of the super class called `Course`. Traditional Course objects will contain certain things that online courses do not like start times and end times.  
