import java.lang.reflect.Array;
import java.util.ArrayList;

public class Core {
    public  ArrayList<Dorm> DORMS;
    public ArrayList<Student> STUDENTS;
    private ArrayList<RoomSelection> newStudentRoomPair;
    private ArrayList<RoomSelection> oldStudentRoomPair;

    Core(ArrayList<Student> students, ArrayList<Dorm> dorms) {
        this.DORMS = dorms; //inits master list of dorms and students
        this.STUDENTS = students;
        newStudentPairing();
        ReturningStudentPairing();
    }

    private void newStudentPairing(){
        NewStudentPairingAlgo np = new NewStudentPairingAlgo(STUDENTS);
        this.newStudentRoomPair = np.randomAssignToRooms(DORMS);
        System.out.println(newStudentRoomPair);
    }

    private void ReturningStudentPairing() {

        for (Dorm dorm : DORMS) {
            RoomAssigningAlgo oldAlgo = new RoomAssigningAlgo(STUDENTS, dorm.getAllRooms());
        }

    }
}
