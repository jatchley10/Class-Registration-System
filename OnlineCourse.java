package project1_jda;

public class OnlineCourse extends Course {
    
    public OnlineCourse(String courseName, int crnNumber, String courseNumber, String sectionNumber, String creditHours, String courseType, String instructor){
        super(courseName,crnNumber ,courseNumber,sectionNumber,creditHours,courseType, instructor);
    }
    
    @Override
    public String toString(){
        return "#"+super.getCrnNumber()+ " " + super.getCourseNumber() + "-00" + super.getSectionNumber() +" (" + super.getCourseName() + ")," + super.getInstructor() + "," + super.getCourseType();
    }
    
    

    @Override
    public boolean conflictsWith(Course courseToCompare) {
        return false;
    }


    
}
