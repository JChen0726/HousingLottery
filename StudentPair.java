import java.util.ArrayList;

public class StudentPair { //need to make extend students
    Student student1;
    Student student2;
    private ArrayList<String> roomChoices;

    public StudentPair(Student s1, Student s2) {

        this.student1 = s1;
        this.student2 = s2;
        this.roomChoices = s1.getRoomChoices();

    }

    public ArrayList<String> getRoomChoices(){
        return roomChoices;
    }

    public String getGender() {return student1.getGender();}

    public String toString() {
        return student1.toString() + " and " + student2.toString();
    }

}
