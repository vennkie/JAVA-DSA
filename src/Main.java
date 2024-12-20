// Book class to represent a book in the library
class Book {
    private String title;
    private String author;
    private boolean isAvailable;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
        this.isAvailable = true;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void borrow() {
        if (isAvailable) {
            isAvailable = false;
            System.out.println("Book borrowed successfully: " + title);
        } else {
            System.out.println("Book is not available: " + title);
        }
    }

    public void returnBook() {
        isAvailable = true;
        System.out.println("Book returned successfully: " + title);
    }

    @Override
    public String toString() {
        return "Title: " + title + ", Author: " + author + ", Available: " + isAvailable;
    }
}

// Library class to manage a collection of books
class Library {
    private Book[] books;
    private int bookCount;

    public Library(int capacity) {
        books = new Book[capacity];
        bookCount = 0;
    }

    public void addBook(Book book) {
        if (bookCount < books.length) {
            books[bookCount++] = book;
            System.out.println("Book added: " + book.getTitle());
        } else {
            System.out.println("Library is full, cannot add more books.");
        }
    }

    public Book findBook(String title) {
        for (int i = 0; i < bookCount; i++) {
            if (books[i].getTitle().equalsIgnoreCase(title)) {
                return books[i];
            }
        }
        return null;
    }

    public void listBooks() {
        System.out.println("Library Catalog:");
        for (int i = 0; i < bookCount; i++) {
            System.out.println(books[i]);
        }
    }
}

// Member class to represent a library member
class Member {
    private String name;
    private Book borrowedBook;

    public Member(String name) {
        this.name = name;
        this.borrowedBook = null;
    }

    public String getName() {
        return name;
    }

    public void borrowBook(Book book) {
        if (borrowedBook != null) {
            System.out.println("You already have a borrowed book: " + borrowedBook.getTitle());
        } else {
            borrowedBook = book;
            book.borrow();
        }
    }

    public void returnBook() {
        if (borrowedBook != null) {
            borrowedBook.returnBook();
            borrowedBook = null;
        } else {
            System.out.println("You don't have any borrowed book.");
        }
    }
}

// LibraryManagementSystem class to interact with users
class LibraryManagementSystem {
    private Library library;

    public LibraryManagementSystem(int capacity) {
        library = new Library(capacity);
    }

    public void addBookToLibrary(String title, String author) {
        Book book = new Book(title, author);
        library.addBook(book);
    }

    public void borrowBook(String title, Member member) {
        Book book = library.findBook(title);
        if (book != null) {
            member.borrowBook(book);
        } else {
            System.out.println("Book not found: " + title);
        }
    }

    public void returnBook(Member member) {
        member.returnBook();
    }

    public void showLibraryCatalog() {
        library.listBooks();
    }
}

// Main class to drive the program
public class Main {
    public static void main(String[] args) {
        LibraryManagementSystem system = new LibraryManagementSystem(5);  // Library with capacity of 5 books

        // Add books to the library
        system.addBookToLibrary("The Great Gatsby", "F. Scott Fitzgerald");
        system.addBookToLibrary("1984", "George Orwell");
        system.addBookToLibrary("To Kill a Mockingbird", "Harper Lee");

        // Create members
        Member member1 = new Member("Alice");
        Member member2 = new Member("Bob");

        // Show the catalog
        system.showLibraryCatalog();

        // Borrow books
        system.borrowBook("1984", member1);
        system.borrowBook("The Great Gatsby", member2);
        system.borrowBook("1984", member2);  // Trying to borrow the same book

        // Show the updated catalog
        system.showLibraryCatalog();

        // Return books
        system.returnBook(member1);
        system.returnBook(member2);

        // Show the final catalog
        system.showLibraryCatalog();
    }
}
