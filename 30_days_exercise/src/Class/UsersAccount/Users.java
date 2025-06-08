package Class.UsersAccount;

import java.util.LinkedList;

import Class.ExerciseMove.Exercise;
import Class.Workout.WorkoutPlan;
import Controller.MainMenu.*;

public class Users extends Account {
    private int age;
    private String gender;
    private double height, weight;
    private String roleName;
    private boolean firstLogin;
    private int exerciseException;
    private WorkoutPlan[] weeklyPlans = new WorkoutPlan[7];
    private LinkedList<Exercise> listExercises;

    public Users(String username, String password, int age, String gender, double height, double weight, boolean firstLogin, int exerciseException) {
        super(username, password);
        this.age = age;
        this.gender = gender;
        this.height = height;
        this.weight = weight;
        this.firstLogin = firstLogin;
        this.roleName = "User";
        this.exerciseException = exerciseException;
    }

    public Users(String username, String password, String roleName) {
        super(username, password);
        this.age = 0;
        this.gender = "Non-Binary";
        this.height = 0;
        this.weight = 0;
        this.firstLogin = true;
        this.roleName = roleName;
        this.exerciseException = 2;
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

    public int getExerciseException() {
        return exerciseException;
    }
    public void setExerciseException(int exerciseException) {
        this.exerciseException = exerciseException;
    }

    public void createExercise(int totalExercise) {
        for(int i = 0; i < 7; i++) {
            weeklyPlans[i] = new WorkoutPlan(totalExercise);
        }
    }
}
