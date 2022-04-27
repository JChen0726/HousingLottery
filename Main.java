public class Main {
//dfsfdf
    Main(){
        dataInput dataInput = new dataInput();
        //NewStudentPairingAlgo pairingAlgo = new NewStudentPairingAlgo(dataInput.master);
        CurrentStudentPairingAlgo oldAlgo = new CurrentStudentPairingAlgo(dataInput.master,dataInput.roomsPublicTest);
    }
    public static void main(String[] args) {
        new Main();
//test
    }
}
