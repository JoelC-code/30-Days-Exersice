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
        WorkoutPlan selectedWorkoutDay = logUser.returnExerciseBasedOnDay(selectedDay - 1);
        showingListWorkout(selectedWorkoutDay, selectedDay);
    }

    public void showingListWorkout(WorkoutPlan selectedDay, int day) {
        System.out.println("Upcoming exercise on day "+day);
        int arraySize = selectedDay.sizeList();
        for(int i = 0; i < arraySize; i++) {
            Exercise selectedExercise = selectedDay.getExerciseAt(i);
            System.out.println((1+i)+". "+selectedExercise.getName());
        }
    }

    public void viewToday() {

    }

    public void viewAllExercise() {
        if (logUser.getExerciseList().isEmpty()) {
            System.out.println("No exercises in the workout plan.");
        } else {
            System.out.println("Your workout plan:");
            printExerciseRecursive(0);
        }
    }

    private void printExerciseRecursive(int index) {
        if (index >= logUser.getExerciseList().size()) {
            return;
        }
        System.out.println((index + 1) + ". " + logUser.getExerciseList().get(index).getName());
        printExerciseRecursive(index + 1);
    }
}
