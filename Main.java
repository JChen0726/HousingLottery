import java.util.ArrayList;
import java.util.HashMap;

public class Main {

    Main(){
        dataInput dataInput = new dataInput();

        Core core = new Core(dataInput.master);
        System.out.println(core.paired);

    }
    public static void main(String[] args) {

        new Main();

    }
}
