package Class.UsersAccount;

public class Admin extends Account{
    private String roleName;
    public Admin(String username, String password, String roleName){
        super(username, password);
        this.roleName = roleName;
    }
    
    public String getRoleName() {
        return roleName;
    }
    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
}
