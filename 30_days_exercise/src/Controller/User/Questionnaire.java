package Controller.User;

import java.util.LinkedList;
import java.util.Scanner;

import Class.ExerciseMove.Exercise;
import Class.UsersAccount.Users;

public class Questionnaire {
    private Users logUser;
    private Scanner scan;
    private LinkedList<Exercise> allExercises;

    public Questionnaire(Users logUser, LinkedList<Exercise> allExercises) {
        this.logUser = logUser;
        this.scan = new Scanner(System.in);
        this.allExercises = allExercises;
    }

    public void askingSection() {
        int age = 0;
        int jumlahExercise = 0;
        int selectedGender = 0;
        double height = 0;
        double weight = 0;
        String name = "";
        String gender = "";
        System.out.println("===== Questionnaire =====");
        System.out.println("");
        while (name.isEmpty()) {
            System.out.print("Name: ");
            name = scan.nextLine().trim();
            if (name.isEmpty()) {
                System.out.println("You must have a username!");
            }
        }
        logUser.setUsername(name);
        while (age <= 0) {
            try {
                System.out.print("Age: ");
                age = scan.nextInt();
                scan.nextLine();
            } catch (Exception e) {
                System.out.println("Invalid input, please try again");
                scan.nextLine();
            }
        }
        logUser.setAge(age);
        while (selectedGender < 1 || selectedGender > 3) {
            try {
                System.out.println("Gender: ");
                System.out.println("1. Male");
                System.out.println("2. Female");
                System.out.println("3. Non-Binary");
                System.out.print("Option: ");
                selectedGender = scan.nextInt();
                scan.nextLine();
                if (selectedGender < 1 || selectedGender > 3) {
                    System.out.println("Invalid menu, please try again!");
                }
            } catch (Exception e) {
                System.out.println("Invalid input, please try again!");
                scan.nextLine();
            }
        }
        switch (selectedGender) {
            case 1:
                gender = "Male";
                break;
            case 2:
                gender = "Female";
                break;
            case 3:
                gender = "Non-Binary";
                break;
        }
        logUser.setGender(gender);
        while (height < 154) {
            try {
                System.out.print("Height (cm) [Min: 154cm]: ");
                height = scan.nextDouble();
                scan.nextLine();
                if (height < 154.00) {
                    System.out.println("Minimum height required: 154cm");
                }
            } catch (Exception e) {
                System.out.println("Invalid input, please try again!");
                scan.nextLine();
            }
        }
        logUser.setHeight(height);
        while (weight <= 45) {
            try {
                System.out.print("Weight (kg) [min: 45kg]: ");
                weight = scan.nextDouble();
                scan.nextLine();
                if (weight < 45) {
                    System.out.println("Weight canot below 45kg");
                }
            } catch (Exception e) {
                System.out.println("Invalid input, please try again!");
                scan.nextLine();
            }
        }
        while (weight <= 45) {
            try {
                System.out.print("Weight (kg): ");
                weight = scan.nextDouble();
                scan.nextLine();
                if (weight < 45) {
                    System.out.println("Weight canot below 45kg");
                }
            } catch (Exception e) {
                System.out.println("Invalid input, please try again!");
                scan.nextLine();
            }
        }
        logUser.setWeight(weight);
        while (jumlahExercise < 3) {
            try {
                System.out.print("Exercise wanted [Min: 3]: ");
                jumlahExercise = scan.nextInt();
                scan.nextLine();
                if (jumlahExercise < 3) {
                    System.out.println("Exercise cannot under 3");
                }
            } catch (Exception e) {
                System.out.println("Invalid input, please try again!");
                scan.nextLine();
            }
        }
        logUser.createExercise(jumlahExercise, allExercises);
        System.out.println("\nQuestions are done! Thank you for your time!\n\n");
        logUser.setFirstLogin(false);
        UserPage toUserPage = new UserPage(logUser);
        toUserPage.mainMenu();
    }
}