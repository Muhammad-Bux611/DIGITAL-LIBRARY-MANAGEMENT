import java.util.ArrayList;
import java.util.List;

public class Library {
    private List<Book> books;
    private List<User> users;

    public Library() {
        books = new ArrayList<>();
        users = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void addUser(User user) {
        users.add(user);
    }

    public void displayBooks() {
        System.out.println("Books in the library:");
        for (Book book : books) {
            System.out.println("Title: " + book.getTitle() + ", Author: " + book.getAuthor() + ", ISBN: " + book.getISBN() + ", Available: " + (book.isAvailable() ? "Yes" : "No"));
        }
    }

    public void borrowBook(User user, String ISBN) {
        for (Book book : books) {
            if (book.getISBN().equals(ISBN) && book.isAvailable()) {
                book.setAvailable(false);
                System.out.println(user.getUsername() + " borrowed " + book.getTitle());
                return;
            }
        }
        System.out.println("Book with ISBN " + ISBN + " not available for borrowing.");
    }

    public void returnBook(User user, String ISBN) {
        for (Book book : books) {
            if (book.getISBN().equals(ISBN) && !book.isAvailable()) {
                book.setAvailable(true);
                System.out.println(user.getUsername() + " returned " + book.getTitle());
                return;
            }
        }
        System.out.println("Book with ISBN " + ISBN + " was not borrowed by " + user.getUsername());
    }

    public User[] getUsers() {
        return new User[0];
    }
}

