import java.util.ArrayList;

public class Student {

    private int grade;
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
        public void setRoomChoices(String a, String b, String c, String d){
        this.roomChoices.add(a);
        this.roomChoices.add(b);
        this.roomChoices.add(c);
        this.roomChoices.add(d);}


        public boolean getPairedStatus(){return isChosen;}
        public boolean getInternationalStatus(){return isInternational;}
        public int getGrade(){return grade;}
        public String getEmail() {return email;}
        public Object[] getScores() {return scores;}
        public ArrayList<String> getRoomChoices(){
            return roomChoices;
        }
        public String getGender(){
            return gender;
        }
}