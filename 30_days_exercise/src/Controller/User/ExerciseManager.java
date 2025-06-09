package Controller.User;

import java.util.Scanner;

import Class.ExerciseMove.Exercise;
import Class.UsersAccount.Users;
import Class.Workout.WorkoutCalender;
import Class.Workout.WorkoutPlan;

public class ExerciseManager {
    private Users logUser;
    private Scanner scan;

    public ExerciseManager(Users logUser) {
        this.logUser = logUser;
        this.scan = new Scanner(System.in);
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
                System.out.println("\n\nDay you want to check:");
                selectedDay = scan.nextInt();
                if (selectedDay <= 30) {
                    isValid = true;
                } else {
                    System.out.println("Day selected doesn't exist, please try again!");
                }
            } catch (Exception e) {
                System.out.println("Invalid input, please try again!");
            }
        }
        System.out.println();
        WorkoutPlan selectedWorkoutDay = logUser.returnExerciseBasedOnDay(selectedDay);
        showingListWorkout(selectedWorkoutDay, selectedDay, true);
        System.out.println();
    }

    public boolean showingListWorkout(WorkoutPlan selectedDay, int day, boolean showEmptyMessage) {
        if (selectedDay == null || selectedDay.isEmpty()) {
            if (showEmptyMessage) {
                System.out.println("There's no workout planned in day " + day + "!");
            }
            return false;
        } else {
            System.out.println("Exercise on day " + day);
            int arraySize = selectedDay.sizeList();
            for (int i = 0; i < arraySize; i++) {
                Exercise selectedExercise = selectedDay.getExerciseAt(i);
                System.out.println((1 + i) + ". " + selectedExercise.getName());
            }
            return true;
        }
    }

    public void viewToday() {
        WorkoutCalender wc = new WorkoutCalender();
        wc.setDate(null);
        int today = wc.getDay();

        WorkoutPlan workoutToday = logUser.getWorkoutToday();

        if (workoutToday == null || workoutToday.isEmpty()) {
            System.out.println("No workout remaining for today. Returning...");
            return;
        }

        showingListWorkout(workoutToday, today, false);

        int options = -1;
        while (options != 0) {
            System.out.println();
            System.out.println("What are you going to do today?");
            System.out.println("1. Doing a workout");
            System.out.println("2. Resting for the day");
            System.out.println("0. Go back");
            System.out.print("> ");

            try {
                options = scan.nextInt();
            } catch (Exception e) {
                System.out.println("Invalid input, try again!");
                scan.nextLine();
                continue;
            }

            System.out.println();

            switch (options) {
                case 0:
                    System.out.println("Going back...");
                    return;

                case 1:
                    System.out.println("Your exercise is done!");
                    workoutToday.deleteWorkout();
                    break;

                case 2:
                    System.out.println("Get a well resting!");
                    workoutToday.deleteAll();
                    break;

                default:
                    System.out.println("Invalid input, try again!");
                    continue;
            }

            if (!workoutToday.isEmpty()) {
                showingListWorkout(workoutToday, today, false);
            } else {
                System.out.println("No workout remaining for today. Returning...");
                break;
            }
        }
    }

    public void viewAllExercise() {
        System.out.println();
        if (logUser.getExerciseList().isEmpty()) {
            System.out.println("No exercises in the workout plan.");
        } else {
            System.out.println("Your workout plan:");
            printExerciseRecursive(0);
        }
        System.out.println();
    }

    private void printExerciseRecursive(int index) {
        if (index >= logUser.getExerciseList().size()) {
            return;

        }
        System.out.println((index + 1) + ". " + logUser.getExerciseList().get(index).getName() + " ["
                + logUser.getExerciseList().get(index).getIntensityCategory() + "]");
        printExerciseRecursive(index + 1);
    }
}
