import java.sql.Date;

public class Main {
    public static void main(String[] args) {
        Book book1 = new Book("Сага о мече", "Неизвестно", 1998, 1L);
        Book book2 = new Book("Сага об Эгиле", "Неизвестно", 873, 2L);
        User user1 = new User("Олег", 15, 1L);
        User user = new User("Рубен", 37, 2L);
        LibraryService.takeBook(1L, 2L);
        LibraryService.takeBook(1L, 1L);
        LibraryService.takeBook(1L, 1L);
        LibraryService.returnBook("1", "1");
        LibraryService.takeBook(2L, 1L);
        System.out.println(LibraryService.getUserBooks("2"));
        System.out.println(LibraryService.getUserBorrowedBooks());
        Date.

    }
}
