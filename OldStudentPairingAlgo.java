import java.util.ArrayList;

public class OldStudentPairingAlgo {
    int[][] costMatrix;
    ArrayList<Student> oldStudents;
    // students variables arraylist <choices>
    ArrayList<Rooms> dormRooms;
    int [] choicesWeight;
    int [] gradeWeight;
    OldStudentPairingAlgo(){
        choicesWeight = new int[]{1,3,5,7};
        gradeWeight = new int [] {1,3,5};
        
        // need to initialize the two arraylist here
        
        roomChoiceCostInput();//costs into array
        multiplyGradeWeights();
    }
    //student[i] corresponds with row [i]
    //Room[j] corresponds with column [j]
    private void roomChoiceCostInput(){
        for (int i = 0; i <oldStudents.size(); i++){
            Student curStudent = oldStudents.get(i);
            for (int j = 0; j < curStudent.getRoomChoices().size()  ; j++) {
                // 0,1,2,3
                Rooms room = curStudent.getRoomChoices().get(j);
                int idx = dormRooms.indexOf(room);
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
    
    private ArrayList<Student> [][] assignRooms(){
        HungarianAlgorithm hungarianAlgorithm = new HungarianAlgorithm(costMatrix);
        return  hungarianAlgorithm.findOptimalAssignment();
    }
    

}