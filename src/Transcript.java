import java.util.ArrayList;

public class Transcript {
  
  private ArrayList<CourseEnrollment> courses = new ArrayList<CourseEnrollment>();

  public Transcript() {}

  public void addCourse(CourseEnrollment courseenrollment) {
    courses.add(courseenrollment);
  }

  public ArrayList<CourseEnrollment> getCourses() {
    return courses;
  }

  public double getOverallGPA() {
    double gpa = 0.0;
    for (CourseEnrollment c : courses) {
      gpa += c.gradeToGPA();
    }
    return gpa / courses.size();
  }

  public String getFormattedGPA() {
    return Double.toString(getOverallGPA());
  }
  
  @Override
  public String toString() {
    String header = "Course         Credits     Grade     Quality Points\n";
    String line =   "------         -------     -----     --------------\n";
    String entries = "";
    String avgGPA = String.format("\n%-37sGPA:  %s", "", getFormattedGPA());
    for (CourseEnrollment c : courses) {
      entries += c.toString();
    }
    return header + line + entries + avgGPA;
  }

}