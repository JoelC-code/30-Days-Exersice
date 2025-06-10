package Controller.Admin;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

import Class.ExerciseMove.Exercise;
import Class.UsersAccount.Account;
import Class.UsersAccount.Admin;
import Class.UsersAccount.Users;

public class AdminSystem {
    private ArrayList<Account> listUserAccount;
    private LinkedList<Exercise> listExercise;
    private Scanner scan;

    public AdminSystem(ArrayList<Account> listUserAccount, LinkedList<Exercise> listExercises) {
        this.listUserAccount = listUserAccount;
        this.listExercise = new LinkedList<>(listExercises);
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
        do {
            System.out.print("Name: ");
            nameExercise = scan.nextLine();
            if (nameExercise.isEmpty()) {
                System.out.println("Name of exercise cannot be empty, please input a name");
            }
        } while (nameExercise.isEmpty());
        do {
            System.out.print("Description of exercise: ");
            descExercise = scan.nextLine();
            if (descExercise.isEmpty()) {
                System.out.println("Name of exercise cannot be empty, please input a name");
            }
        } while (descExercise.isEmpty());
        do {
            try {
                System.out.print("Base Calorie Burned (kcal): ");
                baseCalorieBurned = scan.nextFloat();
                scan.nextLine();
                if (baseCalorieBurned <= 0) {
                    System.out.println("You cannot burn 0 or below calorie");
                } else if (baseCalorieBurned > 25) {
                    System.out.println("Burned calorie max is 30 Kcal");
                }
            } catch (Exception e) {
                System.out.println("Invalid input, please try again [AE-1]");
            }
        } while (baseCalorieBurned <= 0 && baseCalorieBurned > 25);

        do {
            try {
                System.out.print("Reps done: ");
                repExercise = scan.nextInt();
                scan.nextLine();
                if (repExercise <= 0) {
                    System.out.println("Reps cannot be zero or below");
                } else if (repExercise > 20) {
                    System.out.println("Reps cannot be above 20");
                }
            } catch (Exception e) {
                System.out.println("Invalid input, try again [AE-2]");
            }
        } while (repExercise <= 0 && repExercise > 20);

        do {
            try {
                System.out.print("Sets done: ");
                setExercise = scan.nextInt();
                scan.nextLine();
                if (setExercise <= 0) {
                    System.out.println("Set cannot be zero or below");
                } else if (setExercise > 10) {
                    System.out.println("Set cannot be above 10");
                }
            } catch (Exception e) {
                System.out.println("Invalid input, try again [AE-3]");
            }
        } while (setExercise <= 0 && setExercise > 10);
        do {
            try {
                System.out.print("Time needed to done (seconds): ");
                secondsExercise = scan.nextInt();
                scan.nextLine();
                if (secondsExercise <= 0) {
                    System.out.println("Time cannot be less then or equals to 0");
                } else if (secondsExercise > 300) {
                    System.out.println("Time cannot be done for 300 seconds (5 minutes)");
                }
            } catch (Exception e) {
                System.out.println("Invalid input, try again [AE-4]");
            }
        } while (secondsExercise <= 0 && secondsExercise > 300);
        totalCalorieBurned = repExercise * setExercise * baseCalorieBurned;
        listExercise.add(new Exercise(nameExercise, totalCalorieBurned, repExercise, setExercise, secondsExercise, descExercise));
    }

    public void updateExercise() {
        String updateName, updateDesc = "";
        int updateTime = 0, updateSet = 0, updateRep = 0;
        double updateCal = 0, updateCalBurned = 0;
        boolean isValid = false;
        int exerciseSelected = 0;
        if (listExercise.isEmpty()) {
            System.out.println("No exercise is added, please try again!");
        }
        System.out.println("=-=-= Update Exercise =-=-=");
        viewAllExercise();
        while (exerciseSelected <= 0 || exerciseSelected > listExercise.size()) {
            try {
                System.out.print("Exercise you want to edit: ");
                exerciseSelected = scan.nextInt();
                scan.nextLine();
                if (exerciseSelected <= 0 || exerciseSelected > listExercise.size()) {
                    System.out.println("Exercise doesn't exist, try again!");
                }
            } catch (Exception e) {
                System.out.println("Invalid input, please try again!");
                scan.nextLine();
            }
        }
        Exercise edittedExercise = listExercise.get(exerciseSelected - 1);
        while (!isValid) {
            try {
                System.out.print("Name for update (): ");
                updateName = scan.nextLine().trim();
                if (!updateName.isEmpty()) {
                    edittedExercise.setName(updateName);
                }
                isValid = true;
            } catch (Exception e) {
                System.out.println("Invalid input, try again");
            }
        }
        isValid = false;
        while (!isValid) {
            try {
                System.out.print("Desc for update: ");
                updateDesc = scan.nextLine().trim();
                if (!updateDesc.isEmpty()) {
                    edittedExercise.setDescription(updateDesc);
                }
                isValid = true;
            } catch (Exception e) {
                System.out.println("Invalid input, try again");
            }
        }
        isValid = false;
        while (!isValid) {
            try {
                System.out.print("Base Calorie for update: ");
                updateCal = scan.nextDouble();
                if (updateCal < 0) {
                    System.out.println("Invalid Calorie base, try again!");
                } else if (updateCal > 25) {
                    System.out.println("Burned calorie max is 30 Kcal");
                }
                isValid = true;
            } catch (Exception e) {
                System.out.println("Invalid input, try again");
            }
        }
        isValid = false;
        while (!isValid) {
            try {
                System.out.print("Time for update (max 300): ");
                updateTime = scan.nextInt();
                if (updateTime < 0) {
                    System.out.println("Invalid time, try again!");
                } else if (updateTime > 0 && updateTime <= 300) {
                    edittedExercise.setSecondsExercise(updateTime);
                } else if (updateTime > 300) {
                    System.out.println("Invalid time exercise (max 300)");
                }
                isValid = true;
            } catch (Exception e) {
                System.out.println("Invalid input, try again");
            }
        }
        isValid = false;
        while (!isValid) {
            try {
                System.out.print("Reps for update (max is 20): ");
                updateRep = scan.nextInt();
                if (updateRep < 0) {
                    System.out.println("Invalid reps time, try again!");
                } else if (updateRep > 0 && updateRep <= 20) {
                    edittedExercise.setRepExercise(updateRep);
                } else if (updateRep > 20) {
                    System.out.println("Invalid rep (max is 20)");
                }
                isValid = true;
            } catch (Exception e) {
                System.out.println("Invalid input, try again");
            }
        }
        isValid = false;
        while (!isValid) {
            try {
                System.out.print("Sets for update (max is 10): ");
                updateSet = scan.nextInt();
                if (updateSet < 0) {
                    System.out.println("Invalid reps time, try again!");
                } else if (updateSet > 0) {
                    edittedExercise.setSetExercise(updateSet);
                } else if (updateSet > 10) {
                    System.out.println("Invalid set setting, try again! (max is 10)");
                }
                isValid = true;
            } catch (Exception e) {
                System.out.println("Invalid input, try again");
            }
        }
        updateCalBurned = updateRep * updateSet * updateCal;
        edittedExercise.setCalorieTotal(updateCalBurned);
        System.out.println("Changes is done for the exercise "+edittedExercise.getName()+"!");
    }

    public void deleteExercise() {
        int deletedExercise = 0;
        int count = 0;
        if (listExercise.isEmpty()) {
            System.out.println("Add a new exercise first");
            return;
        }
        while (deletedExercise < 1 || deletedExercise > listExercise.size()) {
            try {
                viewOnlyName(count);
                System.out.print("Exercise to be erased (numbers): ");
                deletedExercise = scan.nextInt();
                scan.nextLine();
                if (deletedExercise < 1 || deletedExercise > listExercise.size()) {
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
            System.out.println("Nama: " + listExercise.get(deletedExercise).getName());
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
        if (listExercise.isEmpty()) {
            System.out.println("Add a new exercise first");
            return;
        }
        int count = 0;
        showAllExercise(count);
    }

    public void viewAllUsername() {
        if (listUserAccount.isEmpty()) {
            System.out.println("There's no users added yet");
            return;
        }
        System.out.println("=-=-= Accounts =-=-=");
        int index = 0;
        showAllUser(index);
    }

    private void showAllUser(int index) {
        if (index >= listUserAccount.size()) {
            return;
        }
        Account selectedAccount = listUserAccount.get(index);
        System.out.print((1 + index) + ". Name: " + selectedAccount.getUsername());
        if (selectedAccount instanceof Admin) {
            Admin selectedAdmin = (Admin) selectedAccount;
            System.out.print(" [" + selectedAdmin.getRoleName() + "]\n");
        }
        if (selectedAccount instanceof Users) {
            Users selectedUsers = (Users) selectedAccount;
            System.out.print(" [" + selectedUsers.getRoleName() + "]\n");
        }
        showAllUser(index + 1);
    }

    private void showAllExercise(int count) {
        if (count >= listExercise.size()) {
            return;
        }
        System.out.println();
        Exercise selectedExercise = listExercise.get(count);
        System.out.println((count + 1) + ". " + "Name: " + selectedExercise.getName());
        System.out.println("Description: " + selectedExercise.getDescription());
        System.out.println("Sets: " + selectedExercise.getSetExercise());
        System.out.println("Reps: " + selectedExercise.getRepExercise());
        System.out.println("Time: " + selectedExercise.getSecondsExercise() + " Seconds");
        System.out.println("Calorie Burned: " + selectedExercise.getCalorieTotal());
        System.out.println();
        showAllExercise(count + 1);
    }

    private void viewOnlyName(int count) {
        if (count >= listExercise.size()) {
            return;
        }
        Exercise selectedExercise = listExercise.get(count);
        System.out.println((count + 1) + ". Name: " + selectedExercise.getName());
        viewOnlyName(count + 1);
    }
}
