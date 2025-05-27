package Controller.Admin;

import java.util.ArrayList;
import java.util.Scanner;

import Class.ExerciseMove.Exercise;
import Class.UsersAccount.Account;

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
                    scan.nextLine();
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
        if(listExercise.isEmpty()) {
            System.out.println("Add a new exercise first");
            return;
        }
        while (deletedExercise >= 1 && deletedExercise <= listExercise.size() ) {
            try {
                viewOnlyName(count);
                System.out.print("Exercise to be erased (numbers): ");
                deletedExercise = scan.nextInt();
                scan.nextLine();
                if(deletedExercise < 1 && deletedExercise > listExercise.size()) {
                    System.out.println("Exercise didn't exist, please try again!");
                }
            } catch (Exception e) {
                System.out.println("Invalid input, please try again!");
                scan.nextLine();
            }
        }
        deletedExercise--;
        String yesNo = "";
        while (yesNo.isEmpty()) {
            System.out.println("Are you sure to delete this exercise? (y/n)");
            System.out.println("Nama: "+listExercise.get(deletedExercise).getName());
            yesNo = scan.nextLine();
            if (yesNo.equalsIgnoreCase("y")) {
                listExercise.remove(deletedExercise);
            } else if (yesNo.equalsIgnoreCase("n")) {
                return;
            } else {
                System.out.println("Invalid, must be 'y' or 'n' as an input");
            }
        }
    }

    public void viewAllExercise() {
        if(listExercise.isEmpty()) {
            System.out.println("Add a new exercise first");
            return;
        }
        int count = 0;
        showAllExercise(count);
    }

    public void viewAllUsername() {
        if(listExercise.isEmpty()) {
            System.out.println("No users/admin is made, how the hell it's possible!?");
            return;
        }
        int count = 0;
        showAllUsers(count);
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

    private void showAllUsers(int count) {
        if(count >= listUserAccount.size()) {
            return;
        }
        System.out.println((1+count)+". Username: "+listUserAccount.get(count).getUsername());
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
