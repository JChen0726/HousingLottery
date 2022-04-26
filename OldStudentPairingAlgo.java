import java.util.ArrayList;

public class OldStudentPairingAlgo {
    int[][] costMatrix;
    ArrayList<Student> oldStudents;
    // students variables arraylist <choices>
    ArrayList<String> dormRooms;
    int [] choicesWeight;
    int [] gradeWeight;

    OldStudentPairingAlgo(ArrayList<Student>oldStudents, ArrayList<String>dormRooms){
        choicesWeight = new int[]{1,3,5,7};
        gradeWeight = new int [] {1,3,5};
        this. costMatrix = new int[oldStudents.size()][dormRooms.size()];
        this.oldStudents = oldStudents;
        this. dormRooms = dormRooms;
        // need to initialize the two arraylist here

        roomChoiceCostInput();//costs into array
        multiplyGradeWeights();
        System.out.println(assignRooms());

    }
    //student[i] corresponds with row [i]
    //Room[j] corresponds with column [j]
    private void roomChoiceCostInput(){
        for (int i = 0; i <oldStudents.size(); i++){
            Student curStudent = oldStudents.get(i);
            for (int j = 0; j < curStudent.getRoomChoices().size()  ; j++) {
                // 0,1,2,3
                costMatrix[i][j] = choicesWeight[3];
                String roomName = curStudent.getRoomChoices().get(j);
                int idx = dormRooms.indexOf(roomName); //need to fix
                costMatrix[i][idx] = choicesWeight[j];
            }

        }
    }
    private void multiplyGradeWeights() {
        for (int i = 0; i < costMatrix.length; i++) {
            Student curStudent = oldStudents.get(i);
            if(curStudent.getGrade() == 12){
                for (int j = 0; j < costMatrix[i].length; j++) {
                    costMatrix[i][j] = costMatrix[i][j]*gradeWeight[0];
                }
            }
            else if(curStudent.getGrade() == 11){
                for (int j = 0; j < costMatrix[i].length; j++) {
                    costMatrix[i][j] = costMatrix[i][j]*gradeWeight[1];
                }
            }
            else if(curStudent.getGrade() == 10){
                for (int j = 0; j < costMatrix[i].length; j++) {
                    costMatrix[i][j] = costMatrix[i][j]*gradeWeight[2];
                }
            }
        }
    }
    
    private int[][] runCalculation(){
        HungarianAlgorithm hungarianAlgorithm = new HungarianAlgorithm(costMatrix);
        return  hungarianAlgorithm.findOptimalAssignment();
    }

    private ArrayList<Direction> assignRooms(){
        ArrayList<Direction> directlist= new ArrayList<>();
        int [][] pairinglist = runCalculation();
        for (int i = 0; i < pairinglist.length; i++) {
           Direction curDirect = new Direction(oldStudents.get(pairinglist[i][0]),dormRooms.get(pairinglist[i][1]));
           directlist.add(curDirect);
        }

        return directlist;
    }



    

}