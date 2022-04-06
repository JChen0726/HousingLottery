import java.time.Year;
import java.util.Scanner;

public class userLogin{
    String username,pword;
    private boolean loginSuccess = false;

    BackStageStudent curStudent;
    BackStageStudent newStudent;
    userLogin(){
        FileInput fileinput = new FileInput("/Users/justinchen/Documents/GitHub/HousingLottery/StudentProfileInput","/Users/justinchen/Documents/GitHub/HousingLottery/dormAndRooms","/Users/justinchen/Documents/GitHub/HousingLottery/newStudentProfileInput");
        curStudent = new BackStageStudent(fileinput.studentProfile,fileinput.direct);
        newStudent = new BackStageStudent(fileinput.newStudentProfile ,fileinput.direct);
        prompt();
        loginStatus();
    }

    private void prompt(){

        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter your username and password");
        System.out.println("Username: ");
        username = sc.next();
        System.out.println("Password: ");
        pword = sc.next();
    }



    private int getInputIdentity(){
        Year curyear = Year.now();
        int newStudentYear = curyear.getValue() + 5 - 2000;
        if(username.equals("tcleary@taboracademy.org")){
            return 0; // stands for admin
        }else if(username.indexOf(newStudentYear)!=-1){
            return 2; // stands for newStudent
        }else{
            return 1;
        }
    }

    private void loginStatus(){
        switch (getInputIdentity()){
            case 0:
                if (pword.equals("admin")) loginSuccess = true;
                else {
                    System.out.println("wrong password or username");
                }
            case 1:
                checkstatus(curStudent);
            case 2:
                checkstatus(newStudent);

        }
    }

    private void checkstatus(BackStageStudent student) {
        for (String key: student.studentProfile.keySet()) {
            String truePword = student.studentProfile.get(key).getPassword();
            if (username.equals(key)) {
                if (pword.equals(truePword)) {
                    System.out.println("Welcome " + key + "!"); // login success
                    loginSuccess = true;
                } else {
                    System.out.println("wrong password or username, please try again!");
                    // login fail
                }
            }else System.out.println("Login Failed");

        }
    }



}
