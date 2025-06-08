package Controller.User;

import java.util.Scanner;

import Class.UsersAccount.Users;
import Class.Workout.WorkoutCalender;

public class ExerciseManager {
    private Users logUser;
    private Scanner scan;

    public ExerciseManager(Users logUser) {
        this.logUser = logUser;
        scan = new Scanner(System.in);
    }

    public void viewCalender() {
        boolean isValid = false;
        int selectedDay = 0;
        System.out.println("=-=-= Calender =-=-=");
        WorkoutCalender wc = new WorkoutCalender();
        wc.setDate(null);
        System.out.println(wc.getFormattedDate());
        wc.displayDaysInMonth();
        while (!isValid) {
            try {
                System.out.println("Day you want to check:");
                selectedDay = scan.nextInt();
                scan.nextLine();
                if (selectedDay <= 30) {
                    isValid = true;
                } else {
                    System.out.println("Day selected doesn't exist, please try again!");
                }
            } catch (Exception e) {
                System.out.println("Invalid input, please try again!");
                scan.nextLine();
            }
        }
    }

    public void viewToday() {
        System.out.println();
    }

    public void viewAllExercise() {
        if (logUser.getExerciseLists().isEmpty()) {
            System.out.println("No exercises in the workout plan.");
        } else {
            System.out.println("Your workout plan:");
            printExerciseRecursive(0);
            System.out.println();
        }
    }

    private void printExerciseRecursive(int index) {
        if (index >= logUser.getExerciseLists().sizeList()) {
            return;
        }
        System.out.println((index + 1) + ". " + logUser.getExerciseLists().getExerciseAt(index));
        printExerciseRecursive(index + 1);
    }
}
