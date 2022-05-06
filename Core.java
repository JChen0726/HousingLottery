import java.util.ArrayList;

public class Core {
    public  ArrayList<Dorm> DORMS;
    public ArrayList<Student> STUDENTS;

    Core(ArrayList<Student> students, ArrayList<Dorm> dorms) {
        this.DORMS = dorms; //inits master list of dorms and students
        this.STUDENTS = students;
        run();
    }

    private void run() {
        //runs the core of the program
        //takes in the master list of students and dorms
        //and runs the algorithm to assign students to dorms
        //and then prints out the results
    }


    private void newStudentPairing(){
        ArrayList<StudentPair> newStudentSP = new ArrayList<>();
        NewStudentPairingAlgo np = new NewStudentPairingAlgo(STUDENTS);

    }

}
