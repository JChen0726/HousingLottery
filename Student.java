import java.util.ArrayList;

public class Student {

    private int grade, gender;
    private String email;
    private Object[] scores;//should make these so that they don't need to be assigned to variables

    private boolean isChosen, isInternational;
    private ArrayList <String> roomChoices = new ArrayList<>(); //change to rooms

    Student () {isChosen = false;}
        // for new student
        public void setStrings(String email){
            this.email = email;}
        public void setInts(ArrayList<Integer> scoreList){
            this.scores = scoreList.toArray();
        }
        public void setInternational(boolean international){ this.isInternational=international;}
        public void setPaired(){this.isChosen = true;}
        public void setGender(int a){this.gender = a;}
        public boolean getPairedStatus(){return isChosen;}
        public boolean getInternationalStatus(){return isInternational;}

        public int getGrade(){
            return grade;}
        public String getEmail() {return email;}
        public Object[] getScores() {return scores;}

        public boolean getInternational(){return isInternational;}

        //
        public void setRoomChoices(String a, String b, String c, String d){ //change to room.getname
            this.roomChoices.add(a);
            this.roomChoices.add(b);
            this.roomChoices.add(c);
            this.roomChoices.add(d);
        }
        public ArrayList<String> getRoomChoices(){
            return roomChoices;
        }
        public int getGender(){
            return gender;
        }
}