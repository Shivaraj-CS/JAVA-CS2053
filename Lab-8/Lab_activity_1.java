package programs;


import java.util.ArrayList;
import java.util.Scanner;

public class StudentList {
    public static void main(String[] args) {
        ArrayList<String> students = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n==== Student List Menu ====");
            System.out.println("1. Add Student");
            System.out.println("2. Insert Student at Specific Index");
            System.out.println("3. Update Student Name");
            System.out.println("4. Remove Student");
            System.out.println("5. Display All Students");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter student name to add: ");
                    String nameToAdd = sc.nextLine();
                    students.add(nameToAdd);
                    System.out.println("Student added successfully!");
                    displayList(students);
                    break;

                case 2:
                    System.out.print("Enter index to insert at: ");
                    int index = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter student name to insert: ");
                    String nameToInsert = sc.nextLine();
                    if (index >= 0 && index <= students.size()) {
                        students.add(index, nameToInsert);
                        System.out.println("Student inserted successfully!");
                    } else {
                        System.out.println("Invalid index!");
                    }
                    displayList(students);
                    break;

                case 3:
                    System.out.print("Enter index of student to update: ");
                    int updateIndex = sc.nextInt();
                    sc.nextLine();
                    if (updateIndex >= 0 && updateIndex < students.size()) {
                        System.out.print("Enter new name: ");
                        String newName = sc.nextLine();
                        students.set(updateIndex, newName);
                        System.out.println("Student name updated!");
                    } else {
                        System.out.println("Invalid index!");
                    }
                    displayList(students);
                    break;

                case 4:
                    System.out.println("Remove by: 1) Name  2) Index");
                    int removeChoice = sc.nextInt();
                    sc.nextLine();

                    if (removeChoice == 1) {
                        System.out.print("Enter name to remove: ");
                        String nameToRemove = sc.nextLine();
                        if (students.remove(nameToRemove))
                            System.out.println("Student removed successfully!");
                        else
                            System.out.println("Student not found!");
                    } else if (removeChoice == 2) {
                        System.out.print("Enter index to remove: ");
                        int removeIndex = sc.nextInt();
                        if (removeIndex >= 0 && removeIndex < students.size()) {
                            students.remove(removeIndex);
                            System.out.println("Student removed successfully!");
                        } else {
                            System.out.println("Invalid index!");
                        }
                    } else {
                        System.out.println("Invalid choice!");
                    }
                    displayList(students);
                    break;

                case 5:
                    displayList(students);
                    break;

                case 0:
                    System.out.println("Exiting program...");
                    break;

                default:
                    System.out.println("Invalid choice! Please try again.");
            }

        } while (choice != 0);

        sc.close();
    }

    // Method to display all students
    public static void displayList(ArrayList<String> students) {
        System.out.println("\nCurrent Student List:");
        if (students.isEmpty()) {
            System.out.println("(No students in the list)");
        } else {
            for (int i = 0; i < students.size(); i++) {
                System.out.println(i + ": " + students.get(i));
            }
        }
    }
}
