import java.util.Random;
import java.util.Scanner;

public class AdminInterface {

    AdminInterface(){
        System.out.println("Welcom - admin");
    }

    public void startGolottery (){
        Scanner sc = new Scanner(System.in);
        System.out.println("Start the lottery");
        System.out.println("Enter 1 for start");
        if(sc.nextInt()==1){
            Random rd = new Random();

            int number = rd.nextInt(100);
        }


    }



}
