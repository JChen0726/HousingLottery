public class Main {
    public static void main(String[] args) {
        dataInput di = new dataInput(); //should be moved into core
        Core v = new Core(di.getStudentMasterList(), di.getDormMasterList());
    }
}
