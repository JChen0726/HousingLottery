import java.util.ArrayList;
import java.lang.Math;

public class pairingAlgo {

    private ArrayList<Student> studentPool;
    private ArrayList<StudentPair> paired = new ArrayList<>();
    private ArrayList<Student> unpaired = new ArrayList<>();

    //encapsulate multiple algos into their own classes inside corealgo

    pairingAlgo(ArrayList<Student> students){
        this.studentPool = students;
        findPairs();
    }

    private int totaldiff(int key1, int key2){ //finds total difference between two students
        Student student1 = studentPool.get(key1);
        Student student2 = studentPool.get(key2); //creates students as we go, but might be easier to create students prior to this
        int cleandiff = Math.abs(student1.getClean() - student2.getClean());
        int quietdiff = Math.abs(student1.getQuiet() - student2.getQuiet());
        int guestdiff = Math.abs(student1.getGuest() - student2.getGuest());
        int getupdiff = Math.abs(student1.getGetUp() - student2.getGetUp());
        int sleepdiff = Math.abs(student1.getStayUp() - student2.getStayUp());
        int sportsorartdiff = Math.abs(student1.getSportsOrArtsy() - student2.getSportsOrArtsy());
        return cleandiff + guestdiff +quietdiff + getupdiff + sleepdiff + sportsorartdiff;
    }


    private ArrayList<StudentPair> findPairs(){

        for(int i = 0; i < studentPool.size(); i++){
            int mindiff = Integer.MAX_VALUE;
            StudentPair temp = null;
            int minMatch=-1;
            if(studentPool.get(i).getPairedStatus()){ //add prioritization rule for international/domestic students
                continue;
            }

            for(int j = i+1; j < studentPool.size(); j++){ //brute force search for best match
                if(!studentPool.get(j).getPairedStatus()){
                    if(mindiff > totaldiff(i, j)){
                        mindiff = totaldiff(i, j);
                        temp = new StudentPair(studentPool.get(i), studentPool.get(j));
                        minMatch = j;
                    }
                }
            }
            System.out.println(mindiff);
            studentPool.get(i).setPaired();
            studentPool.get(minMatch).setPaired();
            paired.add(temp);
        }
        System.out.println(paired);
        return paired;
    }
}
