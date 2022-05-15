import java.util.ArrayList;
import java.lang.Math;

public class NewStudentPairingAlgo { //Justin wrote

    private final ArrayList<Student> studentStatsMap;

    private final ArrayList<StudentPair> paired = new ArrayList<>();

    NewStudentPairingAlgo(ArrayList<Student> students){
       
        this.studentStatsMap = students;

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
        for (int i = 0; i < tempArr1.length; i++) {totalDifference += Math.abs((int)tempArr1[i] - (int)tempArr2[i]);}
        return totalDifference;
    }


    private ArrayList<StudentPair> findPairs(ArrayList<Student> studentList){
        studentList = prioritize(studentList);
        for (int i = 0; i < studentList.size(); i++) {
            Student stud1 = studentList.get(i);
            int mindiff = Integer.MAX_VALUE;
            StudentPair temp = null;
            int minMatch=-1;
            if (stud1.getPairedStatus()) {continue;}
            for (int j = i+1 ;j < studentList.size(); j++) {
                Student stud2 = studentList.get(j);
                if (!stud2.getPairedStatus() && (mindiff > totaldiff(i, j) && stud1.getGender().equals(stud2.getGender()))) {
                    mindiff = totaldiff(i, j);
                    temp = new StudentPair(stud1, stud2);
                    minMatch = j;
                }
            }
            studentList.get(i).setPaired();
            studentList.get(minMatch).setPaired();
            paired.add(temp);
        }
        return paired;
    }


    public void randomAssignToRooms(ArrayList<Dorm> dorms){
        // assign the paired new students to random dorms/rooms
        ArrayList <StudentPair> sp = findPairs(prioritize(studentStatsMap));  //RETURNS PUBLIC OBJECT???
        //for each dorm, for each room in dorm, add students to room and set room to full
        for (int i = 0;i<sp.size();i++){
            for (Dorm dorm : dorms) {
                for (Room room : dorm.getAllRooms()) {
                    if (!room.isSingle() && sp.get(0).getGender().equals(dorm.getGender())) {
                        room.assignStudents(sp.get(0));
                    }
                } // potential error with this code, test heavily
            }
        }
    }
}
