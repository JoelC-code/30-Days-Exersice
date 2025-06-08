package Class.Workout;

import java.util.LinkedList;

import Class.ExerciseMove.Exercise;

public class WorkoutPlan {
    private LinkedList<Exercise> exerciseList = new LinkedList<>();
    private int maxTotal;

    public int getMaxTotal() {
        return maxTotal;
    }

    public void setMaxTotal(int maxTotal) {
        this.maxTotal = maxTotal;
    }

    public WorkoutPlan(int maxTotal) {
        this.maxTotal = maxTotal;
    }

    public WorkoutPlan(LinkedList<Exercise> exerciseList, int maxTotal) {
        this.exerciseList = exerciseList;
        this.maxTotal = maxTotal;
    }

    public void addWorkout(Exercise newWorkout) {
        if (newWorkout instanceof Exercise) {
            exerciseList.add(newWorkout);
        } else {
            throw new IllegalArgumentException(
                    "Something went wrong. When you want to add a workout, call Customer Service (Err:WP-1)");
        }
    }

    public Exercise deleteWorkout() {
        if (!exerciseList.isEmpty()) {
            return exerciseList.removeFirst();
        } else {
            System.out.println("Your exercise is done!");
            return null;
        }
    }

    public Exercise checkFirst() {
        if (!exerciseList.isEmpty()) {
            return exerciseList.getFirst();
        } else {
            System.out.println("-");
            return null;
        }
    }

    public boolean isEmpty() {
        return exerciseList.isEmpty();
    }

    public int sizeList() {
        return exerciseList.size();
    }

    public Exercise getExerciseAt(int index) {
        if (index >= 0 && index < exerciseList.size()) {
            return exerciseList.get(index);
        } else {
            return null;
        }
    }
    public LinkedList<Exercise> getExerciseList(){
        return exerciseList;
    }
}
