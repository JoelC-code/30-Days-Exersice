package Class.ExerciseMove;

public class Exercise {
    private int ID, repExercise, setExercise, secondsExercise;
    private double calorieTotal;
    private String name, intensityCategory, Description;
    private static int amount = 1;

    public Exercise(String name, double calorieTotal, int repExercise, int setExercise, int secondsExercise, String intensityCategory, String Description){
        this.name = name;
        this.calorieTotal = calorieTotal;
        this.repExercise = repExercise;
        this.setExercise = setExercise;
        this.ID = amount++;
        this.secondsExercise = secondsExercise;
        this.intensityCategory = intensityCategory;
        this.Description = Description;
    }

    public int getID(){
        return ID;
    }

    public String getName(){
        return name;
    }

    public void setCalorieTotal(double calorieTotal) {
        this.calorieTotal = calorieTotal;
    }
    public double getCalorieTotal(){
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

    public String getIntensityCategory() {
        return intensityCategory;
    }
    public void setIntensityCategory(String intensityCategory) {
        this.intensityCategory = intensityCategory;
    }

    public String getDescription() {
        return Description;
    }
    public void setDescription(String description) {
        Description = description;
    }
}
