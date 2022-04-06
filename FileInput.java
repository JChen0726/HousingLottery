import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Scanner;

public class FileInput {

    Hashtable<String, Student> studentProfile;
    Hashtable<Dorms, ArrayList<Rooms>> direct;
    FileInput(String location1, String location2) {
        studentProfile = new Hashtable<>();
        direct = new Hashtable<>();
        readInStudentProfile(location1);
        readInDormAndRooms(location2);
        //this is the testing one
        System.out.println(studentProfile);
        System.out.println(direct);
    }

    private void readInStudentProfile(String studentProfileLocation) {
        try {
            Scanner sc = new Scanner(new FileInputStream(studentProfileLocation));
            int total = sc.nextInt();
            // adjustable according to the features we need to input.
            for (int i = 0; i < total; i++) {
                String userID = sc.next();
                String firstName, lastName,isStay,currentDorm,password;

                int grade, sex;
                password = sc.next();
                firstName = sc.next();
                lastName = sc.next();
                grade = sc.nextInt();
                sex = sc.nextInt();
                isStay = sc.next();
                currentDorm = sc.next();
                Student student = new Student(password,firstName,lastName,grade,sex,isStay,currentDorm);
                studentProfile.put(userID,student);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("StudentProfile file not found.");
        }
    }

    private void readInDormAndRooms(String dormAndRoomsLocation) {
        try {
            Scanner sc = new Scanner(new FileInputStream(dormAndRoomsLocation));
            int totalDorms = sc.nextInt();
            for (int i = 0; i < totalDorms; i++) {
                String dormName = sc.next();
                int dormRooms = sc.nextInt();
                int dormType = sc.nextInt();
                Dorms dorm = new Dorms(dormName, dormRooms,dormType);
                ArrayList<Rooms> roomList = new ArrayList<>();
                for (int j = 0; j < dormRooms; j++) {
                    String roomName = sc.next();
                    int numPeople = sc.nextInt();
                    roomList.add(new Rooms(roomName, numPeople));
                }
                direct.put(dorm, roomList);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("DormsandRooms file not found.");

        }
    }




}
