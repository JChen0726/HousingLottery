public class Main {
//dfsfdf
    Main(){
        dataInput dataInput = new dataInput();
        //NewStudentPairingAlgo pairingAlgo = new NewStudentPairingAlgo(dataInput.master);
        OldStudentPairingAlgo oldAlgo = new OldStudentPairingAlgo(dataInput.master,dataInput.roomsPublicTest);
    }
    public static void main(String[] args) {
        new Main();
//test
    }
}
