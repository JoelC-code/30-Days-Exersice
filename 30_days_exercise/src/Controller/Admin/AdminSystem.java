package Controller.Admin;

import java.util.ArrayList;
import java.util.Scanner;

import Class.ExerciseMove.Exercise;
import Class.UsersAccount.Account;
import Class.UsersAccount.Admin;

public class AdminSystem {
    private ArrayList<Account> listUserAccount;
    private ArrayList<Exercise> listExercise;
    private Scanner scan;

    public AdminSystem(ArrayList<Account> listUserAccount) {
        this.listUserAccount = listUserAccount;
        scan = new Scanner(System.in);
    }

    // String name, int calorieTotal, int repExercise, int setExercise, int
    // secondsExercise

    public void addingExercise() {
            String nameExercise = "";
            String descExercise = "";
            int repExercise = 0;
            int setExercise = 0;
            double baseCalorieBurned = 0;
            double totalCalorieBurned = 0;
            int secondsExercise = 0;
            System.out.println("=-=-= Adding Exercise =-=-=");
            do{
                System.out.print("Name: ");
                nameExercise = scan.nextLine();
                if(nameExercise.isEmpty()) {
                    System.out.println("Name of exercise cannot be empty, please input a name");
                }
            } while(nameExercise.isEmpty());
            do{
                System.out.print("Description of exercise: ");
                descExercise = scan.nextLine();
                if(descExercise.isEmpty()) {
                    System.out.println("Name of exercise cannot be empty, please input a name");
                }
            } while(descExercise.isEmpty());
            do{
                try {
                    System.out.print("Base Calorie Burned (kcal/minute): ");
                    baseCalorieBurned = scan.nextFloat();
                    scan.nextLine();
                    if(baseCalorieBurned <= 0) {
                        System.out.println("You cannot burn 0 or below calorie");
                    } else if(baseCalorieBurned > 25) {
                        System.out.println("Burned calorie max is 30 Kcal/minutes");
                    }
                } catch (Exception e) {
                    System.out.println("Invalid input, please try again [AE-1]");
                }
            } while(baseCalorieBurned <= 0 && baseCalorieBurned > 25);

            do{
                try {
                    System.out.print("Reps done: ");
                    repExercise = scan.nextInt();
                    scan.nextLine();
                    if(repExercise <= 0) {
                        System.out.println("Reps cannot be zero or below");
                    } else if(repExercise > 20) {
                      System.out.println("Reps cannot be above 20");
                    }
                } catch (Exception e) {
                    System.out.println("Invalid input, try again [AE-2]");
                }
            } while(repExercise <= 0 && repExercise > 20);

            do{
                try {
                    System.out.print("Sets done: ");
                    setExercise = scan.nextInt();
                    scan.nextLine();
                    if(setExercise <= 0) {
                        System.out.println("Set cannot be zero or below");
                    } else if(setExercise > 10) {
                      System.out.println("Set cannot be above 10");
                    }
                } catch (Exception e) {
                    System.out.println("Invalid input, try again [AE-3]");
                }
            } while(setExercise <= 0 && setExercise > 10);
            do{
                try {
                    System.out.print("Time needed to done (seconds): ");
                    secondsExercise = scan.nextInt();
                    scan.nextLine();
                    if(secondsExercise <= 0) {
                        System.out.println("Time cannot be less then or equals to 0");
                    } else if(secondsExercise > 300) {
                      System.out.println("Time cannot be done for 300 seconds (5 minutes)");
                    }
                } catch (Exception e) {
                    System.out.println("Invalid input, try again [AE-4]");
                }
            } while(secondsExercise <= 0 && secondsExercise > 300);
            totalCalorieBurned = repExercise * setExercise * baseCalorieBurned;
            String intensityExercise = getIntensityCategory(repExercise, setExercise);
            
            listExercise.add(new Exercise(nameExercise, totalCalorieBurned, repExercise, setExercise, secondsExercise, intensityExercise, descExercise));
    }

    public void updateExercise() {

    }

    public void deleteExercise() {
        int deletedExercise = 0;
        int count = 0;
        while (deletedExercise >= 1 && deletedExercise <= listExercise.size() ) {
            try {
                viewOnlyName(count);
            } catch (Exception e) {
                System.out.println("Invalid input, please try again!");
                scan.nextLine();
            }
        }
    }

    public void viewAllExercise() {
        int count = 0;
        showAllExercise(count);
    }

    public void viewAllUsername() {

    }

    private void showAllExercise(int count) {
        if(count >= listExercise.size()) {
            return;
        } 
        Exercise selectedExercise = listExercise.get(count);
        System.out.println((count+1)+". "+"Name: "+selectedExercise.getName());
        System.out.println("Description: "+selectedExercise.getDescription());
        System.out.println("Sets: "+selectedExercise.getSetExercise());
        System.out.println("Reps: "+selectedExercise.getRepExercise());
        System.out.println("Calorie Burned: "+selectedExercise.getCalorieTotal());
        showAllExercise(count + 1);
    }

    private void viewOnlyName(int count) {
        if(count >= listExercise.size()) {
            return;
        } 
        Exercise selectedExercise = listExercise.get(count);
        System.out.println((count+1)+". Name: "+selectedExercise.getName());
        viewOnlyName(count + 1);
    }

    private String getIntensityCategory(int rep, int set) {
        int volumeTotal = rep * set;

        if(volumeTotal <= 40) {
            return "Light";
        } else if (volumeTotal <= 70) {
            return "Moderate";
        } else {
            return "Heavy";
        }
    }
}
