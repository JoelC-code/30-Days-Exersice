package Class.UsersAccount;

public class Users extends Account{
    private int age;
    private String gender;
    private double height, weight;
    private boolean haveOccupation;
    private String roleName;
    private boolean firstLogin;
    public Users(String username, String password, int age, String gender, double height, double weight, boolean haveOccupation, boolean firstLogin){
        super(username, password);
        this.age = age;
        this.gender = gender;
        this.height = height;
        this.weight = weight;
        this.haveOccupation = haveOccupation;
        this.firstLogin = firstLogin;
        this.roleName = "User";
    }
    public Users(String username, String password, String roleName){
        super(username, password);
        this.age = 0;
        this.gender = "Non-Binary";
        this.height = 0;
        this.weight = 0;
        this.haveOccupation = false;
        this.firstLogin = true;
        this.roleName = roleName;
    }
    public void setAge(int age) {
        this.age = age;
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

    public void setRoleName(String roleName) {
        this.roleName = "Admin";
    }
    public String getRoleName() {
        return roleName;
    }

    public boolean getFirstLogin() {
        return firstLogin;
    }
    public void setFirstLogin(boolean firstLogin) {
        this.firstLogin = firstLogin;
    }
}
