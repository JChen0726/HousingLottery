import java.util.ArrayList;
import java.lang.Math;


public class NewStudentPairingAlgo {

    ArrayList<Student> studentStatsMap;

    ArrayList<StudentPair> paired = new ArrayList<>();


    NewStudentPairingAlgo(ArrayList<Student> students){
       
        this.studentStatsMap = students;
        this.studentStatsMap = internationalPrioritized();
        findPairs();
    }

    private ArrayList<Student> internationalPrioritized(){
        return prioritize(studentStatsMap);
    }

    private ArrayList<Student> prioritize(ArrayList<Student> students){
        ArrayList<Student> prioritized = new ArrayList<>();
        for (Student student : students) {
            if (student.getInternationalStatus()) {
                prioritized.add(student);
            }
        }
        for (Student student : students) {
            if (!student.getInternationalStatus()) {
                prioritized.add(student);
            }
        }
        return prioritized;
    }


    private int totaldiff(int key1, int key2){
        Student Justin = studentStatsMap.get(key1);
        Student Bryn = studentStatsMap.get(key2);
        int cleandiff = Math.abs(Justin.getClean() - Bryn.getClean());
        int quietdiff = Math.abs(Justin.getQuiet() - Bryn.getQuiet());
        int guestdiff = Math.abs(Justin.getGuest() - Bryn.getGuest());
        int getupdiff = Math.abs(Justin.getGetUp() - Bryn.getGetUp());
        int sleepdiff = Math.abs(Justin.getStayUp() - Bryn.getStayUp());
        int sportsorartdiff = Math.abs(Justin.getSportsOrArtsy() - Bryn.getSportsOrArtsy());
        return cleandiff + guestdiff +quietdiff + getupdiff + sleepdiff + sportsorartdiff;
    }

    private ArrayList<StudentPair> findPairs(){

        for(int i = 0; i < studentStatsMap.size(); i++){
            int mindiff = Integer.MAX_VALUE;
            StudentPair temp = null;
            int minMatch=-1;
            if(studentStatsMap.get(i).getPairedStatus()){
                continue;
            }
            for(int j = i+1 ;j < studentStatsMap.size(); j++){
                if(!studentStatsMap.get(j).getPairedStatus()){
                    if(mindiff > totaldiff(i, j)){
                        mindiff = totaldiff(i, j);
                        temp = new StudentPair(studentStatsMap.get(i), studentStatsMap.get(j));
                        minMatch = j;
                    }
                }
            }
            System.out.println(mindiff); // testing
            studentStatsMap.get(i).setPaired();
            studentStatsMap.get(minMatch).setPaired();
            paired.add(temp);
        }
        return paired;
    }

}
