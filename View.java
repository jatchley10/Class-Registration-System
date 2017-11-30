package project1_jda;

import java.util.Scanner;
public class View {
    
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
   
}
