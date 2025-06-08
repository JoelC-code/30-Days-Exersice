package Controller.User;

import java.util.Scanner;

import Class.UsersAccount.*;
import Controller.MainMenu.Main;

public class UserPage {
    private Scanner scan;
    private Users loginUser;

    public UserPage(Users loginUser) {
        scan = new Scanner(System.in);
        this.loginUser = loginUser;
    }

    public void mainMenu() {
        ExerciseManager toManager = new ExerciseManager(loginUser);
        int menuSelected = -1;
        System.out.println("=-=-= Welcome, " + loginUser.getUsername() + " =-=-=");
        while (menuSelected != 0) {
            try {
                System.out.println("1. View Calender");
                System.out.println("2. View today's exercise");
                System.out.println("3. View All Exercise");
                System.out.println("0. Logout");
                System.out.print("> ");
                menuSelected = scan.nextInt();
                scan.nextLine();
                if (menuSelected < 1 && menuSelected > 3) {
                    System.out.println("Invalid menu selection, please try again!");
                }
            } catch (Exception e) {
                System.out.println("Invalid input, please try again!");
                scan.nextLine();
            } 
            switch (menuSelected) {
            case 1:
                toManager.viewCalender();
                break;
            case 2:
                toManager.viewToday();
                break;
            case 3:
                toManager.viewAllExercise();
                break;
            case 4:
                Main toMainMenu = new Main();
                toMainMenu.openingMenu();
                break;
        }
        }

    }
}