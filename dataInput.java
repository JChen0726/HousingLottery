import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Random;
public class dataInput{

    private ArrayList<ArrayList> studentData;
    public ArrayList<String> roomsPublicTest = new ArrayList<>();

    public ArrayList<Student> master; //change to private later

    // test data inputs
   dataInput() {

       //code creates test data, NOT FOR PRODUCTION
        for(int i = 1;i<21;i++){
            roomsPublicTest.add(Integer.toString(i));
        }
        master = new ArrayList<>();
        Random rand = new Random();
        for (int q = 0; q < 100; q++) {
            Student s = new Student();
            //s.setEmail(stringmaker() + "@taboracademy.org");
            //s.setRoomPreference(rand.nextInt(1,5), rand.nextInt(1,5), rand.nextInt(1,5));
            //s.setSleepinghabit(rand.nextInt(1,5), rand.nextInt(1,5));
            s.setStrings(make_strings_for_testing() + "@taboracademy.org");
            s.setRoomChoices(String.valueOf(rand.nextInt(20)),String.valueOf(rand.nextInt(20)),String.valueOf(rand.nextInt(20)),String.valueOf(rand.nextInt(20)));
            s.setInts(rand.nextInt(5), rand.nextInt(5), rand.nextInt(5), rand.nextInt(5), rand.nextInt(5),rand.nextInt(5));
            s.setInternational(Math.random() < 0.5);
            master.add(s);
        }

    }
    private ArrayList input_data_from_ollys_excel_program(ArrayList<ArrayList<Object>> olly_master_list){
        for(int i = 0;i<olly_master_list.size();i++){
            Student curstu = new Student();
            ArrayList<Object> temparray = olly_master_list.get(i);
            curstu.setStrings((String) temparray.get(0));
            ArrayList<Integer> tempints = (ArrayList<Integer>) temparray.get(1);
            curstu.setInts(tempints.get(0),tempints.get(1),tempints.get(2),tempints.get(3),tempints.get(4),tempints.get(5));
            // this method is not defined;
        }

        return studentData;
    }


    private static String make_strings_for_testing(){
            byte[] array = new byte[7]; // length is bounded by 7
            new Random().nextBytes(array);
        return new String(array, Charset.forName("UTF-8"));
    }

}