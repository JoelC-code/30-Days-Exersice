package Class.Workout;

import java.util.LinkedList;

import Class.ExerciseMove.Exercise;

public class WorkoutPlan {
    private LinkedList<Exercise> exerciseList = new LinkedList<>();

    public WorkoutPlan(int selectedDay, LinkedList<Exercise> exerciseList, boolean isDone) {
        this.exerciseList = exerciseList;
    }


    public void addWorkout(Exercise newWorkout) {
        if(newWorkout instanceof Exercise) {
            exerciseList.add(newWorkout);
        } else {
            throw new IllegalArgumentException("Something went wrong. When you want to add a workout, call Customer Service (Err:WP-1)");
        }
    }

    public Exercise deleteWorkout() {
        if(!exerciseList.isEmpty()) {
            return exerciseList.removeFirst();
        } else {
            System.out.println("Your exercise is done!");
            return null;
        }
    }

    public Exercise checkFirst() {
        if(!exerciseList.isEmpty()) {
            return exerciseList.getFirst();
        } else {
            System.out.println("-");
            return null;
        }
    }

    public boolean isEmpty () {
        return exerciseList.isEmpty();
    }

    public int sizeList() {
        return exerciseList.size();
    }

    public String getExerciseAt(int index){
        return exerciseList.get(index).getName();
    }
}
