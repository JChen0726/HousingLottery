import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;


public class RoomAssigningAlgo{
    private final int[][] costMatrix;
    private final ArrayList<Object> students;
    // students variables arraylist <choices>
    private ArrayList<Room> dormRooms;
    private final int [] choicesWeight;
    private final int [] gradeWeight;

    RoomAssigningAlgo(ArrayList Student, ArrayList<Room> rooms){ //CHANGE TO ARRAYLIST OF OBJECTS
        // for single students
        choicesWeight = new int[]{1,3,5,7};
        gradeWeight = new int [] {1,3,5};

        this.costMatrix = new int[Student.size()][rooms.size()];
        this.students = Student;
        // need to initialize the two arraylist here

        roomChoiceCostInput();//costs into array
        multiplyGradeWeights();

    }

    // Vivian's code havent tested to see if itactually works.
    private int[][] makeSquare(int [][] inputmatrix) {
        int colCount= inputmatrix[0].length;
        int rowCount= inputmatrix.length;
        int [][] squareCM;
        if(colCount<rowCount){
            squareCM=new int[rowCount][rowCount];
        }
        else {
            squareCM=new int[colCount][colCount];
        }
        for (int i = 0; i <squareCM.length; i++) {
            for (int j = 0; j <squareCM[0].length; j++) {
                try{squareCM[i][j]= this.costMatrix[i][j];}
                catch (IndexOutOfBoundsException e){
                    squareCM[i][j]=10000;//bigger than any number that would be in the matrix
                }
            }
        }
        return squareCM;
    }

    //student[i] corresponds with row [i]
    //Room[j] corresponds with column [j]
    private void roomChoiceCostInput(){ //THERE'S GOTTA BE A BETTER WAY TO DO THIS
        for (int i = 0; i < students.size(); i++){
            try{
                Student curStudent = (Student) students.get(i);
                for (int j = 0; j < curStudent.getRoomChoices().size()  ; j++) {
                    // 0,1,2,3
                    costMatrix[i][j] = choicesWeight[3];
                    String roomName = curStudent.getRoomChoices().get(j);
                    int idx = dormRooms.indexOf(roomName); //need to fix
                    costMatrix[i][idx] = choicesWeight[j];
                }
            }catch(ClassCastException e){
                StudentPair curStudent = (StudentPair) students.get(i);
                for (int j = 0; j < curStudent.getRoomChoices().size()  ; j++) {
                    // 0,1,2,3
                    costMatrix[i][j] = choicesWeight[3];
                    String roomName = curStudent.getRoomChoices().get(j);
                    int idx = dormRooms.indexOf(roomName); //need to fix
                    costMatrix[i][idx] = choicesWeight[j];
                }
            }

        }
    }


    private void multiplyGradeWeights() {

        for (var ref = new Object() { int i = 0; }; ref.i < costMatrix.length; ref.i++) {
            Student curStudent = (Student) students.get(ref.i);

            if (curStudent.getGrade() == 12) {
                //lambda done by bryn
                Arrays.stream(costMatrix[ref.i]).forEach(j -> costMatrix[ref.i][j] = costMatrix[ref.i][j] * gradeWeight[0]);
            }
            else if (curStudent.getGrade() == 11) {
                Arrays.stream(costMatrix[ref.i]).forEach(j -> costMatrix[ref.i][j] = costMatrix[ref.i][j] * gradeWeight[1]);
            }
            else if (curStudent.getGrade() == 10) {
                Arrays.stream(costMatrix[ref.i]).forEach(j -> costMatrix[ref.i][j] = costMatrix[ref.i][j] * gradeWeight[0]);
            }
        }
    }


    private int[][] runCalculation(){
        HungarianAlgorithm hungarianAlgorithm = new HungarianAlgorithm(makeSquare(costMatrix));
        return hungarianAlgorithm.findOptimalAssignment();
    }



@SuppressWarnings("ForLoopReplaceableByForEach")
class HungarianAlgorithm {

    private final int[][] matrix; // initial matrix (cost matrix)

    // markers in the matrix
    private final int[] squareInRow;
    private final int[] squareInCol;
    private final int[] rowIsCovered;
    private final int[] colIsCovered;
    private final int[] staredZeroesInRow;

    public HungarianAlgorithm(int[][] matrix) {
        if (matrix.length != matrix[0].length) {
            try {
                throw new IllegalAccessException("The matrix is not square!");
            } catch (IllegalAccessException e) {
                System.err.println(e);
                System.exit(1);
            }
        }

        this.matrix = matrix;
        squareInRow = new int[matrix.length];       // squareInRow & squareInCol indicate the position
        squareInCol = new int[matrix[0].length];    // of the marked zeroes

        rowIsCovered = new int[matrix.length];      // indicates whether a row is covered
        colIsCovered = new int[matrix[0].length];   // indicates whether a column is covered
        staredZeroesInRow = new int[matrix.length]; // storage for the 0*
        Arrays.fill(staredZeroesInRow, -1);
        Arrays.fill(squareInRow, -1);
        Arrays.fill(squareInCol, -1);
    }

    /**
     * find an optimal assignment
     *
     * @return optimal assignment
     */
    public int[][] findOptimalAssignment() {
        step1();    // reduce matrix
        step2();    // mark independent zeroes
        step3();    // cover columns which contain a marked zero

        while (!allColumnsAreCovered()) {
            int[] mainZero = step4();
            while (mainZero == null) {      // while no zero found in step4
                step7();
                mainZero = step4();
            }
            if (squareInRow[mainZero[0]] == -1) {
                // there is no square mark in the mainZero line
                step6(mainZero);
                step3();    // cover columns which contain a marked zero
            } else {
                // there is square mark in the mainZero line
                // step 5
                rowIsCovered[mainZero[0]] = 1;  // cover row of mainZero
                colIsCovered[squareInRow[mainZero[0]]] = 0;  // uncover column of mainZero
                step7();
            }
        }

        int[][] optimalAssignment = new int[matrix.length][];
        for (int i = 0; i < squareInCol.length; i++) {
            optimalAssignment[i] = new int[]{i, squareInCol[i]};
        }
        return optimalAssignment;
    }

    /**
     * Check if all columns are covered. If that's the case then the
     * optimal solution is found
     *
     * @return true or false
     */
    private boolean allColumnsAreCovered() {
        for (int i : colIsCovered) {
            if (i == 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * Step 1:
     * Reduce the matrix so that in each row and column at least one zero exists:
     * 1. subtract each row minima from each element of the row
     * 2. subtract each column minima from each element of the column
     */
    private void step1() {
        // rows
        for (int i = 0; i < matrix.length; i++) {
            // find the min value of the current row
            int currentRowMin = Integer.MAX_VALUE;
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] < currentRowMin) {
                    currentRowMin = matrix[i][j];
                }
            }
            // subtract min value from each element of the current row
            for (int k = 0; k < matrix[i].length; k++) {
                matrix[i][k] -= currentRowMin;
            }
        }

        // cols
        for (int i = 0; i < matrix[0].length; i++) {
            // find the min value of the current column
            int currentColMin = Integer.MAX_VALUE;
            for (int j = 0; j < matrix.length; j++) {
                if (matrix[j][i] < currentColMin) {
                    currentColMin = matrix[j][i];
                }
            }
            // subtract min value from each element of the current column
            for (int k = 0; k < matrix.length; k++) {
                matrix[k][i] -= currentColMin;
            }
        }
    }

    /**
     * Step 2:
     * mark each 0 with a "square", if there are no other marked zeroes in the same row or column
     */
    private void step2() {
        int[] rowHasSquare = new int[matrix.length];
        int[] colHasSquare = new int[matrix[0].length];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                // mark if current value == 0 & there are no other marked zeroes in the same row or column
                if (matrix[i][j] == 0 && rowHasSquare[i] == 0 && colHasSquare[j] == 0) {
                    rowHasSquare[i] = 1;
                    colHasSquare[j] = 1;
                    squareInRow[i] = j; // save the row-position of the zero
                    squareInCol[j] = i; // save the column-position of the zero
                    continue; // jump to next row
                }
            }
        }
    }

    /**
     * Step 3:
     * Cover all columns which are marked with a "square"
     */
    private void step3() {
        for (int i = 0; i < squareInCol.length; i++) {
            colIsCovered[i] = squareInCol[i] != -1 ? 1 : 0;
        }
    }

    /**
     * Step 7:
     * 1. Find the smallest uncovered value in the matrix.
     * 2. Subtract it from all uncovered values
     * 3. Add it to all twice-covered values
     */
    private void step7() {
        // Find the smallest uncovered value in the matrix
        int minUncoveredValue = Integer.MAX_VALUE;
        for (int i = 0; i < matrix.length; i++) {
            if (rowIsCovered[i] == 1) {
                continue;
            }
            for (int j = 0; j < matrix[0].length; j++) {
                if (colIsCovered[j] == 0 && matrix[i][j] < minUncoveredValue) {
                    minUncoveredValue = matrix[i][j];
                }
            }
        }

        if (minUncoveredValue > 0) {
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[0].length; j++) {
                    if (rowIsCovered[i] == 1 && colIsCovered[j] == 1) {
                        // Add min to all twice-covered values
                        matrix[i][j] += minUncoveredValue;
                    } else if (rowIsCovered[i] == 0 && colIsCovered[j] == 0) {
                        // Subtract min from all uncovered values
                        matrix[i][j] -= minUncoveredValue;
                    }
                }
            }
        }
    }

    /**
     * Step 4:
     * Find zero value Z_0 and mark it as "0*".
     *
     * @return position of Z_0 in the matrix
     */
    private int[] step4() {
        for (int i = 0; i < matrix.length; i++) {
            if (rowIsCovered[i] == 0) {
                for (int j = 0; j < matrix[i].length; j++) {
                    if (matrix[i][j] == 0 && colIsCovered[j] == 0) {
                        staredZeroesInRow[i] = j; // mark as 0*
                        return new int[]{i, j};
                    }
                }
            }
        }
        return null;
    }

    /**
     * Step 6:
     * Create a chain K of alternating "squares" and "0*"
     *
     * @param mainZero => Z_0 of Step 4
     */
    private void step6(int[] mainZero) {
        int i = mainZero[0];
        int j = mainZero[1];

        Set<int[]> K = new LinkedHashSet<>();
        //(a)
        // add Z_0 to K
        K.add(mainZero);
        boolean found;
        do {
            // (b)
            // add Z_1 to K if
            // there is a zero Z_1 which is marked with a "square " in the column of Z_0
            if (squareInCol[j] != -1) {
                K.add(new int[]{squareInCol[j], j});
                found = true;
            } else {
                found = false;
            }

            // if no zero element Z_1 marked with "square" exists in the column of Z_0, then cancel the loop
            if (!found) {
                break;
            }

            // (c)
            // replace Z_0 with the 0* in the row of Z_1
            i = squareInCol[j];
            j = staredZeroesInRow[i];
            // add the new Z_0 to K
            if (j != -1) {
                K.add(new int[]{i, j});
            } else {
                found = false;
            }

        } while (found); // (d) as long as no new "square" marks are found

        // (e)
        for (int[] zero : K) {
            // remove all "square" marks in K
            if (squareInCol[zero[1]] == zero[0]) {
                squareInCol[zero[1]] = -1;
                squareInRow[zero[0]] = -1;
            }
            // replace the 0* marks in K with "square" marks
            if (staredZeroesInRow[zero[0]] == zero[1]) {
                squareInRow[zero[0]] = zero[1];
                squareInCol[zero[1]] = zero[0];
            }
        }

        // (f)
        // remove all marks
        Arrays.fill(staredZeroesInRow, -1);
        Arrays.fill(rowIsCovered, 0);
        Arrays.fill(colIsCovered, 0);
    }
}
}