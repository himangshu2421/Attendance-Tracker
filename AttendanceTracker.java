import java.util.ArrayList;
import java.util.Scanner;

class Student {
    int id;
    String name;
    boolean isPresent;

    Student(int id, String name) {
        this.id = id;
        this.name = name;
        this.isPresent = false;
    }
}

public class AttendanceTracker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Student> students = new ArrayList<>();
        boolean running = true;

        while (running) {
            System.out.println("\n========= Attendance Tracker =========");
            System.out.println("1. Add Student");
            System.out.println("2. Mark Attendance");
            System.out.println("3. View Attendance");
            System.out.println("4. Exit");
            System.out.print("Enter your choice (1-4): ");

            int choice = scanner.nextInt();
            scanner.nextLine();  // Clear input buffer

            switch (choice) {
                case 1:
                    System.out.print("Enter Student ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter Student Name: ");
                    String name = scanner.nextLine();
                    students.add(new Student(id, name));
                    System.out.println("Student added successfully.");
                    break;

                case 2:
                    if (students.isEmpty()) {
                        System.out.println("No students to mark attendance for.");
                    } else {
                        for (Student s : students) {
                            System.out.print("Is " + s.name + " present? (y/n): ");
                            String response = scanner.nextLine();
                            s.isPresent = response.equalsIgnoreCase("y");
                        }
                        System.out.println("Attendance marked.");
                    }
                    break;

                case 3:
                    System.out.println("\n===== Attendance Report =====");
                    System.out.printf("%-5s %-20s %-10s\n", "ID", "Name", "Status");
                    for (Student s : students) {
                        String status = s.isPresent ? "Present" : "Absent";
                        System.out.printf("%-5d %-20s %-10s\n", s.id, s.name, status);
                    }
                    break;

                case 4:
                    running = false;
                    System.out.println("Exiting program.");
                    break;

                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }

        scanner.close();
    }
}
