import java.util.ArrayList;
import java.util.Arrays;

public class AssignmentAlgorithm {
    int[][] CostMatrix;
    ArrayList<Student> Students;
    ArrayList<Room> DormRooms;

    public static void main(String[] args) {

        //student[i] corresponds with row [i]
        //Room[j] corresponds with column [j]

        roomChoiceCostInput(0,3,7,12, 20);
        multiplyGradeWeights(5,3,1);
    }

    void roomChoiceCostInput(int firstChoiceWeight, int secondChoiceWeight, int thirdChoiceWeight, int forthChoiceWeight, int notChoiceWeight) {

        if (DormRooms.get(i).equals(student.choices.get(0))){
            CostMatrix[][]=firstChoiceWeight;
            }

    }

    void multiplyGradeWeights(int seniorWeight, int juniorWeight, int sophomoreWeight) {
        for (int i = 0; i < CostMatrix.length; i++) {
            if (Students.get(i).grade == 12) {
                for (int j = 0; j < CostMatrix.length; j++) {
                    CostMatrix[i][j] *= seniorWeight;
                }
            } else if (Students.get(i).grade == 11) {
                for (int j = 0; j < CostMatrix.length; j++) {
                    CostMatrix[i][j] *= juniorWeight;
                }
            } else if (Students.get(i).grade == 10) {
                for (int j = 0; j < CostMatrix.length; j++) {
                    CostMatrix[i][j] *= sophomoreWeight;
                }
            }
        }
    }
    h

    int[][] optimize(int[][] costs) {
        int[][] optimized = new int[costs.length][costs.length];
        //"assignment problem" algorithm
        //try the hungarian algorithm or whatever
        //or just maybe solve it in Excel for now :)
        System.out.println(optimized);
        return optimized;
    }
}