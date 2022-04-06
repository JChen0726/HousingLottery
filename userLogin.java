import java.util.Scanner;

public class userLogin{
    String username,password;
    userLogin(){
        prompt();
    }
    private void prompt(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter your username and password");
        System.out.println("Username: ");
        username = sc.next();
        System.out.println("Password: ");
        password = sc.next();
    }
}
