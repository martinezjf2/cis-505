
/**
 * Student.java
 * Holds the values from the GradeBook entry form.
 * Sprint 1: Class structure only — used in Sprint 2 for CSV persistence.
 */
public class Student {

    // Private fields
    private String firstName;
    private String lastName;
    private String course;
    private String grade;

    // ── Default Constructor ────────────────────────────────────────────────
    public Student() {
        this.firstName = "";
        this.lastName  = "";
        this.course    = "";
        this.grade     = "";
    }

    // ── Parameterized Constructor ──────────────────────────────────────────
    public Student(String firstName, String lastName, String course, String grade) {
        this.firstName = firstName;
        this.lastName  = lastName;
        this.course    = course;
        this.grade     = grade;
    }

    // ── Getters ────────────────────────────────────────────────────────────
    public String getFirstName() { return firstName; }
    public String getLastName()  { return lastName;  }
    public String getCourse()    { return course;    }
    public String getGrade()     { return grade;     }

    // ── Setters ────────────────────────────────────────────────────────────
    public void setFirstName(String firstName) { this.firstName = firstName; }
    public void setLastName(String lastName)   { this.lastName  = lastName;  }
    public void setCourse(String course)       { this.course    = course;    }
    public void setGrade(String grade)         { this.grade     = grade;     }

    // ── toString Override ──────────────────────────────────────────────────
    @Override
    public String toString() {
        return "Student{" +
               "firstName='"  + firstName + '\'' +
               ", lastName='" + lastName  + '\'' +
               ", course='"   + course    + '\'' +
               ", grade='"    + grade     + '\'' +
               '}';
    }
}
