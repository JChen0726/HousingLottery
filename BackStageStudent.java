import java.sql.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Scanner;

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

private static class StudentInterface{
    HashMap<String, Student> studentProfile; // student class maybe that would be an object
    HashMap<Dorms, ArrayList<Rooms>> studentDorm;
    HashMap<String, Student> go;

    StudentInterface(HashMap<String, Student> studentProfile, HashMap<Dorms, ArrayList<Rooms>> dormDirect, String key){
        this.studentProfile = studentProfile;
        this.studentDorm = dormDirect;
        this.go = new HashMap<>();
        ArrayList<String> inputs = new ArrayList<>();
        Scanner sc = new Scanner(System.in);

        System.out.println("Welcome to the Student Interface, "+studentProfile.get(key).getFirstName()+"!");
        System.out.println("Are you leaving or staying your current dorm? (type 'stay' or 'leave')");
        inputs.add(sc.nextLine());

        //input function

        if(inputs.get(0).equals("stay")){

        }else if(inputs.get(0).equals("leave")){

        }else{
            System.out.println("Invalid input, please try again.");
        }

        /**

         1. Check if staying/going
         2. Check if you want double/single room
         3. If staying, let them choose room based on their preferences/weight
         4. If going, put them into go lottery pool
         5. If going, tell admin to manually start go lottery

        **/


    }
}
}

