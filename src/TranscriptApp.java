import java.util.Scanner;

public class TranscriptApp {
  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);
    Transcript t = new Transcript();
    System.out.println("Welcome to the transcript application.");
    
    while (true) {
      String code = Validator.getString(s, "\nEnter course:  ");
      int credits = Validator.getInt(s,    "Enter credits: ", 0, 8);
      char  grade = Validator.getString(s, "Enter grade:   ").toUpperCase().charAt(0);
      
      CourseEnrollment ce = new CourseEnrollment(code, credits, grade);
      t.addCourse(ce);
      
      System.out.print("Another course? (y/n): ");
      if (s.nextLine().toUpperCase().charAt(0) == 'N') {
        break;
      }
    }
    
    System.out.println("\n" + t);
    s.close();
  }
}