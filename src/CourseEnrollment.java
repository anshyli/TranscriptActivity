public class CourseEnrollment {
  
  private String code = "";
  private int credits = 0;
  private char grade = 'N';
  
  public CourseEnrollment(String code, int credits, char grade) {
    this.code = code;
    this.credits = credits;
    this.grade = grade;
  }

  public CourseEnrollment() {
	// TODO Auto-generated constructor stub
}

public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public int getCredits() {
    return credits;
  }

  public void setCredits(int credits) {
    this.credits = credits;
  }

  public char getGrade() {
    return grade;
  }

  public void setGrade(char grade) {
    this.grade = grade;
  }
  
  public double gradeToGPA() {
	  double theGrade = 0.0;
	  switch (grade) {
	  case 'A' :  theGrade = 4.0;
	  				break;
	  case 'B' :   theGrade = 3.0;
	  				break;
	  case 'C' :  theGrade = 2.0;
	  				break;
	  case 'D' :  theGrade = 1.0;;
	  }
	  return theGrade;
  }  
  
  @Override
  public String toString() {
    return String.format("%-15s%-12s%-10s%s\n", 
        code, credits, grade, gradeToGPA());
  }
  
}