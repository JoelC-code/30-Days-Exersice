package Controller.Admin;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

import Class.ExerciseMove.Exercise;
import Class.UsersAccount.Account;
import Class.UsersAccount.Admin;

public class AdminPage {
    private Scanner scan;
    private Admin logAdmin;
    private ArrayList<Account> listUser;
    private LinkedList<Exercise> listExercises;

    public AdminPage(Admin logAdmin, ArrayList<Account> listUser, LinkedList<Exercise> listExercises) {
        scan = new Scanner(System.in);
        this.logAdmin = logAdmin;
        this.listUser = listUser;
        this.listExercises = listExercises;
    }

    public void mainMenu() {
        int selectedMenu = -1;
        System.out.println("Login is done, Welcome " + logAdmin.getUsername());
        AdminSystem toSystemAdmin = new AdminSystem(listUser, listExercises);
        while (selectedMenu != 0) {
            System.out.println("\nMenu:");
            System.out.println("1. Add Exercise");
            System.out.println("2. Update Exercise");
            System.out.println("3. Delete Exercise");
            System.out.println("4. View All Exercise");
            System.out.println("5. View All Users");
            System.out.println("0. Logout");
            try {
                System.out.print("> ");
                selectedMenu = scan.nextInt();
                scan.nextLine();
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
            } catch (Exception e) {
                System.out.println("Invalid input, please try again!");
                scan.nextLine();
            }
        }
    }

}
