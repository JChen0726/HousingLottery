public class Student {
    /*private final String password;
    private final String firstName;
    private final String lastName;
    private final int grade;
    private boolean isStaying;
    private final int sex;
    private String preferences;
    String currentDorm;*/
    // profile that we need to account for... open to any recommendations

    Student () {
        /*
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.grade = grade;
        this.isStaying = isStaying.equals(("Yes"));
        this.sex = sex;
        this.currentDorm = currentDorm;*/
    }

    /*public String toString (){
        return "\n"+"INFO: "+firstName+" "+lastName+" "+ "\n" + "Grade: "+grade+"\n"+" isStaying?: "+isStaying+"\n\n";

    }
    public String getFirstName() {return firstName;}
    public String getLastName() {return lastName;}
    public int getGrade() {return grade;}
    public boolean getIsStaying() {return isStaying;}
    public int getSex() {return sex;}
    public String getPassword(){return password;}*/

        // for new student
        private String email;
        private int cleanliness, quietness, stayUp, getUp, guestover, sportsOrArtsy; // on a scale of 1-10;

        public void setEmail(String email){
            this.email = email;
        }
        public void setRoomPreference(int cleanliness,int quietness, int guestover){
            this.cleanliness = cleanliness;
            this.quietness = quietness;
            this.guestover = guestover;
        }
        public void setSleepinghabit(int stayUp,int getUp){
            this.stayUp = stayUp;
            this.getUp = getUp;
        }
        public void setSportsOrArtsy(int sportsOrArtsy){
            this.sportsOrArtsy = sportsOrArtsy;
        }
        public String getEmail() {return email;}
        public int getClean() {return cleanliness;}
        public int getQuiet() {return quietness;}
        public int getGuest() {return guestover;}
        public int getStay() {return stayUp;}
        public int getGetUp(){return getUp;}
        public int getSportsOrArtsy(){return sportsOrArtsy;}
        public int getStayUp(){return stayUp;}

}
