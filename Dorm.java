import java.util.ArrayList;

public class Dorm {
    private final String name;
    private final String gender;
    int totalRooms;
    private final ArrayList<Room> Rooms = new ArrayList<>();

    public Dorm(String name, int totalRooms, String gender) {

        this.name = name;
        this.totalRooms = totalRooms;
        this.gender = gender;

    }

    public String getGender() {
        return gender;
    }


    public String toString() {
        return name;
    }


    public void setRooms(ArrayList<ArrayList<String>> roomlists) {
        System.out.println(roomlists);
        for (int i = 0; i < totalRooms; i++) {
            //lambda that returns 2 if a string is "Double" and 1 if its "Single"
            Room tempRoom = new Room(roomlists.get(i).get(0), doubleOrSingle(roomlists.get(i).get(2)));
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
        int v;
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
    private final boolean isSingle;
    private boolean isFull = false;
    private ArrayList<Object> Residents = new ArrayList<>();
    private boolean isAvailable = true; // for administrator to choose if room is available for use or not

    Room(String name, int numPeople){

        this.name = name;
        isSingle = numPeople == 1;

    }


    public String toString(){return name;}


    public boolean isOccupied(){return isFull;}


    public boolean isSingle(){return isSingle;}


    // change that later.
    public void assignStudents(Object v){
        isFull = true;
        Residents.add(v);
    }



    public ArrayList<Object> getResidents(){
        return Residents;
    }


    public void removeStudents(Student student){
        if (Residents.contains(student)) {
            Residents.remove(student);
        } else {
            System.out.println("Student not found"); // to GUI?
        }
    }


    public void removeStudents(StudentPair s1){
        if (Residents.contains(s1)){
            Residents.remove(s1);
        } else {
            System.out.println("Students not found"); // to GUI?
        }
    }

}
