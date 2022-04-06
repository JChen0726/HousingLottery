import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;

public class BackStageStudent {
    HashMap<String, Student> studentProfile; // student class maybe that would be an object
    HashMap<Dorms, ArrayList<Rooms>> studentDorm;
    HashMap<String, Student> go;

    BackStageStudent(HashMap<String, Student> studentProfile, HashMap<Dorms, ArrayList<Rooms>> dormDirect){
        this.studentProfile = studentProfile;
        this.studentDorm = dormDirect;
        this.go = new HashMap<>();
    }
    public void checkStay(){
        for(String key : studentProfile.keySet()){
            if(!studentProfile.get(key).getIsStaying()){
                go.put(key, studentProfile.get(key));
            }
            else{
                //assign to current dorm; and then assign to the room.
            }
        }
    }



}
