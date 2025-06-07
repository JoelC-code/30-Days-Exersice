package Class.UsersAccount;

import java.util.LinkedList;

import Class.ExerciseMove.Exercise;
import Class.Workout.WorkoutPlan;

public class Users extends Account {
    private int age;
    private String gender;
    private double height, weight;
    private String roleName;
    private boolean firstLogin;
    private WorkoutPlan workoutPlan;

    public Users(String username, String password, int age, String gender, double height, double weight, boolean firstLogin) {
        super(username, password);
        this.age = age;
        this.gender = gender;
        this.height = height;
        this.weight = weight;
        this.firstLogin = firstLogin;
        this.roleName = "User";
    }

    public Users(String username, String password, String roleName) {
        super(username, password);
        this.age = 0;
        this.gender = "Non-Binary";
        this.height = 0;
        this.weight = 0;
        this.firstLogin = true;
        this.roleName = roleName;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    public double getHeight() {
        return height;
    }

    public double getWeight() {
        return weight;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }
    
    public void setRoleName(String roleName) {
        this.roleName = "Admin";
    }

    public String getRoleName() {
        return roleName;
    }

    public boolean getFirstLogin() {
        return firstLogin;
    }

    public void setFirstLogin(boolean firstLogin) {
        this.firstLogin = firstLogin;
    }

    public void assignExercise(LinkedList<Exercise> selectedExercises) {
        if (workoutPlan == null) {
            workoutPlan = new WorkoutPlan(1, selectedExercises, false);
        } else {
            for (Exercise e : selectedExercises) {
                workoutPlan.addWorkout(e);
            }
        }
    }
}
