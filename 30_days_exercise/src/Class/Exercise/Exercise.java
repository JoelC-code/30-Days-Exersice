package Class.Exercise;

public class Exercise {
    private int ID, calorieTotal, repExercise, setExercise, secondsExercise;
    private String name;
    private static int amount = 1;

    public Exercise(String name, int calorieTotal, int repExercise, int setExercise, int secondsExercise){
        this.name = name;
        this.calorieTotal = calorieTotal;
        this.repExercise = repExercise;
        this.setExercise = setExercise;
        this.ID = amount++;
        this.secondsExercise = secondsExercise;
    }

    public int getID(){
        return ID;
    }

    public String getName(){
        return name;
    }

    public void setCalorieTotal(int calorieTotal) {
        this.calorieTotal = calorieTotal;
    }
    public int getCalorieTotal(){
        return calorieTotal;
    }

    public void setRepExercise(int repExercise) {
        this.repExercise = repExercise;
    }
    public int getRepExercise(){
        return repExercise;
    }

    public void setSetExercise(int setExercise) {
        this.setExercise = setExercise;
    }
    public int getSetExercise(){
        return setExercise;
    }

    public int getSecondsExercise() {
        return secondsExercise;
    }
    public void setSecondsExercise(int secondsExercise) {
        this.secondsExercise = secondsExercise;
    }

}
