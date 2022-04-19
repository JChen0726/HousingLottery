import java.util.ArrayList;

public class AssignmentAlgorithm {
    int[][] costMatrix;


    ArrayList<Student> oldStudents;

    // students variables arraylist <choices>

    ArrayList<Rooms> dormRooms;
    int [] choicesWeight;
    int [] gradeWeight;

    AssignmentAlgorithm(){
        choicesWeight = new int[]{1,3,5,7};
        gradeWeight = new int [] {1,3,5};
        roomChoiceCostInput();//costs into array
        multiplyGradeWeights();
    }

    //student[i] corresponds with row [i]
    //Room[j] corresponds with column [j]


    private void roomChoiceCostInput(){
        for (int i = 0; i <oldStudents.size(); i++){
            Student curStudent = oldStudents.get(i);
            for (int j = 0; j <oldStudents.choices.size()  ; j++) {
                // 0,1,2,3
                Rooms room = oldStudents.choices.get(j);
                int idx = dormRooms.indexOf(room);
                costMatrix[i][idx] = choicesWeight[j];
            }
        }
    }

    private void multiplyGradeWeights() {
        for (int i = 0; i < costMatrix.length; i++) {
            Student curStudent = oldStudents.get(i);
            if(curStudent.getGrade() == 12){
                costMatrix[i] = gradeWeight[0] * costMatrix[i];
            }
            else if(curStudent.getGrade() == 11){
                costMatrix[i] = gradeWeight[1] * costMatrix[i];
            }
            else if(curStudent.getGrade() == 10){
                costMatrix[i] = gradeWeight[2] * costMatrix[i];
            }
        }
    }

    private int [][] assignRooms(){
        HungarianAlgorithm hungarianAlgorithm = new HungarianAlgorithm(costMatrix);
        return  hungarianAlgorithm.findOptimalAssignment();
    }
}