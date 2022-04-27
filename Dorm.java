import java.util.ArrayList;

public class Dorm {

    String name;
    int gender;
    int totalRooms;
    private ArrayList<Room> Rooms = new ArrayList<>();

    public Dorm(String name, int totalRooms, int gender){
        this.name = name;
        this.totalRooms = totalRooms;
        this.gender = gender;
    }

    public int getTotalRooms(){return totalRooms;}

    public String toString (){
        return name;
    }

    public void setRooms(ArrayList<ArrayList<String>> rooms){
        for (int i = 0;i<totalRooms;i++) {
            Room tempRoom = new Room(rooms.get(i).get(0),Integer.parseInt(rooms.get(i).get(1)));
        }
    }

    public Room getRoom(String roomname){
        for (Room room : Rooms) {
            if (room.toString().equals(roomname)) {
                return room;
            }
        }
        return null;
    }
}

class Room {

    private final String name;
    private boolean isSingle;
    private boolean isFull;
    private Student[] Students;

    Room(String name, int numPeople){
        this.name = name;
        if (numPeople == 1){
            isSingle = true;
            Students = new Student[1];
        }else{
            isSingle = false;
            Students = new Student[2];
        }
    }
    public String toString(){return name;}

    public boolean isFull(){return isFull;}

    public boolean isSingle(){return isSingle;}

    // change that later.
    public void assignStudent(Student student){
        if (!isFull&& Students[0]==null) {
            Students[0] = student;
            if (isSingle) {
                isFull = true;
            }
        } else if (!isFull && Students[1]==null) {
            Students[1] = student;
        } else {
            isFull = true;
            System.out.println("Room is full"); // to GUI?
        }
    }

    public void removeStudent(Student student){
        if (Students[0]==student) {
            Students[0] = null;
        } else if(Students[1]==student) {
            Students[1] = null;
        } else {
            System.out.println("Student not found"); // to GUI?
        }
    }

}
