package Controller.MainMenu;

import java.util.ArrayList;
import java.util.Scanner;

import Class.ExerciseMove.Exercise;
import Class.UsersAccount.*;
import Controller.Admin.AdminPage;
import Controller.User.Questionnaire;
import Controller.User.UserPage;

import java.util.InputMismatchException;
import java.util.LinkedList;

public class LoginRegister {
    private Scanner scan;
    private ArrayList<Account> listAccounts;
    private LinkedList<Exercise> listExercises;
    public LoginRegister(ArrayList<Account> listAccounts, LinkedList<Exercise> listExercises) {
        scan = new Scanner(System.in);
        this.listAccounts = listAccounts;
        this.listExercises = listExercises;
    }

    public void login() {
        String usernameLog = "";
        String passwordLog = "";

        System.out.println("===== Login Account =====");
        do {
            try {
                System.out.println("Username: ");
                System.out.print("> ");
                usernameLog = scan.nextLine();
                if (usernameLog.isEmpty()) {
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
                if (passwordLog.isEmpty()) {
                    System.out.println("Password can't be empty!");
                }
            } catch (Exception e) {
                System.out.println("Invalid input, please try again!");
                scan.nextLine();
            }
        } while (passwordLog.isEmpty());
        Account fetchedAccount = checkLoginAccount(usernameLog, passwordLog);
        if (fetchedAccount == null) {
            String confirmationTry = "";
            while (!confirmationTry.equalsIgnoreCase("y") && !confirmationTry.equalsIgnoreCase("n")) {
                System.out.println("Account is not found, try again?");
                System.out.println("> ");
                confirmationTry = scan.nextLine();
                if (confirmationTry.equalsIgnoreCase("y")) {
                    login();
                } else if (confirmationTry.equalsIgnoreCase("n")) {
                    return;
                }
                System.out.println("Invalid input, check again (y/n)\n");
            }
        } else {
            if (fetchedAccount instanceof Users) {
                Users selectedUser = (Users) fetchedAccount;
                if (!selectedUser.getFirstLogin()) {
                    UserPage toUserPage = new UserPage(selectedUser);
                    toUserPage.mainMenu();
                } else {
                    Questionnaire toQuestionnaire = new Questionnaire(selectedUser ,listExercises);
                    toQuestionnaire.askingSection();
                }
            }
            if (fetchedAccount instanceof Admin) {
                Admin selectedAdmin = (Admin) fetchedAccount;
                AdminPage toAdminPage = new AdminPage(selectedAdmin, getListAccount(), listExercises);
                toAdminPage.mainMenu();
            }
        }
    }

    public void register() {
        String newUsernameAccount = "";
        String newPasswordAccount = "";
        boolean isValid = false;
        String passwordRegex = "^(?=(?:.*\\d){2})(?=(?:.*[A-Z]){2}).*$";

        System.out.println("===== Register Account =====");
        do {
            try {
                System.out.println("Username account: ");
                System.out.print("> ");
                newUsernameAccount = scan.nextLine();
                if (newUsernameAccount.isEmpty()) {
                    System.out.println("Error: Username must NOT empty, try again!");
                }
            } catch (InputMismatchException ime) {
                System.out.println("Invalid input, try again! [LR-Register-1]");
                scan.nextLine();
            }
        } while (newUsernameAccount.isEmpty());
        do {
            try {
                System.out.println("Password account (2 digits, 2 capitals, 8 letter minimum): ");
                System.out.print("> ");
                newPasswordAccount = scan.nextLine();
                if (newPasswordAccount.isEmpty()) {
                    System.out.println("Error: Username must NOT empty, try again!");
                } else if (newPasswordAccount.length() < 8) {
                    System.out.println("Your password length must above or at 8");
                } else if (!newPasswordAccount.matches(passwordRegex)) {
                    System.out.println("Your password must have 2 digits and 2 capitals");
                } else {
                    isValid = true;
                }
            } catch (InputMismatchException ime) {
                System.out.println("Invalid input, try again! [LR-Register-1]");
                scan.nextLine();
            }
        } while (!isValid);
        listAccounts.add(new Users(newUsernameAccount, newPasswordAccount));
        System.out.println("\n=-=- Account has been made! -=-=\n");
        return;
    }

    public Account checkLoginAccount(String username, String password) {
        for (int i = 0; i < listAccounts.size(); i++) {
            Account selectedAccount = listAccounts.get(i);
            if (selectedAccount.getUsername().equals(username) && selectedAccount.getPassword().equals(password)) {
                return (Account) selectedAccount;
            }
        }
        return null;
    }

    public ArrayList<Account> getListAccount() {
        return listAccounts;
    }
}
