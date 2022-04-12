import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Random;

public class dataInput{

   dataInput() {
        System.out.println(stringmaker()+"@taboracademy.org");
        ArrayList<ArrayList> master = new ArrayList();
        Random rand = new Random();
        for (int q = 0; q < 100; q++) {
            master.add(new ArrayList());
            master.get(q).add(stringmaker() + "@taboracademy.org");
            for (int v = 0; v < 7; v++) {
                master.get(q).add(rand.nextInt(1, 6));
            }
        }
    }
    public static String stringmaker(){
            byte[] array = new byte[7]; // length is bounded by 7
            new Random().nextBytes(array);
            String generatedString = new String(array, Charset.forName("UTF-8"));
        return generatedString;
    }
}
