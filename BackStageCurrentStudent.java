import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;

public class BackStageCurrentStudent {
    Hashtable<String, Student> studentProfile; // student class maybe that would be an object
    Hashtable<Dorms, ArrayList<Rooms>> studentDorm;
    HashMap<String, Student> Go;

    BackStageCurrentStudent(Hashtable<String, Student> studentProfile, Hashtable<Dorms, ArrayList<Rooms>> dormDirect){
        this.studentProfile = studentProfile;
        this.studentDorm = dormDirect;
        this.Go = new HashMap<>();
    }

    public void checkStay(){
        for(String key : studentProfile.keySet()){
            if(studentProfile.get(key).getIsStaying()){
                Go.put(key, studentProfile.get(key));
            }
            else{
                //assign to current dorm; and then assign to the room.
            }
        }



    }



}
