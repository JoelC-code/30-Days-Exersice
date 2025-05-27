package Class.Workout;

import Class.ExerciseMove.*;

public interface WorkoutQueue {
    public void addWorkout(Exercise e);
    public Exercise deleteWorkout();
    public Exercise checkFirst();
    public boolean isEmpty();
    public int sizeList();
}
