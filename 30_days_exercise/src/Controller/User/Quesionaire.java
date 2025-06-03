package Controller.User;

import java.util.Scanner;

import Class.UsersAccount.Users;

public class Quesionaire {
    private Users logUser;
    private Scanner scan;

    public Quesionaire(Users logUser) {
        this.logUser = logUser;
        scan = new Scanner(System.in);
    }

    public void askingSection() {
        int option = 0;
        int age = 0;
        int selectedGender = 0;
        int activity = 0;
        int workoutTime = 0;
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
        logUser.setRoleName(name);
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
        while (height <= 154.00 && height >= 300.00) {
            try {
                System.out.print("Height (cm): ");
                height = scan.nextDouble();
                scan.nextLine();
                if (height < 154.00) {
                    System.out.println("Minimum height required: 154cm");
                } else if (height > 300.00) {
                    System.out.println("Maximum height required: 300.00");
                }
            } catch (Exception e) {
                System.out.println("Invalid input, please try again!");
                scan.nextLine();
            }
        }
        logUser.setHeight(height);
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
        char affirmation = 'a';
        while (affirmation != 'y' || affirmation != 'n') {
            System.out.print("Do you have work? (y/n): ");
            String affirmationlong = scan.nextLine();
            affirmation = affirmationlong.charAt(0);
            if (affirmation == 'y') {
                logUser.setHaveOccupation(true);
            } else if (affirmation == 'n') {
                logUser.setHaveOccupation(false);
            } else {
                System.out.println("Invalid menu, please try again!");
            }
        }

        System.out.println("\n=== Preferences & Lifestyle ===");
        while (option < 1 || option > 4) {
            try {
                System.out.println("\nHow many days per week are you currently active?");
                System.out.println("1. 1");
                System.out.println("2. 2");
                System.out.println("3. 3");
                System.out.println("4. 4");
                System.out.print("Option: ");
                option = scan.nextInt();
                scan.nextLine();
                if (option < 1 || option > 4) {
                    System.out.println("\nDays selection does NOT exist, try again!\n");
                }
            } catch (Exception e) {
                System.out.println("Invalid input, please try again!");
            }
        }
        switch (option) {
            case 1:
                activity = 1;
                break;

            case 2:
                activity = 2;
                break;

            case 3:
                activity = 3;
                break;

            case 4:
                activity = 4;
                break;
        }
        logUser.setWorkoutDays(activity);
        option = 0;
        while (option < 1 || option > 4) {
            try {
                System.out.println("\nHow long do you prefer your workouts to be?");
                System.out.println("1. <30 minutes");
                System.out.println("2. 30 minutes");
                System.out.println("3. 45 minutes");
                System.out.println("4. 60+ minutes");
                System.out.print("Option: ");
                option = scan.nextInt();
                scan.nextLine();
                if (option < 1 || option > 4) {
                    System.out.println("\nTime selection is not exist, try again!\n");
                }
            } catch (Exception e) {
                System.out.println("Invalid input, please try again!");
                scan.nextLine();
            }
        }
        switch (option) {
            case 1:
                workoutTime = 15;
                break;

            case 2:
                workoutTime = 30;
                break;

            case 3:
                workoutTime = 45;
                break;

            case 4:
                workoutTime = 60;
                break;
        }
        logUser.setWorkoutTime(workoutTime);
        System.out.println("\nQuestions are done! thanks for your time!\n\n");
        logUser.setFirstLogin(false);
        UserPage toUserPage = new UserPage(logUser);
        toUserPage.mainMenu();
    }
}