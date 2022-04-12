import java.util.Hashtable;

public class Core {

    // for new student
    String firstname, lastname;
    private int cleaniness, quietness, stayUp, getUp, guestover;
    private boolean oppositeOrNo;

    Core(String firstname, String lastname){
        this.firstname = firstname;
        this.lastname = lastname;
    }

    public void setRoomPreference(int cleaniness,int quietness, int guestover){
        this.cleaniness = cleaniness;
        this.quietness = quietness;
        this.guestover = guestover;

    }
    public void setSleepinghabit(int stayUp,int getUp){
        this.stayUp = stayUp;
        this.getUp = getUp;
    }

    public double calculateScore(){
        double score = 0;





    }




}
