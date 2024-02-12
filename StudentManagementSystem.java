package core_Java_Project;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
class Student {
    private String name;
    private String rollNumber;
    private int age;
    private String email;

    // Constructor
    public Student(String name, String rollNumber, int age, String email) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.age = age;
        this.email = email;
    }

    // Getters
    public String getName() {
        return name;
    }

    public String getRollNumber() {
        return rollNumber;
    }

    public int getAge() {
        return age;
    }

    public String getEmail() {
        return email;
    }

    // Setter
    public void setName(String name) {
		// TODO Auto-generated method stub
		this.name = name;
	}
    public void setAge(int age) {
		// TODO Auto-generated method stub
		this.age = age;
	}

	
    public void setEmail(String email) {
        this.email = email;
    }

    // Override toString() method for displaying student details
    @Override
    public String toString() {
        return "Name: " + name + ", Roll Number: " + rollNumber + ", Age: " + age + ", Email: " + email;
    }

	
}

class Admin {
    private String username;
    private String password;

    // Constructor
    public Admin(String username, String password) {
        this.username = username;
        this.password = password;
    }

    // Getter
    public String getUsername() {
        return username;
    }

    // Method to check if provided credentials match
    public boolean authenticate(String username, String password) {
        return this.username.equals(username) && this.password.equals(password);
    }
}





public class StudentManagementSystem {
	

	
    private static Map<String, Student> students = new HashMap<>();
    private static Admin admin = new Admin("admin", "admin");

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("/nWelcome to Student Management System");
            System.out.println("1. Student Login");
            System.out.println("2. Admin Login");
            System.out.println("3. Exit");
            System.out.print("/nEnter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    studentLogin(scanner);
                    break;
                case 2:
                    adminLogin(scanner);
                    break;
                case 3:
                    System.out.println("Exiting...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }

    private static void studentLogin(Scanner scanner) {
        System.out.print("Enter your roll number: ");
        String rollNumber = scanner.next();

        Student student = students.get(rollNumber);
        if (student != null) {
            System.out.println("Login successful!");
            System.out.println("Student Details: " + student);
            // Additional student functionalities can be added here
        } else {
            System.out.println("Student not found!");
        }
    }

    private static void adminLogin(Scanner scanner) {
        System.out.print("Enter username: ");
        String username = scanner.next();
        System.out.print("Enter password: ");
        String password = scanner.next();

        if (admin.authenticate(username, password)) {
            System.out.println("Admin login successful!");
            adminMenu(scanner);
        } else {
            System.out.println("Invalid credentials!");
        }
    }

    private static void adminMenu(Scanner scanner) {
        while (true) {
            System.out.println("Admin Menu:");
            System.out.println("1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. Edit Student Details");
            System.out.println("4. Delete Student");
            System.out.println("5. Logout");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    addStudent(scanner);
                    break;
                case 2:
                    viewAllStudents();
                    break;
                case 3:
                    editStudentDetails(scanner);
                    break;
                case 4:
                    deleteStudent(scanner);
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }

    private static void addStudent(Scanner scanner) {
        System.out.print("Enter name: ");
        String name = scanner.next();
        System.out.print("Enter roll number: ");
        String rollNumber = scanner.next();
        System.out.print("Enter age: ");
        int age = scanner.nextInt();
        System.out.print("Enter email: ");
        String email = scanner.next();

        students.put(rollNumber, new Student(name, rollNumber, age, email));
        System.out.println("Student added successfully!");
    }

    private static void viewAllStudents() {
    	if (!students.isEmpty()) {
    	    for (Student student : students.values()) {
    	        System.out.println(student);
    	    }
    	} else {
    	    System.out.println("No student data available.");
    	}


    	
    	
     /*   System.out.println("All Students:");
        for (Student student : students.values()) {
        	            System.out.println(student);
        	} */
    }

    private static void editStudentDetails(Scanner scanner) {
        System.out.print("Enter roll number of student to edit: ");
        String rollNumber = scanner.next();
        Student student = students.get(rollNumber);
        
        while(true)
        {
        	System.out.println("Select to edit Student detail:");
        	System.out.println("1.Name");
        	System.out.println("2.Age");
        	System.out.println("3.Email");
        	System.out.println("4.Exit");
        	System.out.println("Enter your choice: ");
            int choice = scanner.nextInt();
            
            switch (choice) {
            case 1:
            	if (student != null) {
                    System.out.print("Enter new Name: ");
                    String newName = scanner.next();
                    student.setName(newName);
                    System.out.println("Student details updated successfully!");
                } else {
                    System.out.println("Student not found!");
                }          
            	
            	break;
            case 2:
            	if (student != null) {
                    System.out.print("Enter new Age: ");
                    int newAge = scanner.nextInt();
                    student.setAge(newAge);
                    System.out.println("Student details updated successfully!");
                } else {
                    System.out.println("Student not found!");
                }       
            	break;
            case 3:
            	if (student != null) {
                    System.out.print("Enter new email: ");
                    String newEmail = scanner.next();
                    student.setEmail(newEmail);
                    System.out.println("Student details updated successfully!");
                } else {
                    System.out.println("Student not found!");
                }    
            	break;
            case 4:
            	return;
            	
          
            default:
                System.out.println("Invalid choice!");
        }

        }
      /*  if (student != null) {
            System.out.print("Enter new email: ");
            String newEmail = scanner.next();
            student.setEmail(newEmail);
            System.out.println("Student details updated successfully!");
        } else {
            System.out.println("Student not found!");
        } */
    }

    private static void deleteStudent(Scanner scanner) {
        System.out.print("Enter roll number of student to delete: ");
        String rollNumber = scanner.next();
        if (students.containsKey(rollNumber)) {
            students.remove(rollNumber);
            System.out.println("Student deleted successfully!");
        } else {
            System.out.println("Student not found!");
        }
    }
}


