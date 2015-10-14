import org.junit.*;
import static org.junit.Assert.*;

public class TranscriptTest {

  @Test
  public void test_CourseEnrollment_getCode() {
    CourseEnrollment ce = new CourseEnrollment("BSCI462", 3, 'B');
    assertTrue(ce.getCode().equals("BSCI462"));
  }
  
  @Test
  public void test_CourseEnrollment_setCode() {
    CourseEnrollment ce = new CourseEnrollment("BSCI462", 3, 'B');
    ce.setCode("CMSC216");
    assertTrue(ce.getCode().equals("CMSC216"));
  }
  
  @Test
  public void test_CourseEnrollment_getCredits() {
    CourseEnrollment ce = new CourseEnrollment("BSCI462", 3, 'B');
    assertTrue(ce.getCredits() == 3);
  }
  
  @Test
  public void test_CourseEnrollment_setCredits() {
    CourseEnrollment ce = new CourseEnrollment("BSCI462", 3, 'B');
    ce.setCredits(4);
    assertTrue(ce.getCredits() == 4);
  }
  
  @Test
  public void test_CourseEnrollment_getGrade() {
    CourseEnrollment ce = new CourseEnrollment("BSCI462", 3, 'B');
    assertTrue(ce.getGrade() == 'B');
  }
  
  @Test
  public void test_CourseEnrollment_setGrade() {
    CourseEnrollment ce = new CourseEnrollment("BSCI462", 3, 'B');
    ce.setGrade('C');
    assertTrue(ce.getGrade() == 'C');
  }  
  
  @Test
  public void test_CourseEnrollment_gettersAndSetters() {
    CourseEnrollment ce = new CourseEnrollment("BSCI462", 3, 'B');
    assertTrue(ce.getCode().equals("BSCI462"));
    assertTrue(ce.getCredits() == 3);
    assertTrue(ce.getGrade() == 'B');
    
    ce.setCode("CMSC216");
    ce.setCredits(4);
    ce.setGrade('C');
    
    assertTrue(ce.getCode().equals("CMSC216"));
    assertTrue(ce.getCredits() == 4);
    assertTrue(ce.getGrade() == 'C');
  }
  
  @Test
  public void test_CourseEnrollment_gradeToGPA() {
    CourseEnrollment ce = new CourseEnrollment("BSCI462", 3, 'B');
    assertTrue(ce.gradeToGPA() == 3);
  }
  
  @Test
  public void test_CourseEnrollment_gradeToGPA_boundary() {
    CourseEnrollment ce = new CourseEnrollment("BSCI462", 3, 'X');
    assertTrue(ce.gradeToGPA() == 0);
  }
  
  @Test
  public void test_CourseEnrollment_toString() {
    CourseEnrollment ce = new CourseEnrollment("BSCI462", 3, 'B');
    System.out.println(ce);
    assertTrue(ce.toString().equals("BSCI462        3           B         3.0\n"));
  }
  
  @Test
  public void test_Transcript_addCourse() {
    CourseEnrollment ce = new CourseEnrollment("BSCI462", 3, 'B');
    Transcript t = new Transcript();
    t.addCourse(ce);
    assertTrue(t.getCourses().get(0).getCode().equals("BSCI462"));
    assertTrue(t.getCourses().get(0).getCredits() == 3);
    assertTrue(t.getCourses().get(0).getGrade() == 'B');
  }
  
  @Test
  public void test_Transcript_getCourses() {
    CourseEnrollment ce1 = new CourseEnrollment("BSCI462", 3, 'B');
    CourseEnrollment ce2 = new CourseEnrollment("CMSC216", 3, 'A');
    Transcript t = new Transcript();
    t.addCourse(ce1);
    t.addCourse(ce2);
    assertTrue(t.getCourses().get(0).getCode().equals("BSCI462"));
    assertTrue(t.getCourses().get(1).getCode().equals("CMSC216"));
  }
  
  @Test
  public void test_Transcript_getOverallGPA1() {
    CourseEnrollment ce1 = new CourseEnrollment("BSCI462", 3, 'B');
    CourseEnrollment ce2 = new CourseEnrollment("CMSC216", 3, 'A');
    Transcript t = new Transcript();
    t.addCourse(ce1);
    t.addCourse(ce2);
    assertTrue(t.getOverallGPA() == 3.5);
  }
  
  @Test
  public void test_Transcript_getOverallGPA2() {
    CourseEnrollment ce1 = new CourseEnrollment("BSCI462", 3, 'B');
    CourseEnrollment ce2 = new CourseEnrollment("CMSC216", 3, 'F');
    CourseEnrollment ce3 = new CourseEnrollment("ENGL101", 3, 'Z');
    Transcript t = new Transcript();
    t.addCourse(ce1);
    t.addCourse(ce2);
    t.addCourse(ce3);
    System.out.println("test_Transcript_getOverallGPA2: " + t.getOverallGPA());
    assertTrue(t.getOverallGPA() == 1.0);
  }
  @Test
  public void testaddItemLength() {
  System.out.println("Test if adding to Transcript is correct.") ;
  Transcript t = new Transcript();
  CourseEnrollment course = new CourseEnrollment();
  course.setCode("Java");
  t.addCourse(course);;
  assertTrue(t.getCourses().size() == 1) ;}

  @Test
  public void testaddItemCourseCode()
  {
  System.out.println("Test if adding to Transcript is correct");
  Transcript t = new Transcript();
  CourseEnrollment course = new CourseEnrollment();
  course.setCode("Java");
  t.addCourse(course);
  assertTrue(t.getCourses().get(0).getCode().equals("Java"));}  
  @Test
  public void test_Transcript_toString() {
    CourseEnrollment ce1 = new CourseEnrollment("BSCI462", 3, 'B');
    CourseEnrollment ce2 = new CourseEnrollment("CMSC216", 3, 'F');
    CourseEnrollment ce3 = new CourseEnrollment("ENGL101", 3, 'Z');
    Transcript t = new Transcript();
    t.addCourse(ce1);
    t.addCourse(ce2);
    t.addCourse(ce3);
    System.out.println(t);
    assertTrue(t.toString().equals("Course         Credits     Grade     Quality Points\n"
      + "------         -------     -----     --------------\n"
      + "BSCI462        3           B         3.0\n"
      + "CMSC216        3           F         0.0\n"
      + "ENGL101        3           Z         0.0\n\n"
      + "                                     GPA:  1.0"
    ));
  }
}