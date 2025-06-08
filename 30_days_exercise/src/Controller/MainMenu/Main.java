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
<<<<<<< HEAD
    private LinkedList<Exercise> listExercises;
=======
    private ArrayList<Exercise> listExercises;
<<<<<<< HEAD
    private LinkedList<Exercise> listExercisesTemp;
    private WorkoutPlan workoutPlanTemp;
>>>>>>> 2e8bdb6d54d4adac41bf43170a5c9674e7f94f1c
=======
>>>>>>> 89f924a0e36840cc31efd30885472a8793abf9be

    public Main() {
        scan = new Scanner(System.in);
        listAccounts = new ArrayList<>();
        listExercises = new LinkedList<>();

        listAccounts.add(new Admin("Abdus", "12345678", "Admin"));
        listAccounts.add(new Users("A", "2", "Users"));
        listExercises.add(new Exercise("Push Up", 30, 10, 5, 30, "Push Up"));
        listExercises.add(new Exercise("Sit Up", 25, 15, 8, 30, "Sit Up"));
        listExercises.add(new Exercise("Pull Up", 40, 5, 10, 30, "Pull Up"));
        listExercises.add(new Exercise("Jumping Rope", 35, 10, 5, 30, "Jumping Rope"));
        listExercises.add(new Exercise("Interval Running", 45, 15, 8, 30, "Interval Running"));
        listExercises.add(new Exercise("Squats", 20, 5, 10, 30, "Walking"));
        listExercises.add(new Exercise("Plank", 30, 10, 5, 30, "Plank"));
        listExercises.add(new Exercise("Dance", 25, 15, 8, 30, "Dance"));
        listExercises.add(new Exercise("Pull Down", 40, 5, 10, 30, "Pull Down"));

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

    public LinkedList<Exercise> getListExercises() {
        return listExercises;
    }
}
