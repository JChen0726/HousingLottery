import java.util.ArrayList;

public class Core {
    public  ArrayList<Dorm> DORMS;
    public ArrayList<Student> STUDENTS;

    Core(ArrayList<Student> students, ArrayList<Dorm> dorms) {
        this.DORMS = dorms; //inits master list of dorms and students
        this.STUDENTS = students;
        newStudentPairing();
        ReturningStudentPairing();
    }

    private void newStudentPairing(){
        ArrayList<StudentPair> newStudentSP = new ArrayList<>();
        NewStudentPairingAlgo np = new NewStudentPairingAlgo(STUDENTS);

    }

    private void ReturningStudentPairing(){
        for(Dorm s : DORMS){
            RoomAssigningAlgo oldAlgo = new RoomAssigningAlgo(STUDENTS,s.getAllRooms());
        }
    }
}
