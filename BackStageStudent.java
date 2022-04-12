import java.sql.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Scanner;

public class BackStageStudent {
    HashMap<String, Student> studentProfile; // student class maybe that would be an object
    HashMap<Dorms, ArrayList<Rooms>> studentDorm;
    HashMap<String, Student> go;

    BackStageStudent(HashMap<String, Student> studentProfile, HashMap<Dorms, ArrayList<Rooms>> dormDirect) {
        this.studentProfile = studentProfile;
        this.studentDorm = dormDirect;
        this.go = new HashMap<>();
    }
}

