package Class.UsersAccount;

import java.util.LinkedList;
import java.util.Random;

import Class.ExerciseMove.Exercise;
import Class.Workout.WorkoutCalender;
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
    private LinkedList<Exercise> listExercises;
    private WorkoutPlan[] workoutPlans = new WorkoutPlan[7];
    private WorkoutPlan workoutToday;
    protected WorkoutCalender calendar = new WorkoutCalender();

    public Users(String username, String password, String name, int age, String gender, double height, double weight,
            boolean firstLogin, WorkoutPlan[] workoutPlans) {
        super(username, password);
        calendar.setDate(null);
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
        int today = calendar.getDayOfWeek();
        updateWorkoutToday(today);
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

    public int getTotalOlahraga() {
        return totalOlahraga;
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

    public void updateWorkoutToday(int today) {
        if (workoutPlans != null && workoutPlans[today] != null && workoutPlans[today].getExerciseList() != null) {
            LinkedList<Exercise> copiedList = new LinkedList<>();
            for (Exercise e : workoutPlans[today].getExerciseList()) {
                copiedList.add(new Exercise(e));
            }
            this.workoutToday = new WorkoutPlan(copiedList);
        } else {
            this.workoutToday = new WorkoutPlan(null);
        }
    }

    public String getRoleName() {
        return roleName;
    }

    public boolean getFirstLogin() {
        return firstLogin;
    }

    public WorkoutPlan getWorkoutToday() {
        return workoutToday;
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

    public LinkedList<Exercise> getExerciseList() {
        LinkedList<Exercise> allExercises = new LinkedList<>();
        if (workoutPlans != null) {
            for (WorkoutPlan plan : workoutPlans) {
                if (plan != null && plan.getExerciseList() != null) {
                    allExercises.addAll(plan.getExerciseList());
                }
            }
        }
        return allExercises;
    }

    public void createExercise(int totalExercise, LinkedList<Exercise> allExercises) {
        Random rand = new Random();

        LinkedList<Exercise> lightList = new LinkedList<>();
        LinkedList<Exercise> moderateList = new LinkedList<>();
        LinkedList<Exercise> heavyList = new LinkedList<>();

        for (Exercise ex : allExercises) {
            String intensity = ex.getIntensityCategory().toLowerCase();
            switch (intensity) {
                case "light":
                    lightList.add(ex);
                    break;
                case "moderate":
                    moderateList.add(ex);
                    break;
                case "heavy":
                    heavyList.add(ex);
                    break;
            }
        }

        if (lightList.isEmpty() || moderateList.isEmpty() || heavyList.isEmpty()) {
            System.out
                    .println("Error: Not enough exercise variety. Need at least one of each: Light, Moderate, Heavy.");
            return;
        }

        for (int i = 0; i < 7; i++) {
            WorkoutPlan plan = new WorkoutPlan(totalExercise);
            LinkedList<Exercise> used = new LinkedList<>();

            Exercise l, m, h;

            do {
                l = lightList.get(rand.nextInt(lightList.size()));
            } while (used.contains(l));
            plan.addWorkout(l);
            used.add(l);

            do {
                m = moderateList.get(rand.nextInt(moderateList.size()));
            } while (used.contains(m));
            plan.addWorkout(m);
            used.add(m);

            do {
                h = heavyList.get(rand.nextInt(heavyList.size()));
            } while (used.contains(h));
            plan.addWorkout(h);
            used.add(h);

            while (plan.sizeList() < totalExercise) {
                Exercise selected = allExercises.get(rand.nextInt(allExercises.size()));
                boolean duplicate = false;
                for (Exercise e : used) {
                    if (e.getID() == selected.getID()) {
                        duplicate = true;
                        break;
                    }
                }
                if (!duplicate) {
                    plan.addWorkout(selected);
                    used.add(selected);
                }

                if (used.size() >= allExercises.size())
                    break;
            }

            workoutPlans[i] = plan;
        }
        calendar.setDate(null);
        updateWorkoutToday(calendar.getDayOfWeek());
    }

    public WorkoutPlan returnExerciseBasedOnDay(int selectedDay) {
        int index = (selectedDay % 7) - 1;
        if (index < 0) {
            index = 6;
        }
        WorkoutPlan todayPlan = workoutPlans[index];
        return todayPlan;
    }
}
