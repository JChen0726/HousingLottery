public class Student {
    String firstName;
    String lastName;
    int grade;
    boolean isStaying;
    int sex;
    // profile that we need to account for... open to any recommendations;

    Student (String firstName, String lastName, int grade, int sex, String isStaying) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.grade = grade;
        if(isStaying.equals(("Yes"))){
            this.isStaying = true;
        }else{
            this.isStaying = false;
        }
        this.sex = sex;
    }


    public String toString (){
        return "Profile: "+firstName+" "+lastName+" "+ grade;
    }
    public String getFirstName() {return firstName;}
    public String getLastName() {
        return lastName;
    }
    public int getGrade() {return grade;}

}
