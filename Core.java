import java.util.ArrayList;

public class Core {

    private static ArrayList<Dorm> DORMS;
    public static ArrayList<Student> STUDENTS;
    private static final ArrayList<Student> NEWSTUDENT = new ArrayList<>();
    private static final ArrayList<Object> OLDSTUDENT = new ArrayList<>();

    Core() {

    }
    public void setData(ArrayList<Student> students, ArrayList<Dorm> dorms){
        DORMS = dorms; //inits master list of dorms and students
        STUDENTS = students;
        for (Student student : STUDENTS) {
            if (student.getGrade()==9) {
                NEWSTUDENT.add(student);
            } else {
                OLDSTUDENT.add(student);
            }
        }
        pairNewStudents();
        for(Dorm dorm : DORMS) {
            for( Room room : dorm.getAllRooms()) {
                //System.out.println(room.isOccupied());
            }
        }
        GUI v = new GUI();
        returningStudentHousing();
    }


    private void pairNewStudents(){
        NewStudentPairingAlgo np = new NewStudentPairingAlgo(NEWSTUDENT);
        np.randomAssignToRooms(DORMS);
    }


    private void returningStudentHousing() {
        for (Dorm dorm : DORMS) {
            RoomAssigningAlgo algo = new RoomAssigningAlgo(OLDSTUDENT, dorm.getAllRooms());
        }
    }

    public ArrayList<Student> getSTUDENTS(){return STUDENTS;}
    public ArrayList<Dorm> getDORMS(){return DORMS;}
}
