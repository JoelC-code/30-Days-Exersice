package Controller.User;

import java.util.LinkedList;
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
        showingListWorkout(selectedWorkoutDay, selectedDay);
    }

    public boolean showingListWorkout(WorkoutPlan selectedDay, int day) {
        if (selectedDay == null || selectedDay.isEmpty()) {
            System.out.println("There's no workout planned in day " + day + "!");
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

        System.out.println(today);
        WorkoutPlan workoutToday = logUser.getWorkoutToday();

        int options = -1;
        while (options != 0) {
            if (!showingListWorkout(workoutToday, today)) {
                System.out.println("No workout for today. Returning...");
                break;
            }
            
            System.out.println();
            System.out.println("What are you going to do today?");
            System.out.println("1. Doing a workout");
            System.out.println("2. Resting for the day");
            System.out.println("0. Go back");
            System.out.print("> ");
            options = scan.nextInt();

            switch (options) {
                case 0:
                    System.out.println("Going back...");
                    break;

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
                    break;
            }

            if (!workoutToday.isEmpty()) {
                showingListWorkout(workoutToday, today);
            } else {
                System.out.println("No workout remaining for day" + today + ". Returning...");
                break;
            }
        }

        showingListWorkout(logUser.returnExerciseBasedOnDay(today), today);
        System.out.println();

    }

    public void viewAllExercise() {
        System.out.println();
        if (logUser.getExerciseList().isEmpty()) {
            System.out.println("No exercises in the workout plan.");
        } else {
            System.out.println("Your workout plan:");
            LinkedList<Integer> printedIDs = new LinkedList<>();
            int index = 1;
            for (Exercise ex : logUser.getExerciseList()) {
                if (!printedIDs.contains(ex.getID())) {
                    System.out.println(index + ". " + ex.getName() + " [" + ex.getIntensityCategory() + "]");
                    printedIDs.add(ex.getID());
                    index++;
                }
            }
        }
        System.out.println();
    }
}
