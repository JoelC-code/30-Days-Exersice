package Class.ExerciseMove;

public class Exercise {
    private int ID, repExercise, setExercise;
    private double calorieTotal, secondsExercise;
    private String name, intensityCategory, Description;
    private static int amount = 1;

    public Exercise(String name, double baseCalorie, int repExercise, int setExercise, double secondsExercise, String Description){
        this.name = name;
        this.repExercise = repExercise;
        this.setExercise = setExercise;
        this.calorieTotal = baseCalorie * repExercise * setExercise * (secondsExercise / 60);
        this.ID = amount++;
        this.secondsExercise = secondsExercise;
        this.intensityCategory = getIntensityCategory();
        this.Description = Description;
    }

    public int getID(){
        return ID;
    }

    public String getName(){
        return name;
    }
    public void setName(String name) {
        this.name = name;
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
        return (int) secondsExercise;
    }

    public void setSecondsExercise(int secondsExercise) {
        this.secondsExercise = secondsExercise;
    }

    public String getIntensityCategory() {
        return intensityCategory;
    }
    public void setIntensityCategory(String intensityCategory) {
        int volumeTotal = this.repExercise * this.setExercise;

        if (volumeTotal <= 40) {
            intensityCategory = "Light";
        } else if (volumeTotal <= 70) {
            intensityCategory = "Moderate";
        } else {
            intensityCategory = "Heavy";
        }    }

    public String getDescription() {
        return Description;
    }
    public void setDescription(String description) {
        Description = description;
    }
}
