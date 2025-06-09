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
        WorkoutPlan selectedWorkoutDay = logUser.returnExerciseBasedOnDay(selectedDay);
        showingListWorkout(selectedWorkoutDay, selectedDay);
    }

    public void showingListWorkout(WorkoutPlan selectedDay, int day) {

        if (selectedDay == null || selectedDay.isEmpty()) {
            System.out.println("There's no workout planned in day " + day + "!");
        } else {
            System.out.println("Exercise on day " + day);
            int arraySize = selectedDay.sizeList();
            for (int i = 0; i < arraySize; i++) {
                Exercise selectedExercise = selectedDay.getExerciseAt(i);
                System.out.println((1 + i) + ". " + selectedExercise.getName());
            }

        System.out.println();
        if (selectedDay == null) {
            System.out.println("There's no workout planned in day " + day + "!");
        }
        else{
        System.out.println("Exercise on day " + day);
        int arraySize = selectedDay.sizeList();
        for (int i = 0; i < arraySize; i++) {
            Exercise selectedExercise = selectedDay.getExerciseAt(i);
            System.out.println((1 + i) + ". " + selectedExercise.getName());
        
        }
        System.out.println();

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
            System.out.println();
            showingListWorkout(workoutToday, today);
            System.out.println("Apa yang ingin anda lakukan hari ini?");
            System.out.println("1. Melakukan work-out");
            System.out.println("2. Beristirahat untuk hari ini");
            System.out.println("0. Kembali");
            System.out.print("> ");
            options = scan.nextInt();

            switch (options) {
                case 0:
                    System.out.println("Kembali...");
                    break;

                case 1:
                    workoutToday.deleteWorkout();
                    break;

                case 2:
                    workoutToday.deleteAll();
                    break;

                default:
                    System.out.println("Invalid input, try again!");
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
            printExerciseRecursive(0);
        }
        System.out.println();
    }

    private void printExerciseRecursive(int index) {
        if (index >= logUser.getExerciseList().size()) {
            return;
        }
        System.out.println((index + 1) + ". " + logUser.getExerciseList().get(index).getName()+" ["+logUser.getExerciseList().get(index).getIntensityCategory()+"]");
        printExerciseRecursive(index + 1);
    }
}
