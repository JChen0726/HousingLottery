import java.util.ArrayList;

public class StudentPair { //need to make extend students
    private Dorm curDorm;
    private Room curRoom;
    private final Student student1;
    private final Student student2;
    private final ArrayList<String> roomChoices;

    public StudentPair(Student inputstudent1, Student inputstudent2) {

        this.student1 = inputstudent1;
        this.student2 = inputstudent2;
        this.roomChoices = student1.getRoomChoices();

    }
    public int getGrade(){return student1.getGrade();}
    public String getNames(){
        return student1.toString() + " and " + student2.toString();
    }
    public void setRoom(Room a){curRoom = a; student1.setRoom(a); student2.setRoom(a);}
    public void setDorm(Dorm a){curDorm = a; student1.setDorm(a); student2.setDorm(a);}
    public ArrayList<String> getRoomChoices(){
        return roomChoices;
    }
    public Dorm getCurDorm(){return curDorm;}
    public Room getCurRoom(){return curRoom;}
    public String getGender() {return student1.getGender();}
    public String toString() {
        return student1.toString() + " and " + student2.toString();
    }

}
