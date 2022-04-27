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

    }

}
