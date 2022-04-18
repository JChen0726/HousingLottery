import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Random;
public class dataInput{

    ArrayList<Student> master;

   dataInput() {
        master = new ArrayList();
        Random rand = new Random();
        for (int q = 0; q < 100; q++) {
            Student s = new Student();
<<<<<<< HEAD
            s.setEmail(stringmaker() + "@taboracademy.org");
            s.setRoomPreference(rand.nextInt(1,5), rand.nextInt(1,5), rand.nextInt(1,5));
            s.setSleepinghabit(rand.nextInt(1,5), rand.nextInt(1,5));
            s.setSportsOrArtsy(rand.nextInt(1,5));
=======
            s.setStrings(stringmaker() + "@taboracademy.org");
            s.setInts(rand.nextInt(5), rand.nextInt(5), rand.nextInt(5), rand.nextInt(5), rand.nextInt(5),rand.nextInt(5));
            s.setInternational(Math.random() < 0.5);
>>>>>>> 40b0c79d2f5f0a7f9b5ebc2639506c0b3e985754
            master.add(s);
        }
    }

    public static String stringmaker(){
            byte[] array = new byte[7]; // length is bounded by 7
            new Random().nextBytes(array);
        return new String(array, Charset.forName("UTF-8"));

    }

}