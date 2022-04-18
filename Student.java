
public class Student {
    /*
    private final String password;
    private final String firstName;
    private final String lastName;
    private final int grade;
    private boolean isStaying;
    private final int sex;
    private String preferences;
    String currentDorm;
    // profile that we need to account for... open to any recommendations

*/

    private String email;
    private int cleanliness, quietness, stayUp, getUp, guestover, sportsOrArtsy;
<<<<<<< HEAD
    private boolean isChosen, isInternational;
=======
    private boolean isChosen, international;

>>>>>>> 40b0c79d2f5f0a7f9b5ebc2639506c0b3e985754
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
        public void setInternational(boolean international){ this.international=international;}
        public void setPaired(){isChosen = true;}

        public boolean getPairedStatus(){return isChosen;}
<<<<<<< HEAD
        public void setSportsOrArtsy(int sportsOrArtsy){
            this.sportsOrArtsy = sportsOrArtsy;
        }

        public boolean getInternationalStatus(){
            return isInternational;
        }


=======
>>>>>>> 40b0c79d2f5f0a7f9b5ebc2639506c0b3e985754
        public String getEmail() {return email;}
        public int getClean() {return cleanliness;}
        public int getQuiet() {return quietness;}
        public int getGuest() {return guestover;}
        public int getStayUp() {return stayUp;}
        public int getGetUp(){return getUp;}
        public int getSportsOrArtsy(){return sportsOrArtsy;}
        public boolean getInternational(){return international;}
}