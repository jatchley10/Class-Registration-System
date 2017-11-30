/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project1_jda;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Model {
    private ArrayList<Course> courses;
    private ArrayList<Course> schedule;
    
    
    public Model(){
        courses = readCourseData("project1input.csv");
    }
    
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
                    OnlineCourse course = new OnlineCourse(courseName,crnNumber,courseNumber,sectionNumber,creditHours,courseType,instructor);
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
    
    public String findCourse(String courseNumber){
        
        String courseFound = "Course Not Found";
        for(int i = 0; i < courses.size();++i){
            courses.get(i).getCourseNumber().equals(courseNumber);
            courseFound = courses.get(i).toString();
        
    }
        return courseFound;
       
    }
    
    public Course registerForCourse(int crnNnumber){
        Course wantedCourse = null;
        
        
        return wantedCourse;
    }
        
        
        
    
}
