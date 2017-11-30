package project1_jda;

import java.time.LocalTime;
public class TraditionalCourse extends Course{
    
    private LocalTime startTime;
    private LocalTime endTime;
    private String room;
    private String daysMet;
    private int startHour;
    private int startMinute;
    private int endMinute;
    private int endHour;
  

    public TraditionalCourse(String courseName, int crnNumber, String courseNumber, String sectionNumber, String creditHours, String courseType, String instructor, int startHour, int startMinute, int endHour,int endMinute, String room,String daysMet) {
        super(courseName, crnNumber, courseNumber, sectionNumber, creditHours, courseType, instructor);
        this.startHour = startHour;
        this.startMinute = startMinute;
        this.endHour = endHour;
        this.endMinute = endMinute;
        this.startTime = LocalTime.of(startHour, startMinute);
        this.endTime = LocalTime.of(endHour, endMinute);
        this.room = room;
        this.daysMet = daysMet;
    }


    public String getRoom() {
        return room;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public String getDaysMet() {
        return daysMet;
    }
    
    

    
    
    
    @Override
    public String toString(){
        return "#"+super.getCrnNumber()+ " " + super.getCourseNumber() + "-00" + super.getSectionNumber() +" (" + super.getCourseName() + ")," + super.getInstructor() + "," + super.getCourseType()+ ", " + this.startHour + ":" + this.startMinute+ "-" + this.endHour+ ":" + this.endMinute+", " + this.getDaysMet()+", " +this.getRoom();
    }
   
    public boolean conflictsWith(Course courseToCompare){
        
        boolean decision = false;
        boolean daysConflict = false;
        
        if(courseToCompare instanceof TraditionalCourse){
            for(int i = 0; i < ((TraditionalCourse) courseToCompare).getDaysMet().length();++i){
                for(int j = 0; j < this.daysMet.length();++j){
                    if(this.daysMet.substring(j, j+1).equalsIgnoreCase(((TraditionalCourse)courseToCompare).getDaysMet().substring(i, i+1))){
                        daysConflict = true;
                    }
                }
            }
        }
        
        else{
            daysConflict = false;
        }
        
        if(daysConflict){
            if(this.startTime.isBefore(((TraditionalCourse)courseToCompare).startTime) && this.endTime.isBefore(((TraditionalCourse)courseToCompare).startTime)){
                decision = false;
            }
            
             else if(this.startTime.isAfter(((TraditionalCourse)courseToCompare).endTime) && this.endTime.isAfter(((TraditionalCourse)courseToCompare).endTime)){
                decision = false;
            }
                
            else if(this.startTime.equals(((TraditionalCourse)courseToCompare).startTime) || this.startTime.equals(((TraditionalCourse)courseToCompare).endTime)){
                decision = true;
            }
            
            
            else if(this.endTime.equals(((TraditionalCourse)courseToCompare).startTime) || this.endTime.equals(((TraditionalCourse)courseToCompare).endTime)){
                decision = true;
            }
            
            
            else if(this.startTime.isAfter(((TraditionalCourse)courseToCompare).startTime) && this.endTime.isBefore(((TraditionalCourse)courseToCompare).endTime)){
                decision = true;
            }
            
            else if(this.startTime.isBefore(((TraditionalCourse)courseToCompare).endTime) && this.endTime.isAfter(((TraditionalCourse)courseToCompare).endTime)){
                decision = true;
            }
            
                
            else{
                decision = true;
            }
                
                
        }
        else{
            decision = false;
        }
            
            
        
        
        
        return decision;
    
    }
    
    

   
    
    
}
