public class Student {
    String firstName;
    String lastName;
    int grade;
    // profile that we need to account for... open to any recommendations;

    Student (String firstName, String lastName, int grade) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.grade = grade;
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
