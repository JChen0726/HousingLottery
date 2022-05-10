public class Main {
//dfsfdf
    Main(){
        dataInput di = new dataInput();
        Core v = new Core(di.getStudentMasterList(), di.getDormMasterList());
        //NewStudentPairingAlgo pairingAlgo = new NewStudentPairingAlgo(dataInput.master);

    }
    
    public static void main(String[] args) {
        new Main();
//test
    }
}
