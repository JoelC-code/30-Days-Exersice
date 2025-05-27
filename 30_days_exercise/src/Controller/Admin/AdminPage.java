package Controller.Admin;
import java.util.ArrayList;
import java.util.Scanner;

import Class.UsersAccount.Account;
import Class.UsersAccount.Admin;

public class AdminPage {
    private Scanner scan;
    private Admin logAdmin;
    private ArrayList<Account> listUser;

    public AdminPage(Admin logAdmin, ArrayList<Account> listUser) {
        scan = new Scanner(System.in);
        this.logAdmin = logAdmin;
        this.listUser = listUser;
    }

    public void mainMenu() {
        int selectedMenu = 0;
        boolean isValid = false;
        System.out.println("Login is done, welcome admin "+logAdmin.getUsername());
        System.out.println("Menu:");
        System.out.println("1. Add Exercise");
        System.out.println("2. Update Exercise");
        System.out.println("3. Delete Exercise");
        System.out.println("4. View All Exercise");
        System.out.println("5. View All Users");
        System.out.println("0. Logout");
        while (!isValid) {
            try {
                System.out.print("> ");
                selectedMenu = scan.nextInt();
                scan.nextLine();
                if(selectedMenu >= 0 && selectedMenu <= 5) {
                    isValid = true;
                } else {
                    System.out.println("Menu doesn't exist, try again!");
                }
            } catch (Exception e) {
                System.out.println("Invalid input, please try again!");
                scan.nextLine();
            }
        }
        AdminSystem toSystemAdmin = new AdminSystem(listUser);
        switch (selectedMenu) {
            case 1:
                toSystemAdmin.addingExercise();
                break;
            case 2:
                toSystemAdmin.updateExercise();
                break;
            case 3:
                toSystemAdmin.deleteExercise();
                break;
            case 4:
                toSystemAdmin.viewAllExercise();
                break;
            case 5:
                toSystemAdmin.viewAllUsername();
                break;
            case 0:
                return;
        }
    }
}
