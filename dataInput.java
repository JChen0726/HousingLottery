import java.time.Year;
import java.util.Scanner;

public class dataInput{

    /**General TO-DOs in no order (feel free to add/remove once finished or needed):
     1. Add in-house db for user info once entered
     2. More work on better encapsulation
    **/

    private String username,pword;
    private boolean loginSuccess = false;
    private BackStageStudent curStudent;
    private BackStageStudent newStudent;

    dataInput(){
        // 1
        //allow users to input username, and replace the name in the string below with theirs
        FileInput fileinput = new FileInput("/Users/brynkerslake/Documents/Github/HousingLottery/StudentProfileInput","/Users/brynkerslake/Documents/Github/HousingLottery/dormAndRooms","/Users/brynkerslake/Documents/Github/HousingLottery/newStudentProfileInput");
        curStudent = new BackStageStudent(fileinput.studentProfile,fileinput.direct);
        newStudent = new BackStageStudent(fileinput.newStudentProfile ,fileinput.direct);
        loginPrompt();
        loginStatus();
    }

    private void loginPrompt(){
        // 2
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter your username and password");
        System.out.println("Username: ");
        username = sc.next();
        System.out.println("Password: ");
        pword = sc.next();
    }

    private int getInputIdentity(){
        // 4
        //needs rebuilding
        Year curyear = Year.now();
        int newStudentYear = curyear.getValue() + 5 - 2000;
        if(username.equals("tcleary@taboracademy.org")){
            return 0; // stands for admin
        }else if(username.indexOf(newStudentYear)!=-1){ //what is this? -bryn
            return 2; // stands for newStudent
        }else{
            return 1;
        }
    }

    private void loginStatus(){
        // 3
        //needs reworking
        switch (getInputIdentity()) {
            case 0:
                if (pword.equals("admin")) {
                    loginSuccess = true;
                    System.out.println("Welcome Admin!");
                }
                else {
                    System.out.println("wrong password or username");
                }
                break;
            case 1:
                checkLoginStatus(curStudent);
                break;

            case 2:
                checkLoginStatus(newStudent);
                break;


        }
    }

    private void checkLoginStatus(BackStageStudent student) {
        // 5
        //needs reworking
        for (String key: student.studentProfile.keySet()) {
            String truePword = student.studentProfile.get(key).getPassword();
            if (username.equals(key)) {
                if (pword.equals(truePword)) {
                    System.out.println("Welcome " + key + "!"); // login success
                    loginSuccess = true;
                } else {
                    System.out.println("wrong password or username, please try again!");
                }
                break;
            }

        }
    }
}
