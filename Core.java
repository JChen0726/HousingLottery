import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class Core{
    public  ArrayList<Dorm> DORMS;
    public ArrayList<Student> STUDENTS;
    private ArrayList<RoomSelection> newStudentRoomPair;
    private ArrayList<RoomSelection> oldStudentRoomPair;


    Core(ArrayList<Student> students, ArrayList<Dorm> dorms) {
        this.DORMS = dorms; //inits master list of dorms and students
        this.STUDENTS = students;
        newStudentPairing();
        ReturningStudentPairing();
        writeDormToCSV();
    }

    private void newStudentPairing(){
        NewStudentPairingAlgo np = new NewStudentPairingAlgo(STUDENTS);
    }

    private void ReturningStudentPairing(){
        for(Dorm dorm : DORMS){
            RoomAssigningAlgo oldAlgo = new RoomAssigningAlgo(STUDENTS,dorm.getAllRooms());
        }
    }

    public void writeDormToCSV(){
        File file = new File("dorm.csv");
        try{
            FileWriter writer = new FileWriter(file);
            for (int i = 0; i < DORMS.size(); i++) {
                writer.write(DORMS.get(i).toString());
            }
            writer.close();
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
}
