public class StudentPair { //need to make extend students
    Student student1;
    Student student2;
    public StudentPair(Student s1, Student s2) {
        student1 = s1;
        student2 = s2;
    }
    public String toString() {
        return student1.toString() + " and " + student2.toString();
    }
}
