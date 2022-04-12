import java.util.ArrayList;
import java.util.HashMap;
import java.util.SplittableRandom;

public class Core {

    HashMap<String,Student> studentStatsMap;
    ArrayList<String> paired = new ArrayList<>();
    ArrayList<String> unpaired = new ArrayList<>();

    Core(HashMap<String,Student> studentStatsMap){
        this.studentStatsMap = studentStatsMap;
    }

    private ArrayList<String> addToList() {
        for (String key1 : studentStatsMap.keySet()) {
            for (String key2 : studentStatsMap.keySet()) {
                if (!key1.equals(key2)) {
                    if(match(key1, key2)) {
                        paired.add(key1 + " pairs with" + key2);
                        studentStatsMap.remove(key1);
                        studentStatsMap.remove(key2);
                    }else {
                        unpaired.add(key1);
                        studentStatsMap.remove(key1);
                    }
                }
            }
        }
        return paired;
    }

    private boolean match(String key1, String key2){
        Student Justin = studentStatsMap.get(key1);
        Student Bryn = studentStatsMap.get(key2);

        int cleandiff = Justin.getClean() - Bryn.getClean();
        int guestdiff = Justin.getGuest() - Bryn.getGuest();
        int getupdiff = Justin.getGetUp() - Bryn.getGetUp();
        int sleepdiff = Justin.getStayUp() - Bryn.getStayUp();
        int sportsorartdiff = Justin.getSportsOrArtsy() - Bryn.getSportsOrArtsy();

        return cleandiff <= 1 && guestdiff <= 1 && getupdiff <= 1 && sleepdiff <= 1 && sportsorartdiff <= 1;
    }
}
