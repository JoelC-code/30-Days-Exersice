package Class.Exercise;
import java.util.ArrayList;
public class WorkoutPlan {
    private ArrayList<Exercise> exercise;

    public WorkoutPlan(ArrayList<Exercise> exercises) {
        exercise = new ArrayList<>();
    }
    
    public ArrayList<Exercise> getExercise() {
        return exercise;
    }
    public void setExercise(ArrayList<Exercise> exercise) {
        this.exercise = exercise;
    }
}
