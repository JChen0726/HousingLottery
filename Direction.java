import java.util.ArrayList;

public class Direction {

    StudentPair studentPair;
    Student studentname;
    String roomName;
    Direction(Student studentName, String room)
    {
        this.studentname = studentName;
        this.roomName = room;
    }
    Direction (StudentPair studentPair, String room){
        this.studentPair = studentPair;
        this.roomName = room;
    }

    public String toString(){
        return studentname.getName()+ " assigned to " + roomName;
    }

    
}


