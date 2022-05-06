public class Main {
//dfsfdf
    Main(){
        dataInput dataInput = new dataInput();
        //NewStudentPairingAlgo pairingAlgo = new NewStudentPairingAlgo(dataInput.master);
        RoomAssigningAlgo oldAlgo = new RoomAssigningAlgo(dataInput.master,dataInput.roomsPublicTest);
    }
    
    public static void main(String[] args) {
        new Main();
//test
    }
}
