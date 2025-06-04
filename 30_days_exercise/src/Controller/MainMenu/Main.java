package Controller.MainMenu;

import java.util.*;

import Class.ExerciseMove.Exercise;
import Class.UsersAccount.Account;
import Class.UsersAccount.Admin;
import Class.UsersAccount.Users;

public class Main {
    private Scanner scan;
    private LoginRegister systemLogin;
    private ArrayList<Account> listAccounts;
    private ArrayList<Exercise> listExercises;

    public Main() {
        scan = new Scanner(System.in);
        listAccounts = new ArrayList<>();
        listExercises = new ArrayList<>();

        listAccounts.add(new Admin("Abdus", "12345678", "Admin"));
        listAccounts.add(new Users("AbdusSalam", "123123123", "Users"));
        listExercises.add(new Exercise("Push Up", 600, 10, 5, 30, "Push Up"));
        listExercises.add(new Exercise("Sit Up", 600, 15, 8, 30, "Sit Up"));
        listExercises.add(new Exercise("Pull Up", 600, 5, 10, 30, "Pull Up"));
        systemLogin = new LoginRegister(listAccounts, listExercises);
    }

    public void openingMenu() {
        while (true) {
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
                    } else {
                        System.out.println("Menu doesn't exist, try again!");

                    }
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
}
