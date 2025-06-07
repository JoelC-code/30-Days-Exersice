package Controller.User;

import Class.UsersAccount.Users;
import Class.Workout.WorkoutCalender;

public class ExerciseManager {
    private Users logUser;

    public ExerciseManager(Users logUser) {
        this.logUser = logUser;
    }

    public void viewCalender() {
        WorkoutCalender wc = new WorkoutCalender();
        wc.setDate(null);
        System.out.println(wc.getFormattedDate());
        wc.displayDaysInMonth();
    }

    public void viewToday() {

    }

    public void viewAllExercise() {
        
    }
}
