# Class-Registration-System
## Running the Program
1. Install Netbeans 8.2
2. Create a new project 
3. Paste the `.java` files into the src folder.
4. Paste the `procext1input.csv` file into the project folder.

## Cell Formatting 
Each cell of the file must be formatted like so in order for the program to work. 
```
Introduction to Information Technology 21729	CS 201	10	3	14:30	16:00	TR	Ayers Hall 357	Lecture	Matthew R Burns
Introduction to Information Technology	21730	CS 201	11	3	World Wide Web	Thomas D White				
```
The numbers included in the first cell DO NOT need to be included in the file. I just included them to show what variable they are assigned to.

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
The program reads in the file and splits it on the `\t` character. It then tests the length of the array in order to determine if it is a `Traditional Course` or `Online Course`. Both of these are subclasses of the super class called `Course`. Traditional Course objects will contain certain things that online courses do not like start times and end times. Each course object contains a `conflictsWith()` method that takes in another course and tests the start time and end times to make sure the classes do not conflict. We call this function as by iterating through the trial schedule by making sure the courses you are already registered for do not conflict with the one you currently want to sign up for.

## Model
The model is where we do all of the file input. It contains the `readCourseData()` function which reads in the file and creates objects out of the different classes. Each time it creates an object, it adds it to an ArrayList of potential courses. 

## View
The view contains the code pertaining to the main menu. It only has one function which returns an integer for the user's selection. It sends this message to the controller in order to operate the main menu.
```
private int selection;
    public int mainMenu(){
        System.out.println("1. Search Courses");
        System.out.println("2. Register for Course");
        System.out.println("3. View Trial Schedule");
        System.out.println("4. Quit");
        System.out.println("Your choice? ");
        Scanner choice = new Scanner(System.in);
        selection = choice.nextInt();
        return selection;     
    }

```



## Control
The control is where we are handling all of the input from the main menu. It runs a while loop that does not terminate until the user selects 4 from the main menu to exit the program. Here is an example of how the final program works below.

``
1) Search Courses
2) Register for Course
3) View Trial Schedule
4) Quit

Your Choice? 1
Enter course number in the format SSNNN (for example, CS201): CS230
#21733: CS 230-001 (Fundamentals of Computing), Eric Adelaide Gamess, Lecture, 10:00 - 11:00, MWF, Ayers Hall 257
#21734: CS 230-002 (Fundamentals of Computing), James Mitchell Jensen, Lecture, 12:30 - 13:30, MWF, Ayers Hall 257
#21735: CS 230-003 (Fundamentals of Computing), Jay W Snellen, Lecture, 09:15 - 10:45, TR, Ayers Hall 363
#21736: CS 230-004 (Fundamentals of Computing), James Mitchell Jensen, Lecture, 12:45 - 14:15, TR, Ayers Hall 361

1) Search Courses
2) Register for Course
3) View Trial Schedule
4) Quit

Your Choice? 2
Enter CRN number: 21735
Course added successfully!


1) Search Courses
2) Register for Course
3) View Trial Schedule
4) Quit

Your Choice? 1
Enter course number in the format SSNNN (for example, CS201): MS100
#21929: MS 100-001 (Intermediate Algebra for Precalculus), Janice Lynn Case, Lecture, 12:30 - 13:30, MWF, Ayers Hall 218
#21930: MS 100-002 (Intermediate Algebra for Precalculus), Janice Lynn Case, Lecture, 09:15 - 10:45, TR, Ayers Hall 218
#22199: MS 100-100 (Intermediate Algebra for Precalculus), Curtis L Gladen, Lecture, 08:45 - 11:00, MTWF, Houston Cole Library B03

1) Search Courses
2) Register for Course
3) View Trial Schedule
4) Quit

Your Choice? 2
Enter CRN number: 21930
ERROR: Either the course was not found, or it conflicts with your current schedule!


1) Search Courses
2) Register for Course
3) View Trial Schedule
4) Quit

Your Choice? 2
Enter CRN number: 21929
Course added successfully!


1) Search Courses
2) Register for Course
3) View Trial Schedule
4) Quit

Your Choice? 3
#21735: CS 230-003 (Fundamentals of Computing), Jay W Snellen, Lecture, 09:15 - 10:45, TR, Ayers Hall 363
#21929: MS 100-001 (Intermediate Algebra for Precalculus), Janice Lynn Case, Lecture, 12:30 - 13:30, MWF, Ayers Hall 218

1) Search Courses
2) Register for Course
3) View Trial Schedule
4) Quit

Your Choice? 1
Enter course number in the format SSNNN (for example, CS201): CS201
#21720: CS 201-001 (Introduction to Information Technology), Nathan Lee Mayberry, Lecture, 08:45 - 09:45, MWF, Ayers Hall 357
#21721: CS 201-002 (Introduction to Information Technology), Cynthia Gunter Jensen, Lecture, 10:00 - 11:00, MWF, Ayers Hall 357
#21722: CS 201-003 (Introduction to Information Technology), Cynthia Gunter Jensen, Lecture, 11:15 - 12:15, MWF, Ayers Hall 357
#21723: CS 201-004 (Introduction to Information Technology), Cynthia Gunter Jensen, Lecture, 12:30 - 13:30, MWF, Ayers Hall 357
#21724: CS 201-005 (Introduction to Information Technology), Cynthia Gunter Jensen, Lecture, 13:45 - 14:45, MWF, Ayers Hall 357
#21725: CS 201-006 (Introduction to Information Technology), Nathan Lee Mayberry, Lecture, 09:15 - 10:45, TR, Ayers Hall 357
#21726: CS 201-007 (Introduction to Information Technology), TBA, Lecture, 11:00 - 12:30, TR, Ayers Hall 357
#21727: CS 201-008 (Introduction to Information Technology), Matthew R Burns, Lecture, 11:00 - 12:30, TR, Ayers Hall 359
#21728: CS 201-009 (Introduction to Information Technology), Matthew R Burns, Lecture, 12:45 - 14:15, TR, Ayers Hall 357
#21729: CS 201-010 (Introduction to Information Technology), Matthew R Burns, Lecture, 14:30 - 16:00, TR, Ayers Hall 357
#21730: CS 201-011 (Introduction to Information Technology), Thomas D White, World Wide Web
#21731: CS 201-012 (Introduction to Information Technology), Cynthia Gunter Jensen, World Wide Web
```

