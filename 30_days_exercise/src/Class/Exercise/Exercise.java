package Class.Exercise;

public class Exercise {
    private int ID, calorieTotal, rep, set;
    private String name;
    private static int amount = 1;

    public Exercise(String name, int calorieTotal, int rep, int set){
        this.name = name;
        this.calorieTotal = calorieTotal;
        this.rep = rep;
        this.set = set;
        this.ID = amount++;
    }

    public int getID(){
        return ID;
    }

    public String getName(){
        return name;
    }

    public int getCalorieTotal(){
        return calorieTotal;
    }

    public int getRep(){
        return rep;
    }

    public int getSet(){
        return set;
    }

}
