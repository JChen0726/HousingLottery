public class Main {
    public static void main(String[] args) {
        DataInput di = new DataInput(); //should be moved into core
        Core core = new Core();
        core.setData(di.getStudentMasterList(), di.getDormMasterList());
    }
}
