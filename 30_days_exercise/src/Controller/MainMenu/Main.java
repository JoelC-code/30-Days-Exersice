package Controller.MainMenu;

import java.util.*;

import Class.ExerciseMove.Exercise;
import Class.UsersAccount.Account;
import Class.UsersAccount.Admin;
import Class.UsersAccount.Users;
import Class.Workout.WorkoutPlan;

public class Main {
    private Scanner scan;
    private LoginRegister systemLogin;
    private ArrayList<Account> listAccounts;
    private LinkedList<Exercise> listExercises;
    private LinkedList<Exercise> listExercisesTemp;
    private WorkoutPlan[] workoutPlanTemp;


    public Main() {
        scan = new Scanner(System.in);
        listAccounts = new ArrayList<>();
        listExercises = new LinkedList<>();

        listAccounts.add(new Admin("Abdus", "12345678", "Admin"));
        listAccounts.add(new Users("A", "2"));

      listAccounts.add(new Users("A", "2"));
        listExercises.add(new Exercise("Push Up", 30, 10, 5, 30, "Push Up"));
        listExercises.add(new Exercise("Sit Up", 25, 5, 8, 30, "Sit Up"));
        listExercises.add(new Exercise("Pull Up", 40, 5, 6, 30, "Pull Up"));
        listExercises.add(new Exercise("Jumping Rope", 35, 15, 4, 30, "Jumping Rope"));
        listExercises.add(new Exercise("Interval Running", 45, 15, 4, 30, "Interval Running"));
        listExercises.add(new Exercise("Squats", 20, 5, 10, 30, "Squats"));
        listExercises.add(new Exercise("Plank", 30, 10, 5, 30, "Plank"));
        listExercises.add(new Exercise("Dance", 25, 15, 8, 30, "Dance"));
        listExercises.add(new Exercise("Pull Down", 40, 5, 10, 30, "Pull Down"));

        listExercisesTemp = new LinkedList<>();
        listExercisesTemp.add(listExercises.get(0));
        listExercisesTemp.add(listExercises.get(1));
        listExercisesTemp.add(listExercises.get(2));
        listExercisesTemp.add(listExercises.get(3));
        listExercisesTemp.add(listExercises.get(4));
        workoutPlanTemp = new WorkoutPlan[7];
        workoutPlanTemp[0] = new WorkoutPlan(listExercisesTemp, 0);
        listAccounts.add(new Users("Salam", "1234", "Abdus Salam", 15, "Male", 160, 70, false, workoutPlanTemp));

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
                System.out.print("> ");
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
