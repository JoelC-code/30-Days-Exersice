package Class.UsersAccount;

public abstract class Account {
    protected String username, password;
    protected int ID;
    // Agar bisa nambah tanpa membuat element baru, diberi static
    protected static int amount = 1;
    public Account (String username, String password){
        this.username = username;
        this.password = password;
        this.ID = amount++;
    }

    public int getID(){
        return ID;
    }
    public String getUsername(){
        return username;
    }
    public void setUsername(String username){
        this.username = username;
    }

    public void setPassword(String password){
        this.password = password;
    }
    public String getPassword() {
        return password;
    }

    public abstract void setRoleName(String roleName);
    public abstract String getRoleName();
}

