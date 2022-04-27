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
        Student Stud1 = studentStatsMap.get(key1);
        Student Stud2 = studentStatsMap.get(key2);
        Object[] tempArr1 = Stud1.getScores();
        Object[] tempArr2 = Stud2.getScores();
        int totalDifference = 0;
        for(int i = 0; i < tempArr1.length; i++){totalDifference += Math.abs((int)tempArr1[i] - (int)tempArr2[i]);}
        return totalDifference;
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

            studentStatsMap.get(i).setPaired();
            studentStatsMap.get(minMatch).setPaired();
            paired.add(temp);
        }
        return paired;
    }
}
