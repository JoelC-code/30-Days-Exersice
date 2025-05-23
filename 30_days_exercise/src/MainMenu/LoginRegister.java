package MainMenu;
import java.util.ArrayList;
import java.util.Scanner;

import Class.UsersAccount.*;

import java.util.InputMismatchException;

public class LoginRegister {
    private Scanner scan;
    private ArrayList<Account> listUser;

    public LoginRegister () {
        scan = new Scanner(System.in);
        listUser = new ArrayList<>();
    }

    public void login(){
        String usernameLog = "";
        String passwordLog = "";

        System.out.println("===== Login Account =====");
        do {
            try {
                System.out.println("Username: ");
                System.out.print("> ");
                usernameLog = scan.nextLine();
                if(usernameLog.isEmpty()) {
                    System.out.println("Username can't be empty!");
                }
            } catch (Exception e) {
                System.out.println("Invalid input, please try again!");
                scan.nextLine();
            }
        } while (usernameLog.isEmpty());
        do {
            try {
                System.out.println("Password: ");
                System.out.print("> ");
                passwordLog = scan.nextLine();
                if(passwordLog.isEmpty()) {
                    System.out.println("Password can't be empty!");
                }
            } catch (Exception e) {
                System.out.println("Invalid input, please try again!");
                scan.nextLine();
            }
        } while (passwordLog.isEmpty()); 
        Users fetchedAccount = checkLoginAccount(usernameLog, passwordLog);
        if(fetchedAccount == null) {
            
        }
    }

    public void register(){
        String newUsernameAccount = "";
        String newPasswordAccount = "";
        String passwordRegex = "^(?=(?:.*\\d){2})(?=(?:.*[A-Z]){2}).*$";

        System.out.println("===== Register Account =====");
        do {
            try {
                System.out.println("Username account: ");
                System.out.print("> ");
                newUsernameAccount = scan.nextLine();
                if(newUsernameAccount.isEmpty()) {
                    System.out.println("Error: Username must NOT empty, try again!");
                }
            } catch (InputMismatchException ime) {
                System.out.println("Invalid input, try again! [LR-Register-1]");
                scan.nextLine();
            }
        } while (newUsernameAccount.isEmpty());
        do {
            try {
                System.out.println("Password account (2 Digits & 2 Capitals): ");
                System.out.print("> ");
                newPasswordAccount = scan.nextLine();
                if(newPasswordAccount.isEmpty()) {
                    System.out.println("Error: Username must NOT empty, try again!");
                } else if (newPasswordAccount.length() < 8) {
                    System.out.println("Your password lenght must above or at 8");
                } else if (newPasswordAccount.length() < 8 && newPasswordAccount.matches(passwordRegex)) {
                    System.out.println("Your password must have 2 digits and 2 capitals");
                }
            } catch (InputMismatchException ime) {
                System.out.println("Invalid input, try again! [LR-Register-1]");
                scan.nextLine();
            }
        } while (newPasswordAccount.isEmpty() && newPasswordAccount.length() < 8 && newPasswordAccount.matches(passwordRegex));
        listUser.add(new Users(newUsernameAccount, newPasswordAccount));
        System.out.println("\n=-=- Account has been made! -=-=\n");
        return;
    }

    public Users checkLoginAccount(String username, String password) {
        for(int i = 0; i < listUser.size(); i++) {
            Account selectedAccount = listUser.get(i);
            if(selectedAccount.getUsername().equals(username) && selectedAccount.getPassword().equals(password)) {
                return (Users) selectedAccount;
            }
        }
        return null;
    }
}
