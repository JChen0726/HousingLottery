import java.util.ArrayList;

public class Core {

    public  ArrayList<Dorm> DORMS;
    public ArrayList<Student> STUDENTS;
    private final ArrayList<Student> NEWSTUDENT = new ArrayList<>();
    private final ArrayList<Object> OLDSTUDENT = new ArrayList<>();

    Core(ArrayList<Student> students, ArrayList<Dorm> dorms) {
        this.DORMS = dorms; //inits master list of dorms and students
        this.STUDENTS = students;
        for (Student student : STUDENTS) {
            if (student.getGrade()==9) {
                NEWSTUDENT.add(student);
            } else {
                OLDSTUDENT.add(student);
            }
        }
        newStudentPairing();
        for(Dorm dorm : DORMS) {
            for( Room room : dorm.getAllRooms()) {
                System.out.println(room.isOccupied());
            }
        }
        ReturningStudentPairing();
    }


    private void newStudentPairing(){
        NewStudentPairingAlgo np = new NewStudentPairingAlgo(NEWSTUDENT);
        np.randomAssignToRooms(DORMS);
    }

    private void ReturningStudentPairing() {
        // go --> go lottery; stay->stay lottery
        for(Dorm dorms: DORMS){
            RoomAssigningAlgo rsp = new RoomAssigningAlgo(OLDSTUDENT, dorms.getAllRooms());
            rsp.runCalculation();
        }
    }
}
