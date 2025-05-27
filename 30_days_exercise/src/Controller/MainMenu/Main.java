package Controller.MainMenu;
import java.util.*;

public class Main {
    private Scanner scan;
    private LoginRegister systemLogin;

    public Main() {
        scan = new Scanner(System.in);
        systemLogin = new LoginRegister();
    }
    
    public void openingMenu(){
        int choice = 0;
        boolean isValid = false;
        while (!isValid) {
            System.out.println("Welcome to 'Health-Habit'");
            System.out.println("1. Login");
            System.out.println("2. Register");
            System.out.println("3. Exit");
            try {
                choice = scan.nextInt();
                scan.nextLine();
                if (choice >= 1 && choice <= 3) {
                    isValid = true;
                } 
                System.out.println("Menu don't exist, try again!");
            } catch (Exception e) {
                System.out.println("Error: Input must a number NOT a string [M-IME]");
                scan.nextLine();
            }
        }
        switch (choice) {
            case 1:
                systemLogin.login();
                break;
        
            case 2:
                systemLogin.register();
                break;
                
            case 3:
                System.exit(0);
        }
    }
}
