import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Random;
public class dataInput{

    private ArrayList<ArrayList> studentData;

    public ArrayList<Student> master; //change to private later

    // test data inputs
   dataInput() {

       //code creates test data, NOT FOR PRODUCTION
        master = new ArrayList();
        Random rand = new Random();
        for (int q = 0; q < 100; q++) {
            Student s = new Student();
            //s.setEmail(stringmaker() + "@taboracademy.org");
            //s.setRoomPreference(rand.nextInt(1,5), rand.nextInt(1,5), rand.nextInt(1,5));
            //s.setSleepinghabit(rand.nextInt(1,5), rand.nextInt(1,5));
            s.setStrings(make_strings_for_testing() + "@taboracademy.org");
            s.setInts(rand.nextInt(5), rand.nextInt(5), rand.nextInt(5), rand.nextInt(5), rand.nextInt(5),rand.nextInt(5));
            s.setInternational(Math.random() < 0.5);
            master.add(s);
        }

    }
    private ArrayList input_data_from_ollys_excel_program(ArrayList<ArrayList<String>> olly_master_list){
        for(int i = 0;i<olly_master_list.size();i++){
            Student curstu = new Student();
            ArrayList<String> temparray = olly_master_list.get(i);
            curstu.setStrings(temparray.get(0));
            curstu.setInts(temparray.get((1),temparray.get((2),temparray.get((3),temparray.get((4),temparray.get((5))
        }

        return studentData;
    }


    private static String make_strings_for_testing(){
            byte[] array = new byte[7]; // length is bounded by 7
            new Random().nextBytes(array);
        return new String(array, Charset.forName("UTF-8"));
    }

}