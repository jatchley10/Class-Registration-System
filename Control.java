/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project1_jda;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author JSU
 */
public class Control {
    
    public static void main(String[] args) {
        Model m = new Model();
        View v = new View();
        ArrayList<Course> courses;
        ArrayList<Course> schedule;
        schedule = new ArrayList<Course>();
        int menu = 0;
        courses = m.readCourseData("project1input.csv");
        
        
        while(menu != 4){
            menu = v.mainMenu();
            Scanner in = new Scanner(System.in);
            switch(menu){
                
                case 1:
                    
                    int timesFound = 0;
                    String userInput;
                    System.out.print("Enter course number in the format SSNNN (for example, CS201): ");
                    userInput = in.next();
                    for(Course e: courses){
                        if(userInput.equals(e.getCourseNumber())){
                            System.out.println(e.toString());
                            timesFound += 1;
                        }
                    }
                    
                    
                    if(timesFound == 0){
                            System.out.println("Course was not Found");
                    }
                    
                    System.out.println("\n");
                    break;
                case 2:
                    boolean conflicts;
                    conflicts = false;
                    Course wantedCourse = null;
                    System.out.println("Enter the CRN Number");
                    int crnNum;
                    crnNum = in.nextInt();
                    for(Course c: courses){
                        if(crnNum == c.getCrnNumber()){
                            wantedCourse = c;
                        }    
                    }
                    
                    if(wantedCourse == null){
                        System.out.println("ERROR: Either the course was not found, or it conflicts with your current schedule!");
                        break;
                    }
                    
                    
                    
                    for(int i = 0; i< schedule.size(); ++i){
                        if(wantedCourse.conflictsWith(schedule.get(i))){
                            conflicts = true;
                            System.out.println("ERROR: Either the course was not found, or it conflicts with your current schedule!");
                                
                        }
                        
                    }
                    
                    if(!conflicts){
                        schedule.add(wantedCourse);
                        System.out.println("Course added successfully");
                    }
                    
                    
                    break;
                case 3:
                    System.out.println("\n");
                    for(Course d: schedule){
                        System.out.println(d.toString());
                    }
                    System.out.println("\n");
                    break;
                case 4:
                    System.out.println("Thanks for using the Student Registration System!");
                    break;
                default:
                    System.out.println("Invalid input");
                    break;
            }
            
        }
    }
    
}
