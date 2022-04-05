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

    // this should be the core part of the algorithm that takes in the ... and output
    // now we need to figure out the full import  and output... and then how to approach this with the algorithm
    // compare or contrast the inputs and maybe the most important thing is to have the algorithm that can be used to
    // solve the problem
    // need to answer these three questions for the main direct ... find better ways to store data>
    // But either way it will work because I think I know what I am doing


    public void checkStay(){

    }



}
