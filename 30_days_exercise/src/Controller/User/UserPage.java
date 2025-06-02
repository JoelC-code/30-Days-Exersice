package Controller.User;

import java.util.Scanner;

import Class.UsersAccount.Users;

public class UserPage {
    private Scanner scan;
    private Users logUser;

    public UserPage(Users logUser) {
        scan = new Scanner(System.in);
        this.logUser = logUser;
    }

    public void mainMenu() {
        int option;
        String yesno;
        if (logUser.isFirstLogin() == true) {
            System.out.println("===== Questionnaire =====");
            System.out.println("");
            System.out.println("=== Basic Information ===");
            System.out.print("Name: ");
            String name = scan.next() + scan.nextLine();
            logUser.setRoleName(name);
            System.out.print("Age: ");
            int age = scan.nextInt();
            logUser.setAge(age);
            System.out.print("Gender: ");
            String gender = scan.next();
            logUser.setGender(gender);
            System.out.print("Height (cm/in): ");
            double height = scan.nextDouble();
            logUser.setHeight(height);
            System.out.print("Weight (kg/lbs): ");
            double weight = scan.nextDouble();
            logUser.setWeight(weight);
            System.out.print("Occupation (activity level, leave blank if none): ");
            String occupation = scan.next() + scan.nextLine();
            if (occupation != null) {
                logUser.setHaveOccupation(true);
            }
            System.out.println("");

            System.out.println("=== Goals ===");
            System.out.println("What part of the body you want to see the result?");
            System.out.println("1. Upper Body (Arm, Chest and Stomach)");
            System.out.println("2. Lower Body (Legs, Hips, Thigh)");
            System.out.println("3. Both");
            System.out.print("Option: ");
            option = scan.nextInt();
            String bodyPart;
            switch (option) {
                case 1:
                    bodyPart = "Upper Body";
                    break;

                case 2:
                    bodyPart = "Lower Body";
                    break;

                case 3:
                    bodyPart = "Both";
                    break;

                default:
                    bodyPart = "Upper Body";
                    break;
            }
            System.out.println("");

            System.out.println("=== Current Fitness Level ===");
            System.out.println("How would you rate your current fitness level?");
            System.out.println("1. Beginner");
            System.out.println("2. Intermediate");
            System.out.println("3. Advanced");
            System.out.print("Option: ");
            option = scan.nextInt();
            String level;
            switch (option) {
                case 1:
                    level = "Beginner";
                    break;

                case 2:
                    level = "Intermediate";
                    break;

                case 3:
                    level = "Advanced";
                    break;

                default:
                    level = "Beginner";
                    break;
            }
            System.out.println("");
            System.out.println("How many days per week are you currently active?");
            System.out.println("1. 0");
            System.out.println("2. 1-2");
            System.out.println("3.  3-4");
            System.out.println("4. 5+");
            System.out.print("Option: ");
            option = scan.nextInt();
            int activity;
            switch (option) {
                case 1:
                    activity = 0;
                    break;

                case 2:
                    activity = 2;
                    break;

                case 3:
                    activity = 4;
                    break;

                case 4:
                    activity = 5;
                    break;

                default:
                    activity = 0;
                    break;
            }
            System.out.println("");

            System.out.println("=== Preferences & Lifestyle ===");
            System.out.println("How long do you prefer your workouts to be?");
            System.out.println("1. <30 minutes");
            System.out.println("2. 30-45 minutes");
            System.out.println("3. 45-60 minutes");
            System.out.println("4. 60+ minutes");
            System.out.print("Option: ");
            option = scan.nextInt();
            int workoutTime;
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

                default:
                    workoutTime = 15;
                    break;
            }
            System.out.println("");
            System.out.println("What type of workout environment do you prefer?");
            System.out.println("1. Gym");
            System.out.println("2. Home");
            System.out.println("3. Outdoors");
            System.out.println("4. No preference");
            System.out.print("Option: ");
            option = scan.nextInt();
            String environment;
            switch (option) {
                case 1:
                    environment = "Gym";
                    break;

                case 2:
                    environment = "Home";
                    break;

                case 3:
                    environment = "Outdoors";
                    break;

                case 4:
                    environment = "No preference";
                    break;

                default:
                    environment = "No preference";
                    break;
            }
            System.out.println("");

            System.out.println("=== Nutrition ===");
            System.out.println("Are you currently following a specific diet? (Y/N)");
            yesno = scan.next();
            if (yesno.equalsIgnoreCase("y")) {
                System.out.println("What kind of diet?");
                String diet = scan.next() + scan.nextLine();
            }
            System.out.println("");
            System.out.println("Are you interested in receiving nutrition guidance as well? (Y/N)");
            String nutritionGuide = scan.next();
            System.out.println("");
            logUser.setFirstLogin(false);
        }
    }
}
