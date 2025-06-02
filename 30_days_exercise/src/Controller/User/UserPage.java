package Controller.User;

import java.util.ArrayList;
import java.util.Scanner;

import Class.UsersAccount.*;
import Class.ExerciseMove.Exercise;

public class UserPage {
    private Scanner scan;
    private Users loginUser;

    public UserPage(Users loginUser) {
        scan = new Scanner(System.in);
        this.loginUser = loginUser;
    }

    public void mainMenu() {
        int menuSelected = 0;
        boolean isValid = false;
        while(!isValid) {
            try {
                System.out.println("=-=-= Welcome, "+loginUser.getUsername()+" =-=-=");
                System.out.println("1. View Calender");
                System.out.println("2. View todays's exercise");
                System.out.println("3. Settings");
                System.out.println("4. Logout");
                System.out.print("> ");
                menuSelected = scan.nextInt();
                scan.nextLine();
                if (menuSelected >= 1 && menuSelected <= 4) {
                    isValid = true;
                }
                System.out.println("Invalid menu selection, please try again!");
            } catch (Exception e) {
                System.out.println("Invalid input, please try again!");
                scan.nextLine();
            }
        }
        switch (menuSelected) {
            case 1:
                
                break;
        
            default:
                break;
        }
    }
}