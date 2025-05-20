package Class.Account;

public class Users extends Account{
    private int age;
    private String gender;
    private double height, weight;
    private boolean haveOccupation;
    public Users(String username, String password, int age, String gender, double height, double weight, boolean haveOccupation){
        super(username, password);
        this.age = age;
        this.gender = gender;
        this.height = height;
        this.weight = weight;
        this.haveOccupation = haveOccupation;
    }

    public int getAge(){
        return age;
    }

    public String getGender(){
        return gender;
    }

    public double getHeight(){
        return height;
    }

    public double getWeight(){
        return weight;
    }

    public boolean getHaveOccupation(){
        return haveOccupation;
    }

}
