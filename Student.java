public class Student {
    private final String password;
    private final String firstName;
    private final String lastName;
    private final int grade;
    private boolean isStaying;
    private final int sex;
    private String preferences;
    String currentDorm;
    // profile that we need to account for... open to any recommendations;

    Student (String password, String firstName, String lastName, int grade, int sex, String isStaying, String currentDorm) {
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.grade = grade;
        this.isStaying = isStaying.equals(("Yes"));
        this.sex = sex;
        this.currentDorm = currentDorm;
    }

    public String toString (){
        return "\n"+"INFO: "+firstName+" "+lastName+" "+ "\n" + "Grade: "+grade+"\n"+" isStaying?: "+isStaying+"\n\n";

    }
    public String getFirstName() {return firstName;}
    public String getLastName() {return lastName;}
    public int getGrade() {return grade;}
    public boolean getIsStaying() {return isStaying;}
    public int getSex() {return sex;}
    public String getPassword(){
        return password;
    }

}
