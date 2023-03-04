import java.util.List;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static class Student {
        private String name;
        private String address;
        private String phoneNumber;

        public Student(String name, String address, String phoneNumber) {
            this.name = name;
            this.address = address;
            this.phoneNumber = phoneNumber;
        }
        public String getName() {
            return this.name;
        }

        public String getAddress() {
            return this.address;
        }

        public String getPhoneNumber() {
            return this.phoneNumber;
        }

        // Getters and setters
    }

    static class StudentDatabase {
        private List<Student> students = new ArrayList<>();

        public void addStudent(Student student) {
            students.add(student);
        }

        public void removeStudent(Student student) {
            students.remove(student);
        }

        public List<Student> searchStudents(String name) {
            List<Student> results = new ArrayList<>();
            for (Student student : students) {
                if (student.getName().equals(name)) {
                    results.add(student);
                }
            }
            return results;
        }
    }

    static class StudentUI {
        private Scanner scanner = new Scanner(System.in);
        private StudentDatabase studentDb = new StudentDatabase();

        public void showMenu() {
            System.out.println("Welcome to the student database!");
            System.out.println("1. Add student");
            System.out.println("2. Remove student");
            System.out.println("3. Search student by name");
            System.out.println("4. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the new line character

            switch (choice) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    removeStudent();
                    break;
                case 3:
                    searchStudents();
                    break;
                case 4:
                    System.out.println("Goodbye!");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice.");
            }

            showMenu(); // Show the menu again
        }

        private void addStudent() {
            System.out.println("Enter student name:");
            String name = scanner.nextLine();
            System.out.println("Enter student address:");
            String address = scanner.nextLine();
            System.out.println("Enter student phone number:");
            String phoneNumber = scanner.nextLine();
            Student student = new Student(name, address, phoneNumber);
            studentDb.addStudent(student);
            System.out.println("Student added.");
        }

        private void removeStudent() {
            System.out.println("Enter student name to remove:");
            String name = scanner.nextLine();
            List<Student> searchResults = studentDb.searchStudents(name);
            if (searchResults.isEmpty()) {
                System.out.println("Student not found.");
                return;
            }
            System.out.println("Select a student to remove:");
            for (int i = 0; i < searchResults.size(); i++) {
                System.out.printf("%d. %s%n", i + 1, searchResults.get(i).getName());
            }
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the new line character
            if (choice < 1 || choice > searchResults.size()) {
                System.out.println("Invalid choice.");
                return;
            }
            Student studentToRemove = searchResults.get(choice - 1);
            studentDb.removeStudent(studentToRemove);
            System.out.println("Student removed.");
        }

        private void searchStudents() {
            System.out.println("Enter student name to search for:");
            String name = scanner.nextLine();
            List<Student> searchResults = studentDb.searchStudents(name);
            if (searchResults.isEmpty()) {
                System.out.println("Student not found.");
                return;
            }
            for (Student student : searchResults) {
                System.out.printf("Name: %s, Address: %s, Phone number: %s%n",
                        student.getName(), student.getAddress(), student.getPhoneNumber());
            }
        }

    }
    public static void main(String[] args) {
        System.out.println("Welcome to the student database!");

     StudentUI objeto = new StudentUI();
     objeto.showMenu();
    }
}