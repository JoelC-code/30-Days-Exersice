package Class.Workout;

import java.util.LinkedList;

import Class.Exercise.Exercise;

public class WorkoutPlan implements WorkoutQueue {
    private LinkedList<Exercise> exerciseList = new LinkedList<>();
    private int selectedDay;
    private boolean isDone;

    public WorkoutPlan(int selectedDay, LinkedList<Exercise> exerciseList, boolean isDone) {
        this.exerciseList = exerciseList;
        this.selectedDay = selectedDay;
        this.isDone = isDone;
    }


    @Override
    public void addWorkout(Exercise newWorkout) {
        if(newWorkout instanceof Exercise) {
            exerciseList.add(newWorkout);
        } else {
            throw new IllegalArgumentException("Something went wrong when you want to add a workout (Err:WP-1)");
        }
    }

    @Override
    public Exercise deleteWorkout() {
        if(!exerciseList.isEmpty()) {
            return exerciseList.removeFirst();
        } else {
            System.out.println("Your exercise is done!");
            return null;
        }
    }

    @Override
    public Exercise checkFirst() {
        if(!exerciseList.isEmpty()) {
            return exerciseList.getFirst();
        } else {
            System.out.println("-");
            return null;
        }
    }

    @Override
    public boolean isEmpty () {
        return exerciseList.isEmpty();
    }

    public int sizeList() {
        return exerciseList.size();
    }

        public int getSelectedDay() {
        return selectedDay;
    }
    public void setSelectedDay(int selectedDay) {
        this.selectedDay = selectedDay;
    }

    public boolean isDone() {
        return isDone;
    }
    public void setDone(boolean isDone) {
        this.isDone = isDone;
    }
}
