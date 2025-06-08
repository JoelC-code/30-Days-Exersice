package Class.UsersAccount;

import java.util.LinkedList;
import java.util.Random;

import Class.ExerciseMove.Exercise;
import Class.Workout.WorkoutPlan;

public class Users extends Account {
    private String name;
    private int age;
    private String gender;
    private double height, weight;
    private String roleName;
    private boolean firstLogin;
    private int totalOlahraga;
    private int exerciseException;
    private WorkoutPlan[] workoutPlans;
    private LinkedList<Exercise> listExercises;

    private WorkoutPlan[] weeklyPlans = new WorkoutPlan[7];

    public Users(String username, String password, String name, int age, String gender, double height, double weight,boolean firstLogin, WorkoutPlan[] workoutPlans) {
        super(username, password);
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.height = height;
        this.weight = weight;
        this.firstLogin = firstLogin;
        this.roleName = "User";
        this.workoutPlans = workoutPlans;
        this.listExercises = getExerciseList();
        this.totalOlahraga = listExercises.size();
    }

    public Users(String username, String password) {
        super(username, password);
        this.name = "John Doe";
        this.age = 0;
        this.gender = "Non-Binary";
        this.height = 0;
        this.weight = 0;
        this.firstLogin = true;
        this.roleName = "User";
        this.exerciseException = 2;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
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
        this.roleName = "Users";
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

    public void setTotalOlahraga(int totalOlahraga) {
        this.totalOlahraga = totalOlahraga;
    }

    public void setExerciseException(int exerciseException) {
        this.exerciseException = exerciseException;
    }

    public void createExercise(int totalExercise) {
        for (int i = 0; i < 7; i++) {
            this.workoutPlans[i] = new WorkoutPlan(totalExercise);
        }
    }

    public LinkedList<Exercise> getExerciseList() {
        LinkedList<Exercise> allExercises = new LinkedList<>();
        if (workoutPlans != null) {
            for (WorkoutPlan plan : workoutPlans) {
                if (plan != null && plan.getExerciseList() != null) {
                    allExercises.addAll(plan.getExerciseList());
                }
            }
    public void createExercise(int totalExercise, LinkedList<Exercise> allExercises) {
        Random rand = new Random();
        for(int i = 0; i < 7; i++) {
            WorkoutPlan plan = new WorkoutPlan(totalExercise);

            boolean hasLight = false;
            boolean hasModerate = false;
            boolean hasHeavy = false;

            while(plan.sizeList() < totalExercise) {
                Exercise selectedExercise = allExercises.get(rand.nextInt(allExercises.size()));

                boolean notDuplicate = true;
                for (Exercise e : plan.getExerciseList()) {
                    if(e.getID() == selectedExercise.getID()) {
                        notDuplicate = false;
                    }
                }
                if(notDuplicate) continue;

                String intensity = selectedExercise.getIntensityCategory().toLowerCase();

                if(!hasLight && intensity.equals("light")) {
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
        return allExercises;
    }
}
