import java.util.ArrayList;
import java.util.Collections;

public class Student {

    private int grade;
    private Dorm curDorm;
    private Room curRoom;
    private String gender;
    private String email;
    private Object[] scores; //should make these so that they don't need to be assigned to variables
    private boolean isChosen, isInternational;
    private final ArrayList <String> roomChoices = new ArrayList<>(); //change to rooms

    Student () {isChosen = false;}
        // for new student

        public void setEmail(String email){this.email = email;}
        public void setScores(ArrayList<Integer> scoreList){
            this.scores = scoreList.toArray();
        }
        public void setInternational(boolean international){ this.isInternational=international;}
        public void setPaired(){this.isChosen = true;}
        public void setGrade(int grade){this.grade = grade;}
        public void setGender(String a){this.gender = a;} // add to the algo;
        public void setRoom(Room a){curRoom = a;}
        public void setDorm(Dorm a){curDorm = a;}
        public void setRoomChoices(String a, String b, String c, String d, String e, String f){
        Collections.addAll(roomChoices, a, b, c, d, e, f);}

        public boolean getPairedStatus(){return isChosen;}
        public boolean getInternationalStatus(){return isInternational;}
        public int getGrade(){return grade;}
        public String toString() {return email;}
        public Object[] getScores() {return scores;}
        public ArrayList<String> getRoomChoices(){
            return roomChoices;
        }
        public String getGender(){return gender;}
        public Dorm getCurDorm(){return curDorm;}
        public Room getCurRoom(){return curRoom;}

}