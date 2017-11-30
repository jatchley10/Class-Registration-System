
package project1_jda;


public abstract class Course {
    
    private String courseName;
    private int crnNumber;
    private String courseNumber;
    private String sectionNumber;
    private String creditHours;
    private String courseType;
    private String instructor;
    
    public Course(String courseName, int crnNumber, String courseNumber, String sectionNumber, String creditHours, String courseType, String instructor){
        this.courseName = courseName;
        this.crnNumber = crnNumber;
        this.courseNumber = courseNumber;
        this.sectionNumber = sectionNumber;
        this.creditHours = creditHours;
        this.courseType = courseType;
        this.instructor = instructor;
    }
    
    public abstract String toString();
    public abstract boolean conflictsWith(Course courseToCompare);
    
    public String getCourseName() {
        return courseName;
    }

    public int getCrnNumber() {
        return crnNumber;
    }

    public String getCourseNumber() {
        return courseNumber;
    }

    public String getSectionNumber() {
        return sectionNumber;
    }

    public String getCreditHours() {
        return creditHours;
    }

    public String getCourseType() {
        return courseType;
    }

    public String getInstructor() {
        return instructor;
    }
    
}
