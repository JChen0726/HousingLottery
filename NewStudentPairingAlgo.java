import java.util.ArrayList;
import java.lang.Math;

public class NewStudentPairingAlgo { //Justin wrote

    ArrayList<Student> studentStatsMap;

    ArrayList<StudentPair> paired = new ArrayList<>();

    NewStudentPairingAlgo(ArrayList<Student> students){
       
        this.studentStatsMap = students;
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

    private ArrayList<StudentPair> findPairs(ArrayList<Student> studentList){ //Justin wrote
        studentList = prioritize(studentList);
        for(int i = 0; i < studentList.size(); i++){
            int mindiff = Integer.MAX_VALUE;
            StudentPair temp = null;
            int minMatch=-1;
            if(studentList.get(i).getPairedStatus()){
                continue;
            }
            for(int j = i+1 ;j < studentList.size(); j++){
                if(!studentList.get(j).getPairedStatus()){
                    if(mindiff > totaldiff(i, j)){
                        mindiff = totaldiff(i, j);
                        temp = new StudentPair(studentList.get(i), studentList.get(j));
                        minMatch = j;
                    }
                }
            }
            studentList.get(i).setPaired();
            studentList.get(minMatch).setPaired();
            paired.add(temp);
        }
        return paired;
    }

    public ArrayList<RoomSelection> randomAssignToRooms( ArrayList<Dorm>dorms){ // Justin wrote
        // assign the paired new students to random dorms
        ArrayList <StudentPair> sp = findPairs(internationalPrioritized());
        ArrayList<RoomSelection> newStudentAssignment = new ArrayList<RoomSelection>();
        for (int i = 0; i <dorms.size(); i++) { //NEED TO FIX THIS
            Dorm dorm = dorms.get(i);
            int count = 0;
            ArrayList<Room> roomList = dorm.getAllRooms(); //NEED TO FIX THIS
            for(Room room: roomList){
                if(!room.isFull()&&room.isAvailable&& !room.isSingle()) {
                    room.assignStudent();
                    newStudentAssignment.add(new RoomSelection(sp.get(0),room));
                    sp.remove(0);
                }
            }
        }
        if(sp.isEmpty()){
            System.out.println("Success");
            return newStudentAssignment;
        }else{
            System.out.println("Not Enough Room/ error happened");
        }
        return null;
    }




}
