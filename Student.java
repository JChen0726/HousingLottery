import java.util.ArrayList;

public class Student {

    private ArrayList<String> choices;
    private String email;
    private int cleanliness, quietness, stayUp, getUp, guestover, sportsOrArtsy;

    private boolean isChosen, isInternational;


    Student () {
        isChosen = false;

    }
        // for new student
        public void setStrings(String email){
            this.email = email;
        }
        public void setInts(int cleanliness,int quietness, int guestover, int stayUp, int getUp, int sportsOrArtsy){
            this.cleanliness = cleanliness;
            this.quietness = quietness;
            this.guestover = guestover;
            this.stayUp = stayUp;
            this.getUp = getUp;
            this.sportsOrArtsy = sportsOrArtsy;
        }
        public void setInternational(boolean international){ this.isInternational=international;}
        public void setPaired(){isChosen = true;}

        public boolean getPairedStatus(){return isChosen;}

        public void setSportsOrArtsy(int sportsOrArtsy){
            this.sportsOrArtsy = sportsOrArtsy;
        }

        public boolean getInternationalStatus(){
            return isInternational;
        }

        public String getEmail() {return email;}
        public int getClean() {return cleanliness;}
        public int getQuiet() {return quietness;}
        public int getGuest() {return guestover;}
        public int getStayUp() {return stayUp;}
        public int getGetUp(){return getUp;}
        public int getSportsOrArtsy(){return sportsOrArtsy;}
        public boolean getInternational(){return isInternational;}
        public ArrayList<String> getChoices(){
            return choices;
        }

}