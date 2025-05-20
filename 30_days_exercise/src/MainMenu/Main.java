package MainMenu;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        LoginRegister loginRegister = new LoginRegister();
        Scanner scan = new Scanner(System.in);
        int choices = -1;
        while (choices != 3) {
            System.out.println("Welcome!\n1. Login\n2. Register\n3. Exit");
            choices = scan.nextInt();
            switch (choices) {
                case 1:
                loginRegister.Login(scan);
                    break;
                case 2:
                loginRegister.Register(scan);
                    break;
                case 3:

                    break;

                default:
                System.out.println("Invalid input!");
                    break;
            }
        }
    }
    
}
