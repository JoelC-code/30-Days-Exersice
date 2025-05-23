package Class.UsersAccount;

public class Admin extends Account{
    private String roleName;
    public Admin(String username, String password){
        super(username, password);
    }

    @Override
    public void setRoleName(String roleName) {
        this.roleName = "Admin";
    }

    @Override
    public String getRoleName() {
        return roleName;
    }
}
