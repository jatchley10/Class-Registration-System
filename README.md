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
The model is where we do all of the file input. It contains the `readCourseData()` function which reads in the file and creates objects out of the different classes. Each time it creates an object, it adds it to an ArrayList of potential courses. This is demonstrated in the code section below. 
```
   public ArrayList<Course> readCourseData(String filename){
        String values;
        ArrayList<String> courseData;
        ArrayList<Course> courses = new ArrayList();
        try {
            Scanner in = new Scanner(Paths.get("project1input.csv"),"UTF-8");
            while(in.hasNextLine()){
                values = in.nextLine();
                courseData = new ArrayList(Arrays.asList(values.split("\t")));
                String courseName;
                Integer crnNumber;
                String courseNumber;
                String sectionNumber;
                String creditHours;
                String courseType;
                String instructor;
                String startTime;
                String endTime;
                String daysMet;
                String room;
                String seperatedNum;
                int startHour;
                int startMinute;
                int endHour;
                int endMinute;

                if(courseData.size() == 7){
                    courseName = courseData.get(0);
                    crnNumber = Integer.parseInt(courseData.get(1));
                    seperatedNum = courseData.get(2);
                    courseNumber = seperatedNum.replaceAll("\\s", "");
                    sectionNumber = courseData.get(3);
                    creditHours = courseData.get(4);
                    courseType = courseData.get(5);
                    instructor = courseData.get(6);

                    // Create an object of the online course and add it to the arraylist of all the courses
                    OnlineCourse course = new     OnlineCourse(courseName,crnNumber,courseNumber,sectionNumber,creditHours,courseType,instructor);
                    courses.add(course);
                }

                else{

                    // Create a traditional course out of the values we are given since we know that it has too many elements to be an online course
                    ArrayList<String> start;
                    ArrayList<String> end;
                    courseName = courseData.get(0);
                    crnNumber = Integer.parseInt(courseData.get(1));
                    seperatedNum = courseData.get(2);
                    courseNumber = seperatedNum.replaceAll("\\s", "");
                    sectionNumber = courseData.get(3);
                    creditHours = courseData.get(4);
                    startTime = courseData.get(5);
                    endTime = courseData.get(6);
                    daysMet = courseData.get(7);
                    room = courseData.get(8);
                    courseType = courseData.get(9);
                    instructor = courseData.get(10);

                    start = new ArrayList(Arrays.asList(startTime.split(":")));
                    startHour = Integer.parseInt(start.get(0));
                    startMinute = Integer.parseInt(start.get(1));


                    end = new ArrayList(Arrays.asList(endTime.split(":")));
                    endHour = Integer.parseInt(end.get(0));
                    endMinute = Integer.parseInt(end.get(1));

                    TraditionalCourse  course = new TraditionalCourse(courseName,crnNumber,courseNumber,sectionNumber,creditHours,courseType,instructor,startHour,startMinute,endHour ,endMinute ,room,daysMet);

                    courses.add(course);
                }
            }
            
        } catch (IOException ex) {
            Logger.getLogger(Model.class.getName()).log(Level.SEVERE, null, ex);
        }
        //Delete before running
        return courses;
        
      
        
    }
```
