package Class.UsersAccount;

import java.util.LinkedList;
import java.util.Random;

import Class.ExerciseMove.Exercise;
import Class.Workout.WorkoutPlan;

public class Users extends Account {
    private int age;
    private String gender;
    private double height, weight;
    private String roleName;
    private boolean firstLogin;
    private int exerciseException;
    private WorkoutPlan[] weeklyPlans = new WorkoutPlan[7];

    public Users(String username, String password, int age, String gender, double height, double weight,
            boolean firstLogin, int exerciseException) {
        super(username, password);
        this.age = age;
        this.gender = gender;
        this.height = height;
        this.weight = weight;
        this.firstLogin = firstLogin;
        this.roleName = "User";
        this.exerciseException = exerciseException;
    }

    public Users(String username, String password) {
        super(username, password);
        this.age = 0;
        this.gender = "Non-Binary";
        this.height = 0;
        this.weight = 0;
        this.firstLogin = true;
        this.roleName = "User";
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
        this.roleName = "User";
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

    public void createExercise(int totalExercise, LinkedList<Exercise> allExercises) {
        Random rand = new Random();
        for (int i = 0; i < 7; i++) {
            WorkoutPlan plan = new WorkoutPlan(totalExercise);

            boolean hasLight = false;
            boolean hasModerate = false;
            boolean hasHeavy = false;

            while (plan.sizeList() < totalExercise) {
                Exercise selectedExercise = allExercises.get(rand.nextInt(allExercises.size()));

                boolean notDuplicate = true;
                for (Exercise e : plan.getExerciseList()) {
                    if (e.getID() == selectedExercise.getID()) {
                        notDuplicate = false;
                    }
                }
                if (notDuplicate)
                    continue;

                String intensity = selectedExercise.getIntensityCategory().toLowerCase();

                if (!hasLight && intensity.equals("light")) {
                    plan.addWorkout(selectedExercise);
                    hasLight = true;
                } else if (!hasModerate && intensity.equals("moderate")) {
                    plan.addWorkout(selectedExercise);
                    hasModerate = true;
                } else if (!hasHeavy && intensity.equals("heavy")) {
                    plan.addWorkout(selectedExercise);
                    hasHeavy = true;
                } else if (hasLight && hasModerate & hasHeavy) {
                    plan.addWorkout(selectedExercise);
                }
            }
            weeklyPlans[i] = plan;
        }
    }

    public void returnExerciseBasedOnDay(int selectedDay) {
        WorkoutPlan todayPlan = weeklyPlans[selectedDay % 7];
        int arraySize = todayPlan.sizeList();
        for(int i = 0; i < arraySize; i++) {
            Exercise exerciseSelected = todayPlan.getExerciseAt(i);
            System.out.println((1+i)+". "+exerciseSelected.getName());
        }
    }
}
