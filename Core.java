import java.util.ArrayList;
import java.util.HashMap;
import java.util.SplittableRandom;
import java.lang.Math;

public class Core {

    HashMap<String,Student> studentStatsMap;
    ArrayList<StudentPair> paired = new ArrayList<>();
    ArrayList<Student> unpaired = new ArrayList<>();

    Core(HashMap<String,Student> studentStatsMap){
        this.studentStatsMap = studentStatsMap;
    }


    private int totaldiff(String key1, String key2){


        Student Justin = studentStatsMap.get(key1);
        Student Bryn = studentStatsMap.get(key2);
        int cleandiff = Math.abs(Justin.getClean() - Bryn.getClean());
        int guestdiff = Math.abs(Justin.getGuest() - Bryn.getGuest());
        int getupdiff = Math.abs(Justin.getGetUp() - Bryn.getGetUp());
        int sleepdiff = Math.abs(Justin.getStayUp() - Bryn.getStayUp());
        int sportsorartdiff = Math.abs(Justin.getSportsOrArtsy() - Bryn.getSportsOrArtsy());
        return cleandiff + guestdiff + getupdiff + sleepdiff + sportsorartdiff;
    }


    private ArrayList<StudentPair> findPairs(){
        for(String key1 : studentStatsMap.keySet()){
            int mindiff = Integer.MAX_VALUE;
            StudentPair temp = null;
            String keysecond = "";
            for(String key2 : studentStatsMap.keySet()){
                if(!key1.equals(key2)){
                    if(mindiff > totaldiff(key1, key2)){
                        mindiff = totaldiff(key1, key2);
                        temp = new StudentPair(studentStatsMap.get(key1), studentStatsMap.get(key2));
                        keysecond = key2;
                    }

                }
            }
            if(temp != null){
                paired.add(temp);
                studentStatsMap.remove(key1);
                studentStatsMap.remove(keysecond);
            }
        }
        return paired;
    }




}
