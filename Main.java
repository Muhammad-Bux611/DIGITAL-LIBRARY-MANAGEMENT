import java.util.Scanner;

public class Main {
    private static Library library = new Library();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        // Add books to the library for demonstration
        library.addBook(new Book("Java Programming", "John Doe", "978-0135166307"));
        library.addBook(new Book("Python Programming", "Jane Smith", "978-0134852043"));
        library.addUser(new User("user1", "password1"));
        library.addUser(new User("user2", "password2"));

        System.out.println("Welcome to Digital Library Management System");

        // Login process
        User currentUser = loginProcess();

        if (currentUser != null) {
            // Display available books
            library.displayBooks();

            // Simulate borrowing and returning books
            library.borrowBook(currentUser, "978-0135166307");
            library.borrowBook(currentUser, "978-0134852043");
            library.returnBook(currentUser, "978-0135166307");

            // Display available books after operations
            library.displayBooks();
        }

        System.out.println("Thank you for using Digital Library Management System");
    }

    private static User loginProcess() {
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        for (User user : library.getUsers()) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                System.out.println("Login successful. Welcome, " + user.getUsername());
                return user;
            }
        }
        System.out.println("Invalid username or password. Please try again.");
        return null;
    }
}

