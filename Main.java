public class Main {

    private String username, pword;
    BackStageCurrentStudent bsCurStudent;
    Main(){
        FileInput fileinput = new FileInput("/Users/justinchen/Documents/GitHub/HousingLottery/StudentProfileInput","/Users/justinchen/Documents/GitHub/HousingLottery/dormAndRooms");
        bsCurStudent = new BackStageCurrentStudent(fileinput.studentProfile,fileinput.direct);
        getInputIdentity();
    }

    private void getInputIdentity(){
        userLogin login = new userLogin();
        username = login.username;
        pword = login.password;

        for (String key: bsCurStudent.studentProfile.keySet()){
            String truePword = bsCurStudent.studentProfile.get(key).getPassword();
            if(username.equals(key)){
                if(pword.equals(truePword)){
                    System.out.println("Welcome " + key + "!"); // login success
                }else System.out.println("wrong password or username");
            }
        }

    }
    public static void main(String[] args) {
        new Main();

    }
}
