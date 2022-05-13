import java.util.ArrayList;

public class Dorm {
    private String name;
    private String gender;
    int totalRooms;
    private final ArrayList<Room> Rooms = new ArrayList<>();

    public Dorm(String name, int totalRooms, String gender) {
        this.name = name;
        this.totalRooms = totalRooms;
        this.gender = gender;
    }

    public String toString() {
        return name;
    }

    public void setRooms(ArrayList<ArrayList> rooms) {
        for (int i = 0; i < totalRooms; i++) {
            //lambda that returns 2 if a string is "Double" and 1 if its "Single"
            String v = rooms.get(i).get(0).toString();
            if (v.equals("Double")) {

            }
            Room tempRoom = new Room(rooms.get(i).get(0).toString(), doubleOrSingle(rooms.get(i).get(0).toString()));
            Rooms.add(tempRoom);
        }
    }

    public Room getRoom(String roomname) {
        for (Room room : Rooms) {
            if (room.toString().equals(roomname)) {
                return room;
            }
        }
        return null;
    }

    public ArrayList<Room> getAllRooms() {
        return Rooms;
    }

    private int doubleOrSingle(String q) {
        int v = 0;
        if (q.equals("Double")) {
            v = 2;
        } else {
            v = 1;
        }
        return v;
    }

}

class Room {

    private final String name;
    private boolean isSingle;
    private boolean isFull;
    private Student[] Students;
    public boolean isAvailable = true;

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
    public void assignStudent(){
        isFull = true;
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
